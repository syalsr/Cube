import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
        R3Vector v1 = new R3Vector(5,6,7);
        R3Vector v2 = new R3Vector(7,8,9);
        R3Vector v3 = new R3Vector(1,2,3);
        R3Vector v4 = new R3Vector(5,6,7);
        v1.out();
        (v1.sum(v1).sum(v1)).sum(v1).out();
        R3Vector.sum(R3Vector.sum(v1,v2), v3).out();
        System.out.println("Скалярное произведение " + R3Vector.Scalar(v1,v2));
        (R3Vector.Vector(v1,v2)).out();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите коэффициент k");
        int k = scan.nextInt();
        v1.scale(k);
        v1.out();
        System.out.println("Введите смещения");
        int x = scan.nextInt();
        int y = scan.nextInt();
        int z = scan.nextInt();
        R3Vector.translate(v1, x,y,z);
        v1.out();
        v4.rotateZ(90);
        v4.out();
        v4.rotateY(90);
        v4.out();
        v4.rotateX(90);
        v4.out();
        v4.rotate(90,90,90);
        v4.out();
        */
        Facet f = new Facet(new R3Vector(0,0,0), new R3Vector(1,0,0), new R3Vector(1,1,0),
                new R3Vector(0,1,0));
        f.out();
        /* f.rotate(90,90,90);
        f.out();
        f.scale(3);
        f.out();
        f.translate(15,10,12);
        f.out();*/
        Cube cube = new Cube();
        cube.scale(150);
        cube.rotate(125,125,125);
        Viewer v = new Viewer(cube);
        Controller с = new Controller(cube,v);
    }
}
