import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


public class writerxml {
	public static void guardaConFormato(Document document, String URI){
	    try {
	        TransformerFactory transFact = TransformerFactory.newInstance();

	        //Formateamos el fichero. Añadimos sangrado y la cabecera de XML
	        transFact.setAttribute("indent-number", new Integer(3));
	        Transformer trans = transFact.newTransformer();
	        trans.setOutputProperty(OutputKeys.INDENT, "yes");
	        trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");

	        //Hacemos la transformación
	        StringWriter sw = new StringWriter();
	        StreamResult sr = new StreamResult(sw);
	        DOMSource domSource = new DOMSource(document);
	        trans.transform(domSource, sr);

	        //Mostrar información a guardar por consola (opcional)
	        //Result console= new StreamResult(System.out);
	        //trans.transform(domSource, console);
	        try {
	            //Creamos fichero para escribir en modo texto
	            PrintWriter writer = new PrintWriter(new FileWriter(URI));

	            //Escribimos todo el árbol en el fichero
	            writer.println(sw.toString());

	            //Cerramos el fichero
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    } catch(Exception ex) {
	        ex.printStackTrace();
	    }
	}
	public static void AnadirCaracteristica(String URI){
	    try {
	        //Obtenemos el document del fichero XML existente
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        document = db.parse(new File(URI));
	        document.getDocumentElement().normalize();
	    } catch (ParserConfigurationException e) {
	        e.printStackTrace();
	    } catch (SAXException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    //Creamos un nuevo elemento en la casa
	    Element terraza = document.createElement("Terraza");
	    //Le añadimos una característica
	    Element tamano = document.createElement("Tamano");
	    //Le añadimos su valor
	    Text valor = document.createTextNode("20m2");

	    //Añadimos la información a la casa ya existente
	    NodeList nodoRaiz = document.getDocumentElement().getElementsByTagName("Casa");
	    nodoRaiz.item(0).appendChild(terraza);
	    terraza.appendChild(tamano);
	    tamano.appendChild(valor);

	    //Guardamos la nueva estructura la fichero XML
	}

	public static void AnadirCaracteristica(String URI){
	    try {
	        //Obtenemos el document del fichero XML existente
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        document = db.parse(new File(URI));
	        document.getDocumentElement().normalize();
	    } catch (ParserConfigurationException e) {
	        e.printStackTrace();
	    } catch (SAXException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    //Creamos un nuevo elemento en la casa
	    Element terraza = document.createElement("Terraza");
	    //Le añadimos una característica
	    Element tamano = document.createElement("Tamano");
	    //Le añadimos su valor
	    Text valor = document.createTextNode("20m2");

	    //Añadimos la información a la casa ya existente
	    NodeList nodoRaiz = document.getDocumentElement().getElementsByTagName("Casa");
	    nodoRaiz.item(0).appendChild(terraza);
	    terraza.appendChild(tamano);
	    tamano.appendChild(valor);

	    //Guardamos la nueva estructura la fichero XML
	}

    public static void main(String[] args) {
         Document document = null;
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);

            //Creación de elementos
            //creamos el elemento principal casa
            Element casa = document.createElement("Casa"); 
            //creamos un nuevo elemento. Casa contiene habitaciones
            Element habitacion= document.createElement("Habitacion");
            //creamos un nuevo elemento. Habitación tiene color
            Element color = document.createElement("Color"); 
            //Ingresamos la info. El color de esta habitación es azul
            Text valorColor = document.createTextNode("Azul"); 

            //Asignamos la versión de nuestro XML
            document.setXmlVersion("1.0"); 
            //Añadimos la casa al documento
            document.getDocumentElement().appendChild(casa); 
            //Añadimos el elemento hijo a la raíz
            casa.appendChild(habitacion); 
            //Añadimos elemento
            habitacion.appendChild(color); 
            //Añadimos valor
            color.appendChild(valorColor); 
         }catch(Exception e){
             System.err.println("Error");
         }
    }
}