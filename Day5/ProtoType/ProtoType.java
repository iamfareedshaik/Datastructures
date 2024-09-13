import java.util.*;


interface Shape extends Cloneable{
    Shape clone();
    void draw();
}

class Circle implements Shape{
    private int radius;

    public Circle(int radius){
        this.radius = radius;
    }

    public Circle clone(){
        return new Circle(this.radius);
    }

    public void draw(){
        System.out.print("Drawing circle radius" +  radius);
    }
}

class Rectangle implements Shape{
    private int radius;
    
    public Rectangle(int radius){
        this.radius = radius;
    }

    public Shape clone(){
        return new Rectangle(this.radius);
    }

    public void draw(){
        System.out.print("drawing Rectangle"+ this.radius);
    }
}

class ProtoType{
    public static void main(String args[]){
        Shape shape = new Rectangle(10);
        shape.draw();
        Shape shape1 = shape.clone();
        shape1.draw();
    }
}