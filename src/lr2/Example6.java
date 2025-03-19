package lr2;

public class Example6 {

    public interface Shape {
        double calculateArea ();
        double calculatePerimeter();
    }

    public static class Circle implements Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double calculateArea () {
            return Math.PI * radius * radius;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * Math.PI * radius;
        }
    }

    public static class Square implements Shape {
        private double side;  // Длина стороны квадрата

        public Square(double side) {
            this.side = side;
        }

        @Override
        public double calculateArea() {
            return side * side;
        }

        @Override
        public double calculatePerimeter() {
            return 4 * side;
        }
    }

    public static class Triangle implements Shape {
        private double sideA;
        private double sideB;
        private double sideC;

        public Triangle(double side1, double side2, double side3) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }

        @Override
        public double calculateArea() {
            double s = (sideA + sideB + sideC) / 2;
            return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
        }

        @Override
        public double calculatePerimeter() {
            return sideA + sideB + sideC;
        }
    }

    public static void main(String[] args) {
        Circle circle = new Circle(10);
        System.out.println("Круг: Площадь - " + circle.calculateArea() + ", Периметр - " + circle.calculatePerimeter());

        Square square = new Square(5);
        System.out.println("Квадрат: Площадь - : " + square.calculateArea() + ", Периметр - " + square.calculatePerimeter());

        Triangle triangle = new Triangle(3, 5, 7);
        System.out.println("Треугольник: Площадь - " + triangle.calculateArea() + ", Периметр - " + triangle.calculatePerimeter());
    }

}