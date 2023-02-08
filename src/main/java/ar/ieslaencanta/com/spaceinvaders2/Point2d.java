package ar.ieslaencanta.com.spaceinvaders2;

/**
 * Clase que representa un punto de dos dimenciones x e y
 * @author rutov
 */


public class Point2d {
    private int x;
    private int y;


    public Point2d(){
        this.x =-1;
        this.y =-1;
    }

    public Point2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Incrementa o descrimenta la posicion en el eje x
     * @param incx
     */
    public void addX(int incx){
        this.x += incx;
    }
    /**
     * Incrementa o descrimenta la posicion en el eje y
     * @param incy
     */
    public void addY(int incy){
        this.y += incy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
