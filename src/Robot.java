public class Robot {
	int X;
	int Y;
	Direction D;
	
	public Robot() {
		
	}
	
	public Boolean place(int xIndex, int yIndex, Direction direction) {
		if(xIndex < 5 && xIndex >= 0) {
			this.X = xIndex;
		}else {
			System.out.println("Please enter valid coordinate");
			return false;
		}
		if(yIndex < 5 && yIndex >= 0) {
			this.Y = yIndex;
		}else {
			System.out.println("Please enter valid coordinate");
			return false;
		}
		this.D = direction;
		return true;
	}
	
	public Boolean move() {
		switch(this.D) {
		case NORTH:
			if(this.Y < 4) {
				this.Y++;
				return true;
			}else {
				System.out.println("Your robot will fail from the table");
				return false;
			}
		case SOUTH:
			if(this.Y > 0) {
				this.Y--;
				return true;
			}else {
				System.out.println("Your robot will fail from the table");
				return false;
			}
		case EAST:
			if(this.X < 4) {
				this.X++;
				return true;
			}else {
				System.out.println("Your robot will fail from the table");
				return false;
			}
		case WEST:
			if(this.X > 0) {
				this.X--;
				return true;
			}else {
				System.out.println("Your robot will fail from the table");
				return false;
			}
		}
		return false;
	}
	
	public void right() {
		switch(this.D) {
		case NORTH:
			this.D = Direction.EAST;
			break;
		case EAST:
			this.D = Direction.SOUTH;
			break;
		case SOUTH:
			this.D = Direction.WEST;
			break;
		case WEST:
			this.D = Direction.NORTH;
			break;
		}
		System.out.println(this.D.toString());
	}
	
	public void left() {
		switch(this.D) {
		case NORTH:
			this.D = Direction.WEST;
			break;
		case EAST:
			this.D = Direction.NORTH;
			break;
		case SOUTH:
			this.D = Direction.EAST;
			break;
		case WEST:
			this.D = Direction.SOUTH;
			break;
		}
		System.out.println(this.D.toString());
	}
	
	public void report() {
		System.out.println("Output: "+this.X+", "+this.Y+", "+this.D.toString());
	}
}
