// הערות כלליות -
// שווה לבדוק מקרי קצה של צורות ריקות / שאותחלו עם פרמטרים שליליים וכאלה


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
                sum += this.shapes[i][j].perimeter();
            }
        }
        return sum;

    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Canvas otherCanvas) {
            // instead of casting everytime - trick of the new version of JAVA


            // check if they have the same row num
            if(this.shapes.length != otherCanvas.shapes.length) {
                return false;
            }

            // check if they have the same col num
            // need to check edge case first in order to calc cols num by doing
            // this.shapes[0].length - error if the canvas is empty
            if (this.shapes.length > 0) { // preventing errors - at least one row
                if (this.shapes[0].length != otherCanvas.shapes[0].length) {
                    return false;
                }
            }

            // now we can compare every shape in both canvases
            for (int i = 0; i < shapes.length; i++) {
                for (int j = 0; j < shapes[0].length; j++) {
                    // edge cases - one of the canvases is null:
                    Shape myShape = this.shapes[i][j];
                    Shape otherShape = otherCanvas.shapes[i][j];

                    if((myShape == null && otherShape != null) ||
                            (myShape != null && otherShape == null)) return false;

                    if (myShape != null && !myShape.equals(otherShape)) {
                        return false;
                    }
                }
            }
            return true;
            }
        return false;

        }
}