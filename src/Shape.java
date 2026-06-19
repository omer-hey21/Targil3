public abstract class Shape {

    public abstract void draw();
    public abstract double area();
    public abstract double perimeter();
    public abstract double getWidth();
    public abstract double getHeight();

    @Override
    public abstract boolean equals(Object other);

}
