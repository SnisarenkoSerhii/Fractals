/**
 * Created by Sergey on 09.10.2015.
 */
class Point2D{

    private float x, y;
    //создаем точку по двум координатам
    public Point2D(float x, float y) {
        this.x=x;
        this.y = y;
    }

    public Point2D(){

    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }

}