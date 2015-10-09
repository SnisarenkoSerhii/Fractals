/**
 * Created by Sergey on 09.10.2015.
 */
import java.awt.geom.Line2D;
import java.util.*;
class Branch {
    Point2D begin;
    Point2D end;
    int length;
    //������ ����� �� ���� ������
    public Branch(Point2D begin, Point2D end, int length) {
        this.begin=begin;
        this.end=end;
        this.length=length;
    }
    //������ ������ ����� �� �������� �����������
    public Line2D getShape(){
        return new Line2D.Double(begin.getX(), begin.getY(), end.getX(), end.getY());
    }

}
