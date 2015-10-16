package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import src.Objects.EClass;

public class Employee extends Main{
    private JComboBox eList;
    private JButton set,add;
    private JLabel nameL,hRate,hWorked,typeL,payL;
    private JTextField nameF,typeF,hRateF,hWorkedF,payF;
    private boolean buttonPress=false;
    private EClass[] employs=new EClass[1];
    public Employee()
    {
        employs[0]=new EClass();
        employs[0].setName("Null");
        payF=new JTextField();
        payF.setBounds(210,5+(35*6),200,30);
        payF.setEditable(false);
        payF.setVisible(false);
        hWorkedF=new JTextField();
        hWorkedF.setBounds(210,5+(35*5),200,30);
        hWorkedF.setVisible(false);
        hRateF=new JTextField();
        hRateF.setBounds(210,5+(35*4),200,30);
        hRateF.setVisible(false);
        typeF=new JTextField();
        typeF.setBounds(210,5+(35*3),200,30);
        typeF.setVisible(false);
        nameF=new JTextField();
        nameF.setBounds(210,5+(35*2),200,30);
        nameF.setVisible(false);
        payL=new JLabel();
        payL.setText("Total Pay:");
        payL.setBounds(5,5+(35*6),75,30);
        payL.setVisible(false);
        hWorked=new JLabel();
        hWorked.setText("Hours Worked (1-60):");
        hWorked.setBounds(5,5+(35*5),150,30);
        hWorked.setVisible(false);
        hRate=new JLabel();
        hRate.setText("Hourly Rate (6.75 - 30.50):");
        hRate.setBounds(5,5+(35*4),200,30);
        hRate.setVisible(false);
        typeL=new JLabel();
        typeL.setText("Type:");
        typeL.setBounds(5,5+(35*3),50,30);
        typeL.setVisible(false);
        nameL=new JLabel();
        nameL.setText("Name:");
        nameL.setBounds(5,5+(35*2),50,30);
        nameL.setVisible(false);
        eList=new JComboBox();
        eList.setVisible(false);
        eList.setBounds(5,40,200,30);
        eList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if(buttonPress==false)
                refresh();
            }
        });
        set=new JButton();
        set.setVisible(false);
        set.setText("Set");
        set.setBounds(160,5,150,30);
        set.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonPress=true;
                String s=nameF.getText();
                int temp;
                double tempd;
                if(s.length()<2)
                    nameF.setText("More than 2 letters");
                else
                employs[eList.getSelectedIndex()].setName(s);
                try
                {
                    temp=Integer.parseInt(typeF.getText());
                    employs[eList.getSelectedIndex()].setType(temp);
                }
                catch(NumberFormatException ex){typeF.setText("Needs to be 1 or 2");}
                try
                {
                    tempd=Double.parseDouble(hRateF.getText());
                    tempd=Math.round(tempd*100);
                    tempd=tempd/100;
                    if(tempd>=6.75 && tempd<=30.50)
                    employs[eList.getSelectedIndex()].setPay(tempd);
                    else throw new NumberFormatException("hRateF Not between 6.75 and 30.50");
                }
                catch(NumberFormatException ex){hRateF.setText("Needs to be between 6.75 and 30.50");}
                try
                {
                    tempd=Double.parseDouble(hWorkedF.getText());
                    if(tempd<1||tempd>60)throw new NumberFormatException("Not between 1 and 60");
                    else employs[eList.getSelectedIndex()].setHours(tempd);
                }
                catch(NumberFormatException ex){hWorkedF.setText("Needs to be between 1 and 60");}
                refresh();
                buttonPress=false;
            }
        });
        add=new JButton();
        add.setVisible(false);
        add.setText("Add");
        add.setBounds(315,5,150,30);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonPress=true;
                boolean addPerson=true;
                String name=nameF.getText();
                int type=0;
                double hourRate=0,hours=0;
                if(name.length()<2)
                {
                    nameF.setText("More than 2 letters");
                    addPerson=false;
                }
                try
                {
                    type=Integer.parseInt(typeF.getText());
                    if(type<1&&type>2)throw new NumberFormatException("1 or 2 only");
                }
                catch(NumberFormatException ex){typeF.setText("Needs to be 1 or 2");addPerson=false;}
                try
                {
                    hourRate=Double.parseDouble(hRateF.getText());
                    if(hourRate>30.5||hourRate<6.75)throw new NumberFormatException("Not between 6.75 and 30.50");
                    hourRate=Math.round(hourRate*100);
                    hourRate=hourRate/100;
                }
                catch(NumberFormatException ex){hRateF.setText("Needs to be between 6.75 and 30.50");addPerson=false;}
                try
                {
                    hours=Double.parseDouble(hWorkedF.getText());
                    if(hours<1||hours>60)throw new NumberFormatException("Not between 1 and 60");
                }
                catch(NumberFormatException ex){hWorkedF.setText("Needs to be between 1 and 60");addPerson=false;}
                if(addPerson==true)
                {
                    addEm();
                    employs[employs.length-1]=new EClass();
                    employs[employs.length-1].setHours(hours);
                    employs[employs.length-1].setType(type);
                    employs[employs.length-1].setPay(hourRate);
                    employs[employs.length-1].setName(name);
                }
                refresh();
                buttonPress=false;
            }
        });
        refresh();
        frame.add(payF);
        frame.add(hWorkedF);
        frame.add(hRateF);
        frame.add(payL);
        frame.add(typeF);
        frame.add(nameF);
        frame.add(hWorked);
        frame.add(hRate);
        frame.add(typeL);
        frame.add(nameL);
        frame.add(eList);
        frame.add(add);
        frame.add(set);
    }
    private void refresh()
    {
        int index=eList.getSelectedIndex();
        eList.removeAllItems();
        for(int i=0;i<employs.length;i++)
        {
            eList.addItem(employs[i].getName());
        }
        eList.setSelectedIndex(index);
        try
        {
            nameF.setText(employs[index].getName());
            hRateF.setText(""+employs[index].getPay());
            hWorkedF.setText(""+employs[index].getHours());
            typeF.setText(""+employs[index].getType());
            payF.setText(""+employs[index].getTotalPay());
        }
        catch(ArrayIndexOutOfBoundsException ex){}
    }
    private void addEm()
    {
        EClass[] temp=new EClass[employs.length+1];
        for(int i=0;i<employs.length;i++)
        {
            temp[i]=employs[i];
        }
        employs=new EClass[temp.length];
        for(int i=0;i<temp.length;i++)
        {
            employs[i]=temp[i];
        }
    }
    public void visible(boolean tf)
    {
        frame.setTitle("Lesson 6 - Employee");
        frame.setSize(475,500);
        set.setVisible(tf);
        add.setVisible(tf);
        eList.setVisible(tf);
        nameL.setVisible(tf);
        typeL.setVisible(tf);
        hRate.setVisible(tf);
        hWorked.setVisible(tf);
        nameF.setVisible(tf);
        typeF.setVisible(tf);
        payL.setVisible(tf);
        hRateF.setVisible(tf);
        hWorkedF.setVisible(tf);
        payF.setVisible(tf);
    }
}
