/*******************************************************************************
 *  
 *  $Id: XMLOutputter.java 249 2009-01-07 08:31:07Z kd $
 *  Copyright (C) 2006 Jalian Systems Private Ltd.
 *  Copyright (C) 2006 Contributors to Marathon OSS Project
 * 
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU General Public License
 *  as published by the Free Software Foundation; either version 2
 *  of the License, or any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 * 
 *  Project website: http://www.marathontesting.com
 *  Help: Marathon help forum @ http://groups.google.com/group/marathon-testing
 * 
 *******************************************************************************/
package net.sourceforge.marathon.junit.textui;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.runner.BaseTestRunner;
import net.sourceforge.marathon.Constants;
import net.sourceforge.marathon.checklist.CheckList;
import net.sourceforge.marathon.junit.MarathonTestCase;

public class XMLOutputter implements Outputter {
	public XMLOutputter() {
		super();
	}

	public void output(Writer writer, Test testSuite, Map testOutputMap) {
		try {
			System.err.println("Producing xml outputter file ...................................");
			writer.write("<?xml version=\"1.0\" ?>\n");
			String reportDir = new File(System.getProperty(Constants.PROP_REPORT_DIR)).getName();
			//writer.write("<testsuites projectname='" + System.getProperty(Constants.PROP_PROJECT_NAME, "") + "' " + "reportdir='"
			//		+ reportDir + "' " + ">\n");
			printResult("", writer, testSuite, testOutputMap);
			//writer.write("</testsuites>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void captureTestResult(Test test, Map testOutputMap,Vector<MarathonTestResult> results) throws IOException {
		if (test instanceof TestSuite) {
			TestSuite suite = (TestSuite) test;						
			
			Enumeration testsEnum = suite.tests();
			while (testsEnum.hasMoreElements()) {
				captureTestResult((Test) testsEnum.nextElement(),testOutputMap,results);
			}
		} else {
			MarathonTestResult result = (MarathonTestResult) testOutputMap.get(test);
			results.add(result);
		}
		
	}
	private void printResult(String indent, Writer writer, Test test, Map testOutputMap) throws IOException {
		Vector<MarathonTestResult> mtr=new Vector<MarathonTestResult>();
		int counttests=0;
		int countfails=0;
		int counterrors=0;
		String name="";
		if (test instanceof TestSuite) {
			TestSuite suite = (TestSuite) test;						
			name=suite.getName();
			counttests=counttests+suite.countTestCases();
			countfails=countfails+countFailures(test);
			counterrors=counterrors+countErrors(test);
			Enumeration testsEnum = suite.tests();
			while (testsEnum.hasMoreElements()) {
				captureTestResult((Test) testsEnum.nextElement(), testOutputMap,mtr);
			}
			
			
		} else {
			MarathonTestResult result = (MarathonTestResult) testOutputMap.get(test);
			mtr.add(result);
			//writeResultXML(indent, writer, result, test);
		}
		writer.write(indent + "<testsuite name=\"" + name + "\" tests=\""+counttests+"\" failures=\""+
				countfails+"\" errors=\""+counterrors+"\" >\n");
		for (MarathonTestResult result:mtr){
			writeResultXML(indent, writer, result, test);
		}
		writer.write(indent + "</testsuite>\n");
	}

	private int countFailures(Test test){
		int total=0;
		if (test instanceof TestSuite){
			TestSuite suite = (TestSuite) test;									
			Enumeration testsEnum = suite.tests();			
			while (testsEnum.hasMoreElements()) {
				total=total+countFailures((Test) testsEnum.nextElement());	
			};
		} else {
			if (test instanceof MarathonTestResult){
				MarathonTestResult result=(MarathonTestResult)test;
				if (result.getStatus()== MarathonTestResult.STATUS_FAILURE){
					total=total+1;
				}
			}
		}
		return total;
	}

	private int countErrors(Test test){
		int total=0;
		if (test instanceof TestSuite){
			TestSuite suite = (TestSuite) test;									
			Enumeration testsEnum = suite.tests();			
			while (testsEnum.hasMoreElements()) {
				total=total+countErrors((Test) testsEnum.nextElement());	
			};
		} else {
			if (test instanceof MarathonTestResult){
				MarathonTestResult result=(MarathonTestResult)test;
				if (result.getStatus()== MarathonTestResult.STATUS_ERROR){
					total=total+1;
				}
			}
		}
		return total;
	}

	private void writeResultXML(String indent, Writer writer, MarathonTestResult result, Test test) throws IOException {
		String durationStr = NumberFormat.getInstance().format(result.getDuration());
		int status = result.getStatus();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-ddEHH:mm:ss");
		
		String xml = indent + "<testcase name=\"" + result.getTestName() + "\" classname=\""+result.getTestName()+"\" timestamp=\""+sdf.format(new Date())+"\" time=\"" + durationStr
		+ "\" >\n";
		if (test instanceof MarathonTestCase) {
			MarathonTestCase mtestcase = (MarathonTestCase) test;
			ArrayList<CheckList> checklists = mtestcase.getChecklists();
			if (checklists.size() > 0) {
				int index = 1;
				for (CheckList checkList : checklists) {
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					checkList.saveXML(indent, baos, index++);
					xml += new String(baos.toByteArray());
				}
			}
		}
		if (status == MarathonTestResult.STATUS_PASS) {
			xml += indent + "</testcase>\n";
		} else {
			String stackTrace = " ";
			Throwable throwable = result.getThrowable();
			if (throwable != null)
				stackTrace = BaseTestRunner.getFilteredTrace(throwable);
			String captureDir = System.getProperty(Constants.PROP_IMAGE_CAPTURE_DIR);
			if (captureDir != null && test instanceof MarathonTestCase) {
				File[] files = ((MarathonTestCase) test).getScreenCaptures();
				List<File> fileList = new ArrayList<File>();
				for (int i = 0; i < files.length; i++) {
					fileList.add(files[i]);
				}
				/**
				 * We have to sort them, because they are not guaranteed to be
				 * in any particular order, and tend to be in reverse order
				 * (ordered by newest to oldest file)
				 */
				/*Collections.sort(fileList);
				if (fileList.size() > 0) {
					xml += "<screen_captures>";
					Iterator it = fileList.iterator();
					while (it.hasNext()) {
						File file = (File) it.next();
						xml += "<screen_capture file=\"" + file.getName() + "\"/>";
					}
					xml += "</screen_captures>";
				}*/
			}
			xml += "<system-err><![CDATA[" + stackTrace;
			xml += indent + "]]></system-err></testcase>\n";
		}
		writer.write(xml);
	}

}
