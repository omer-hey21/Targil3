public class Rectangle extends Shape {
        private int width;
        private int height;

    public Rectangle(int width,int height)
    {
        this.height = height;
        this.width = width;
    }

    public void draw()
    {
        for (int i =0; i < height;i++)
        {
            for (int j =0; j < width;j++)
            {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    @Override
    public double area()
    {
        return this.height *this.height;
    }

    @Override
    public double perimeter()
    {
        return this.height *2+this.width*2;
    }

    @Override
    public double getWidth()
    {
        return this.width;
    }

    @Override
    public double getHeight()
    {
        return this.height;
    }

    @Override
    public boolean equals(Object other)
    {
        if(other instanceof Rectangle)
        {
            return this.height == ((Rectangle) other).height && this.width == ((Rectangle) other).width;
        }
        return false;
    }
}
