/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projet_mappage;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author user
 */
public class ReadXmlFileDnn {
    private String path;
    public ReadXmlFileDnn(String path){
    this.path=path;
    }
    
       private Class_Dnn Dnn_modele = new Class_Dnn();
        //DomParserDemo Demo;
        
        
       private Class_noued Noued_source,Noued_destination ;
       
        // Demo = new DomParserDemo();
        public void setModeleDnn(){
        try {
            
      
          
         File inputFile = new File(path);
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("layer");
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
                String nom_premier_layer = eElement.getAttribute("name");
                //vous etes dans la 1er layer 
                Dnn_modele.create_layer();
               System.out.println("LayerName est : " 
                  + eElement.getAttribute("name"));
               NodeList ListNeuron= eElement.getElementsByTagName("neuron");
               
               for(int cpt=0 ; cpt<ListNeuron.getLength();cpt++){
               
                  Node bNode=ListNeuron.item(cpt);
                System.out.println("\nCurrent Element :" + bNode.getNodeName());
                if(bNode.getNodeType()==Node.ELEMENT_NODE){
                Element neuron = (Element) bNode;
                String id_neuron = neuron.getAttribute("id");
                String debit =neuron.getElementsByTagName("debit").item(0).getTextContent();
                String energie= neuron.getElementsByTagName("energie").item(0).getTextContent();
                    System.out.println("id neuron est "+id_neuron);
                     System.out.println("debit neuron "+debit);
                      System.out.println("energie neuron "+energie);
                      
                      //il faut cree le noued 
                   
                   Noued_source = new Class_noued(id_neuron,Float.parseFloat(energie),Double.parseDouble(debit));
                      //donc ici pour chaque neuron il faut parcourir la liste de ces connection direct 
                      
                      NodeList ListConnection = neuron.getElementsByTagName("connction");
         System.out.println("----------------------------");
         for(int cpt2=0; cpt2<ListConnection.getLength();cpt2++){
         Node cNode=ListConnection.item(cpt2);
         System.out.println("maintenat on est en  :" + cNode.getNodeName());
         if(cNode.getNodeType()==Node.ELEMENT_NODE){
             Element connection = (Element) cNode;
         System.out.println("----------------------------");
         System.out.println("----------------------------");
         
         NodeList List_neuron_in_Connection = connection.getElementsByTagName("neurondist");
         for(int cpt3=0;cpt3<List_neuron_in_Connection.getLength();cpt3++){
             
             
             Node dNode=List_neuron_in_Connection.item(cpt3);
         System.out.println("maintenat on est en le neuron distination  :" + dNode.getNodeName());
         if(dNode.getNodeType()==Node.ELEMENT_NODE){
             Element neuronDistination = (Element) dNode;
         String id_neuronDistination=neuronDistination.getAttribute("id");
         String debit_distination=neuronDistination.getElementsByTagName("debit").item(0).getTextContent();
         String energie_distination=neuronDistination.getElementsByTagName("energie").item(0).getTextContent();
         String data_send=neuronDistination.getElementsByTagName("datasize").item(0).getTextContent();
         //cree un autre neuron local et ajouter ces information
         
        Noued_destination = new Class_noued(id_neuronDistination,Float.parseFloat(energie_distination),Double.parseDouble(debit_distination));
             System.out.println("id neuron distination est :"+id_neuronDistination);
              System.out.println("debit neuron distination est :"+debit_distination);
               System.out.println("energie neuron distination est :"+energie_distination);
                 System.out.println("datasize neuron distination est :"+data_send);
                 //ajouter ce neuron a la destination de neuron courant
                 
                 Noued_source.add_connect_noued(new Class_connect(Noued_source, Noued_destination, Integer.parseInt(data_send)));
                 
         }
         else{
         System.out.println("sans distination");
         }
         
         
         }
         
        
         
         
         System.out.println("----------------------------");
         System.out.println("----------------------------");}
         
         
         
         }                 
                     
                      
                
        //ajouter le neuron a layer apropris
            Dnn_modele.add_neuron_in_layer(Noued_source);
                }
                
               }
               
               
               
               
            
            //ajouter layer 
            Dnn_modele.add_layer_in_dnn_architecteur_with_position(temp, Dnn_modele.getOne_Layer());
            }
         }
         
        
        } catch (Exception ex) {
            Logger.getLogger(Class_main.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        public Class_Dnn getDnn_modele(){
        return this.Dnn_modele;}
}
