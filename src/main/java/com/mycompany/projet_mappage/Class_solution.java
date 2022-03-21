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
public class Class_solution {
    private Class_Dnn Dnn_modele;
    private Class_noued noued;
    private ArrayList<Class_noued> one_Layer;
    
    
    private double Energey_total=0;
    private double Latence_total=0;
    
    private int nombre_neuron_max;
    private int nombre_neuron_min;
  //  private ArrayList<Class_noued>  Noc_architecteur[][];
    //private int random_place;
    
    
    //private ArrayList<ArrayList<Class_noued>> Noc_architecteur;
    private ArrayList<Class_noued> list_neurons_in_one_pe;
    private Class_NocArchitecteur Noc;
    
    
    
    @SuppressWarnings("unchecked")
    public Class_solution(Class_Dnn Dnn_modele, Class_NocArchitecteur Noc_architecteur){
    this.Dnn_modele=Dnn_modele;
    this.Noc= Noc_architecteur;
    //this.axe_x=Noc_architecteur.getAxe_x();
    //this.axe_y=Noc_architecteur.getAxe_y();
    nombre_neuron_min=(int)Dnn_modele.getNbr_neuron()/(Noc_architecteur.getAxe_x()*Noc_architecteur.getAxe_y());
    nombre_neuron_max=(int)((Dnn_modele.getNbr_neuron())*15/100);
    
    
    
    
    }
    public void Random_mapping(){
        this.Noc.genere_noc_archiecteur();
       // genere_noc_archiecteur();
        int size_dnn_architecteur = Dnn_modele.getDnn_architecteur().size();
        int index=0;
        while((index>=0)&&(index<size_dnn_architecteur )){
            one_Layer= Dnn_modele.getDnn_architecteur().get(index);
            int size_layer=one_Layer.size();
            int index_in_one_layer=0;
            while(index_in_one_layer>=0 && index_in_one_layer<size_layer){
            noued= one_Layer.get(index_in_one_layer);
            index_in_one_layer++;
            int random_position= (int) (Math.random()*(((this.Noc.getAxe_x()*this.Noc.getAxe_y())))-0);
            int size_verification =this.Noc.getNoc_architecteur().get(random_position).size();
            if(size_verification>nombre_neuron_max){
            random_position= (int) (Math.random()*((this.Noc.getAxe_x()*this.Noc.getAxe_y()))-0);
            }
            noued.setnumero_pe(random_position+1);
            this.Noc.getNoc_architecteur().get(random_position).add(noued);
   
            
            }
            index++;
            
            
      
        
        
         }
       int f=0;
      while(f<size_dnn_architecteur){
      if(this.Noc.getNoc_architecteur().get(f).size()<nombre_neuron_min) Random_mapping();
      f++;
      } 
    
    
    
    }
    
    /*
     public void genere_noc_archiecteur(){
         int index_cree_array=0;
         int fin_index= axe_x*axe_y;
         while(index_cree_array<fin_index){
             this.list_neurons_in_one_pe=new ArrayList<Class_noued> ();
             this.Noc.getNoc_architecteur().add(index_cree_array,list_neurons_in_one_pe);
             this.Noc.setNoc_architecteur(this.Noc.getNoc_architecteur());
             index_cree_array++;
            
         }
        }
*/
     public void affiche_resulta_mappage(){
     for(int i=0; i< (this.Noc.getAxe_x()*this.Noc.getAxe_y());i++){
     one_Layer=Noc.getNoc_architecteur().get(i);
     int size_pe=one_Layer.size();
     System.out.println("\n"+"voisi les noueds de PE n°: "+i+"\n");
     for(int j=0;j<size_pe;j++){
    System.out.println("id de neuron n° "+j+" : "+one_Layer.get(j).getId_noued());
     }
     }
     }
     
     
     public double Energey_in_Noc(ArrayList<ArrayList<Class_noued>> Noc){
     double energey_total_in_noc=0;
     int size=Noc.size();
     for(int i=0;i<size;i++){
     energey_total_in_noc=energey_total_in_noc+Energey_in_one_pe(Noc.get(i));
     }
     return(energey_total_in_noc);}
     
     public double Latence_in_Noc(ArrayList<ArrayList<Class_noued>> Noc){
     double Latence_total_in_noc=0;
     int size=Noc.size();
     for(int i=0;i<size;i++){
     Latence_total_in_noc=Latence_total_in_noc+Latence_in_one_pe(Noc.get(i));
     }
     return(Latence_total_in_noc);}
     
     
     public double Energey_in_one_pe(ArrayList<Class_noued> PE){
         int size=PE.size();
         double eneregy_in_pe=0;
         if(size==0) return 0;
         else{
         for(int i=0;i<size;i++){
         eneregy_in_pe=eneregy_in_pe+(Eneregy_in_one_neuron_in_on_pe(PE.get(i)));
         }        
         }
     return eneregy_in_pe;
         }
     
