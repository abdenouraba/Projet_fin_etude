/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projet_mappage;

import javax.swing.JPanel;



public class Class_main extends JPanel{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
      
       JFrame_entre f=new JFrame_entre();
        f.setVisible(true);
        Class_Dnn Dnn_modele = new Class_Dnn();
        ReadXmlFileDnn instantReadXml;
        
        Class_solution Solution;
        Class_NocArchitecteur Noc;
        Class_noued Noued_source,Noued_destination ;
       instantReadXml=new ReadXmlFileDnn("/input1.xml");
       instantReadXml.setModeleDnn();
        Noc=new Class_NocArchitecteur(2,3,7,5,2,5);
         Solution=new Class_solution(instantReadXml.getDnn_modele(),Noc );
        Solution.genere_population(5);
        System.out.println("finish ");
          
        
        }
         
         
        
        
    }
    
