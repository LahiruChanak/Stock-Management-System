import java.util.*;

class courseWork{
	static Scanner input= new Scanner(System.in);
	static String[] ar= {"danujav"};
	static String[] xr= {"1234"};
	static String[][] supArr= new String[1][2];
	static String[] itemCateArr= new String[1];
	static String[][] itemDetArr= new String[1][6];
	
	private static void clearConsole(){
		final String os = System.getProperty("os.name");
		try {
			if (os.equals("Linux")) {
			System.out.print("\033\143");
		} else if (os.equals("Windows")) {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} else {
			System.out.print("\033[H\033[2J");
			System.out.flush();
		}
		} catch (final Exception e) {
			//handle the exception
			System.err.println(e.getMessage());
		}
	}
	
	public static void loginPage(){
		System.out.println("+-------------------------------------------------------+");
		System.out.println("|			LOGIN PAGE			|");
		System.out.println("+-------------------------------------------------------+\n");
		
	L1:	while(true){
		System.out.print("User Name : ");
		String user= input.next();
		
			if(!user.equals(ar[0])){
				System.out.println("user name is invalid. please try again! \n");
				
			}else{
				while(true){
					System.out.print("\nPassword : ");
					String pw= input.next();
					
					if(!pw.equals(xr[0])){
						System.out.println("password is invalid. please try again!");
						
					}else{
						System.out.println();
						break L1;
					}
				}		
			}
		}
	}

	public static void homePage(){
	
		clearConsole();
	
		System.out.println("+-------------------------------------------------------+");
		System.out.println("|	WELCOME TO IJSE STOCK MANAGEMENT SYSTEM		|");
		System.out.println("+-------------------------------------------------------+\n");
		
		System.out.print("[1] Change the Credentials");
		System.out.println("\t[2] Supplier Manage");
		System.out.print("[3] Stock Manage");
		System.out.println("\t\t[4] Log out");
		System.out.println("[5] Exit the system");
		
		System.out.print("\nEnter an option to continue > ");
		int opt= input.nextInt();
		
			clearConsole();
			
		switch(opt){
			case 1:
				credentialManage();
					break;
			
			case 2:
				supplierManage();
					break;
					
			case 3:
				stockManagement();
					break;
					
			case 4:
				loginPage();
					break;
					
			case 5:
				clearConsole();
				System.exit(0);
					break;
		}
	}

	public static void credentialManage(){
		System.out.println("+-------------------------------------------------------+");
		System.out.println("|		CREDENTIAL MANAGE			|");
		System.out.println("+-------------------------------------------------------+\n");
				
	L1:	while(true){
			System.out.print("Please enter the user name to verify it's you: ");
			String user= input.next();
					
			if(!user.equals(ar[0])){
				System.out.println("invalid user name. try again! \n");
					
			}else{
				System.out.println("Hey danujav\n");
					
				while(true){
					System.out.print("Enter your current password : ");
					String pw= input.next();
						
					if(!pw.equals(xr[0])){
						System.out.println("incorrect password. try again!");
						System.out.println();
							
					}else{
					System.out.print("Enter your new password : ");
					pw= input.next();
					xr[0]=pw;
						break L1;
					}
				}
			}
		}
		
	L2:	while(true){				
		System.out.print("\nPassword change successfully! Do you want to go home page (Y/N): ");
		String yOrN= input.next();
		
			if(yOrN.equalsIgnoreCase("Y")){
				clearConsole();
				homePage();
				break L2;
				
			}if(yOrN.equalsIgnoreCase("N")){
				clearConsole();
				System.exit(0);
				
			}else{
				System.out.println("Invalid option please try again");
				continue L2;
			}
		}
	}
	
	public static void supplierManage(){
		System.out.println("+-------------------------------------------------------+");
		System.out.println("|		  SUPPLIER MANAGE			|");
		System.out.println("+-------------------------------------------------------+\n");
		
		System.out.print("[1] Add Supplier");
		System.out.println("\t[2] Update Supplier");
		System.out.print("[3] Delete Supplier");
		System.out.println("\t[4] View Suppliers");
		System.out.print("[5] Search Supplier");
		System.out.println("\t[6] Home Page");
		
		System.out.print("\nEnter an option to continue > ");
		int opt= input.nextInt();
		
			clearConsole();
			
		switch(opt){
			case 1:
				addSupplier();
					break;
				
			case 2:
				updateSupplier();
					break;
					
			case 3:
				deleteSupplier();
					break;
					
			case 4:
				viewSuppliers();
					break;
				
			case 5:
				searchSupplier();
					break;
					
			case 6:
				homePage();
					break;
		}
	}
	
