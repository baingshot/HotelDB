/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbd;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author bvc
 */
public class Utils {
      
    int modTest(int i){
        if (i==0) return 0;
        if (i>0) return 1;
        return -1;
    }
    
   /* void testf(User1 guest){
          try{
        String pass = guest.getnewpass().getText();
        //1
        //Statement statement = guest.getGuestconn().createStatement(); 
        //statement.executeUpdate("UPDATE Visitors SET password='"+pass+"' WHERE Visitors.idvisitor="+guest.getcurrentuserid()+";");
       //2
//        PreparedStatement statement = guest.getGuestconn().prepareStatement("UPDATE Visitors SET password=? WHERE Visitors.idvisitor=? ;");
//        statement.setString(1,pass);
//        statement.setInt(2,guest.getcurrentuserid());
//        statement.executeUpdate();
        
        }catch( Exception e){
        
        }
    }*/
//Shared------------------------------------------------------------        
    Pair<String[], Object[][]> getdatafortable(ResultSet rs){//, String[] headers, Object[][] data){
//         String[] headers = new String[1];
//         Object[][] data = new String[1][1];
        try{
            
        ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>(); 
      
        int i=0;
        int c = rs.getMetaData().getColumnCount();
        String[] headers = new String[c];
        for( int m =0;m<c;m++){
        headers[m]=rs.getMetaData().getColumnName(m+1);
        }
        
         while (rs.next()) {
             array.add(new ArrayList<String>());
             for(int j =0 ; j< c; j++ )
             {
             array.get(i).add(rs.getString(j+1));
             }
             i++;
         }
         Object[][] data = new String[i][c];
         for( int m =0; m<i;m++) {
         for(int n=0; n<c;n++){
             data[m][n]=array.get(m).get(n);
         }
         }
         
        return new Pair<>(headers, data);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
       // return new Pair<>(headers, data);
       return null;
    }
    
//Guest(User1)------------------------------------------------------    
void openvxodframeGuest(User1 guest ){
    
    // TODO add your handling code here:
        guest.setVisible(false);
        guest.getuservxod().setVisible(true);
        guest.getjPanel2().setVisible(false);
        
         if(guest.getcurrentuserid()!=0){
        guest.setcurrentuserid(0);
        guest.getvxod().setBackground(Color.LIGHT_GRAY);
        }
         
        guest.getservicebox().removeAllItems();
        guest.getmealbox().removeAllItems();
     
        try{
            
         Statement statement = guest.getGuestconn().createStatement();
         try{//Statement---
             
         ResultSet rs = statement.executeQuery("select Services.name from Services;");
         
         try{ //ResultSet-----
             
         while (rs.next()) {
              guest.getservicebox().addItem(rs.getString(1)); 
         }
         rs = statement.executeQuery("select Meal.name from Meal;");
         while (rs.next()) {
              guest.getmealbox().addItem(rs.getString(1)); 
         }
         
         } finally {
              rs.close(); 
         }//----ResultSet
         
         }finally{
             statement.close(); 
         }//----Statement
         
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }  
        
        
            /*if (statement != null ) try {  statement.close(); } catch (SQLException ex) {
                      System.out.println(ex.getMessage());
                 } 
                  if (rs != null) try {  rs.close(); } catch (SQLException ex) {
                      System.out.println(ex.getMessage());
                 } */    
}

void closevxodframeGuest(User1 guest){
      if(guest.getcurrentuserid()!=0){
            guest.setcurrentuserid(0);
            guest.getvxod().setBackground(Color.LIGHT_GRAY);
            guest.getjPanel2().setVisible(false);
            
            String[] headers = new String[4];
            Object[][] data = new String[1][4];
            guest.getusertable().setModel(new javax.swing.table.DefaultTableModel( data, headers ));
        }
}

void vivodallvxodframeGuest(User1 guest){
        try{
        Statement statement = guest.getGuestconn().createStatement();
        
        try{
        
        ResultSet rs = statement.executeQuery("select HotelRegistration.Numrecord, Rooms.number, HotelRegistration.fullcost, HotelRegistration.typeoplata, HotelRegistration.comin, HotelRegistration.comout from\n" +
        "HotelRegistration join Rooms on HotelRegistration.idroom = Rooms.idroom\n" +
        "where HotelRegistration.idvisitor="+guest.getcurrentuserid()+";");
        
        try{
        
        Pair<String[], Object[][]> pair = getdatafortable(rs);
         guest.getusertable().setModel(new javax.swing.table.DefaultTableModel( pair.getValue(), pair.getKey() ));
        } finally {
            rs.close();
        }
        
        } finally {
            statement.close();
        }
        }catch( SQLException e)
        {
            System.out.println(e.getMessage());
        }   
}

void vivodinfovxodframeGuest(User1 guest){
        try{
        Statement statement = guest.getGuestconn().createStatement();
        
        try{
        
        ResultSet rs = statement.executeQuery("select Visitors.surname, Visitors.name, Visitors.number, Visitors.birthdate, Visitors.password from Visitors where Visitors.idvisitor = "+guest.getcurrentuserid()+";");
        
        try{
        
        Pair<String[], Object[][]> pair = getdatafortable(rs);
        guest.getusertable().setModel(new javax.swing.table.DefaultTableModel( pair.getValue(), pair.getKey() ));
        
        } finally{
           rs.close(); 
        }
        
        } finally {
            statement.close();
        }
        
        }catch( SQLException e)
        {
            
        }
}
    
void servicerecordvxodframeGuest(User1 guest){
      try{
        int nrecord = Integer.parseInt(guest.getinfoS().getText());
        Statement statement = guest.getGuestconn().createStatement();
        
        try{
        
        ResultSet rs1 = statement.executeQuery("select HotelRegistration.Numrecord from HotelRegistration where HotelRegistration.idvisitor = "+guest.getcurrentuserid()+";");  
        boolean find = false; 
        try{
        
        while (rs1.next()) {  
             if (nrecord == Integer.parseInt(rs1.getString(1))){
                 find = true;
                 break;
             }
         }
         
        } finally {
            rs1.close();
        }
        
        if(find){
        ResultSet rs = statement.executeQuery("select Services.name, ServiceNrecord.datestart, ServiceNrecord.dateend from ServiceNrecord join Services on ServiceNrecord.idservice= Services.idservice\n" +
"where ServiceNrecord.Numrecord = "+ nrecord +";");
        try{
        Pair<String[], Object[][]> pair = getdatafortable(rs);
        guest.getusertable().setModel(new javax.swing.table.DefaultTableModel( pair.getValue(), pair.getKey() ));
         } finally {
            rs.close();
        }
        
        }else{
            guest.getinfoS().setText("Не ваша запись!");
        }
       
        
        } finally {
            statement.close();
        }
        
        }catch( SQLException e )
        {
            System.out.println(e.getMessage());
        }
}

void mealrecordvxodframeGuest(User1 guest){
       try{
        int nrecord = Integer.parseInt(guest.getinfoM().getText());
         Statement statement = guest.getGuestconn().createStatement();
         try{
         ResultSet rs1 = statement.executeQuery("select HotelRegistration.Numrecord from HotelRegistration where HotelRegistration.idvisitor = "+guest.getcurrentuserid()+";");  
        boolean find = false; 
        try{
        while (rs1.next()) {  
             if (nrecord == Integer.parseInt(rs1.getString(1))){
                 find = true;
                 break;
             }
         }
        } finally {
            rs1.close();
        }
         
         if(find){
        ResultSet rs = statement.executeQuery("select Meal.name, Kategories.name, MealRoom.kolvo, MealRoom.date from (MealRoom join Meal on MealRoom.idmeal = Meal.idmeal) join Kategories on Meal.idkategory = Kategories.idkategory\n" +
"where MealRoom.Numrecord = "+nrecord+";");
     try{   
Pair<String[], Object[][]> pair = getdatafortable(rs);
        
        guest.getusertable().setModel(new javax.swing.table.DefaultTableModel( pair.getValue(), pair.getKey() ));
     } finally {
         rs.close();
     }
         }else{
             guest.getinfoM().setText("Не ваша запись!");
         }
         
         } finally {
             statement.close();
         }
        }catch( SQLException e )
        {
            System.out.println(e.getMessage());
        }
}

void changetelvxodframeGuest(User1 guest){
      try{
        
        PreparedStatement statement = guest.getGuestconn().prepareStatement("UPDATE Visitors SET number=? WHERE Visitors.idvisitor=? ;"); 
        try{
        statement.setString(1,guest.getnewtel().getText());
        statement.setInt(2,guest.getcurrentuserid());
        statement.executeUpdate();
        guest.getnewtel().setText("Номер изменен!");
        } finally {
            statement.close();
        }
        }catch( Exception e){
          System.out.println(e.getMessage());
        }
}

void changepassvxodframeGuest(User1 guest){
      
    try{
        String pass = guest.getnewpass().getText();
        PreparedStatement statement = guest.getGuestconn().prepareStatement("UPDATE Visitors SET password=? WHERE Visitors.idvisitor=? ;"); 
        try{
            statement.setString(1, pass);
            statement.setInt(2, guest.getcurrentuserid());
            statement.executeUpdate();
        guest.getnewpass().setText("Пароль изменен!");
        } finally {
            statement.close();
        }
        }catch( SQLException e){
            System.out.println(e.getMessage());
        }
}

void vxodtovxodframeGuest(User1 guest){
      // TODO add your handling code here:
        String surname="";
        String password="";
        //boolean exist=false;
        try{
            surname=guest.getvxodsurname().getText();
            password=guest.getvxodpassword().getText();
            Statement statement = guest.getGuestconn().createStatement();
            
            try{
            
            ResultSet rs = statement.executeQuery("select Visitors.idvisitor from Visitors where Visitors.surname ='"+surname+"' and Visitors.password='"+password+"'");
           
            try{
            //int idvisitor=0;
            guest.setcurrentuserid(0);
            while (rs.next()) {
                guest.setcurrentuserid(Integer.parseInt(rs.getString(1)));
            }
            if(guest.getcurrentuserid()!=0)
            {
                guest.getvxod().setBackground(Color.green);
                guest.getjPanel2().setVisible(true);
            }
            else{
                guest.getvxod().setBackground(Color.red);
            }
            } finally {
                rs.close();
            }
            } finally {
                statement.close();
            }
        }
        catch( SQLException e ){
            System.out.println(e.getMessage());
        }
}

void addservicevxodframeGuest(User1 guest){
        try{
            int Nrecord = Integer.parseInt(guest.getSrecord().getText());
            int nservice = guest.getservicebox().getSelectedIndex()+1;
            String date1 = guest.getSdate1().getText();
            String date2 = guest.getSdate2().getText();
            Statement statement = guest.getGuestconn().createStatement();
            
            try{
            statement.executeUpdate("insert into ServiceNrecord (Numrecord, idservice, datestart, dateend ) values('"+Nrecord+"','"+nservice+"','"+date1+"','"+date2+"');");
            guest.getlabel17().setText("Добавлено: "+ guest.getservicebox().getItemAt(nservice-1)+" к "+Nrecord+" вашей записи");
            } finally {
                statement.close();
            }
        }
        catch( SQLException e)
        {
            guest.getlabel17().setText("Ошибка!");
        }
}

void addmealvxodframeGuest(User1 guest){
     try{
            int Nrecord = Integer.parseInt(guest.getMrecord().getText());
            int nmeal = guest.getmealbox().getSelectedIndex()+1;
            int namount = Integer.parseInt(guest.getMamount().getText());
            String date = guest.getMdate().getText();
            Statement statement = guest.getGuestconn().createStatement();
            try{
            statement.executeUpdate("insert into MealRoom (Numrecord, idmeal, kolvo, date ) values('"+Nrecord+"','"+nmeal+"','"+namount+"','"+date+"');");
            guest.getlabel17().setText("Добавлено: "+ guest.getmealbox().getItemAt(nmeal-1)+"("+namount+" шт.) к "+Nrecord+" вашей записи");
            } finally {
                statement.close();
            }
            }
        catch( SQLException e)
        {
            guest.getlabel17().setText("Ошибка!");
        }
}

void backvxodframeGuest(User1 guest){
        if(guest.getcurrentuserid()!=0){
            guest.setcurrentuserid(0);
            guest.getvxod().setBackground(Color.LIGHT_GRAY);
        }
        guest.getuservxod().setVisible(false);
        guest.setVisible(true);

}

void zaprosiGuest(User1 guest){// throws Exception{
     // TODO add your handling code here:
//          Statement statement = null;
         try{
             
             try{
             String comintext = guest.getcomin().getText();
             String comouttext = guest.getcomout().getText();
             
             String yearin="",monthin="",dayin="";
             String yearout="",monthout="",dayout="";
             
             dayin = Character.toString(comintext.charAt(8))+Character.toString(comintext.charAt(9));
             monthin = Character.toString(comintext.charAt(5))+Character.toString(comintext.charAt(6));
             yearin = Character.toString(comintext.charAt(0))+Character.toString(comintext.charAt(1))+Character.toString(comintext.charAt(2))+Character.toString(comintext.charAt(3));
             
             dayout = Character.toString(comouttext.charAt(8))+Character.toString(comouttext.charAt(8));
             monthout = Character.toString(comouttext.charAt(5))+Character.toString(comouttext.charAt(6));
             yearout = Character.toString(comouttext.charAt(0))+Character.toString(comouttext.charAt(1))+Character.toString(comintext.charAt(2))+Character.toString(comintext.charAt(3));
             
             int yearinI=0,monthinI=0,dayinI=0;
             int yearoutI=0,monthoutI=0,dayoutI=0;
             
             dayinI = Integer.parseInt(dayin);
             monthinI = Integer.parseInt(monthin);
             yearinI = Integer.parseInt(yearin);
             
             dayoutI = Integer.parseInt(dayout);
             monthoutI = Integer.parseInt(monthout);
             yearoutI = Integer.parseInt(yearout);
             
             if( guest.getusermainzapros().getSelectedIndex()==0){
             guest.getParamsClass().setsqlzaprosiGuest1(yearinI, monthinI, dayinI, yearoutI, monthoutI, dayoutI);
             }
             
             }catch(RuntimeException e)
             {
                 guest.getcomin().setText("Ошибка ввода!");
                 guest.getcomout().setText("Ошибка ввода!");
                 return;
             }
             
        Statement statement = guest.getGuestconn().createStatement();
        try{
         int currentsql=10;
         if( guest.getusermainzapros().getSelectedIndex()==0)
         {
          currentsql =0 ;
         }
         else if(guest.getusermainzapros().getSelectedIndex()==1)
         {
         currentsql =1 ;
         }
         else if(guest.getusermainzapros().getSelectedIndex()==2)
         {
         currentsql =2 ;
         }
        ResultSet rs = statement.executeQuery(guest.getParamsClass().getsqlzaprosiGuest(currentsql));
        try{
       Pair<String[], Object[][]> pair = getdatafortable(rs); 
       
        guest.getguesttable().setModel(new javax.swing.table.DefaultTableModel( pair.getValue(), pair.getKey() ));
        } finally {
            rs.close();
        }
        } finally {
            statement.close();
        }
    }catch(SQLException e) 
    {
        e.printStackTrace();
    }
}

void zaselenieGuest(User1 guest){
//     Statement statement=null;
        int n = 0;
        try{
            String name = guest.getnameuser().getText();
            String surname = guest.getsurnameuser().getText();
            String tel = guest.gettelephone().getText(); 
            String bday = guest.getbirthday().getText();
            String pass = guest.getpassword().getText();
            
            String roomnum = guest.getroomnumber().getText();
            String cmin = guest.getcomin().getText();
            String cmout = guest.getcomout().getText();
            
         Statement statement = guest.getGuestconn().createStatement();
         try{
         
         ResultSet rs1 = statement.executeQuery("select count(Visitors.idvisitor) from Visitors where Visitors.name ='"+name+"' and Visitors.surname ='"+surname+"' and Visitors.birthdate = '"+bday+"';");
         try{
         while (rs1.next()) {
         n = Integer.parseInt(rs1.getString(1));  
         }
           } finally{
             rs1.close();
         }
         
         if(n == 0)
         {
             //записываем пользователя в таблицу Visitors
             guest.geterrorlabel().setText("Такого юзера нет,запишем его в таблицу,оформим номер");
             statement.executeUpdate("INSERT INTO Visitors (surname, name, number, birthdate, password) values('"+surname+"','"+name+"','"+tel+"','"+bday+"','"+pass+"');");
             ResultSet rs = statement.executeQuery("select max(Visitors.idvisitor) from Visitors;");
             
             try{
             
             int idvisitor=0;
              while (rs.next()) {
                idvisitor = Integer.parseInt(rs.getString(1));  
              }
              int roomID=0;
              double roomCOST=0;
              rs = statement.executeQuery("select Rooms.idroom, Rooms.roomcost from Rooms where Rooms.number = '"+roomnum+"';");
              while (rs.next()) {
                roomID = Integer.parseInt(rs.getString(1));  
                roomCOST = Double.parseDouble(rs.getString(2));
              }
              String type="";
              if(guest.gettypeoplata().getSelectedIndex()==0)
              {
                  type="карта";
              }
              else if(guest.gettypeoplata().getSelectedIndex()==1)
              {
                  type="наличные";
              }
             statement.executeUpdate("INSERT INTO HotelRegistration (idroom, fullcost, idvisitor, typeoplata, comin, comout) values('"+roomID+"','"+roomCOST+"','"+idvisitor+"','"+type+"','"+cmin+"','"+cmout+"');");
             guest.getlabel11().setText("Заказ успешный, воспользуйтесь личным паролем для входа в систему:");
             guest.getlabel12().setText(pass); 
             } finally {
                 rs.close();
             }
         }   
         else
         {
             //ищем id этого пользователя
             guest.geterrorlabel().setText("Такой юзер есть, оформим на него номер");
             ResultSet rs = statement.executeQuery("select Visitors.idvisitor from Visitors where Visitors.name ='"+name+"' and Visitors.surname ='"+surname+"' and Visitors.birthdate = '"+bday+"';");
            try{
             int idvisitor=0;
             while (rs.next()) {
                idvisitor = Integer.parseInt(rs.getString(1));  
             }
             
             int roomID=0;
              double roomCOST=0;
              rs = statement.executeQuery("select Rooms.idroom, Rooms.roomcost from Rooms where Rooms.number = '"+roomnum+"';");
              while (rs.next()) {
                roomID = Integer.parseInt(rs.getString(1));  
                roomCOST = Double.parseDouble(rs.getString(2));
              }
              String type="";
              if(guest.gettypeoplata().getSelectedIndex()==0)
              {
                  type="карта";
              }
              else if(guest.gettypeoplata().getSelectedIndex()==1)
              {
                  type="наличные";
              }
             statement.executeUpdate("INSERT INTO HotelRegistration (idroom, fullcost, idvisitor, typeoplata, comin, comout) values('"+roomID+"','"+roomCOST+"','"+idvisitor+"','"+type+"','"+cmin+"','"+cmout+"');");
             guest.getlabel11().setText("Заказ успешный, воспользуйтесь личным паролем для входа в систему:");
             guest.getlabel12().setText(pass);
            } finally {
                rs.close();
            }
         }
         //записываем его в таблицу HotelRegistration
       
         } finally {
             statement.close();
         }
        }
        catch( SQLException e )
        {
            //errorlabel.setText("Проверьте правильность ввода!");
                guest.geterrorlabel().setText(e.getMessage());
                 guest.getlabel11().setText("");
                 guest.getlabel12().setText("");
        }
}

//HAdmin(User2)------------------------------------------------

void zaprosiHAdmin(User2 HAdmin){
      // TODO add your handling code here:
        try{
         Statement statement = HAdmin.getAdminconn().createStatement();
         try{
         int currentsql=0;
         if( HAdmin.getshowall().getSelectedIndex()==0)
         {
          currentsql =0 ;
         }
         else if(HAdmin.getshowall().getSelectedIndex()==1)
         {
         currentsql =1 ;
         }
         else if(HAdmin.getshowall().getSelectedIndex()==2)
         {
         currentsql =2 ;
         }
         else if(HAdmin.getshowall().getSelectedIndex()==3)
         {
            currentsql =3 ; 
         }
         else if(HAdmin.getshowall().getSelectedIndex()==4)
         {
             currentsql =4 ;
         }
         else if( HAdmin.getshowall().getSelectedIndex()==5)
         {
             currentsql =5 ;
         }
         else if( HAdmin.getshowall().getSelectedIndex()==6)
         {
             currentsql =6 ;
         }
         else if( HAdmin.getshowall().getSelectedIndex()==7)
         {
             currentsql =7 ;
         }
       
        ResultSet rs = statement.executeQuery(HAdmin.getParamsClass().getsqlzaprosiHAdmin(currentsql));
        try{
        Pair<String[], Object[][]> pair = getdatafortable(rs);
    
          HAdmin.getadmintable().setModel(new javax.swing.table.DefaultTableModel( pair.getValue(), pair.getKey() ));
        } finally {
            rs.close();
        }
          
         } finally {
             statement.close();
         }
          
         } catch( SQLException e){
                System.out.println(e.getMessage());
                }
}

void zaprosiTOPHAdmin(User2 HAdmin){
       try{
         Statement statement = HAdmin.getAdminconn().createStatement();
         try{
         ResultSet rs = statement.executeQuery(HAdmin.getParamsClass().getsqlzaprosiTOPHAdmin(HAdmin.getmainzaprosi().getSelectedIndex())); 
         
         try{
         
         Pair<String[], Object[][]> pair = getdatafortable(rs);
         HAdmin.getadmintable().setModel(new javax.swing.table.DefaultTableModel( pair.getValue(), pair.getKey() ));
        
         } finally {
             rs.close();
         }
         
         } finally {
             statement.close();
         }
         
         }
        catch( SQLException e){
                System.out.println(e.getMessage());
                }
        
}

void newGuestHadmin(User2 HAdmin){
       try{
        int idroom = Integer.parseInt((String)HAdmin.gethotelregistration().getValueAt(0,0));
        int fullcost = Integer.parseInt((String)HAdmin.gethotelregistration().getValueAt(0,1));
        int idvisitor = Integer.parseInt((String)HAdmin.gethotelregistration().getValueAt(0,2));
        String typeoplata = (String)HAdmin.gethotelregistration().getValueAt(0,3);
        String zaezd = (String)HAdmin.gethotelregistration().getValueAt(0,4);
        String viezd = (String)HAdmin.gethotelregistration().getValueAt(0,5);
        
        Statement statement = HAdmin.getAdminconn().createStatement();
        
        try{
        
        statement.executeUpdate("INSERT INTO HotelRegistration (idroom, fullcost, idvisitor, typeoplata, comin, comout) values('"+idroom+"','"+fullcost+"','"+idvisitor+"','"+typeoplata+"','"+zaezd+"','"+viezd+"');");
        HAdmin.getnewrecord().setBackground(Color.green);
       
        } finally {
            statement.close();
        }
        
        }catch( SQLException e )
        {
            HAdmin.getnewrecord().setBackground(Color.red);
        }
}

void newRoomHAdmin(User2 HAdmin){
    try{
        int number = Integer.parseInt((String)HAdmin.getrooms().getValueAt(0,0));
        String type = (String)HAdmin.getrooms().getValueAt(0,1);
        int floor = Integer.parseInt((String)HAdmin.getrooms().getValueAt(0,2));
        String view = (String)HAdmin.getrooms().getValueAt(0,3);
        int kolvo = Integer.parseInt((String)HAdmin.getrooms().getValueAt(0,4));
        int cost = Integer.parseInt((String)HAdmin.getrooms().getValueAt(0,5));
              
        Statement statement = HAdmin.getAdminconn().createStatement();
        
        try{
        
        statement.executeUpdate("INSERT INTO Rooms(number, type, floor, viewfromwindow, roomsnumber, roomcost) values('"+number+"','"+type+"','"+floor+"','"+view+"','"+kolvo+"','"+cost+"');");
        HAdmin.getnewroom().setBackground(Color.green);
        
        } finally {
            statement.close();
        }
        
        }catch( SQLException e )
        {
           HAdmin.getnewroom().setBackground(Color.red); 
        }
}

void editRoomHAdmin(User2 HAdmin){
          try{
        int roomid = Integer.parseInt(HAdmin.getjTextField2().getText());
 
        int number = Integer.parseInt((String)HAdmin.getrooms().getValueAt(0,0));
        String type = (String)HAdmin.getrooms().getValueAt(0,1);
        int floor = Integer.parseInt((String)HAdmin.getrooms().getValueAt(0,2));
        String view = (String)HAdmin.getrooms().getValueAt(0,3);
        int kolvo = Integer.parseInt((String)HAdmin.getrooms().getValueAt(0,4));
        int cost = Integer.parseInt((String)HAdmin.getrooms().getValueAt(0,5));
        
        Statement statement = HAdmin.getAdminconn().createStatement();
        
        try{
        
        statement.executeUpdate("UPDATE Rooms SET number='"+number+"', type='"+type+"',floor='"+floor+"',viewfromwindow='"+view+"',roomsnumber='"+kolvo+"', roomcost='"+cost+"' WHERE Rooms.idroom="+roomid+";");
         HAdmin.geteditroom().setBackground(Color.green);
         //editroom.setBackground(Color.LIGHT_GRAY);
         
        } finally {
            statement.close();
        }
            }catch( SQLException e )
            {
                HAdmin.geteditroom().setBackground(Color.red);
            }
}

void newServiceHAdmin(User2 HAdmin){
     try{
        String newservice = (String)HAdmin.getservices().getValueAt(0,0);
        Statement statement = HAdmin.getAdminconn().createStatement();
        
        try{
        
        statement.executeUpdate("INSERT INTO Services(name) values('"+newservice+"');");
        HAdmin.getaddservice().setBackground(Color.green);
        
        } finally {
            statement.close();
        }
        
        }catch( SQLException e ){
            HAdmin.getaddservice().setBackground(Color.red);
        }
        
}

void editserviceHAdmin(User2 HAdmin){
      try{
        int serviceid = Integer.parseInt(HAdmin.getjTextField3().getText());
        String newservice = (String)HAdmin.getservices().getValueAt(0,0);
        Statement statement = HAdmin.getAdminconn().createStatement();
        
        try{
        
        statement.executeUpdate("UPDATE Services SET name='"+newservice+"' WHERE Services.idservice="+serviceid+";");
         HAdmin.geteditservice().setBackground(Color.green);
         
        } finally {
            statement.close();
        }
         
        }catch( SQLException e ){
            HAdmin.geteditservice().setBackground(Color.red);
        }
        
}

void deletesmthHAdmin(User2 HAdmin){
        try{
        int idf = Integer.parseInt(HAdmin.getid1().getText());
        if(HAdmin.getdeletebox().getSelectedIndex()==0){          
        Statement statement = HAdmin.getAdminconn().createStatement();
        try{
        statement.executeUpdate("DELETE FROM Rooms WHERE Rooms.idroom="+idf+";");
        } finally {
            statement.close();
        }
        }
        else if(HAdmin.getdeletebox().getSelectedIndex()==1){
            int ids = Integer.parseInt(HAdmin.getid2().getText());
            Statement statement = HAdmin.getAdminconn().createStatement();
            try{
            statement.executeUpdate("DELETE FROM ServiceNrecord WHERE ServiceNrecord.Numrecord="+idf+" and ServiceNrecord.idservice ="+ids+";");  
         } finally {  statement.close();
        }
            }
        else if(HAdmin.getdeletebox().getSelectedIndex()==2){           
            Statement statement = HAdmin.getAdminconn().createStatement();
                try{
            statement.executeUpdate("DELETE FROM Services WHERE Services.idservice ="+idf+";");
             } finally {  statement.close();
        }
        }
        else if(HAdmin.getdeletebox().getSelectedIndex()==3){
            int ids = Integer.parseInt(HAdmin.getid2().getText());
            Statement statement = HAdmin.getAdminconn().createStatement();
                try{
            statement.executeUpdate("DELETE FROM MealRoom WHERE MealRoom.Numrecord="+idf+" and MealRoom.idmeal ="+ids+";");  
                 } finally {  statement.close();
        }
        }
       
        HAdmin.getdeleteA().setBackground(Color.green);
         }catch( SQLException e){
                HAdmin.getdeleteA().setBackground(Color.red);
            }
}

//RestAdmin(User3)---------------------------------------------
void zaprosiRestAdmin(User3 RestAdmin){
     try{
        Statement statement = RestAdmin.getRestconn().createStatement();
        
        try{
        
        ResultSet rs = statement.executeQuery(RestAdmin.getParamsClass().getsqlzaprosiRestAdmin(RestAdmin.getrestbox().getSelectedIndex()));
        try{
        Pair<String[], Object[][]> pair = getdatafortable(rs);
  
        RestAdmin.getresttable().setModel(new javax.swing.table.DefaultTableModel( pair.getValue(), pair.getKey() ));
        } finally {
            rs.close();
        }
        } finally {
            statement.close();
        }
        }catch( SQLException e){
            System.out.println(e.getMessage());
        }
}

void newmealRestAdmin(User3 RestAdmin){
        try{
        String name = (String)RestAdmin.getrestmeal().getValueAt(0,0);
        int cost = Integer.parseInt((String)RestAdmin.getrestmeal().getValueAt(0,1));
        int idkategory = Integer.parseInt((String)RestAdmin.getrestmeal().getValueAt(0,2));
        
        Statement statement = RestAdmin.getRestconn().createStatement();
        try{
        statement.executeUpdate("INSERT INTO Meal(name, cost, idkategory) values('"+name+"','"+cost+"','"+idkategory+"');");
        RestAdmin.getaddmeal().setBackground(Color.green);
        } finally {
            statement.close();
        }
        }catch( SQLException e )
        {
           RestAdmin.getaddmeal().setBackground(Color.red); 
        }
}
void editmealRestAdmin(User3 RestAdmin){
    try{
        int idm = Integer.parseInt(RestAdmin.geteditm().getText());
        String name = (String)RestAdmin.getrestmeal().getValueAt(0,0);
        int cost = Integer.parseInt((String)RestAdmin.getrestmeal().getValueAt(0,1));
        int idkategory = Integer.parseInt((String)RestAdmin.getrestmeal().getValueAt(0,2));
        
        Statement statement = RestAdmin.getRestconn().createStatement();
        try{
        statement.executeUpdate("UPDATE Meal SET name='"+name+"', cost='"+cost+"', idkategory='"+idkategory+"' where Meal.idmeal= "+idm+";");
        RestAdmin.getjButton2().setBackground(Color.green);
        } finally {
            statement.close();
        }
        }catch( SQLException e )
        {
           RestAdmin.getjButton2().setBackground(Color.red); 
        }
}

void newcategoryRestAdmin(User3 RestAdmin){
     try{
        String name = (String)RestAdmin.getrestkategory().getValueAt(0,0);
        
        Statement statement = RestAdmin.getRestconn().createStatement();
        try{
        statement.executeUpdate("INSERT INTO Kategories(name) values('"+name+"');");
        RestAdmin.getaddkategory().setBackground(Color.green);
        } finally {
            statement.close();
        }
        }catch( SQLException e )
        {
           RestAdmin.getaddkategory().setBackground(Color.red); 
        }
}
void editcategoryRestAdmin(User3 RestAdmin){
          try{
        int idk = Integer.parseInt(RestAdmin.geteditk().getText());
        String name = (String)RestAdmin.getrestkategory().getValueAt(0,0);
        
        Statement statement = RestAdmin.getRestconn().createStatement();
        try{
        statement.executeUpdate("UPDATE Kategories set name='"+name+"' where Kategories.idkategory = '"+idk+"';");
        RestAdmin.getjButton3().setBackground(Color.green);
        } finally {
            statement.close();
        }
        }catch( SQLException e )
        {
           RestAdmin.getjButton3().setBackground(Color.red); 
        }
}

void newmpRestAdmin(User3 RestAdmin){
         try{
        int idmeal = Integer.parseInt((String)RestAdmin.getrestmp().getValueAt(0,0));
        int idproduct = Integer.parseInt((String)RestAdmin.getrestmp().getValueAt(0,1));
        double kolvo = Double.parseDouble((String)RestAdmin.getrestmp().getValueAt(0,2));
            
        Statement statement = RestAdmin.getRestconn().createStatement();
        try{
        statement.executeUpdate("INSERT INTO MealProducts(idmeal, idproduct, kolvo) values('"+idmeal+"','"+idproduct+"','"+kolvo+"');");
        RestAdmin.getaddmp().setBackground(Color.green);
        } finally {
            statement.close();
        }
        }catch( SQLException e )
        {
           RestAdmin.getaddmp().setBackground(Color.red); 
        }
}

void newpRestAdmin(User3 RestAdmin){
          try{
        String name = (String)RestAdmin.getrestp().getValueAt(0,0);
        int kolvo = Integer.parseInt((String)RestAdmin.getrestp().getValueAt(0,1));
            
        Statement statement = RestAdmin.getRestconn().createStatement();
        try{
        statement.executeUpdate("INSERT INTO Products(name, kolvo) values('"+name+"','"+kolvo+"');");
        RestAdmin.getaddp().setBackground(Color.green);
        } finally {
            statement.close();
        }
        }catch( SQLException e )
        {
           RestAdmin.getaddp().setBackground(Color.red); 
        }
}
void editpRestAdmin(User3 RestAdmin){
          try{
        int idp = Integer.parseInt(RestAdmin.geteditp().getText());
        String name = (String)RestAdmin.getrestp().getValueAt(0,0);
        int kolvo = Integer.parseInt((String)RestAdmin.getrestp().getValueAt(0,1));
            
        Statement statement = RestAdmin.getRestconn().createStatement();
        try{
        statement.executeUpdate("UPDATE Products set name='"+name+"', kolvo='"+kolvo+"' where Products.idproduct = "+idp+" ;");
        RestAdmin.getjButton5().setBackground(Color.green);
        } finally {
            statement.close();
        }
        }catch( SQLException e )
        {
           RestAdmin.getjButton5().setBackground(Color.red); 
        }
}

void newpnRestAdmin(User3 RestAdmin){
               try{
        int idn = Integer.parseInt((String)RestAdmin.getrestpn().getValueAt(0,0));
        int idp = Integer.parseInt((String)RestAdmin.getrestpn().getValueAt(0,1));         
        int kolvo = Integer.parseInt((String)RestAdmin.getrestpn().getValueAt(0,2));
        int cost = Integer.parseInt((String)RestAdmin.getrestpn().getValueAt(0,3)); 
            
        Statement statement = RestAdmin.getRestconn().createStatement();
        try{
        statement.executeUpdate("INSERT INTO ProductsNakladnie(idnakladnoy, kolvo, cost, idproduct) values('"+idn+"','"+kolvo+"','"+cost+"','"+idp+"');");
        RestAdmin.getaddpn().setBackground(Color.green);
        } finally {
            statement.close();
        }
        }catch( SQLException e )
        {
           RestAdmin.getaddpn().setBackground(Color.red); 
        }
}

void newnRestAdmin(User3 RestAdmin){
        try{
        String date = (String)RestAdmin.getrestn().getValueAt(0,0);
        String company = (String)RestAdmin.getrestn().getValueAt(0,1);
            
        Statement statement = RestAdmin.getRestconn().createStatement();
        try{
        statement.executeUpdate("INSERT INTO Nakladnie(data, company) values('"+date+"','"+company+"');");
        RestAdmin.getaddn().setBackground(Color.green);
        } finally {
            statement.close();
        }
        }catch( SQLException e )
        {
           RestAdmin.getaddn().setBackground(Color.red); 
        }
}
void editnRestAdmin(User3 RestAdmin){
       try{
              int idn = Integer.parseInt(RestAdmin.geteditn().getText());
        String date = (String)RestAdmin.getrestn().getValueAt(0,0);
        String company = (String)RestAdmin.getrestn().getValueAt(0,1);
            
        Statement statement = RestAdmin.getRestconn().createStatement();
        try{
        statement.executeUpdate("UPDATE Nakladnie set data='"+date+"', company='"+company+"' where Nakladnie.idnakladnoy = "+idn+";");
        RestAdmin.getjButton7().setBackground(Color.green);
        } finally {
            statement.close();
        }
        }catch( SQLException e )
        {
           RestAdmin.getjButton7().setBackground(Color.red); 
        }
}

void deletesmthRestAdmin(User3 RestAdmin){
      try{
        int idf = Integer.parseInt(RestAdmin.getid1().getText());
        if(RestAdmin.getdeletebox().getSelectedIndex()==0){          
        Statement statement = RestAdmin.getRestconn().createStatement();
        try{
        statement.executeUpdate("DELETE FROM Meal WHERE Meal.idmeal="+idf+";"); 
        } finally {
            statement.close();
        }
        }
        else if(RestAdmin.getdeletebox().getSelectedIndex()==1){           
        Statement statement = RestAdmin.getRestconn().createStatement();
                try{
        statement.executeUpdate("DELETE FROM Kategories WHERE Kategories.idkategory="+idf+";");
           } finally {
            statement.close();
        }
        }
        else if(RestAdmin.getdeletebox().getSelectedIndex()==2){
            int ids = Integer.parseInt(RestAdmin.getid2().getText());
            Statement statement = RestAdmin.getRestconn().createStatement();
                try{
            statement.executeUpdate("DELETE FROM MealProducts WHERE MealProducts.idmeal ="+idf+" and MealProducts.idproduct= "+ids+";");
           } finally {
            statement.close();
        }
                }
        else if(RestAdmin.getdeletebox().getSelectedIndex()==3){
            Statement statement = RestAdmin.getRestconn().createStatement();
                try{
            statement.executeUpdate("DELETE FROM Products WHERE Products.idproduct="+idf+";");  
               } finally {
            statement.close();
        }
        }
        else if(RestAdmin.getdeletebox().getSelectedIndex()==4){
            int ids = Integer.parseInt(RestAdmin.getid2().getText());
            Statement statement = RestAdmin.getRestconn().createStatement();
                try{
            statement.executeUpdate("DELETE FROM ProductsNakladnie WHERE ProductsNakladnie.idnakladnoy ="+idf+" and ProductsNakladnie.idproduct= "+ids+";");
          } finally {
            statement.close();
        }
                }
        else if(RestAdmin.getdeletebox().getSelectedIndex()==5){
            Statement statement = RestAdmin.getRestconn().createStatement();
                try{
            statement.executeUpdate("DELETE FROM Nakladnie WHERE Nakladnie.idnakladnoy="+idf+";");
               } finally {
            statement.close();
        }
        }
        RestAdmin.getdeleteRest().setBackground(Color.green);
         }catch( SQLException e){
                RestAdmin.getdeleteRest().setBackground(Color.red);
            }
}
}
