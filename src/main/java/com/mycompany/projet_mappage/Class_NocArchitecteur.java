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
public class Class_NocArchitecteur {
    private ArrayList<ArrayList<Class_noued>> Noc_architecteur;
    private int axe_x=0;
    private int axe_y=0;
    private double Eneregy_in_router=0;
    private double Energey_in_link=0;
    private double Wight_Traffic=0;
    private double bandwith_between_pe=0;
    private ArrayList<Class_noued> list_neurons_in_one_pe;
    public Class_NocArchitecteur(int axe_x,int axe_y, double Eneregy_in_router,double Energey_in_link,double Wight_Traffic,double bandwith_between_pe){
    this.axe_x=axe_x;
    this.axe_y=axe_y;
    this.Eneregy_in_router=Eneregy_in_router;
    this.Energey_in_link=Energey_in_link;
    this.Wight_Traffic=Wight_Traffic;
     this.bandwith_between_pe=bandwith_between_pe;
    this.Noc_architecteur=new ArrayList<ArrayList<Class_noued>>();
    }
    public void genere_noc_archiecteur(){
         int index_cree_array=0;
         int fin_index= axe_x*axe_y;
         while(index_cree_array<fin_index){
             this.list_neurons_in_one_pe=new ArrayList<Class_noued> ();
             this.Noc_architecteur.add(index_cree_array,list_neurons_in_one_pe);
             index_cree_array++;
            
         }
        }
    
    public double getEneregy_in_router(){return this.Eneregy_in_router;}
     public double getEnergey_in_link(){return this.Energey_in_link;}
      public double getWight_Traffic(){return this.Wight_Traffic;}
     public double getbandwith_between_pe(){return this.bandwith_between_pe;}
     public void setEneregy_in_router(double Eneregy_in_router){this.Eneregy_in_router=Eneregy_in_router;}
     public void setEnergey_in_link(double Energey_in_link){this.Energey_in_link=Energey_in_link;}
      public void setWight_Traffic(double Wight_Traffic){this.Wight_Traffic=Wight_Traffic;}
     public void setbandwith_between_pe(double bandwith_between_pe){this.bandwith_between_pe=bandwith_between_pe;}
     public int getAxe_x(){return this.axe_x;}
     public int getAxe_y(){return this.axe_y;}
     public void setAxe_x(int axe_x){ this.axe_x=axe_x;}
     public void setAxe_y(int axe_y){ this.axe_y=axe_y;}
     public ArrayList<ArrayList<Class_noued>> getNoc_architecteur(){return this.Noc_architecteur;}
     public void setNoc_architecteur(ArrayList<ArrayList<Class_noued>> Noc_architecteur){ this.Noc_architecteur=Noc_architecteur;}
     public ArrayList<Class_noued> getList_neurons_in_one_pe(){return this.list_neurons_in_one_pe;}
     public void setList_neurons_in_one_pe(ArrayList<Class_noued> list_neurons_in_one_pe ){this.list_neurons_in_one_pe=list_neurons_in_one_pe;}
    
}
