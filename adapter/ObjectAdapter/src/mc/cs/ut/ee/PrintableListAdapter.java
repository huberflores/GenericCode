package mc.cs.ut.ee;

import java.util.ArrayList;  

//Adapter
public class PrintableListAdapter implements PrintableList{  
  
 public void printList(ArrayList<String> list) {  

  String listString = "";  
  
  for (String s : list)  
  {  
      listString += s + "\t";  
  }  
    

  PrintString ps=new PrintString();  
  ps.print(listString);  
 }  
}  

