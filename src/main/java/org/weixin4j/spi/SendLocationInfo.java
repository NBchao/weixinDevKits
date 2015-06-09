package org.weixin4j.spi;

/**
 * SendLocationInfo业务
 *
 * @author qsyang
 * @version 1.0
 */
public class SendLocationInfo {

    private double Location_X;
    private double Location_Y;
    private int Scale;
    private String Label;
    private String Poiname;

    public double getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(double Location_X) {
        this.Location_X = Location_X;
    }

    public double getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(double Location_Y) {
        this.Location_Y = Location_Y;
    }

    public int getScale() {
        return Scale;
    }

    public void setScale(int Scale) {
        this.Scale = Scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String Label) {
        this.Label = Label;
    }

    public String getPoiname() {
        return Poiname;
    }

    public void setPoiname(String Poiname) {
        this.Poiname = Poiname;
    }

}