	public static void stockManagement(){
		System.out.println("+-------------------------------------------------------+");
		System.out.println("|		     STOCK MANAGEMENT		        |");
		System.out.println("+-------------------------------------------------------+\n");
		
		System.out.print("[1] Manage Item  Categories");
		System.out.println("\t[2] Add Item");
		System.out.print("[3] Get Items Supplier Wise");
		System.out.println("\t[4] View Items");
		System.out.print("[5] Rank Items Per Unit Price");
		System.out.println("\t[6] Home Page");
		
		System.out.print("\nEnter an option to continue > ");
		int opt= input.nextInt();
		
			clearConsole();
			
		switch(opt){
			case 1:
				manageItemCategory();
					break;
					
			case 2:
				addItem();
					break;
			
			case 3:
				itemSupplier();
					break;
					
			case 4:
				viewItems();
					break;
			
			case 5:
				rankItem();
					break;
					
			case 6:
				homePage();
					break;
		}
	}
	
	public static void addSupplier(){
		System.out.println("+-------------------------------------------------------+");
		System.out.println("|		       ADD SUPPLIER		        |");
		System.out.println("+-------------------------------------------------------+\n");
		
	L1:	while(true){
		System.out.print("Supplier Id : ");
		String sId=input.next();
		
		for(int i=0;i<supArr.length;i++){
			if(supArr[i][0]!=null && supArr[i][0].equals(sId)){
				System.out.println("Already exists. Try another supplier id!");
				System.out.println();
				continue L1;
				}
		}
		
		supArr[supArr.length-1][0]=sId;
		supArr= growArray();
		
		System.out.print("Supplier Name : ");
		supArr[supArr.length-2][1]=input.next();
		
	L2: while(true){
		System.out.print("Add Successfully! Do you want to add another supplier (Y/N): ");
		String yOrN=input.next();
		System.out.println();
		
		if(yOrN.equalsIgnoreCase("Y")){
			clearConsole();
			addSupplier();
				continue L1;
			
			}else if(yOrN.equalsIgnoreCase("N")){
				clearConsole();
				supplierManage();
			
			}else{
				System.out.println("Invalid option please try again");
				System.out.println();
					continue L2;
				}
			}
		}
	}
	
	public static void updateSupplier(){
		System.out.println("+-------------------------------------------------------+");
		System.out.println("|		      UPDATE SUPPLIER	        	|");
		System.out.println("+-------------------------------------------------------+\n");
		
	L1: while(true){
			System.out.print("Suppiler Id  : ");
			String sId=input.next();
			
			boolean f=false;
			
			for(int i=0;i<supArr.length;i++){
				if(supArr[i][0]!=null && supArr[i][0].equals(sId)){
					System.out.println("Supplier name : "+ supArr[i][1]);
					
					System.out.print("\nEnter the new supplier name : ");
					supArr[i][1]=input.next();
					
				f=true;
					break;
					}
				}
				
				if(!f){
					System.out.println("Can't find id. try agin\n");
						continue L1;
				}
				
			L2:	while(true){
					System.out.print("Update successfully! Do you want to update another supplier? (Y/N): ");
					String yOrN=input.next();
					
				if(yOrN.equalsIgnoreCase("Y")){
					clearConsole();
					updateSupplier();
						continue L1;
					
				}if(yOrN.equalsIgnoreCase("N")){
					clearConsole();
					supplierManage();
						break;
				
				}else{
					System.out.println("please enter valid option");
					continue L2;
				}
			}
		}
	}
	
	public static void deleteSupplier(){
		System.out.println("+-------------------------------------------------------+");
		System.out.println("|		      DELETE SUPPLIER	        	|");
		System.out.println("+-------------------------------------------------------+\n");
	
	L1:  while(true){
      System.out.print("Supplier ID : ");
      String sId = input.next();
      
      boolean f= false;
      
      for (int i = 0; i < supArr.length; i++){
        if(supArr[i][0] != null && supArr[i][0].equals(sId)){
          
          supArr= deleteValue(supArr,i);
          
          f= true;
          break;
        }
      }
          
      if(!f){
        System.out.println("Can't find supplier id. try again!\n");
			continue L1;
      }
         
  L2 :  while(true){
        System.out.print("deleted successfully! Do you want to delete another supplier?(Y/N) ");
        String yOrN= input.next();
        
			if(yOrN.equalsIgnoreCase("Y")){
				clearConsole();
				deleteSupplier();
					continue L1;
				
			}if(yOrN.equalsIgnoreCase("N")){
				clearConsole();
				supplierManage();
					break;
					
			}else{
				System.out.println("please enter valid option");
					continue L2;
				}
			}
		}
	}
	
