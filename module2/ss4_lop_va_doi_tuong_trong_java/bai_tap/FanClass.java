public class FanClass {
    private final int slow = 1;
    private final int medium = 2;
    private final int fast = 3;
    private int speed = 1;
    private boolean on = false;
    private String color = "blue";
    private double radius = 5;

    public int getSlow() {
        return this.slow;
    }

    public int getMedium() {
        return this.medium;
    }

    public int getFast() {
        return this.fast;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return this.on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public FanClass() {
    }

    FanClass(int speed, boolean on, String color, double radius) {
        this.speed = speed;
        this.on = on;
        this.color = color;
        this.radius = radius;
    }

    public String toString() {
        if (this.isOn()) {
            return this.getSpeed() + " - " + this.getColor() + " - " + this.getRadius() + " fan is on";
        } else {
            return this.getColor() + " - " + this.getRadius() + " - " + " fan is off";
        }
    }

    public static void main(String[] args) {
        FanClass fan1 = new FanClass(3, true, "yellow", 10);
        FanClass fan2 = new FanClass(2, false, "blue", 5);
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
