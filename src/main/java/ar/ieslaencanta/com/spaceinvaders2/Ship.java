package ar.ieslaencanta.com.spaceinvaders2;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;

public class Ship {
    private Point2d position;
    private int weidth=4;
    private int height=4;

    private Bullet[] ballas;
    private TextColor color;
    private TextColor backgroundcolor;
    private static int maxbullet =3;

    private TextCharacter Shipsymbol;

    public Ship(Point2d position, int weidth, int height) {
        this.position = position;
        this.weidth = weidth;
        this.height = height;
        this.init();
    }
    public Ship(int x, int y, int weidth, int height) {
        this.position = new Point2d(x,y);
        this.weidth = weidth;
        this.height = height;
        this.init();
    }

    public Ship(Point2d position) {
        this.position = position;
        this.init();
    }
    public Ship(int x, int y) {
        this.position = new Point2d(x,y);
        this.init();
    }

    public Ship() {
        this.position = new Point2d();
        this.ballas = new Bullet[maxbullet];
        this.init();

    }

    public Point2d getPosition() {
        return position;
    }

    public void setPosition(Point2d position) {
        this.position = position;
    }

    public int getWeidth() {
        return weidth;
    }

    public void setWeidth(int weidth) {
        this.weidth = weidth;
    }

    public int getHeight() {
        return height;
    }

    private void init(){
        this.color = TextColor.ANSI.BLACK;
        this.backgroundcolor = TextColor.ANSI.YELLOW;
        this.Shipsymbol = TextCharacter.fromCharacter(Symbols.DOUBLE_LINE_BOTTOM_LEFT_CORNER)[0].withForegroundColor(this.color).withBackgroundColor(this.backgroundcolor);
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void moveShip(int x, int max_x, int min_x){
        if(this.position.getX()+x-(this.weidth)>=min_x && this.position.getX()+x+(this.weidth)<max_x){
            this.position.addX(x);
        }
    }

    public void shot(){

    }

    public void moveBullet(){

    }

    public void paint(Screen s) {
        for (int i = 0; i < height / 2; i++) {
            if((i+2)>height / 2) {
                for (int j = 0; j < (weidth-2 / 2); j++){
                    s.setCharacter(this.position.getX() - j, this.position.getY()+i, this.Shipsymbol);
                    s.setCharacter(this.position.getX() + j, this.position.getY()+i, this.Shipsymbol);
                }
            }     else {
                for (int j = 0; j < weidth / 2; j++) {
                    s.setCharacter(this.position.getX() - j, this.position.getY() + i, this.Shipsymbol);
                    s.setCharacter(this.position.getX() + j, this.position.getY() + i, this.Shipsymbol);
                }
            }
        }

    }

}
