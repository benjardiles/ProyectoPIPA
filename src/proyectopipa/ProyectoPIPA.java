/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectopipa;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Benja
 */
public class ProyectoPIPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Reader read = new Reader();
        List<PuntoDibujo> puntos = new ArrayList<PuntoDibujo>();
        read.read("C:/Users/Benja/Desktop/nodes.xml", puntos);
        for (PuntoDibujo p : puntos) {
            System.out.println("Punto (X, Y): " + p.posX + "," + p.posY);
        }
        //Reader read2 = new Reader();
       // read.read2("C:/Users/Benja/Desktop/edges.xml");
        // TODO code application logic here
        
        SwingUtilities.invokeLater(() -> {
            
            JFrame frame = new JFrame("Dibujar Polígono");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            DibujarPoligono panel = new DibujarPoligono(puntos);
            frame.add(panel);

            frame.setSize(800, 600);
            frame.setVisible(true);
        });
    }
    
}