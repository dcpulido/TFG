/*
 Copyright (C) 2002 Jorge Gomez Sanz
 
 This file is part of INGENIAS IDE, a support tool for the INGENIAS
 methodology, availabe at http://grasia.fdi.ucm.es/ingenias or
 http://ingenias.sourceforge.net
 
 INGENIAS IDE is free software; you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation; either version 2 of the License, or
 (at your option) any later version.
 
 INGENIAS IDE is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.
 
 You should have received a copy of the GNU General Public License
 along with INGENIAS IDE; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 
 */

package ingenias.generator.util;

import java.io.*;


public class Conversor {
	public static final String SUBTAGCHAR="@@@";
	
	/*
	 * Transforms a string of tags into a compatible string with only
	 * dtd valid tags. Other tags are converted to &lt; and &gt;
	 */
	public static String convertTaggedFormat(String containment) throws ingenias.exception.NotWellFormed {
		int pos = getTagStart(0, containment);
		int lastPos = 0;
		StringBuffer result = new StringBuffer();
		boolean endTagFlag=false;
		while (pos >=0 && (pos+1)<containment.length()) {
			String tagName = getTagAt(pos + 1, containment).toLowerCase().trim();
			if (tagName.startsWith("/")){
				tagName=tagName.substring(1,tagName.length());
				endTagFlag=true;
			} else
				endTagFlag=false;
			
//			System.err.println(tagName);
		/*	if ( (tagName.startsWith("v") ||
					tagName.startsWith("saveto") ||
					tagName.startsWith("repeat") ||
					tagName.startsWith("text") ||
					tagName.startsWith("file") ||
					tagName.startsWith("program") ||
					tagName.startsWith("sequences"))) {*/
				
				if (lastPos<0 || pos <lastPos || pos>containment.length()) {
					
					
					throw new RuntimeException();
				} else 
				{
					String nString = containment.substring(lastPos, pos);
					if (endTagFlag && tagName.startsWith("v"))
						nString=nString.trim();
					result.append(nString);
					int endTag = getTagEnd(pos, containment);
					if (endTag<0){
						System.err.println("Error in transforming file. End tag is negative when dealing with this part ");
						System.err.println(containment.substring(pos, containment.length()));
						throw new  ingenias.exception.NotWellFormed();
					}
					if (pos<0)
						System.err.println("otra cosa");
					
					result.append("<"+restoreInvalidChar(containment.substring(pos+1, endTag).trim()) + ">");
					lastPos = endTag + SUBTAGCHAR.length();					
					pos=lastPos;
				}
			/*} else {
				
				
				pos=pos+SUBTAGCHAR.length();
			}*/
			
			int oldpos=pos;
			pos = getTagStart(pos , containment);
		
			/*if (pos<0){
				System.err.println("Error in transforming file. No open tag sign when dealing with this part ");
				System.err.println(containment.substring(oldpos, oldpos+SUBTAGCHAR.length())+ "$$$FROM HERE$$$" +
						containment.substring(oldpos+SUBTAGCHAR.length(),containment.length())+" <EOF>");
			}*/
			
			
		} 
		
		result.append(replaceInvalidChar(containment.substring(lastPos, containment.length())));
		
		return result.toString();
	}
	
	public static String convertArrobaFormat(String containment) throws ingenias.exception.NotWellFormed {
		
		String result = convertArrobaToTag(replaceInvalidChar(containment));
		
		return convertTaggedFormat(result);
	}
	
