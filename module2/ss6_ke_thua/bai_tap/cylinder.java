public class cylinder extends circle {
    int hight;

    public cylinder() {
    }

    public cylinder(int hight) {
        this.hight = hight;
    }

    public cylinder(int radius, String color, int hight) {
        super(radius, color);
        this.hight = hight;
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }
    void cylindricalVolume(){
        System.out.println("Thể tích của hình trụ = " + ((getRadius()* getRadius()) * getHight()) +"π");
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "hight=" + hight +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
