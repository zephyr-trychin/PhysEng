public class Hitbox {
    double x;
    double xVel;
    double y;
    double yVel;
    double w;
    double h;


    Hitbox (double xPos, double yPos, double width, double height, double xVels, double yVels){
        x = xPos;
        y = yPos;
        w = width;
        h = height;
        xVel = xVels;
        yVel = yVels;
    }


    public int collide (Hitbox o){
        double diffX = x - o.x;
        double diffY = y - o.y;
        double sumW = (w + o.w) /2;
        double sumH = (h + o.h) /2;
        if (Math.abs(diffX) < sumW && Math.abs(diffY) < sumH) {
            if (Math.abs(diffX) < (Math.abs(diffY)) {

            }
        }
    }



    public void update (double gravX, double gravY, double timeStep) {
        xVel += gravX * timeStep;
        yVel += gravY * timeStep;
        x += xVel * timeStep;
        y += yVel * timeStep;

    }

    public void collBounce (Hitbox o){
        int collSide = collide (o);
        if (collSide == 1 | collSide == 3) {
            o.xVel = -o.xVel;
        } else if (collSide == 2) {
            o.yVel = 0;
        } else if (collSide == 4) {
            o.yVel = -o.yVel;
        }
    }
}
