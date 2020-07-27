import java.util.*;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.*;
import java.io.IOException;


class elebill
{

	String contactno;
    String address;
    String name;
    int units;

    void setdata(String num,String adr,String cname,int unit)
     {
         contactno = num;
         address = adr;
         name = cname ;
         units = unit;
     }

	    String userid()
	    {
	    	return this.name.substring(0,3)+this.contactno.substring(this.contactno.length()-3,this.contactno.length());
	    }

	 	double billcalculate()
	    {
	         double bill;
	         if(this.units<100)
	           bill = this.units * 1.20 ;
	         else if(this.units <= 300)
	            bill = 100 * 1.20 + (this.units - 100) * 2 ;
	         else
	            bill = 100 * 1.20 + 200 * 2 + (this.units - 300) * 3 ;
	         return bill;
	    }
	    
	    boolean check()throws IOException{
	    	File customerID = new File("/Users/arshitbabariya/Desktop/java_project","customerID.txt");
			Scanner sobj = new Scanner(customerID);
			while(sobj.hasNextLine()){
	        	String data = sobj.nextLine();
	        	if(data.equals(this.userid())) return true;
	        }
	        return false;
		}
		
		
		void printbill()throws IOException
		{	System.out.println("********************************************************************");
			System.out.println("                          ELECTRICITY  BILL                       ");
			System.out.println("********************************************************************");
			System.out.println("\nUSERID: "+this.userid());
			System.out.println("\nCUSTOMER NAME: "+ this.name);
			System.out.println("\nCONTACT NUMBER: "+ this.contactno);
			System.out.println("\nADDRESS: "+ this.address);
			System.out.println("\nUNITS: "+this.units);
			System.out.println("\nAMOUNT TO PAY: Rs."+this.billcalculate()+"/-");
			//System.out.println(this.check());
			System.out.println("********************************************************************");

		}

