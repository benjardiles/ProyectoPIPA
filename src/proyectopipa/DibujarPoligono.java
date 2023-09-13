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
    private List<PuntoDibujo> puntos;
    private double escala = 1.0; // Factor de escala inicial


    public DibujarPoligono(List<PuntoDibujo> puntos) {
        this.puntos = puntos;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.scale(escala, escala);
        
        int numPuntos = puntos.size();
                // Encuentra el rango de coordenadas
        float minX = this.puntos.get(0).posX;
        float maxX = this.puntos.get(0).posX;
        float minY = this.puntos.get(0).posY;
        float maxY =  this.puntos.get(0).posY;

        for (int i = 1; i < numPuntos; i++) {
            if ( this.puntos.get(i).posX < minX) minX =  this.puntos.get(i).posX;
            if ( this.puntos.get(i).posX > maxX) maxX =  this.puntos.get(i).posX;
            if ( this.puntos.get(i).posY < minX) minY=  this.puntos.get(i).posY;
            if ( this.puntos.get(i).posY > maxX) maxY=  this.puntos.get(i).posY;
        }

        // Escala las coordenadas para ampliar el rango
        float escalaX = 800f / (maxX - minX); // ancho de la ventana
        float escalaY = 600f / (maxY - minY); // altura de la ventana

        // Convierte y ajusta las coordenadas
        int[] puntosX = new int[numPuntos];
        int[] puntosY = new int[numPuntos];

        for (int i = 0; i < numPuntos; i++) {
            puntosX[i] = Math.round(( this.puntos.get(i).posX - minX) * escalaX);
            puntosY[i] = Math.round((this.puntos.get(i).posY - minY) * escalaY);
        }

        // Crea un polígono a partir de las coordenadas enteras
        Polygon poligono = new Polygon(puntosX, puntosY, numPuntos);

        // Dibuja el polígono
        g2d.draw(poligono);
    }


}
