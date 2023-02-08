package ar.ieslaencanta.com.spaceinvaders2;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Terminal terminal;
    private Screen screen;
    private boolean exit_key;
    private Bullet bala;

    public Game() {
        this.exit_key = false;
        try {
            this.terminal = new DefaultTerminalFactory().createTerminal();
            this.screen = new TerminalScreen(this.terminal);
            this.screen.setCursorPosition(null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        bala = new Bullet(40,12);
    }

    public void loop() {
        try {
            screen.startScreen();
            screen.clear();
            //this.terminal.setBackgroundColor(TextColor.ANSI.YELLOW);
            while (!this.exit_key) {
                int x =(int) Math.random() *80;
                int y = (int) Math.random()+24;
                //se procesa la entrada
                process_input();
                update();
                paint();
            }
            //cierra la ventana y terminal
            screen.close();
            terminal.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void update(){

    }

    private void paint(){
        this.bala.paint(screen);
        try {
            screen.refresh();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void process_input() {
        KeyStroke keyStroke = null;

        try {
            keyStroke = screen.pollInput();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (keyStroke != null) {
            if (keyStroke.getKeyType() == KeyType.Escape) {
                this.exit_key = true;
            }
        }
    }


}