		void addtofile()throws IOException
		{

			File bills = new File("/Users/arshitbabariya/Desktop/java_project","bills.txt");
			FileWriter bw = new FileWriter(bills,true);
			bw.write("********************************************************************");
			bw.write("\nUSERID: "+this.userid());
			bw.write("\nCUSTOMER NAME: "+ this.name);
			bw.write("\nCONTACT NUMBER: "+ this.contactno);
			bw.write("\nADDRESS: "+ this.address);
			bw.write("\nUNITS: "+this.units);
			bw.write("\nAMOUNT TO PAY: Rs."+this.billcalculate()+"/-");
			bw.write("\n********************************************************************");
			bw.write("\n\n");
			bw.flush();
			bw.close();
			if(!this.check()){
				File customers = new File("/Users/arshitbabariya/Desktop/java_project","customer_record.txt");
				FileWriter cw = new FileWriter(customers,true);
				cw.write("\nUSERID: "+userid());
				cw.write("\nCUSTOMER NAME: "+ this.name);
				cw.write("\nCONTACT NUMBER: "+ this.contactno);
				cw.write("\nADDRESS: "+ this.address);
				cw.write("\n\n");
				cw.flush();
				cw.close();

				File customerID = new File("/Users/arshitbabariya/Desktop/java_project","customerID.txt");
				FileWriter iw = new FileWriter(customerID,true);
				iw.write(this.userid()+"\n");
				iw.flush();
				iw.close();
			}
		}

}

    class javafinal
    {
			public final static void cls()
			{
			        System.out.print("\033[H\033[2J");  
    				System.out.flush();
			}

		  static int checkname(String n1)
		  {
			  int cnt=0;
			  int l1=n1.length();
			  char asv;
			          int flag1=0;
			          if(l1==0)
			          	flag1=1;
			          for(int ll=0;ll<l1;ll++)
			          {
			            asv=n1.charAt(ll);
			            if(ll==0&&asv==' ')
			            {
			            	flag1=1;
			            	break;
			            }
			            if(asv==' ')
			            	cnt++;
			            if(cnt==2)
			            {
			            	flag1=1;
			            	break;
			            }
			            if((asv>='A'&&asv<='Z')||(asv>='a'&&asv<='z')||asv==' ')
			            	continue;
			            else
			            {
			            	flag1=1;
			            	break;
			            }
			          }
			          if(flag1==1)
			          	return 1;
			          else
			          	return 0;

		  }
		  static int checknumber(String num)
		  {
			  int l1=num.length();
			  int flag1=0;
			  if(l1==0)
			  	flag1=1;
			  else if(((num.charAt(0))=='9')||((num.charAt(0))=='8')||((num.charAt(0))=='7')||((num.charAt(0))=='6'))
			  {
			  	flag1=0;
			  }
			  else
			  	flag1=1;
			  if(l1!=10)
			  	flag1=1;
			  else
			  {
			  for(int i=0;i<l1;i++)
			  {
			  	char ch;
			  	ch=num.charAt(i);
			  if(ch>='0'&&ch<='9')
			  	continue;
			  else
			  	flag1=1;
			  }
			  }
			  if(flag1==1)
			  	return 1;
			  else
			  	return 0;
		  }
		  static int checkadd(String add){
		  	int l = add.length();
		  	int flag = 0;
		  	if(l == 0)
		  	{
		  		flag = 1;
		  	}
		  	for(int i=0;i<add.length();i++){
		  		int ch = add.charAt(i);
		  		if(((ch>=33 && ch<=47)|| (ch>=58 && ch<=64))&&!(ch==44 || ch==45|| ch==46 || ch==47))
		  		{
		  			flag = 1;
		  			break;
		  		}
		  	}
			if(flag==1)
			    return 1;
			else
			    return 0;
		  }


    	public static void main(String []args)throws IOException
    	{	
    		Scanner scn = new Scanner(System.in);

    		int ch=0;
    		cls();
    		while(ch!=4){
    			
    				
    		System.out.println("************ WELCOME TO NIRMA ELECTRICITY CO.LMTD *************  ");
    		System.out.println("\n--------- HOME --------");
    		System.out.println("\n1.PRINT ELECTRICITY BILLS");
    		System.out.println("\n2.PAST BILLS");
    		System.out.println("\n3.CUSTOMER RECORD");
    		System.out.println("\n4.EXIT");
    		System.out.println("");
    		System.out.println("*****************************************************************");
			String ss;
    		while(true)
							      {
							        try
							        {
							        ch = scn.nextInt();
							        if(ch<=0 || ch>4)
		       				        {
							        System.out.println(" ENTER VALID CHOICE ");
							        continue;
							        }
							        break;
							        }
							        catch(InputMismatchException e)
							        {
							        System.out.println(" ENTER VALID INTEGER BETWEEN 1 TO 4 ");
							        ss=scn.nextLine();
							        }
							      }
    		

	    		switch(ch){

	    			case 1:
	    				int g=1;
			    		while(g==1){
			    			//name
				        	System.out.println("\nENTER CUSTOMER NAME");
				        	int l1;
				        	scn.nextLine();
					        String cname = scn.nextLine();
					        l1=checkname(cname);
							 while(l1==1)
							 {
							  System.out.println("\nENTER VALID NAME");
							  cname=scn.nextLine();
							  l1=checkname(cname);
							 }

							 //contact number
							System.out.println("\nENTER CONTACT NUMBER (10 DIGITS)");
					        String num = scn.nextLine();
					        int b;
					        b=checknumber(num);
							while(b==1)
							{
							 	System.out.println("\nENTER VALID 10 DIGIT MOBILE NUMBER");
							  	num=scn.nextLine();
							  	b=checknumber(num);
							}
					        //scn.nextLine();

					        //address
					        System.out.println("\nENTER COUSTOMER ADDRESS");
					        String adr = scn.nextLine();
					        int ca;
					        ca = checkadd(adr);
					        while(ca == 1){
					        	System.out.println("\nENTER VALID ADDRESS ");
					        	adr = scn.nextLine();
					        	ca = checkadd(adr);
					        }

					        //units
					        System.out.println("\nUNITS");
					        int unit;
					          while(true)
							      {
							        try
							        {
							        unit = scn.nextInt();
							        if(unit<0)
		       				        {
							        System.out.println("ENTER VALID UNITS");
							        continue;
							        }
							        break;
							        }
							        catch(InputMismatchException e)
							        {
							        System.out.println("ENTER VALID UNIT");
							        ss=scn.nextLine();
							        }
							      }
					        

					        elebill obj = new elebill();
							obj.setdata(num,adr,cname,unit);
							cls();
							obj.printbill();
							obj.addtofile();
							
				    		System.out.println("PRESS 2 FOR GO BACK TO HOME");
				    		System.out.println("\nPRESS 1 TO PRINT BILL\n");
				    		while(true)
							      {
							        try
							        {
							        g = scn.nextInt();
							        if(ch<=0 || ch>2)
		       				        {
							        System.out.println("ENTER VALID CHOICE");
							        continue;
							        }
							        break;
							        }
							        catch(InputMismatchException e)
							        {
							        System.out.println("ENTER VALID CHOICE");
							        ss=scn.nextLine();
							        }
							      }
    		
				    		
			    		}
			    		break;
			    	case 2:
			    		File bills = new File("/Users/arshitbabariya/Desktop/java_project","bills.txt");
			    		Scanner br = new Scanner(bills);
			    		cls();
			    		while(br.hasNextLine()){
			    			System.out.println(br.nextLine());
			    		}
			    		br.close();
			    		break;
			    	case 3:
			    		File customers = new File("/Users/arshitbabariya/Desktop/java_project","customer_record.txt");
			    		Scanner cr = new Scanner(customers);
			    		cls();	
			    		while(cr.hasNextLine()){
			    			System.out.println(cr.nextLine());
			    		}
			    		cr.close();

	    			}
    			}
    		
    		}	    	
    	}
    




