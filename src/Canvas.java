public class Canvas {
    private Shape[][] shapes;

    public Canvas(int length,int width)
    {
       this.shapes = new Shape[length][width];
    }
    public void addShape(Shape shape, int x, int y)
    {
        this.shapes[x][y] = shape;
    }
    public void removeShape(int x, int y)
    {
        this.shapes[x][y] = null;
    }
    public double getTotalArea()
    {   double sum = 0.0;
        for(int i = 0; i < this.shapes.length; i++)
        {
            for (int j = 0; j < this.shapes[0].length;j++)
            {
                sum += this.shapes[i][j].getArea();
            }
        }
        return sum;
    }
    public double getTotalPerimeter()
    {
        double sum = 0.0;
        for(int i = 0; i < this.shapes.length; i++)
        {
            for (int j = 0; j < this.shapes[0].length;j++)
            {
                sum += this.shapes[i][j].getPerimeter();
            }
        }
        return sum;

    }
}