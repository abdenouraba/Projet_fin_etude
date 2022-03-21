/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projet_mappage;

import java.util.ArrayList;

/**
 *
 * @author pc acer
 */
public class Class_noued {
   // private double connexion_latence_total;
    //private double connexion_enregy_total;
    private int numero_pe;
    private String Id_noued;
   // private float processing_Energy_consome;
    private double debit;
    private Class_connect connect;
    private ArrayList<Class_connect> connect_noued  ;
    public Class_noued(String Id_noued,float processing_Energy_consome,
            double debit){
    this.Id_noued=Id_noued;
    //this.processing_Energy_consome=processing_Energy_consome;
    this.debit=debit;
    this.connect_noued=new ArrayList<Class_connect>();
    this.numero_pe=-1;
    //this.connexion_enregy_total=0;
    //this.connexion_latence_total=0;
     
    
    }
   
    
    public void add_connect_noued(Class_connect connect){
    connect_noued.add( connect);
    }
    public void remove_connect_noued(Class_connect connect){
     connect_noued.remove(connect);}
    public void clear_voisin_noued(){
    this.connect_noued.clear();}
    
    
    
   // public double getConnexion_latence_total(){return this.connexion_latence_total;}
   // public double getConnexion_enregy_total(){return this.connexion_latence_total;}
    
    
    //les seteur et geteur
    public void setnumero_pe(int numero_pe){this.numero_pe=numero_pe;}
    public int get_numero_pe(){return this.numero_pe;}
    public void numero_pe(int numero_pe){this.numero_pe=numero_pe;}
    public void setId_noued(String Id_noued){
    this. Id_noued=Id_noued;}
   /* public void setEngery_consome(float processing_Energy_consome){
    this.processing_Energy_consome=processing_Energy_consome;}
*/
    public void setDebit(double debit){
    this.debit=debit;}
    public void setConnect_noued(ArrayList<Class_connect> connect_noued ){this.connect_noued=connect_noued;}
    public String getId_noued(){return this.Id_noued;}
    //public float getEnergy_consome(){return this.processing_Energy_consome;}
    public double getDebit(){return this.debit;}
    public ArrayList<Class_connect> getConnect_noued(){return this.connect_noued;}
    
}
