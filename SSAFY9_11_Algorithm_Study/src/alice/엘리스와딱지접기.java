package alice;

import java.util.Scanner;

class Rectangle {
    /* 1. Rectangle 클래스를 완성해봅시다. */
    int width, height;
    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int area(){
        return width*height;
    }
}

class Square extends Rectangle {
    /* 2. Square 클래스를 정의하고, 완성해봅시다. */
	int r;
	public Square(int r) {
		super(r, r);
		this.r = r;
	}
	@Override
	public int area() {
		return r*r;
	}
	
}

public class 엘리스와딱지접기 {
	public static void main(String args[]) {
        int t;
        Scanner scan = new Scanner(System.in);
    
        t = scan.nextInt();
    
        if(t == 1)
        {
            Rectangle rect = new Rectangle(scan.nextInt(), scan.nextInt());
            System.out.println(rect.area());
        }
        else
        {
            Square sq = new Square(scan.nextInt());
            System.out.println(sq.area());
        }
    }
}
