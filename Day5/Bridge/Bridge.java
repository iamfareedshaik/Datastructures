abstract class Shape{
    protected DrawingApi drawingApi;

    protected Shape(DrawingApi drawingApi){
        this.drawingApi = drawingApi;
    }

    public abstract void draw();
}

class CircleShape extends Shape{
    private double x, y, radius;

}

