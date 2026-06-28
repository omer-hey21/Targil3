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
                if (this.shapes[i][j] != null) {
                    sum += this.shapes[i][j].area();
                }
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
                if (this.shapes[i][j] != null) {
                    sum += this.shapes[i][j].perimeter();
                }
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
            return true; // they are equal!
            }
        return false; // not an instance of canvas... error!
        }


        // a function that get the max height of the shapes in curr row
        private int getMaxHeightInRow(Shape[] currRowShapes) {
            if (currRowShapes == null) {
                return 0; // edge case of no shape
            }
            int currMax = 0;
            for (int i = 0; i < currRowShapes.length; i++) {
                if (currRowShapes[i] != null) {
                    if (currRowShapes[i].getHeight() > currMax) {
                        currMax = currRowShapes[i].getHeight();
                    }
                }
            }
            return currMax;
        }


        // a function that get the max width of all shapes in canvas
        private int getMaxWidthInCanvas() {
            int max = 0;
            for(int i = 0; i < shapes.length; i++) { // every row of shapes
                for (int j = 0; j < shapes[i].length; j++) {
                    if (shapes[i][j] != null) {
                        if (shapes[i][j].getWidth() > max) {
                            max = shapes[i][j].getWidth();
                        }
                    }
                }
            }
            return max;
        }


        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            // getting the max width of the canvas
            int maxWidth = getMaxWidthInCanvas();

            // first we need to find the max shape height in the canvas
            for (int i = 0; i < shapes.length; i++) {
                int maxLinesInRow = getMaxHeightInRow(shapes[i]);

                if (maxLinesInRow == 0) {
                    // no shapes in this line - need to print an empty line
                    sb.append("\n");
                    continue; // go to the next line
                }

                // for this "row of shapes" run on every line (of text...)
                for (int currLine = 0; currLine < maxLinesInRow; currLine++) {

                    // go on every shape in this curr line and print its curr row
                    for (int j = 0; j < shapes[i].length; j++) {
                        Shape currShape = shapes[i][j];
                        if (currShape == null) {
                            // if shape is empty - print spaces by the maxWidth*3
                            sb.append(" ".repeat(maxWidth * 3));
                            // need to print only spaces - empty shape
                            // we can and should use .repead(amount)
                        } else { // actually printing line by line...

                            String[] shapeLines = currShape.toString().split("\n");

                            // try to print currLine if shape is "big enough"
                            if (shapeLines.length > currLine) {
                                // there is a line - we can print it
                                sb.append(shapeLines[currLine]);
                            } else {
                                // if currShape is too short we need to print spaces
                                // the spaces should be by the width of this shape
                                sb.append(" ".repeat(currShape.getWidth() * 3));
                            }
                        }

                        // if we are not at the end of some line - add space divider
                        if (j < shapes[i].length - 1) {
                            sb.append("   ");
                        }
                    }
                    // we reached the end of some line - go to the next
                    sb.append("\n");
                }
                // we reached the end of some canvas line of rows - print empty line
                sb.append("\n");
            }
            return sb.toString();
        }
}