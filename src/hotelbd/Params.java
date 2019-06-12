/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbd;

/**
 *
 * @author bvc
 */
public class Params {
    //-----------------------------------------GUEST----------------------------
   private static String[] sqlzaprosiGuest ={
"select Rooms.idroom, Rooms.number, Rooms.type,Rooms.floor,Rooms.viewfromwindow,Rooms.roomsnumber,Rooms.roomcost from Rooms where Rooms.idroom in\n" +
"(select Rooms.idroom from Rooms where not exists ( select * from HotelRegistration where HotelRegistration.idroom = Rooms.idroom and (YEAR(HotelRegistration.comout)= 2015 and YEAR(HotelRegistration.comin)= 2015 and (( \n" +
" (MONTH(HotelRegistration.comin)<8 and MONTH(HotelRegistration.comout)>11) or (MONTH(HotelRegistration.comin)>8 and MONTH(HotelRegistration.comout)<11)\n" +
" or ( (MONTH(HotelRegistration.comin)>8 and MONTH(HotelRegistration.comout)>11 and MONTH(HotelRegistration.comin)<11) or (MONTH(HotelRegistration.comin)<8 and MONTH(HotelRegistration.comout)<11 and MONTH(HotelRegistration.comout)>8))) or\n" +
"  ( MONTH(HotelRegistration.comin)=8 and MONTH(HotelRegistration.comout)=11 and  \n" +
" ( ((DAY(HotelRegistration.comin)>10 and DAY(HotelRegistration.comout)>20 and DAY(HotelRegistration.comin)<20) or (DAY(HotelRegistration.comout)<20 and DAY(HotelRegistration.comout)>10 and DAY(HotelRegistration.comin)<10)) \n" +
" or (DAY(HotelRegistration.comin)>10 and DAY(HotelRegistration.comout)<20) or (DAY(HotelRegistration.comin)<10 and DAY(HotelRegistration.comout)>20) ))))));"
            ,
"select Services.name from Services;"
            ,
"select Meal.name, Meal.cost, Kategories.name from Meal join Kategories on Meal.idkategory = Kategories.idkategory;"
    };
   
   void setsqlzaprosiGuest1(int yearinI, int monthinI, int dayinI, int yearoutI, int monthoutI, int dayoutI){
       sqlzaprosiGuest[0]= "select  Rooms.number, Rooms.type,Rooms.floor,Rooms.viewfromwindow,Rooms.roomsnumber,Rooms.roomcost from Rooms where Rooms.idroom in\n" +
"(select Rooms.idroom from Rooms where not exists ( select * from HotelRegistration where HotelRegistration.idroom = Rooms.idroom and (YEAR(HotelRegistration.comout)= "+yearoutI+" and YEAR(HotelRegistration.comin)= "+yearinI+" and (( \n" +
" (MONTH(HotelRegistration.comin)<"+monthinI +"and MONTH(HotelRegistration.comout)>"+monthoutI+" ) or (MONTH(HotelRegistration.comin)>"+monthinI + "and MONTH(HotelRegistration.comout)<"+monthoutI+")\n" +
" or ( (MONTH(HotelRegistration.comin)>"+monthinI +" and MONTH(HotelRegistration.comout)>"+monthoutI+" and MONTH(HotelRegistration.comin)<"+monthoutI+") or (MONTH(HotelRegistration.comin)<"+monthinI +" and MONTH(HotelRegistration.comout)<"+monthoutI+" and MONTH(HotelRegistration.comout)>"+monthinI +"))) or\n" +
"  ( MONTH(HotelRegistration.comin)="+monthinI +" or MONTH(HotelRegistration.comout)="+monthoutI+" and  \n" +
" ( ((DAY(HotelRegistration.comin)>"+dayinI+" and DAY(HotelRegistration.comout)>"+dayoutI+" and DAY(HotelRegistration.comin)<"+dayoutI+") or (DAY(HotelRegistration.comout)<"+dayoutI+" and DAY(HotelRegistration.comout)>"+dayinI+" and DAY(HotelRegistration.comin)<"+dayinI+" )) \n" +
" or (DAY(HotelRegistration.comin)>"+dayinI+" and DAY(HotelRegistration.comout)<"+dayoutI+" ) or (DAY(HotelRegistration.comin)<"+dayinI+" and DAY(HotelRegistration.comout)>"+dayoutI+" ) ))))));";
   }
   
   String getsqlzaprosiGuest(int i){
       return sqlzaprosiGuest[i];
   }
    
   //---------------------------------------------------------------------------
   
   //------------------------------------------------------------------HAdmin---
   
