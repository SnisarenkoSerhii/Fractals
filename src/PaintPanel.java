import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;
/**
 * Created by Sergey on 09.10.2015.
 */

class PaintPanel extends JPanel {
    List<Branch> listBranch =  new CopyOnWriteArrayList<>();
    double angle=0;

    public void setAngle(double angle) {
        this.angle = angle;
    }
    //����������� �������, � ������� �������������� ��� ����� ����� ��������� �� ����������, � ����������� � ������
    //� �� ���������� ����� �����, ����� ������ ���������, ���� �������, � ��� ��������
    public void fractal(int startLength, Point2D startPoint, double alpha, int step){
        if(alpha<0) alpha=360;
        double radian =(alpha/(180/Math.PI));
        Point2D endPoint1 = new Point2D();
        Point2D endPoint2 = new Point2D();

        endPoint1.setX((float) (startPoint.getX()-startLength*Math.cos(radian)));
        endPoint1.setY((float) (startPoint.getY()-startLength*Math.sin(radian)));
        addBranch(new Branch(startPoint, endPoint1, startLength));

        endPoint2.setX((float) (startPoint.getX()-startLength*Math.cos(radian)));
        endPoint2.setY((float) (startPoint.getY()-startLength*Math.sin(radian)));
        addBranch(new Branch(startPoint, endPoint2, startLength));

        if(step>0){
            step--;
            startLength-=4; //��������� ����� �����
            //���������� �������������������� � ��������� ������� �� ������� � �������. ������
            //�������� ���������� ��������.
            fractal(startLength, endPoint1, alpha-(20+angle),step); //angle ����������� ��� ��������
            fractal(startLength, endPoint2, alpha+(20-angle), step);
        }
    }

    public void addBranch(Branch b){
        listBranch.add(b);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
//������������ � �������� ������, � ��������� ������ ����� 60, ����� 90, � �� 10 �����
        fractal(60, new Point2D(320, 480), 90, 8);
        Random randomX = new Random();
        Graphics2D g2d = (Graphics2D)g;
        for(Branch b: listBranch){
            // ����� ������������ ���, �� ��������� ������������ ����������� ������
            //g2d.setColor(new Color(randomX.nextInt(255),randomX.nextInt(255),randomX.nextInt(255)));
            //���� ���������������� ���������� ������, � ����������������� ��������� ���,
            //�� �����, ����� � ������ ����� �������������� ������ ������

			if(b.length>40)
				g2d.setColor(Color.ORANGE.darker());
			else
				g2d.setColor(Color.GREEN);

            g2d.draw(b.getShape());

        }
        //����� ��������� ������� ������, ����� ����� ���� ������� �����
        listBranch.clear();
    }
    //������ ������ ������ ���������
    public Dimension getPreferredSize() {
        // TODO Auto-generated method stub
        return new Dimension(640,480);
    }
}