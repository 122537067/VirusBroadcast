import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @ClassName: MyPanel
 * @Description: TODO
 * @author: Bruce Young
 * @date: 2020年02月02日 17:03
 * @annotation:wihenne
 */
public class MyPanel extends JPanel implements Runnable {


   private int pIndex=0;

   //set background color 设置画布背景颜色
    public MyPanel() {
        this.setBackground(new Color(0x444444));
    }

    @Override
    public void paint(Graphics arg0) {
        super.paint(arg0);
        //draw border 描绘矩型框边框
        arg0.setColor(new Color(0x00ff00));
        //根据Hospital绘制
        arg0.drawRect(Hospital.getInstance().getX(),Hospital.getInstance().getY(),
                Hospital.getInstance().getWidth(),Hospital.getInstance().getHeight());


        List<Person> people = PersonPool.getInstance().getPersonList();
        if(people==null){
            return;
        }
        people.get(pIndex).update();
        for(Person person:people){

            switch (person.getState()){
                //普通人
                case Person.State.NORMAL:{
                    arg0.setColor(new Color(0xdddddd));

                }break;
                case Person.State.SHADOW:{
                    //疑似人
                    arg0.setColor(new Color(0xffee00));

                }break;
                case Person.State.CONFIRMED:
                case Person.State.FREEZE:{
                    //感染人
                    arg0.setColor(new Color(0xff0000));

                }break;
            }
            person.update();
            arg0.fillOval(person.getX(), person.getY(), 3, 3);

        }
        pIndex++;
        if(pIndex>=people.size()){
            pIndex=0;
        }
    }

    public static int worldTime=0;
    @Override
    public void run() {
        while (true) {

            this.repaint();

            try {
                Thread.sleep(100);
                worldTime++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
