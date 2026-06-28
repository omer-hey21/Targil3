public abstract class Shape {

    public abstract double area();
    public abstract double perimeter();
    public abstract int getWidth();
    public abstract int getHeight();


    @Override
    public abstract boolean equals(Object other);

    @Override
    public abstract String toString();

}
