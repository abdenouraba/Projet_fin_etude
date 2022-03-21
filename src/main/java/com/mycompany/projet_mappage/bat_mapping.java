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
public class bat_mapping {
    Class_solution solution;
   private ArrayList<Contenu_bat> List_bat_population;
   private int position_current_best_solution,bat_population;
   private Contenu_bat current_best_solution;
   private ArrayList<ArrayList<Contenu_bat>> List_bats_iteration;
   
   private double Freq_min=0;
   private double Freq_max=1;
    
  public bat_mapping( Class_solution solution){
   this. solution=solution;
  List_bats_iteration = new ArrayList<ArrayList<Contenu_bat>>(); 
  }
  
  public void bat_algorithme(int max_iteration , int bat_population , double loudness , double pulse_rate){
      
      for(int i=0; i<bat_population; i++){
          this.bat_population=bat_population;
      Contenu_bat one_bat = new Contenu_bat();
      one_bat.set_class_solution(solution);
      one_bat.set_Loudnesse(loudness);
      one_bat.set_Pulse_rate(pulse_rate);
      one_bat.set_Freq(0);
      one_bat.set_Velocitie(0);
      one_bat.set_Position(i);
      one_bat.set_size_population(10);
      one_bat.genere_bat_solutions();
      
      List_bat_population.add(one_bat); 
      
      
      }
      List_bats_iteration.add(List_bat_population);

select_current_best_solution();

int iteration=1;
while(iteration<max_iteration){
   for(int i=0; i<bat_population; i++){
          this.bat_population=bat_population;
      Contenu_bat one_bat = new Contenu_bat();
      one_bat.set_class_solution(solution);
      one_bat.set_Loudnesse(loudness);
      one_bat.set_Pulse_rate(pulse_rate);
      float B=(float) Math.random()*(1-0);
      one_bat.set_Freq((Freq_min+(Freq_max-Freq_min)*(B)));
      one_bat.set_Velocitie((List_bats_iteration.get(iteration-1).get(i).get_Velocitie())+
                            ((List_bats_iteration.get(iteration-1).get(i).get_Position())+position_current_best_solution)*one_bat.get_Freq());
      
      //probleme position 
      one_bat.set_Position(i);
      one_bat.set_size_population(10);
      one_bat.genere_bat_solutions();
      
      List_bat_population.add(one_bat); 
      
      
      }
           float rand =(float) Math.random()*(1-0);
           
           if(rand>1){}
           
           
   
   
   
List_bats_iteration.add(iteration, List_bat_population);



}









}
  public void select_current_best_solution(){
   this.position_current_best_solution=0;
   this.current_best_solution=List_bat_population.get(position_current_best_solution);
  for(int i=1;i<bat_population; i++){
      
      
      if(((current_best_solution.get_rate_energy_in_bat())+(current_best_solution.get_rate_latence_in_bat()))/2 >= ((List_bat_population.get(i).get_rate_energy_in_bat())+(List_bat_population.get(i).get_rate_latence_in_bat()))/2 ) {
          this.position_current_best_solution=i;
          this.current_best_solution=List_bat_population.get(i);
      }
  }
  }
}

