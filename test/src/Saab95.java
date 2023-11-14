import java.awt.*;

public class Saab95 extends Cars {

    private boolean turboOn;
    public Saab95() {
        super(2, 125,1470,Color.red, "Saab95");
        stopEngine();
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    protected double speedFactor(){
        double turbo = 1.0;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }



}
