import java.awt.*;

public class Volvo240 extends PersCar{

    private final static double trimFactor = 1.25;
    public Volvo240() {
        super(4, 100, 1243, Color.black, "Volvo240");
        stopEngine();
    }

    protected double speedFactor(){ return getEnginePower() * 0.01 * trimFactor;}





    }



