import java.util.ArrayList;
import java.util.Scanner;

public class RobotChallenge {

	public static void main(String[] args) {
		Boolean error = true;
		Boolean con = true;
		ArrayList<Robot> robots = new ArrayList<Robot>();
		
		while(error) {
			System.out.println("Please enter the command to place a robot.");
			Scanner sc = new Scanner(System.in);
			String placeCommand = sc.nextLine();
			
			String[] arrComm = placeCommand.split(" ");
			if(arrComm[0].compareTo("PLACE") == 0) {
				String CoorComm = arrComm[1];
				String[] Coor = CoorComm.split(",");
				int X = Integer.parseInt(Coor[0]);
				int Y = Integer.parseInt(Coor[1]);
				Direction D = Direction.valueOf(Coor[2]);
				
				Robot r = new Robot();
				if(r.place(X, Y, D)) {
					robots.add(r);
					
					System.out.println("Robot 1 is active.");
					
					Robot temp = new Robot();
					temp = r;
					
					while(con) {
						System.out.println("Please enter the next command");
						String command = sc.nextLine();
						String[] arrComm1 = command.split(" ");
												
						if(arrComm1.length > 1) {
							if(arrComm1[0].compareTo("PLACE") == 0) {
								String CoorComm1 = arrComm1[1];
								String[] Coor1 = CoorComm1.split(",");
								int X1 = Integer.parseInt(Coor1[0]);
								int Y1 = Integer.parseInt(Coor1[1]);
								Direction D1 = Direction.valueOf(Coor1[2]);
								
								Robot r1 = new Robot();
								
								if(r1.place(X1, Y1, D1)) {
									robots.add(r1);
									temp = r1;
									System.out.println("Robot "+(robots.indexOf(r1)+1)+" is active");
								}
								
							}
							if(arrComm1[0].compareTo("ROBOT") == 0) {
								int number = Integer.parseInt(arrComm1[1]);
								temp = robots.get(number-1);
								System.out.println("Robot "+number+" is active");
							}
						}else {
							switch(command) {
							case "MOVE":
								if(temp.move()) {
									//moving
								}else {
									System.out.println("Try again.");
								}
								break;
							case "RIGHT":
								temp.right();
								break;
							case "LEFT":
								temp.left();
								break;
							case "REPORT":
								System.out.println("Number of Robots: "+robots.size());
								for(Robot rb : robots) {
									System.out.print("Robot "+(robots.indexOf(rb)+1)+" ");
									rb.report();
								}
								System.out.println("Game Over. Thank You.");
								error = false;
								con = false;
								break;
							}
						}
					}
					
				}
			}else {
				System.out.println("You need to place a robot first.");
			}
			sc.close();
		}
	}

}
