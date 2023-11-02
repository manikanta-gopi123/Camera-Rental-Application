package com.mphasis.project;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

class Camera {
    private int id;
    private String brand;
    private String Model;
    private int price;
    private boolean Available;
    int amount;
    public Camera(int id, String brand,int price,String model) {
        this.id = id;
        this.brand = brand;
        this.Available = true;
        this.price=price;
        this.Model=model;   
    }
    public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
    public int getId() {
        return id;   
    }
    public String getBrand() {
        return brand;
    }
    public boolean isAvailable() {
        return Available;
    }
    public void rent() {
        Available = false;   
    }
    public void returnCamera() {
       Available = true;
    }
	@Override
	public String toString() {
		
		return  "   "+id +"           "+ brand +"        "	+Model+"         "+  price+"           " +Available ;	
	}	
}
class CameraRentalSystem {
   ArrayList<Camera> cameras = new ArrayList<>();
    public void addCamera(Camera camera) {
        cameras.add(camera);
    }
    public void rentCamera(int cameraId) {
        for (Camera camera : cameras) {
            if (camera.getId() == cameraId && camera.isAvailable()) {
                camera.rent();
                System.out.println("Camera rented successfully.");
                return;
            }
        }
        System.out.println("Camera not available or does not exist.");
    }
    public void displayAvailableCameras() {
        System.out.println("Available Cameras:");
        System.out.println("+---------------------------------------------------------------------------------+");
		System.out.println("|   Id    "+"     Brand    "+"    Model   "+ "   Price per Day   "+"   Status                  |" );
		System.out.println("+---------------------------------------------------------------------------------+");
        for (Camera camera : cameras) {
            if (camera.isAvailable()) {
                System.out.println(camera);
                
            }
            else {
                //System.out.println(camera.isAvailable());
            	  
            	System.out.println("                                                      Item Rented" );
            }
        }
    }
}
public class Main {
	public static void main(String[] args) {
		CameraRentalSystem rentalSystem = new CameraRentalSystem();
        rentalSystem.addCamera(new Camera(1, "Canon",1000,"Duplex"));
        rentalSystem.addCamera(new Camera(2, "Nikon",2000,"Duplex"));
        rentalSystem.addCamera(new Camera(3, "Sonys",3000,"Duplex"));
        rentalSystem.addCamera(new Camera(4, "VivoV",4000,"Duplex"));
        rentalSystem.addCamera(new Camera(5, "Redmi",4000,"Duplex"));
        rentalSystem.addCamera(new Camera(6, "SonyS",1000,"Duplex"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Developed By NADIKATLA GOPI MANIKANTA");
        System.out.println("+-------------------------------------------+");
        System.out.println("|      WELCOME TO CAMERA RENTAL APP         |");
        System.out.println("+-------------------------------------------+");
        System.out.println("Enter User_Name : ");
        String user_name=scanner.next();
        System.out.println("Enter password : ");
        String password=scanner.next();
        if(user_name.equals("admin")&&password.equals("admin123")) {
        while (true) {
        	System.out.println("1. My Camera");
            System.out.println("2. Rent Camera");
            System.out.println("3. View All Cameras");
            System.out.println("4. Mywallet");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
            	System.out.println("1.Add\n2.Remove\n3.View My Cameras");
            	int option=scanner.nextInt();
            	switch(option) {
            	case 1:
            		System.out.println("Enter Camera Id:");
            		int id=scanner.nextInt();
            		System.out.println("Enter Camera Brand:");
            		String brand=scanner.next();
            		System.out.println("Enter Camera price:");
            		int price=scanner.nextInt();
            		System.out.println("Enter Camera Model:");
            		String Model=scanner.next();
            		Camera newCamera=new Camera(id,brand,price,Model);
            		//cameras.add(newCamera);
            		rentalSystem.addCamera(newCamera);
            		System.out.println("Camera Added Sucessfully");
            		break;
            	case 2:
            		System.out.println("Enter Camera Id to remove");
            		int removeId=scanner.nextInt();
            		if(removeId>=0&&removeId<((Collection<Camera>) rentalSystem).size()) {
            			((Collection<Camera>) rentalSystem).remove(removeId);
            			//cameras.remove(removeId);
            			System.out.println("Camera Removed Sucessfully");
            		}
            		else {
            			System.out.println("Invalid Id");
            		}
            		break;
            	case 3:
            		rentalSystem.displayAvailableCameras();
                    break;
            	
            	}
            	break;
                case 2:
                    System.out.print("Enter the camera ID to rent: ");
                    int rentId = scanner.nextInt();
                    rentalSystem.rentCamera(rentId);
                    break;
                case 3:
                	rentalSystem.displayAvailableCameras();
                    break;
                    
                case 4:
                	int balance=2000;
                	System.out.println("Balance in your Wallet :  "+balance);
                	System.out.println("Do you want to deposit More amount (Yes/No)");
                	String s=scanner.next();
                	if(s.equals("Yes")) {
                		System.out.println("Enter Amount to Deposit");
                		int amount=scanner.nextInt();
                    	amount=balance+amount;
                    	//amount=amount-rentalSystem.price();
                    	System.out.println("The Amount in your wallet After Rent a Camera "+amount);
                	}
                	else
                	System.out.println("Thank You ");
                	
                	break;
                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        }
        else {
        	System.out.println("Invalid Credentils");	
        }
    }
	}



