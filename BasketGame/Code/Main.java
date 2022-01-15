package Code;


import java.util.Random;
import java.awt.Color;

import sas.*;

public class Main{

    View view;
    Rectangle background;
    Rectangle rect;
    Circle cir1;
    Circle cir2;
    Circle cir3;
    Circle cir4;
    
    Text scorePanel;
    int score;
    Random rand;

    Main(){
        view= new View(500, 400);

        background= new Rectangle(0, 0, 500, 400, new Color(0, 0, 0));
        rect= new Rectangle(200, 300, 50, 100, new Color(255, 0, 0));

        cir1= new Circle(200, 0, 20, new Color(255,255,0));
        cir2= new Circle(300, 0, 20, new Color(255, 215, 0));
        cir3= new Circle(350, 0, 20, new Color(255,255,255));
        cir4= new Circle(100, 0, 20, new Color(255, 0, 0));

        scorePanel= new Text(400, 0, "Score: ", new Color(255, 255, 255));
        score=0;
        rand= new Random();
        play();
    }

    void play(){

        Circle[] circles= {cir1, cir2, cir3, cir4};
        int speed=100;
        int step= 10;

        while(!view.keyPressed('s')){
            for(int a=0;a<circles.length;a++){
                circles[a].move(0, 5);
            }

            if(view.keyRightPressed()){
                rect.move(step);
            }else if(view.keyLeftPressed()){
                rect.move(-step);
            }

            for(int a=0;a<circles.length;a++){

                if(rect.contains(circles[a])){
                    score++;
                    scorePanel.setText("Score: "+ score);
                    int ran= rand.nextInt(300);

                    int col1= rand.nextInt(255);
                    int col2= rand.nextInt(255);
                    int col3= rand.nextInt(255);

                    circles[a].moveTo(ran, 0);
                    circles[a].setColor(new Color(col1, col2, col3));
                }   

                if(!circles[a].intersects(background)){
                    int ran= rand.nextInt(300);

                    int col1= rand.nextInt(255);
                    int col2= rand.nextInt(255);
                    int col3= rand.nextInt(255);

                    circles[a].moveTo(ran, 0);
                    circles[a].setColor(new Color(col1, col2, col3));
                }
            }

            if(score>10){
                if(speed==1){
                    speed=1;
                    step=1;
                }else{
                    speed=speed-1;
                }
            }

            view.wait(speed);
        }
    }

    public static void main(String[] args) {
        new Main();
    }

}