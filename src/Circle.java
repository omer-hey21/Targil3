public class Circle extends Shape{
    private double radius;

    public Circle (double radius) {
        // edge case - preventing entering negative radius
        if (radius < 0 ) {
            radius = 0; // or throwing some error ???
        }
        this.radius = radius;
    }

    @Override
    public double area() { return this.radius * this.radius * Math.PI; }

    @Override
    public double perimeter() { return this.radius * 2 * Math.PI; }

    @Override
    public double getWidth() { return this.radius * 2; }

    @Override
    public double getHeight() { return this.radius * 2; }

    // spacial for the circle class
    // for encapsulation - it should be private static method
    private static double calcDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));
    }

    public void draw()
    {
        double range = this.getHeight(); // same as getHeight()...
        double xCenter = range / 2;
        double yCenter = range / 2;

        for(int  y = 0; y < range; y++) { // for every row ...
            for (int x = 0; x < range; x++) { // for every col ...
                if (calcDistance(xCenter, yCenter, x, y) <= this.radius + 0.3) {
                    System.out.print(" * ");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public boolean equals(Object other)
    {
        if(other instanceof Circle otherCircle) { // trick of new version of JAVA
            return this.radius == otherCircle.radius;
        }
        return false;
    }
}
