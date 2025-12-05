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
