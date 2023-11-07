package assign02tester;

import java.util.Scanner;

import assign02.Point2D;

public class TestPointArray1 {
	
	
	public static int calculateDistance(Point2D a1 , Point2D a2) {
		//d=√((x2 – x1)² + (y2 – y1)²)
		int xaxis = (a2.getX_axis() - a1.getX_axis())*(a2.getX_axis() - a1.getX_axis());
		int yaxis = (a2.getY_axis() - a1.getY_axis()) * (a2.getY_axis() - a1.getY_axis());
		int distance =  (int) Math.sqrt(xaxis + yaxis);
		
		return distance;
	}

	public static void main(String[] args) {
		
		System.out.print("Enter Size of Array :");
		int size = new Scanner(System.in).nextInt();
		
		Point2D arr1[] = new  Point2D[size];
		int k = 1;
		for(int i= 0 ; i < size ; i++) {
			System.out.println("enter co-ordinate od point "+k++);
			arr1[i] = new Point2D();
			arr1[i].acceptPoint();	
		}
		boolean flag =  true;
		while(flag == true) {
			
			System.out.println("1. To Display Details Of a Specific Point");
			System.out.println("2. To Display Co-ordinate of all Point");
			System.out.println("3. To Calculate Distance between 2 points");
			System.out.println("4. To Exit");
			int choice = new Scanner(System.in).nextInt();
			
			switch (choice) {
			case 1:
			{
				System.out.println("Enter a point ");
				int index = new Scanner(System.in).nextInt();
				if(index > 0 && index <= size) {
					arr1[index - 1].displayPoint();
				}else
					System.out.println("Invalid point");
			}
				break;
				
			case 2:
			{	
				int j = 1;
				for(int i = 0; i < size ; i++) {
					System.out.println("point ["+ j++ +"] = ("+ arr1[i].getX_axis()+","+arr1[i].getY_axis()+")" );
				}
			}
				break;
				
			case 3:
			{
				System.out.println("Enter 2 points :");
				int p1 = new Scanner(System.in).nextInt();
				int p2 = new Scanner(System.in).nextInt();
				
				if((p1 < 0 || p1>size) ||(p2 < 0 || p2>size)) {
					System.out.println("invalid points ");
				}else {
					if((arr1[p1 - 1].getX_axis() == arr1[p2 -1].getX_axis() ) && ( arr1[p1-1].getY_axis() == arr1[p2-1].getY_axis())) {
						System.out.println("You entered a same point ");
					}else
					{
						int res = TestPointArray1.calculateDistance(arr1[p1-1], arr1[p2-1]);
						System.out.println("Distance b/w 2 points is ="+res+" units");
					}
				}
			}
				break;
				
			case 4:
			{
				System.exit(0);
			}
				break;

			default:
				break;
			}
		}
	}

}
