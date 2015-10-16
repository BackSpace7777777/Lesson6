package src.Objects;
public class EClass {
    private String name;
    private int type;
    private double hours,payPerHour;
    public EClass()
    {
        
    }
    public double getTotalPay()
    {
        double out=0;
        if(type==1)
        {
            if(hours>40)
            {
                double tempHours=hours;
                out+=40*payPerHour;
                tempHours=tempHours-40;
                out+=(tempHours*(payPerHour*2));
                out*=100;
                out=Math.round(out);
                out/=100;
            }
            else
            {
                out=hours*payPerHour;
            }
        }
        else
        {
            out=hours*payPerHour;
            out*=100;
            out=Math.round(out);
            out/=100;
        }
        return out;
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