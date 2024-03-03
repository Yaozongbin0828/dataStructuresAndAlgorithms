import java.util.Scanner;
public class solveQuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一元二次方程的系数 a：");
        double a = scanner.nextDouble();
        System.out.print("请输入一元二次方程的系数 b：");
        double b = scanner.nextDouble();
        System.out.print("请输入一元二次方程的系数 c：");
        double c = scanner.nextDouble();
        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("方程的根为：" + x1 + " 和 " + x2);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            System.out.println("方程的根为：" + x);
        } else {
            System.out.println("方程无实根");
        }
    }
}
