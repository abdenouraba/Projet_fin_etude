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
public class Class_Dnn {
    private int NbrLayer;
    private int Nbr_neuron;
    private int Nbr_neuron_in_layer;
    private String Type_Dnn;
    private ArrayList<ArrayList<Class_noued>> Dnn_architecteur;
    private ArrayList<Class_noued> one_Layer;
    private Class_noued one_noued;
    public Class_Dnn(){
    this.Type_Dnn=Type_Dnn;
    this.one_Layer=new ArrayList<Class_noued>();
    
    
    this.Dnn_architecteur=new ArrayList<ArrayList<Class_noued>>();
    
    }
    public Class_Dnn(String Type_Dnn){
    
    this.Type_Dnn=Type_Dnn;
    this.one_Layer=new ArrayList<Class_noued>();
    
    
    this.Dnn_architecteur=new ArrayList<ArrayList<Class_noued>>();
    
    
    }
    public void create_layer(){
        this.Nbr_neuron_in_layer=0;
    this.one_Layer=new ArrayList<Class_noued>();
    }
    public void add_neuron_in_layer(Class_noued noued){
        this.one_Layer.add(noued);
        this.Nbr_neuron_in_layer++;
        
        
    }
    public void remove_neuron_in_layer(Class_noued neuron){
        while(!(one_Layer.isEmpty())){
        
        }
    
    }
    public void add_layer_in_dnn_architecteur_with_position(int position_layer,ArrayList<Class_noued> Layer){
        this.Dnn_architecteur.add(position_layer,Layer);
        
    
    }
    public void remove_layer_in_dnn_architecteur_with_position(int position_Layer){
    Dnn_architecteur.remove(position_Layer);
    
    }
    public void clear_layer(ArrayList<Class_noued> Layer){Layer.clear();}
    public void clear_Dnn_architecteur(ArrayList<ArrayList<Class_noued>> Dnn_archietcteur){
    Dnn_archietcteur.clear();}
    
    
    
    
    public void setNbr_layer(int Nbr_layer){this.NbrLayer=Nbr_layer; }
    public void setNbr_neuron(int Nbr_neuron){this.Nbr_neuron=Nbr_neuron;}
    public void setNbr_neuron_in_layer(int Nbr_neuron_in_layer){this.Nbr_neuron_in_layer=Nbr_neuron_in_layer;}
    public void setType_Dnn(String Type_Dnn){this.Type_Dnn=Type_Dnn;}
    public void setDnn_architecteur(ArrayList<ArrayList<Class_noued>> Dnn_architecteur){this.Dnn_architecteur=Dnn_architecteur;}
    public void setOne_Layer(ArrayList<Class_noued> one_Layer){this.one_Layer=one_Layer;}
    public void setOne_noued(Class_noued one_noued){this.one_noued=one_noued;}
    
    public int getNbr_layer(){return this.NbrLayer;}
    public int getNbr_neuron(){return this.Nbr_neuron;}
    public int getNbr_neuron_in_layer(){return this.Nbr_neuron_in_layer;}
    public String getType_Dnn(){return this.Type_Dnn;}
    public ArrayList<ArrayList<Class_noued>> getDnn_architecteur(){return this.Dnn_architecteur;}
    public ArrayList<Class_noued> getOne_Layer(){return this.one_Layer;}
    public Class_noued getOne_noued(){return this.one_noued;}


    
    
}