   private static String[] sqlzaprosiHAdmin ={
    "select HotelRegistration.Numrecord, Rooms.number, HotelRegistration.fullcost, Visitors.surname, Visitors.name, HotelRegistration.typeoplata, HotelRegistration.comin, HotelRegistration.comout from (HotelRegistration join Rooms on HotelRegistration.idroom =Rooms.idroom) join Visitors on HotelRegistration.idvisitor = Visitors.idvisitor;",
        "select Rooms.idroom, Rooms.number, Rooms.type, Rooms.floor, Rooms.viewfromwindow, Rooms.roomsnumber, Rooms.roomcost from Rooms;",
        "select Visitors.idvisitor, Visitors.surname, Visitors.name, Visitors.number, Visitors.birthdate from Visitors;",
        "select Services.idservice, Services.name from Services;",
        
        "select ServiceNrecord.Numrecord, Services.name, ServiceNrecord.idservice, ServiceNrecord.datestart, ServiceNrecord.dateend from ServiceNrecord join Services on ServiceNrecord.idservice = Services.idservice;",
        "select Meal.idmeal, Meal.name, Meal.cost, Kategories.name from Meal join Kategories on Meal.idkategory =Kategories.idkategory; ",
        "select MealRoom.Numrecord, Meal.name, Meal.idmeal, MealRoom.kolvo, MealRoom.date from MealRoom join Meal on MealRoom.idmeal = Meal.idmeal;",
        "select Kategories.idkategory, Kategories.name from Kategories;"
        
    };
   
   private static String[] sqlzaprosiTOPHAdmin ={
        "Select distinct(Visitors.surname), Rooms.number from \n" +
"(((( HotelRegistration left outer join Visitors on HotelRegistration.idvisitor = Visitors.idvisitor)\n" +
"left outer join Rooms on HotelRegistration.idroom = Rooms.idroom )\n" +
"left outer join MealRoom on HotelRegistration.Numrecord = MealRoom.Numrecord)\n" +
"left outer join Meal on MealRoom.idmeal = Meal.idmeal) \n" +
"where HotelRegistration.typeoplata = 'карта' and Meal.cost = (select MAX(Meal.cost) from Meal);", 
        "Select distinct(HotelRegistration.Numrecord), Visitors.name, Visitors.surname, HotelRegistration.comin, HotelRegistration.comout  from \n" +
"(((HotelRegistration left outer join Visitors on HotelRegistration.idvisitor = Visitors.idvisitor)\n" +
"left outer join MealRoom on HotelRegistration.Numrecord = MealRoom.Numrecord) \n" +
"left outer join Meal on MealRoom.idmeal = Meal.idmeal) where Meal.name = 'стейк' and MealRoom.kolvo>3;",
        "select Meal.name, Meal.cost from\n" +
"((Meal left outer join MealProducts on Meal.idmeal = MealProducts.idmeal ) \n" +
"left outer join Products on MealProducts.idproduct = Products.idproduct) \n" +
"where Products.name = 'мясо' and MealProducts.kolvo = (select MAX(MealProducts.kolvo) from MealProducts left outer join Products on MealProducts.idproduct = Products.idproduct where Products.name = 'мясо' )\n" +
"or Products.name = 'рыба' and MealProducts.kolvo = (select MIN(MealProducts.kolvo) from MealProducts left outer join Products on MealProducts.idproduct = Products.idproduct where Products.name = 'рыба' ) ;",
        "select AVG(datediff(year,Visitors.birthdate,getdate())) as avg_age from Visitors where Visitors.idvisitor in\n" +
"(select distinct(Visitors.idvisitor) from ((((HotelRegistration left outer join Visitors on HotelRegistration.idvisitor = Visitors.idvisitor)\n" +
"left outer join Rooms on HotelRegistration.idroom = Rooms.idroom)\n" +
"left outer join ServiceNrecord on HotelRegistration.Numrecord = ServiceNrecord.Numrecord)\n" +
"left outer join Services on ServiceNrecord.idservice = Services.idservice)\n" +
"where (Services.name = 'сейф' or Services.name='уборка в номере') and Rooms.viewfromwindow = 'залив');",
        "select Meal.name, Products.name, MealProducts.kolvo from \n" +
" ((Meal left outer join MealProducts on Meal.idmeal = MealProducts.idmeal) \n" +
" left outer join Products on MealProducts.idproduct = Products.idproduct)\n" +
" where Meal.idmeal in (select Meal.idmeal from Meal\n" +
"  where Meal.idmeal in( select MealRoom.idmeal from MealRoom\n" +
"   group by MealRoom.idmeal having count(MealRoom.idmeal)>2 ) and Meal.cost>( select AVG(Meal.cost) from Meal)); ",
        
        "Select 'Количество машин = ' + convert(char(15), ceiling(SUM(ProductsNakladnie.kolvo*1.0)/300))\n" +
"as cars from ProductsNakladnie left outer join Nakladnie on ProductsNakladnie.idnakladnoy= Nakladnie.idnakladnoy\n" +
"where Nakladnie.company='экопит' and datediff(WEEK,Nakladnie.data,getdate())<3;", 
        "select 'Средняя стоимость = ' + convert(char(15), AVG(Meal.cost)) from ((Meal left outer join MealRoom on Meal.idmeal=MealRoom.idmeal)\n" +
"left outer join HotelRegistration on MealRoom.Numrecord= HotelRegistration.Numrecord)\n" +
"where HotelRegistration.typeoplata='наличные' and datediff(WEEK,getdate(), HotelRegistration.comout)>0;",
        "select Rooms.number, Visitors.name, Visitors.surname, HotelRegistration.comin, HotelRegistration.comout from \n" +
" ((HotelRegistration left outer join Rooms on HotelRegistration.idroom = Rooms.idroom)\n" +
" left outer join Visitors on HotelRegistration.idvisitor = Visitors.idvisitor)\n" +
" where HotelRegistration.Numrecord = ( select Numrecord from Zapros8finalTable where FullCost = ( select MAX(FullCost) from Zapros8finalTable));",
        "select Visitors.name, Visitors.surname from Visitors \n" +
"where Visitors.idvisitor in\n" +
"\n" +
"(select HotelRegistration.idvisitor from HotelRegistration group by HotelRegistration.idvisitor\n" +
"having HotelRegistration.idvisitor in \n" +
"\n" +
"(select HotelRegistration.idvisitor from HotelRegistration left outer join Visitors on HotelRegistration.idvisitor = Visitors.idvisitor\n" +
"where MONTH(HotelRegistration.comin)<12 and MONTH(HotelRegistration.comin)>2 and MONTH(HotelRegistration.comout)<12 and MONTH(HotelRegistration.comout)>2 and (YEAR(HotelRegistration.comin)=YEAR(HotelRegistration.comout))));",
        "select Visitors.surname, Visitors.name, Visitors.birthdate from Visitors where Visitors.idvisitor in\n" +
"(select HotelRegistration.idvisitor from HotelRegistration, Months \n" +
"where MONTH(HotelRegistration.comin) = Months.months and YEAR(HotelRegistration.comin) = 2015\n" +
"group by HotelRegistration.idvisitor\n" +
"having count(distinct(MONTH(HotelRegistration.comin))) = (select count(Months.months) from Months));",
            
    };
   