	public static void viewSuppliers(){
		System.out.println("+-------------------------------------------------------+");
		System.out.println("|		       VIEW SUPPLIER		        |");
		System.out.println("+-------------------------------------------------------+\n");
	
		System.out.printf("+-----------------------------------------------+%n");
		System.out.printf("|	%-15s |	%-15s |%n","SUPPLIER ID","SUPPLIER NAME");
		System.out.printf("+-----------------------------------------------+%n");
		
	for(int i=0; i<supArr.length-1; i++){
		System.out.printf("|	%-15s |	%-15s |%n",supArr[i][0],supArr[i][1]);
	}
		System.out.printf("+-----------------------------------------------+%n");
		
	L1:	while(true){
			System.out.print("Do you want to update another supplier?(Y/N): ");
			String yOrN=input.next();
				
			if(yOrN.equalsIgnoreCase("Y")){
				clearConsole();
				supplierManage();
				break;
				
			}else if(yOrN.equalsIgnoreCase("N")){
				break L1;
			
			}else{
				System.out.println("please enter valid option");
				continue L1;
			}
		}
	}
	
	public static void searchSupplier(){
		System.out.println("+-------------------------------------------------------+");
		System.out.println("|		      SEARCH SUPPLIER			|");
		System.out.println("+-------------------------------------------------------+\n");
	
	L1: while(true){
			System.out.print("Suppiler Id  : ");
			String sId=input.next();
			
			boolean f=false;
			
			for(int i=0;i<supArr.length;i++){
				if(supArr[i][0]!=null && supArr[i][0].equals(sId)){
					System.out.println("Supplier name : "+ supArr[i][1]);
					System.out.println();
					
				f=true;
					break;
					}
				}
				
				if(!f){
					System.out.println("Can't find id. try agin");
					System.out.println();
						continue L1;
				}
				
			L2:	while(true){
					System.out.print("added successfully! Do you want to add another find(Y/N)? ");
					String yOrN=input.next();
					
				if(yOrN.equalsIgnoreCase("Y")){
					clearConsole();
					searchSupplier();
						continue L1;
					
				}if(yOrN.equalsIgnoreCase("N")){
					clearConsole();
					supplierManage();
						break;
				
				}else{
					System.out.println("please enter valid option");
					continue L2;
				}
			}
		}
	}
	
	public static void manageItemCategory(){
		System.out.println("+-------------------------------------------------------+");
		System.out.println("|		  MANAGE ITEM CATEGORY		 	|");
		System.out.println("+-------------------------------------------------------+\n");
		
		System.out.print("[1] Add Item Category");
		System.out.println("\t\t[2] Delete Item Category");
		System.out.print("[3] Update Items Category");
		System.out.println("\t[4] Stock Management");
		
		System.out.print("\nEnter an option to continue > ");
		int opt= input.nextInt();
		
			clearConsole();
			
		switch(opt){
			case 1:
				addItemCategory();
			
			case 2:
				deleteItemCategory();
			
			case 3:
				updateItemsCategory();
			
			case 4:
				stockManagement();
		}		
	}
	