     public double Latence_in_one_pe(ArrayList<Class_noued> PE){
         int size=PE.size();
         double Latence_in_pe=0;
         if(size==0) return 0;
         else{
         for(int i=0;i<size;i++){
         Latence_in_pe=Latence_in_pe+(Latence_in_one_neuron_in_one_pe(PE.get(i)));
         }        
         }
     return Latence_in_pe;
         }
     
     
     
     public double Eneregy_in_one_neuron_in_on_pe(Class_noued neuron){
         double eneregy_one_neuron_in_on_pe=0;
        ArrayList<Class_connect> list_voisin =neuron.getConnect_noued();
        int size =list_voisin.size();
        if(size==0) return 0;
        else{
        int index_x= return_indice_column((neuron.get_numero_pe()));
        int index_y= return_indice_ligne((neuron.get_numero_pe()));
        for(int i=0;i<size;i++){
           int index_x_destination=return_indice_column(list_voisin.get(i).getnoued_destination().get_numero_pe());
           int index_y_destination=return_indice_ligne(list_voisin.get(i).getnoued_destination().get_numero_pe());
           int distance_x=Math.abs(index_x_destination-index_x);
           int distance_y=Math.abs(index_y_destination-index_y);
           int distance_mathaten=distance_x+distance_y;
        eneregy_one_neuron_in_on_pe=eneregy_one_neuron_in_on_pe+(list_voisin.get(i).getNombre_bit()*((((distance_mathaten+1)*(this.Noc.getEneregy_in_router()))+(distance_mathaten*(this.Noc.getEnergey_in_link())))*((this.Noc.getWight_Traffic()))));
        
        }
        return eneregy_one_neuron_in_on_pe;
        }
     
     
     
     }
     public double Latence_in_one_neuron_in_one_pe(Class_noued neuron){
     double latence_one_neuron_on_pe=0;
     ArrayList<Class_connect> list_voisin =neuron.getConnect_noued();
     int size =list_voisin.size();
     if(size==0) return 0;
     
     else{
        int index_x= return_indice_column((neuron.get_numero_pe()));
        int index_y= return_indice_ligne((neuron.get_numero_pe()));
        for(int i=0;i<size;i++){
           int index_x_destination=return_indice_column(list_voisin.get(i).getnoued_destination().get_numero_pe());
           int index_y_destination=return_indice_ligne(list_voisin.get(i).getnoued_destination().get_numero_pe());
           int distance_x=Math.abs(index_x_destination-index_x);
           int distance_y=Math.abs(index_y_destination-index_y);
           int distance_mathaten=distance_x+distance_y;
       latence_one_neuron_on_pe=latence_one_neuron_on_pe+(list_voisin.get(i).getNombre_bit()*(distance_mathaten+1)*(1/this.Noc.getbandwith_between_pe()));
        
        }
        return latence_one_neuron_on_pe;
        }
     
     
     
     
     }
     public void genere_population(int nbr){
     for (int i=0 ;i<nbr;i++){
         System.out.println("population n° : "+i);
         Random_mapping();
         Energey_total= Energey_in_Noc(this.Noc.getNoc_architecteur());
         Latence_total= Latence_in_Noc(this.Noc.getNoc_architecteur());
         System.out.println("******energy total in noc is :" +Energey_total+"*****");
         System.out.println("******latence total in noc is :" +Latence_total +", second (s) *****");
         affiche_resulta_mappage();
     
     }
     }
     
     public int return_indice_column(int position_pe){
     if(position_pe<=this.Noc.getAxe_x())return position_pe; 
     else{
     if((position_pe % this.Noc.getAxe_x())==0)return this.Noc.getAxe_x();
     else return (int) position_pe % (this.Noc.getAxe_x());
     } 
     }
     
     public int return_indice_ligne(int position_pe ){
     if(position_pe<=this.Noc.getAxe_x()) return 1;
     else{
     if ((position_pe%this.Noc.getAxe_x())==0) return (int)position_pe/this.Noc.getAxe_x();
     else return (int)(position_pe/this.Noc.getAxe_x())+1;
     
     }
     
     
     
     }
     
     /*
     public ArrayList<ArrayList<Class_noued>> getNoc_architecteur(){return this.Noc_architecteur;}
     public void setNoc_architecteur(ArrayList<ArrayList<Class_noued>> Noc_architecteur){ this.Noc_architecteur=Noc_architecteur;}
*/
     public ArrayList<Class_noued> getList_neurons_in_one_pe(){return this.list_neurons_in_one_pe;}
     public void setList_neurons_in_one_pe(ArrayList<Class_noued> list_neurons_in_one_pe ){this.list_neurons_in_one_pe=list_neurons_in_one_pe;}
     public Class_NocArchitecteur getNoc(){
     return this.Noc; 
     }
    
}
