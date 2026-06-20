public class RightAngleTriangle extends Shape {    // required attributes: width, hight, slop
    private double height;
    private double width;
    private double slop;

    public RightAngleTriangle(int width, int height) {
        this.width = width;
        this.height = height;
        this.slop = ((double) this.height - 1) / ((double) this.width - 1) * (-1);

    }

    @Override
    public void draw() {
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < 1 + slop * i; ++j) {
                System.out.print("*");
            }
            System.out.println();

        }
    }

    @Override
    public double getArea(RightAngleTriangle this) {
        return this.width * this.height / 2;
    }

    @Override
    public double getParimeter() {
        double hypotenuse_sqr = this.width * this.width + this.height * this.height;
        double hypotenuse = Math.sqrt(hypotenuse_sqr);
        return this.width + this.height + hypotenuse;

    }

    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    public boolean equals(Shape other) {
        if (other.getClass() == this.getClass()) {
            if (other.getWidth() == this.getWidth() && other.getWidth() == this.getHeight()) {
                return true;
            }
        }
        return false;
    }


}



