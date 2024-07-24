/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task01_2;

/**
 *
 * @author yushi
 */
public class Rectangle extends Shape {
	private double length;
    private double width;
    
    public Rectangle(double width, double length){
        super("Rectangle");
        this.length=length;
        this.width=width;
    }
    public Rectangle(String name,double length, double width){
        super(name);
        this.length=length;
        this.width=width;
    }

	@Override
	public void calculateArea() {
		this.area = getLength()*getWidth();
	}

    /**
     * @return the length
     */
    public double getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }



}