	public static void addItem(){
		System.out.println("+-------------------------------------------------------+");
		System.out.println("|			ADD ITEM			|");
		System.out.println("+-------------------------------------------------------+\n");
		
		if(itemCateArr[0] == null){
			System.out.println("OOPS! It seems that you don't have any item categories in the system.");
  
	L1:	while(true){
			System.out.print("Do you want to add a new item category (Y/N) ? ");
			String yOrN=input.next();
			
			if(yOrN.equalsIgnoreCase("Y")){
				clearConsole();
				addItemCategory();
					break;
					
			}else if(yOrN.equalsIgnoreCase("N")){
				clearConsole();
				stockManagement();
					break;
			
			}else{
				System.out.println("please enter valid option");
					continue L1;
			}
		}
	}
  
		if(supArr[0][0] == null){
			System.out.println("OOPS! It seems that you don't have any suppliers in the system.");
	  
	L2:	while(true){
		System.out.print("Do you want to add a new supplier(Y/N) ? ");
	   String yOrN=input.next();
	   
		if(yOrN.equalsIgnoreCase("y")){
			clearConsole();
			addSupplier();
				break;
			
		}if(yOrN.equalsIgnoreCase("n")){
			clearConsole();
			stockManagement();
				break;
		}else{
			System.out.println("please enter valid option");
				continue L2;
			}
		}
	}
	  
	L3:	while(true){
			System.out.print("Item Code : ");
			String code = input.next();
	   
		for (int i = 0; i < itemDetArr.length; i++){
		if(itemDetArr[i][0] != null && itemDetArr[i][0].equals(code)){
			System.out.println("Already exists. Try another item code!\n");
				continue L3;
		}
	}
	   
	   itemDetArr[itemDetArr.length - 1][0]= code;
	   System.out.println();
		
	   System.out.println("Supplier List : ");
	   
	   int x = 1;
	   
	   System.out.printf("+-------------+-------------------------+-------------------------+%n");
	   System.out.printf("| %-11s | %-23s | %-23s |%n", "     # ", "      SUPPLIER ID", "     SUPPLIER NAME");
	   System.out.printf("+-------------+-------------------------+-------------------------+%n");
	   
		for(int i = 0; i< (supArr.length-1); i++){
			System.out.printf("| %-11s | %-23s | %-23s |%n", "     " + x++, "         " + supArr[i][0],"       " + supArr[i][1]);
	   }
	   
		System.out.printf("+-------------+-------------------------+-------------------------+%n");
		System.out.println();
	   
	L4:	while(true){
		System.out.print("Enter the supplier number > ");
		int sNumb= input.nextInt();
	   
		if(sNumb < supArr.length && sNumb > 0){
		itemDetArr[itemDetArr.length-1][1] = supArr[sNumb-1][0];
			break;
		}else{
			System.out.println("Invalid number ! Try again");
			System.out.println();
				continue L4;
			}
		}
		
		System.out.println();
		
		System.out.println("Item Categories : ");
		x = 1;
		
		System.out.printf("+-------------+---------------------------+%n");
		System.out.printf("| %-11s | %-25s |%n", "     # ", "     CATEGORY NAME");
		System.out.printf("+-------------+---------------------------+%n");
		
		for(int i= 0; i < (itemCateArr.length-1); i++){
		System.out.printf("| %-11s | %-25s |%n",  "     " + x++,"         " + itemCateArr[i]);
		}
		System.out.printf("+-------------+---------------------------+%n");
		System.out.println();
		
	L5:	while(true){
		System.out.print("Enter the category number > ");
		int cNumb= input.nextInt();
		
		if(cNumb < itemCateArr.length && cNumb > 0){
		itemDetArr[itemDetArr.length - 1][2] = itemCateArr[cNumb - 1];
			break;
		
		}else{
		System.out.println("Invalid number! Try again");
		System.out.println();
			continue L5;
			}
		}
		System.out.println();
	   
		System.out.print("Description : ");
		String xr1=input.next();
		itemDetArr[itemDetArr.length - 1][3] = xr1;
		
		System.out.print("Unit price  : ");
		String xr2=input.next();
		itemDetArr[itemDetArr.length - 1][4] = xr2;
	   
		System.out.print("Qty on hand : ");
		String xr3=input.next();
		itemDetArr[itemDetArr.length - 1][5] = xr3;
		
		System.out.print("Added successfully ! ");
		
		itemDetArr = grow2Array(itemDetArr);
		
	L6:	while(true){
		System.out.print("Do you want to add another item (Y/N)? ");
		String option = input.next();
		
		System.out.println();
		
		switch(option){
			case "Y":
				clearConsole();
				addItem();
					break;
					
			case "y":
				clearConsole();
				addItem();
					break;
					
			case "N":
				clearConsole();
				stockManagement();
					break L3;
					
			case "n":
				clearConsole();
				stockManagement();
					break L3;
					
			default :
				System.out.println("Invalid option. Please try again!\n");
					continue L6;
					}
				}
			}
		}
	
