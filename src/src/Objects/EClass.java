package src.Objects;
public class EClass {
    private String name;
    private int type;
    private double hours,payPerHour;
    public EClass()
    {
        
    }
    public double getPay()
    {
        return payPerHour;
    }
    public void setPay(double p)
    {
        payPerHour=p;
    }
    public double getHours()
    {
        return hours;
    }
    public void setHours(double h)
    {
        hours=h;
    }
    public int getType()
    {
        return type;
    }
    public void setType(int t)
    {
        type=t;
    }
    public void setName(String n)
    {
        name=n;
    }
    public String getName()
    {
        return name;
    }
}