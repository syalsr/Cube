import javafx.scene.shape.Path;

import java.awt.*;
import java.awt.geom.Path2D;
import java.util.Random;

public class Facet {
    private R3Vector[] vertex;
    private Color color;
    private Random r = new Random();
    public Facet(R3Vector v1, R3Vector v2, R3Vector v3, R3Vector v4){
        vertex = new R3Vector[4];
        vertex[0] = v1;
        vertex[1] = v2;
        vertex[2] = v3;
        vertex[3] = v4;
        this.color = color;
    }
    public void out(){
        for(int i = 0; i<vertex.length; i++) {
            vertex[i].out();
            System.out.print(" - ");
            if(i==3){
                vertex[0].out();
            }else{
                vertex[i + 1].out();
            }
            System.out.print("\n");
        }
    }
    public void rotate(double ux, double uy, double uz){
        for(int i=0; i<vertex.length; i++){
            vertex[i].rotate(ux,uy,uz);
        }
    }
    public void scale(double k){
        for(int i=0; i<vertex.length; i++){
            vertex[i].scale(k);
        }
    }
    public void translate(double dx, double dy, double dz){
        for(int i=0; i<vertex.length; i++){
            vertex[i].translate(dx,dy,dz);
        }
    }
    public void draw(Graphics2D g){
        Path2D path = new Path2D.Double();
        path.moveTo(vertex[0].getX(), vertex[0].getY());
        path.lineTo(vertex[1].getX(), vertex[1].getY());
        path.lineTo(vertex[2].getX(), vertex[2].getY());
        path.lineTo(vertex[3].getX(), vertex[3].getY());
        path.lineTo(vertex[0].getX(), vertex[0].getY());
        path.closePath();
        if(light()) {
            g.setColor(this.color);
            g.fill(path);
        }
    }
    public void drawPersp(Graphics2D g, double focus){
        Path2D path = new Path2D.Double();
        double[] t = new double[4];
        t[0] = (vertex[0].getZ()-focus/-focus);
        t[1] = (vertex[1].getZ()-focus/-focus);
        t[2] = (vertex[2].getZ()-focus/-focus);
        t[3] = (vertex[3].getZ()-focus/-focus);
        for(int i=0; i<4; i++){
            vertex[i] = new R3Vector(vertex[i].getX()*t[i], vertex[i].getY()*t[i], vertex[i].getZ());
        }
        path.moveTo(vertex[0].getX(), vertex[0].getY());
        path.lineTo(vertex[1].getX(), vertex[1].getY());
        path.lineTo(vertex[2].getX(), vertex[2].getY());
        path.lineTo(vertex[3].getX(), vertex[3].getY());
        path.lineTo(vertex[0].getX(), vertex[0].getY());
        path.closePath();
        if(light()){
            g.setColor(this.color);
            g.fill(path);
        }
    }
    public boolean light(){
        if(R3Vector.normal(R3Vector.diagonals(vertex[0], vertex[1]),R3Vector.diagonals(vertex[0], vertex[3])).getZ()<=0){
            return true;
        }else
            return false;
    }
    public void set_color(Color color){
        this.color = color;
    }
}