   String getsqlzaprosiHAdmin(int i){
       return sqlzaprosiHAdmin[i];
   }
   
     String getsqlzaprosiTOPHAdmin(int i){
       return sqlzaprosiTOPHAdmin[i];
   }
   
   //------------------------------------------------------------------HAdmin
     
   //------------------------------------------------------------------RestAdmin  
     
     private static String[] sqlzaprosiRestAdmin ={
        "select Meal.idmeal, Meal.name, Meal.cost, Kategories.name from Meal join Kategories on Meal.idkategory =Kategories.idkategory;",
        "select Kategories.idkategory, Kategories.name from Kategories;",
        "select Meal.idmeal, Meal.name, Products.idproduct, Products.name, MealProducts.kolvo from (MealProducts join Meal on MealProducts.idmeal = Meal.idmeal) join Products on MealProducts.idproduct = Products.idproduct;",
        
        "select Products.idproduct, Products.name, Products.kolvo from Products;",
        "select Nakladnie.data, Nakladnie.idnakladnoy, Nakladnie.company, Products.idproduct, Products.name, ProductsNakladnie.kolvo, ProductsNakladnie.cost from (ProductsNakladnie join Products on ProductsNakladnie.idproduct = Products.idproduct )join Nakladnie on ProductsNakladnie.idnakladnoy = Nakladnie.idnakladnoy;",
        "select Nakladnie.idnakladnoy, Nakladnie.data, Nakladnie.company from Nakladnie;"
    };
     
     String getsqlzaprosiRestAdmin(int i){
         return sqlzaprosiRestAdmin[i];
     }
   //------------------------------------------------------------------RestAdmin
   public static void main(String[] args) {
       //new Params().setsqlzaprosiGuest1(1000,2000,3000,4000,5000,6000);
        //System.out.println(new Params().sqlzaprosiGuest[0]);
    }
}