	public static String replace(String orig, String pattern,String nstring){
		String s = orig;
		try {
			s = s.replaceAll(pattern,nstring);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return s;
		
	}
	
	public static String replaceInvalidCharsForID(String text) {
		String s = text;
		try {
			s =s.replaceAll("&", "");
			s = s.replaceAll("<", "");
			s =  s.replaceAll(">", "");
			s =  s.replaceAll("\"", "");
			s =  s.replaceAll("'", "");
			/*s =  s.replaceAll("�", "&nacute;");
			 s =  s.replaceAll("�", "&aacute;");
			 s =  s.replaceAll("�", "&eacute;");
			 s =  s.replaceAll("�", "&iacute;");
			 s =  s.replaceAll("�", "&oacute;");
			 s =  s.replaceAll("�", "&uacute;");*/
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public static String replaceInvalidChar(String text) {
		String s = text;
		try {
			s =s.replaceAll("&", "&amp;");
			s = s.replaceAll("<", "&lt;");
			s =  s.replaceAll(">", "&gt;");
			s =  s.replaceAll("\"", "&quot;");
			s =  s.replaceAll("'", "&apos;");
			/*s =  s.replaceAll("�", "&nacute;");
			 s =  s.replaceAll("�", "&aacute;");
			 s =  s.replaceAll("�", "&eacute;");
			 s =  s.replaceAll("�", "&iacute;");
			 s =  s.replaceAll("�", "&oacute;");
			 s =  s.replaceAll("�", "&uacute;");*/
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public static String convertTagToArroba(String containment){
		String nstring=replace(containment,"<",SUBTAGCHAR);
		nstring=replace(nstring,">",SUBTAGCHAR);
		return restoreInvalidChar(nstring);
	}
	
	public static String restoreInvalidChar(String text) {
		String s = text;
		try {
			s = s.replaceAll("&amp;","&");
			s = s.replaceAll("&lt;","<");
			s = s.replaceAll("&gt;",">");
			s = s.replaceAll("&quot;","\"");
			s = s.replaceAll("&apos;","'");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	
	private static String convertArrobaToTag(String text) {
		int first = 0;
		int tagCount = 0;
		StringBuffer sb = new StringBuffer(text);
		for (int k = 0; k < sb.length()-2; k++) {
			
			if (sb.substring(k,k+3).equals(SUBTAGCHAR)) {
				if (tagCount % 2 == 0) {
					sb.setCharAt(k, '<');
					sb.setCharAt(k+1, ' ');
					sb.setCharAt(k+2, ' ');
				}
				else {
					sb.setCharAt(k, '>');
					sb.setCharAt(k+1, ' ');
					sb.setCharAt(k+2, ' ');
				}
				tagCount++;
			}
		}
		
		
		return sb.toString();
	}
	
	public static String getTagAt(int pos, String text) throws ingenias.exception.NotWellFormed{
		// Assumes that char at "pos" is a "<"
		if (text.charAt(pos) == '/') {
			pos = pos + 1;
		}
		int endName1 = text.indexOf(" ", pos);
		int endName2 = text.indexOf(">", pos);
		String result = "";
		if (endName1 != -1 && endName2 != -1) {
			result = text.substring(pos, endName2);
		}
		else
			if (endName1 != -1) {
				result = text.substring(pos, endName1);
			}
			else
				if (endName2 != -1) {
					result = text.substring(pos, endName2);
				}
				else {
					throw new ingenias.exception.NotWellFormed("Not well formed. Found the error here \n"+text.substring(pos));
				}
		
		return result;
	}
	
	public static int getTagStart(int pos, String text) {
		return text.indexOf("<", pos);
	}
	
	public static int getTagEnd(int pos, String text) {
		return text.indexOf(">", pos);
	}
	
	public static void main(String args[]) throws Exception {
		ingenias.editor.Log.initInstance(new PrintWriter(System.err));
		if (args.length<2)
			System.err.println("Wrong format!!!!\n Conversor (-a2t|-t2a) filename");
		else{
			FileInputStream fis = new FileInputStream(args[1]);
			int read = fis.read();
			StringBuffer sb = new StringBuffer();
			while (read != -1) {
				sb.append( (char) read);
				read = fis.read();
			}
			fis.close();
			if (args[0].equals("-a2t"))
				System.out.println(convertArrobaFormat(sb.toString()));
			else
				if (args[0].equals("-t2a"))
					System.out.println(convertTagToArroba(sb.toString()));
		}
		
	}
}