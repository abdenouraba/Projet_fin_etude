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
public class Contenu_bat {
    private double pulse_rate,freq,velocitie,position,loudness,total_energy,total_latence;
    private int size_population;
    private Class_solution solution;
   private ArrayList<ArrayList<ArrayList<Class_noued>>> bat_solutions;

    public Contenu_bat(){}
    
    
   public void genere_bat_solutions(){
   for(int i=0;i<size_population;i++){
       solution.Random_mapping();
       total_energy=solution.Energey_in_Noc(solution.getNoc().getNoc_architecteur())+total_energy;
       total_latence=solution.Latence_in_Noc(solution.getNoc().getNoc_architecteur())+total_latence;
   bat_solutions.add(solution.getNoc().getNoc_architecteur());
   
   }
   
   
   
   }
   public double get_rate_energy_in_bat(){
      
       return (this.total_energy/size_population);
   }
   
   public double get_rate_latence_in_bat(){
       
       return (this.total_latence/size_population);
   }
   
   public void set_Pulse_rate(double pulse_rate){
   this.pulse_rate=pulse_rate;
   } 
    public void set_Freq(double freq){
   this.freq=freq;
   } 
     public void set_Velocitie(double velocitie){
   this.velocitie=velocitie;
   } 
      public void set_Position(double position){
   this.position=position;
   } 
       public void set_Loudnesse(double loudness){
   this.loudness=loudness;
   } 
       
       public void set_size_population( int size_population ){
   this.size_population= size_population;
   } 
       public void set_class_solution(Class_solution solution){
       this.solution = solution;}
       
       
        public double get_Pulse_rate(){
   return this.pulse_rate;
   } 
    public double get_Freq(){
    return this.freq;
   } 
     public double get_Velocitie(){
  return this.velocitie;
   } 
      public double get_Position(){
  return this.position;
   } 
       public double get_Loudnesse(){
   return this.loudness;
   } 
    
    
      public double get_size_population(){
   return this.size_population;
   } 
      public ArrayList<ArrayList<ArrayList<Class_noued>>> get_bat_solutions(){
      return this.bat_solutions;
      }
}
