/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopipa;

import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 *
 * @author Benja
 */
import java.io.File;
import java.util.List;

//, garantiza que el código dentro del bloque
//se ejecute de manera segura en el hilo de la interfaz gráfica de usuario de Swing
import javax.lang.model.SourceVersion;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

//se utiliza para importar clases y tipos definidos en el paquete
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Reader {
    public void read(String file, List<PuntoDibujo> puntos) {
        try {
            File archivo = new File(file);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //patron de Diseño
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);

            document.getDocumentElement().normalize();
            //System.out.println("Elemento raíz: " + document.getDocumentElement().getNodeName());
            NodeList rows = document.getElementsByTagName("row");

            for (int i = 0; i < rows.getLength(); i++) {
                Node nodo = rows.item(i);
               // System.out.println(nodo.getNodeName());
                
               //verifica si el nodo actual es de tipo ELEMENT_NODE.
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    //se confirma
                    Element element = (Element) nodo;
                    // Obtener el contenido de texto de 'x' e 'y' como cadenas
                   String osmidTextContent = element.getElementsByTagName("osmid").item(0).getTextContent();
                    String xTextContent = element.getElementsByTagName("x").item(0).getTextContent();
                    String yTextContent = element.getElementsByTagName("y").item(0).getTextContent();
                    
                    // Convertir a float(corregir de float ->  double)
                    double posX = Float.parseFloat(xTextContent);
                    double posY = Float.parseFloat(yTextContent);
                    //se almacena 
                    PuntoDibujo p = new PuntoDibujo(posY, posX,osmidTextContent);
                    puntos.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void read2(String file, List<Edges> pEdges,List<PuntoDibujo> puntos ) {
        try {
            File archivo = new File(file);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);

            document.getDocumentElement().normalize();
            System.out.println("Elemento raíz: " + document.getDocumentElement().getNodeName());
            NodeList edge = document.getElementsByTagName("edge");

            for (int i = 0; i < edge.getLength(); i++) {
                Node nodo = edge.item(i);
                //System.out.println(nodo.getNodeName());

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    // Obtener el contenido de texto de los elementos 'u', 'v', 'k', 'osmid', y 'name'
                    String uTextContent = element.getElementsByTagName("u").item(0).getTextContent();
                    String vTextContent = element.getElementsByTagName("v").item(0).getTextContent();
                    String kTextContent = element.getElementsByTagName("k").item(0).getTextContent();
                    String osmidTextContent = element.getElementsByTagName("osmid").item(0).getTextContent();
                    String nameTextContent = element.getElementsByTagName("name").item(0).getTextContent();
                   
                     double k = Float.parseFloat(kTextContent);
                    //Recorro lista de puntos
                      PuntoDibujo p1 = null;
                      PuntoDibujo p2 = null;
                    for (int c = 0; c < puntos.size(); c++) {
                      PuntoDibujo elemento = puntos.get(c);
                      //comparo si id_Punto
                      
                      if(elemento.id_osmid.equals(uTextContent)){
                            p1 = elemento;
                            System.out.println("Uencontrado");
                          
                      }
                      if(elemento.id_osmid.equals(vTextContent)){
                           p2 = elemento;
                          System.out.println("Vencontrado");
                          
                    }
                      
                      
        }
           //creamos el edge
                      Edges punto_edge = new Edges(p1,p2,k,osmidTextContent,nameTextContent);
                        System.out.println("name"+punto_edge.getName());     
                        pEdges.add(punto_edge);
                     
                   
                    System.out.println("u: " + uTextContent);
                    System.out.println("v: " + vTextContent);
                    System.out.println("k: " + kTextContent);
                    System.out.println("osmid: " + osmidTextContent);
                    System.out.println("name: " + nameTextContent);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


