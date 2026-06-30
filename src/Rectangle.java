public class Rectangle extends Shape {
        private final int width;
        private final int height;

    public Rectangle(int width,int height)
    {
        this.height = height;
        this.width = width;
    }

    @Override
    public String toString()
    {

        StringBuilder sb = new StringBuilder();

        for (int i =0; i < height;i++)
        {
            for (int j =0; j < width;j++) // try repeat instead
            {
                // System.out.println(" * ");
                sb.append(" * ");
            }
            //System.out.println();
            sb.append("\n");
        }
        return sb.toString();
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
    public int getWidth()
    {
        return (int) this.width;
    }

    @Override
    public int getHeight()
    {
        return (int) this.height;
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
