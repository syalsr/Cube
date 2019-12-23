import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controller {
    private Cube c;
    private Viewer v;
    private JSlider vsliderVertical, vsliderHorizontal;
    public Controller(Cube c, Viewer v){
        this.c = c;
        this.v = v;
        this.vsliderVertical = v.vsliderVertical;
        this.vsliderHorizontal = v.vsliderHorizontal;
        vsliderVertical.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                int step = vsliderVertical.getValue();
                c.rotate(step, 0, 0);
                v.repaint();
            }
        });
        vsliderHorizontal.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                int step = vsliderHorizontal.getValue();
                c.rotate(0, step, 0);
                v.repaint();
            }
        });
    }
}