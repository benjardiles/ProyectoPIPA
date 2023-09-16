/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopipa;

/**
 *
 * @author Benja
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DibujarPoligono extends JPanel {
    private List<Edges> puntos;
    private double escala = 1.0; // Factor de escala inicial


    public DibujarPoligono(List<Edges> puntos) {
        this.puntos = puntos;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.scale(escala, escala);
        
        int numPuntos = puntos.size();
                // Encuentra el rango de coordenadas
        //double minX = this.puntos.get(0).posX;
       // double maxX = this.puntos.get(0).posX;
        //double minY = this.puntos.get(0).posY;
        //double maxY =  this.puntos.get(0).posY;

        //for (int i = 1; i < numPuntos; i++) {
           // if ( this.puntos.get(i).posX < minX) minX =  this.puntos.get(i).posX;
            //f ( this.puntos.get(i).posX > maxX) maxX =  this.puntos.get(i).posX;
            //if ( this.puntos.get(i).posY < minX) minY=  this.puntos.get(i).posY;
           // if ( this.puntos.get(i).posY > maxX) maxY=  this.puntos.get(i).posY;
        }

        // Escala las coordenadas para ampliar el rango
        //double escalaX = 800f / (maxX - minX); // ancho de la ventana
        //double escalaY = 600f / (maxY - minY); // altura de la ventana

        // Convierte y ajusta las coordenadas
        int[] puntosX = new int[numPuntos];
        int[] puntosY = new int[numPuntos];

        //for (int i = 0; i < numPuntos; i++) {
           // puntosX[i] = (int) Math.round(( this.puntos.get(i).posX - minX) * escalaX);
            //puntosY[i] = (int) Math.round((this.puntos.get(i).posY - minY) * escalaY);
        }

        // Crea un polígono a partir de las coordenadas enteras
        //Polygon poligono = new Polygon(puntosX, puntosY, numPuntos);

        // Dibuja el polígono
        //g2d.draw(poligono);
    //}


//}
public class DibujarPoligono extends JPanel {
    private List<Edges> puntos;
    private double escala = 1.0; // Factor de escala inicial


    public DibujarPoligono(List<Edges> puntos) {
        this.puntos = puntos;
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.scale(escala, escala);
        
        int numPuntos = puntos.size();
                // Encuentra el rango de coordenadas




        // Escala las coordenadas para ampliar el rango


           for(Edges elemento : puntos){
                // Crea un polígono a partir de las coordenadas enteras
               Polygon poligono = new Polygon(elemento.id_Punto1.posX, elemento.id_Punto1.posY, 2);

                 // Dibuja el polígono
                 g2d.draw(poligono);
           }

