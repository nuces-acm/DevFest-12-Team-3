/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package saqibahmed;
import java.sql.*;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author saqibahmed
 */
public class Saqibahmed {
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String print="";
	String id;
	int i=0;
        int jl=0;
        int j=0;
	int num=0;
	int att=0;
        boolean INT=false;
	boolean available = false;
    	boolean first = true;
        boolean entered = true;
        String select ="";
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection con = DriverManager.getConnection("jdbc:odbc:Project");
    Statement st = con.createStatement();
    
    ResultSet result = st.executeQuery("SELECT * FROM teacher");
    while(result.next()){
	i++;
        String list = result.getString("Iname");
        list+="        "+result.getString("IDNO");
        print+="\n"+list;
        }
    int array[] = new int[i];
    String artime[] = new String[i];
    String lvtime[] = new String[i];
    int arrayl[] = new int[i];
    while(true){
        first =true;
        available =false;
        INT = false;
            select=JOptionPane.showInputDialog("1- Entry.\n2-Leave.");
            if(select.equals("1")){
            id= JOptionPane.showInputDialog("Entry Here:\n"+print+"\nPlease Enter your ID No:");
	String split[] = id.split("");
        
    	for(int l=1; l<split.length; l++){
	    if(split[l].charAt(0)>=48 && split[l].charAt(0)<=57){INT=true;}
    	    else{INT=false;} 
	    }
        if(INT){
        num=Integer.parseInt(id);
        }
        else{JOptionPane.showMessageDialog(null,"it is no integer");}
        result  = st.executeQuery("SELECT * FROM teacher");
	while(result.next()){
	    if(num==Integer.parseInt(result.getString("IDNO"))){available=true;}}
	if(available){
            result = st.executeQuery("SELECT attendence FROM teacher WHERE IDNO="+num+"");
	while(result.next()){
	    att = Integer.parseInt(result.getString("attendence"));
	    att++;
	    }
for(int k=0; k<i; k++){
	    if(num==array[k]){
                first=false;}
            }
	    if(first){
                
                st.executeUpdate("UPDATE teacher SET attendence = "+att+" WHERE IDNO="+num+"");
                array[j]=num;
                Date time=new Date();
                SimpleDateFormat sdfTime=new SimpleDateFormat("HH:mm:ss a");
                String t=sdfTime.format(time) +'\n' ;
                artime[j]=t;
                j++;
                }
            else{JOptionPane.showMessageDialog(null,"Double entry not allowed");}
	    }
        else{JOptionPane.showMessageDialog(null,"it is not available");}}
            else if (select.equals("2")){
            
            
            
        id= JOptionPane.showInputDialog("Entry Here:\n"+print+"\nPlease Enter your ID No:");
	String split[] = id.split("");
        
    	for(int l=1; l<split.length; l++){
	    if(split[l].charAt(0)>=48 && split[l].charAt(0)<=57){INT=true;}
    	    else{INT=false;} 
	    }
        if(INT){
        num=Integer.parseInt(id);
        }
        else{JOptionPane.showMessageDialog(null,"it is no integer");}
for(int k=0; k<i; k++){
	    if(num==array[k]){
                first=false;}
            }
	    if(first){JOptionPane.showMessageDialog(null,"Sorry, record not found eigther you are outsider or your entry attendance is not submitted.");}
            else{
for(int k=0; k<i; k++){
	    if(num==arrayl[k]){
                entered=false;}}
            if(entered){                
                arrayl[jl]=num;
                Date time=new Date();
                SimpleDateFormat sdfTime=new SimpleDateFormat("HH:mm:ss a");
                String t=sdfTime.format(time) +'\n' ;
                artime[jl]=t;
                jl++;
  //              int k;
//                String sp[] =split.array[k];
    }            
            
            else{JOptionPane.showMessageDialog(null,"Double entry not allowed");}
	    }
            
            
                
            }
        System.out.println(array[0]+"  "+array[1]+"  "+array[2]+"  "+array[3]+"  num: "+num+"\n\ntime: "+artime[0]+"  "+artime[1]+"  "+artime[2]+"  "+artime[3]);
        }
        
        }
    }

