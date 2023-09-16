/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopipa;
import proyectopipa.PuntoDibujo;

/**
 *
 * @author Benja
 */
public class Edges {
    PuntoDibujo id_Punto1;
    PuntoDibujo id_punto2;
    double  k;
   String osmid;
   String name;

    public Edges(PuntoDibujo id_Punto1, PuntoDibujo id_punto2, double k, String osmid, String name) {
        this.id_Punto1 = id_Punto1;
        this.id_punto2 = id_punto2;
        this.k = k;
        this.osmid = osmid;
        this.name = name;
    }

    public PuntoDibujo getId_Punto1() {
        return id_Punto1;
    }

    public void setId_Punto1(PuntoDibujo id_Punto1) {
        this.id_Punto1 = id_Punto1;
    }

    public PuntoDibujo getId_punto2() {
        return id_punto2;
    }

    public void setId_punto2(PuntoDibujo id_punto2) {
        this.id_punto2 = id_punto2;
    }

    public double getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public String getOsmid() {
        return osmid;
    }

    public void setOsmid(String osmid) {
        this.osmid = osmid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
