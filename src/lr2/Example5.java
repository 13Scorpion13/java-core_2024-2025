package lr2;

public class Example5 {

    public static class Rectangle {

        private double length;
        private double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double calculateArea() {
            return length * width;
        }

        public double calculatePerimeter() {
            return 2 * (length + width);
        }
    }
    public static void main(String[] args) {

            Rectangle rectangle = new Rectangle(13, 7);

            System.out.println("Длина: " + rectangle.getLength());
            System.out.println("Ширина: " + rectangle.getWidth());
            System.out.println("Площадь: " + rectangle.calculateArea());
            System.out.println("Периметр: " + rectangle.calculatePerimeter());
    }

}