	public static void itemSupplier(){
		System.out.println("+-------------------------------------------------------+");
		System.out.println("|		     SEARCH SUPPLIER		        |");
		System.out.println("+-------------------------------------------------------+\n");
		
	if(supArr[0][0] == null){
      System.out.println("OOPS! It seems that you don't have any suppliers in the system.");
    
	L1:	while(true){
		System.out.print("Do you want to add a new supplier (Y/N) ? ");
		String yn= input.next();
		System.out.println();
		
		if(yn.equalsIgnoreCase("y")){
			clearConsole();
			addSupplier();
		}if(yn.equalsIgnoreCase("n")){
			clearConsole();
			stockManagement();
				break;
		}else{
			System.out.println("please enter valid option");
			}
		}
	}
    	
	L2: while(true){
		System.out.print("Enter Supplier Id: ");
		String sId= input.next();
		
		boolean f=false;
			
			for(int i=0;i<supArr.length;i++){
				if(supArr[i][0]!=null && supArr[i][0].equals(sId)){
					System.out.println("Supplier name : "+ supArr[i][1]);
					
		f=true;
			break;
				}
			}
			
			if(!f){
				System.out.println("Can't find id. try agin\n");
					continue L2;
			}
		
		System.out.println("\n");
		System.out.printf("+-----------------------------------------------------------------------------------------------------------------------+%n");
		System.out.printf("|	%-15s |	%-15s |	%-15s |	%-15s |	%-15s |%n","ITEM CODE","DESCRIPTION","UNIT PRICE","QTY ON HAND","CATEGORY");
		System.out.printf("+-----------------------------------------------------------------------------------------------------------------------+%n");
		
		boolean found= false;
		
		for(int i=0; i< itemDetArr.length-1; i++){
			if(sId.equals(itemDetArr[i][1])){
				System.out.printf("|	%-15s |	%-15s |	%-15s |	%-15s |	%-15s |%n",itemDetArr[i][0],itemDetArr[i][3],itemDetArr[i][4],itemDetArr[i][5],itemDetArr[i][2]);
					found=true;
			}
		}
		System.out.printf("+-----------------------------------------------------------------------------------------------------------------------+%n");
		
	L3:	while(true){
			System.out.print("search successfully! Do you want to add another search(Y/N)? ");
			String yOrN=input.next();
				
			if(yOrN.equalsIgnoreCase("Y")){
				clearConsole();
				itemSupplier();
					continue L3;
				
			}else if(yOrN.equalsIgnoreCase("N")){
				clearConsole();
				stockManagement();
					break L3;
			
			}else{
				System.out.println("\nplease enter valid option");
					continue L3;
				}
			}
		}
	}
	
	public static void viewItems(){
		System.out.println("+-------------------------------------------------------+");
		System.out.println("|		     	VIEW ITEMS		        |");
		System.out.println("+-------------------------------------------------------+\n");
		
		if(itemCateArr[0] == null){
			System.out.println("OOPS! It seems that you don't have any item categories in the system.");
      
	L1:	while(true){
		System.out.print("Do you want to add a new item category(Y/N)? ");
		String yn=input.next();
			if(yn.equalsIgnoreCase("y")){
				clearConsole();
				addItemCategory();
			
			}else if(yn.equalsIgnoreCase("n")){
				clearConsole();
				stockManagement();
					break;
			}else{
				System.out.println("please enter valid option");
					continue L1;
			}
		}
	}
		
		for(int i = 0; i < (itemCateArr.length - 1); i++){
			System.out.println(itemCateArr[i] + " :");
				System.out.printf("+----------------------------------------------------------------------------------+%n");
				System.out.printf("|	%-10s |	%-10s |	%-10s |	%-10s |	%-10s |%n","SID","CODE","DESC","PRICE","QTY");
				System.out.printf("+----------------------------------------------------------------------------------+%n");
				
		 boolean f= false;
		 
		  for(int j= 0; j< itemDetArr.length-1; j++){
			if(itemDetArr[j][2].equals(itemCateArr[i])){		
				System.out.printf("|	%-10s |	%-10s |	%-10s |	%-10s |	%-10s |%n",itemDetArr[j][1],itemDetArr[j][0],itemDetArr[j][3],itemDetArr[j][4],itemDetArr[j][5]);
				System.out.printf("+-----------------------------------------------------------------------------------+%n");
				System.out.println();
				
				f=true;
			}
		}
	}
		
	L2:	while(true){
		System.out.print(" Do you want to go stock management page (Y/N) ? ");
		String yn=input.next();
			if(yn.equalsIgnoreCase("y")){
				clearConsole();
				stockManagement();
			
			}else if(yn.equalsIgnoreCase("n")){
				clearConsole();
				System.exit(0);
					break;
			
			}else{
				System.out.println("please enter valid option");
			}
		}
	}
	
