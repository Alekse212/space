package ar.ieslaencanta.com.spaceinvaders2;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;

public class Bullet {

    private Point2d posicion;
    private TextColor color;
    private TextColor backgroundcolor;

    private TextCharacter bulletsymbol;


    public Bullet(Point2d posicion) {
        this.posicion = posicion;
        this.init();
    }

    public Bullet(int x, int y) {
        this.posicion = new Point2d(x,y);
        this.init();
    }

    public Bullet() {
        this.posicion = new Point2d();
        this.init();
    }

    public Point2d getPosicion() {
        return posicion;
    }

    public void setPosicion(Point2d posicion) {
        this.posicion = posicion;
    }
    private void init(){
        this.color = TextColor.ANSI.GREEN;
        this.backgroundcolor = TextColor.ANSI.YELLOW;
        this.bulletsymbol = TextCharacter.fromCharacter(Symbols.ARROW_UP)[0].withForegroundColor(this.color).withBackgroundColor(this.backgroundcolor);
    }

    public void moveVertical(int y, int min_y, int max_y){
        if(this.posicion.getY()+y>=min_y && this.posicion.getY()+y<max_y){
            this.posicion.addY(y);
        }
    }
    public void paint(Screen s){
        s.setCharacter(this.posicion.getX(),this.posicion.getY(),this.bulletsymbol);
    }
}
