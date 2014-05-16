package mc.cs.ut.ee;

import java.util.ArrayList;  

public class AdapterDesignPatternMain {  

//Client
 public static void main(String[] args)  
 {  
  ArrayList<String> list=new  ArrayList<String>();  
  list.add("one");  
  list.add("two");  
  list.add("three");  
  PrintableList pl=new PrintableListAdapter();  
  pl.printList(list);  
    
 }  
}   