	public static void rankItem(){
		System.out.println("+-------------------------------------------------------+");
		System.out.println("|		     RANKED UNIT PRICE		        |");
		System.out.println("+-------------------------------------------------------+\n");
	
		if(itemCateArr[0] == null){
		System.out.println("OOPS! It seems that you don't have any items in the system.");
      
  L1:   while(true){
        System.out.print("Do you want to add a new item (Y/N)? ");
		String yn=input.next();
		
			if(yn.equalsIgnoreCase("y")){
				clearConsole();
				addItem();
					break;

			}else if(yn.equalsIgnoreCase("n")){
				clearConsole();
				stockManagement();
					break;
			
			}else{
				System.out.println("please enter valid option");
					continue L1;
			}
		}
	}
	
		String[][] sortArr= new String[itemDetArr.length][itemDetArr[0].length];
		sortArr= sortArray(itemDetArr);
		
		System.out.printf("+--------------------------------------------------------------------------------------------------+%n");
		System.out.printf("|	%-10s |	%-10s |	%-10s |	%-10s |	%-10s |	%-10s |%n","SID","CODE","DESC","PRICE","QTY","CAT");
		System.out.printf("+--------------------------------------------------------------------------------------------------+%n");
		
		for(int i = 0; i < sortArr.length - 1; i++){
			System.out.printf("|	%-10s |	%-10s |	%-10s |	%-10s |	%-10s |	%-10s |%n",sortArr[i][1],sortArr[i][0],sortArr[i][3],sortArr[i][4],sortArr[i][5],sortArr[i][2]);
		}
			System.out.printf("+--------------------------------------------------------------------------------------------------+%n");
	
	L2:	while(true){
			System.out.print("Do you want to go stock manage page(Y/N)? ");
			String yOrN=input.next();
				
			if(yOrN.equalsIgnoreCase("Y")){
				clearConsole();
				stockManagement();
					continue L2;
				
			}else if(yOrN.equalsIgnoreCase("N")){
				System.out.println();
				break L2;
			
			}else{
				System.out.println("\nplease enter valid option");
					continue L2;
			}
		}	
	}
	
	public static void addItemCategory(){
		System.out.println("+-------------------------------------------------------+");
		System.out.println("|		     ADD ITEM CATEGORY		        |");
		System.out.println("+-------------------------------------------------------+\n");
		
	L1:	while(true){
			System.out.print("Enter the new category : ");
			String cate=input.next();
			
			for(int i=0;i<itemCateArr.length;i++){
				if(itemCateArr[i]!=null && itemCateArr[i].equals(cate)){
					System.out.println("Already exists.Try another item category!\n");
						continue L1;
					}
				}
				itemCateArr[itemCateArr.length-1]=cate;
				itemCateArr=extendArray();
				
			L2: while(true){
				System.out.print("Added successfully! Do you want to add another Category (Y/N)? ");
				String yOrN=input.next();
					
				if(yOrN.equalsIgnoreCase("Y")){
					System.out.println();
						continue L1;
					
				}else if(yOrN.equalsIgnoreCase("N")){
					clearConsole();
					manageItemCategory();
						return;
							
				}else{
					System.out.println("Invalid option. Try again!");
					clearConsole();
						continue L2;
				}
			}
		}
	}
	
	public static void deleteItemCategory(){
		System.out.println("+-------------------------------------------------------+");
		System.out.println("|		     DELETE ITEM CATEGORY	        |");
		System.out.println("+-------------------------------------------------------+\n");
		
	L1:  while(true){
      System.out.print("Category name : ");
      String cate= input.next();
      
      boolean f= false;
      
      for (int i = 0; i < itemCateArr.length; i++){
        if(itemCateArr[i] != null && itemCateArr[i].equals(cate)){
          
			itemCateArr= deleteCategory(itemCateArr,i);
          
          f= true;
          break;
        }
      }
          
      if(!f){
        System.out.println("Can't find category name. try again!\n");
			continue L1;
      }
         
  L2 :  while(true){
        System.out.print("deleted successfully! Do you want to delete another category?(Y/N) ");
        String yOrN= input.next();
        
			if(yOrN.equalsIgnoreCase("Y")){
				clearConsole();
				deleteItemCategory();
					continue L1;
				
			}if(yOrN.equalsIgnoreCase("N")){
				clearConsole();
				manageItemCategory();
					break;
					
			}else{
				System.out.println("please enter valid option");
					continue L2;
				}
			}
		}
	}
	
