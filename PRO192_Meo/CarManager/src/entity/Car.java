package entity;

public class Car {

    private String color;
    private int enginePower;
    private boolean isConvertible;
    private boolean engineOn;
    private boolean parkingBrakeOn;
    private String transmission;

    public SportsCar(String color, int enginePower, boolean isConvertible) {
        this.color = color;
        this.enginePower = enginePower;
        this.isConvertible = isConvertible;
        this.engineOn = false;
        this.parkingBrakeOn = true;
        this.transmission = "";
    }

    public void startEngine() {
        if (!engineOn) {
            engineOn = true;
            System.out.println("Engine started.");
        } else {
            System.out.println("Engine is already on.");
        }
    }

    public void stopEngine() {
        if (engineOn) {
            engineOn = false;
            System.out.println("Engine stopped.");
        } else {
            System.out.println("Engine is already off.");
        }
    }

    public void releaseParkingBrake() {
        if (parkingBrakeOn) {
            parkingBrakeOn = false;
            System.out.println("Parking brake released.");
        } else {
            System.out.println("Parking brake is already released.");
        }
    }

    public void applyParkingBrake() {
        if (!parkingBrakeOn) {
            parkingBrakeOn = true;
            System.out.println("Parking brake applied.");
        } else {
            System.out.println("Parking brake is already applied.");
        }
    }

    public void setTransmissionGear(String gear) {
        this.transmission.setGear(gear);
    }

    public void pressAccelerator() {
        if (!engineOn) {
            System.out.println("Engine is off. Please start the engine first.");
            return;
        }
        if (parkingBrakeOn) {
            System.out.println("Parking brake is on. Please release the parking brake first.");
            return;
        }
        switch (transmission.getCurrentGear()) {
            case PARK:
                System.out.println("The car is in park mode. Please change the transmission to drive or reverse.");
                break;
            case REVERSE:
                System.out.println("The car is moving in reverse.");
                break;
            case NEUTRAL:
                System.out.println("The car is in neutral. It won't move.");
                break;
            case DRIVE:
                System.out.println("The car is driving forward.");
                break;
        }
    }

    @Override
    public String toString() {
        return "SportsCar{" +
                "color='" + color + '\'' +
                ", enginePower=" + enginePower +
                ", isConvertible=" + isConvertible +
                ", engineOn=" + engineOn +
                ", parkingBrakeOn=" + parkingBrakeOn +
                ", transmission=" + transmission.getCurrentGear() +
                '}';
    }

    /**
     * Start the car.
     */
    public void pressStartButton() {
        System.out.println("You have pressed the start button");
    }

    /**
     * Accelerator.
     */
    public void pressAcceleratorButton() {
        System.out.println("You have pressed the Accelerator button");
        System.out.println("Color: " + colour);
        System.out.println("Engine power: " + enginePower);
        System.out.println("Convertible: " + convertible);
        System.out.println("Parking break: " + parkingBrake);
    }
}
