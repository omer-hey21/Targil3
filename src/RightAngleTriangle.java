public class RightAngleTriangle extends Shape {    // required attributes: width, hight, slop
    private int height;
    private int width;
    private double slop;

    public RightAngleTriangle(int width, int height) {
        this.width = width;
        this.height = height;

    }

    @Override
    public void draw() {
        int z = 0;

        for (int i = 1; i <= height; ++i) {
            z = Math.max(1, ((int) ((double) i * width / height)));
            for (int k = 0; k < z; ++k) {
                System.out.print(" * ");

            }
            System.out.println();
        }
    }

    @Override
    public double getArea() {
        return (double) this.width * (double) this.height / 2;
    }

    @Override
    public double getPerimeter() {
        int hypotenuse_sqr = this.width * this.width + this.height * this.height;
        double hypotenuse = Math.sqrt((double) hypotenuse_sqr);
        return this.width + this.height + hypotenuse;

    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }
    @Override
    public boolean equals(Shape other) {
        if (other.getClass() == this.getClass()) {
            if (other.getWidth() == this.getWidth() && other.getHeight() == this.getHeight()) {
                return true;
            }
        }
        return false;
    }


}