	public static void updateItemsCategory(){
		System.out.println("+-------------------------------------------------------+");
		System.out.println("|		     UPDATE ITEM CATEGORY        	|");
		System.out.println("+-------------------------------------------------------+\n");
		
	L1: while(true){
			System.out.print("Categorie Name : ");
			String cate=input.next();
			
			boolean f=false;
			
			for(int i=0;i<itemCateArr.length;i++){
				if(itemCateArr[i]!=null && itemCateArr[i].equals(cate)){
					System.out.print("\nEnter the new category name : ");
					itemCateArr[i]=input.next();
					
				f=true;
					break;
					}
				}
				
				if(!f){
					System.out.println("Can't find name. try agin\n");
						continue L1;
				}
				
			L2:	while(true){
					System.out.print("Update successfully! Do you want to update another supplier? (Y/N): ");
					String yOrN=input.next();
					
				if(yOrN.equalsIgnoreCase("Y")){
					clearConsole();
					updateItemsCategory();
						continue L1;
					
				}if(yOrN.equalsIgnoreCase("N")){
					clearConsole();
					manageItemCategory();
						break;
				
				}else{
					System.out.println("please enter valid option");
					continue L2;
				}
			}
		}
	}
	
	public static String[][] growArray(){
		String[][] newArr=new String[supArr.length+1][2];
		
		for(int i=0; i<supArr.length; i++){
			for(int j=0; j<supArr[i].length; j++){
				newArr[i][j]=supArr[i][j];
			}
		}
			return newArr;
	}
	
	public static String[][] deleteValue(String[][] oldArr,int index){
		String[][] newArr=new String[oldArr.length-1][2];
		
		int newIndex= 0;
		
		for (int i = 0; i < supArr[i].length-1; i++){
			if(i != index){
				newArr[newIndex][0] = oldArr[i][0];
				newArr[newIndex][1] = oldArr[i][1];
				newIndex++;
			}
		}
		return newArr;
	}
	
	public static String[] extendArray(){
		String[] newArr=new String[itemCateArr.length+1];
		
		for(int i=0; i<itemCateArr.length; i++){
			newArr[i]=itemCateArr[i];
		}
			return newArr;
	}
	
	public static String[] deleteCategory(String[] oldArr,int index){
		String[] newArr=new String[oldArr.length-1];
		
		int newIndex= 0;
		
		for(int i = 0; i < oldArr.length; i++){
			if(i != index){
				newArr[newIndex]=oldArr[i];
				newIndex++;
			}
		}
		return newArr;
	}
	
	public static String[][] grow2Array(String[][] oldArr){
		String[][] newArr = new String[oldArr.length + 1][oldArr[0].length];
		
		for(int i = 0; i < oldArr.length; i++){
			for(int j = 0; j < oldArr[i].length; j++){
				newArr[i][j] = oldArr[i][j];
			}
		}
		return newArr;
	}
	
	public static String[][] sortArray(String oldArr[][]){
		String[][] newArr= new String[oldArr.length][oldArr[0].length];
		double[] unitPriceArr=new double[oldArr.length-1];
		
		for(int i = 0; i < oldArr.length - 1; i++){
			unitPriceArr[i] = Double.parseDouble(oldArr[i][4]);
		}
		
		for(int i=0; i< unitPriceArr.length-1; i++){
			for(int j=0; j< unitPriceArr.length-1; j++){
				if(unitPriceArr[j]> unitPriceArr[j+1]){
				double temp= unitPriceArr[j];
				unitPriceArr[j]= unitPriceArr[j+1];
				unitPriceArr[j+1]= temp;
				}
			}
		}
		
		int k = 0;
			for(int i= 0; i< unitPriceArr.length; i++){
				for(int j= 0; j< oldArr.length - 1; j++){
				if(unitPriceArr[i]== (Double.parseDouble(oldArr[j][4]))){
					newArr[k] = oldArr[j];
					k++;
				}
			}
		}
		return newArr;
	}
	
	public static void main(String args[]){
		
		loginPage();
		homePage();
	}
}
