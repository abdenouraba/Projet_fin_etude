/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projet_mappage;

/**
 *
 * @author pc acer
 */
public class Class_connect {
    private Class_noued noued_source;
    private Class_noued noued_destination;
   // private String id_noued_source;
   // private String id_noued_destination;
    private int nombre_bit;
    
    public Class_connect(Class_noued noued_source, Class_noued noued_destination,int nombre_bit){
    //this.id_noued_source=id_noued_source;
    //this.id_noued_destination=id_noued_destination;
    this.nombre_bit=nombre_bit;
    
    this.noued_source=noued_source;
    this.noued_destination=noued_source;
    
    
    }

   
    
    
    public Class_noued getnoued_source(){return this.noued_source;}
    public Class_noued getnoued_destination(){return this.noued_destination;}
    public int getNombre_bit(){return this.nombre_bit;}
    
    
    public void setnoued_source(Class_noued noued_source){ this.noued_source=noued_source;}
    public void setnoued_destination(  Class_noued noued_destination){this.noued_destination=noued_destination;}
    public void setNombre_bit(int nombre_bit){this.nombre_bit=nombre_bit;}
   

}

