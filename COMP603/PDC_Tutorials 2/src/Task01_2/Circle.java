/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task01_2;

/**
 *
 * @author yushi
 */
public class Circle extends Shape {

	private double r;

	public Circle(double r) {
    super("Circle");
    this.r = r;
	}

	@Override
	public void calculateArea() {
        this.area=2*r*Math.PI;
	}

	/**
	 * @return the r
	 */
	public double getR() {
		return r;
	}

	/**
	 * @param r the r to set
	 */
	public void setR(int r) {
		this.r = r;
	}

}
