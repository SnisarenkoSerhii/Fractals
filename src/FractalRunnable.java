/**
 * Created by Sergey on 09.10.2015.
 */
class FractalRunnable implements Runnable{
    PaintPanel paintPanel;

    public FractalRunnable(PaintPanel paintPanel) {
        // TODO Auto-generated constructor stub
        this.paintPanel=paintPanel;
    }

    public void run() {
        double count=0;
        boolean leftDir = true;
        while(true){
            //»Что стоишь качаясь, до самого тына…» С.Есенин
            //Высота тына регулируется переменной count
            double a = 90;
            if(count>8 && a<count){
                leftDir=false;
            }

            if(count<-8 && count>-9){
                leftDir=true;
            }
            if(leftDir)
                count+=0.01;
            else
                count-=0.01;

            paintPanel.setAngle(a);
            paintPanel.repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
