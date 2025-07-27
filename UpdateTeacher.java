package university.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateTeacher extends JFrame implements ActionListener {
    JTextField textaddress,textphone,textemail,textadharno,textcourse,textbranch;
    JLabel empText;

    JButton submit,cancel;
    Choice cEMPID;

    UpdateTeacher(){
        getContentPane().setBackground(new Color(230,210,252));

        JLabel heading=new JLabel("Update Teacher Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel empID=new JLabel("select Employee Id");
        empID.setBounds(50,100,200,20);
        empID.setFont(new Font("serif",Font.PLAIN,20));
        add(empID);

        cEMPID=new Choice();
        cEMPID.setBounds(250,100,200,20);
        add(cEMPID);

        try{
            conn c=new conn();
            ResultSet rs=c.statement.executeQuery("select * from teacher");
            while(rs.next()){
                cEMPID.add(rs.getString("empId"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel name=new JLabel("Name:");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

       JLabel textName=new JLabel();
        textName.setBounds(200,150,150,30);
        add(textName);

        JLabel fname=new JLabel(" Father Name:");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);

        JLabel textfather=new JLabel();
        textfather.setBounds(600,150,150,30);
        add(textfather);

        JLabel EMPIDD=new JLabel(" Employee ID :");
        EMPIDD.setBounds(50,200,200,30);
        EMPIDD.setFont(new Font("serif",Font.BOLD,20));
        add(EMPIDD);

        empText=new JLabel();
        empText.setBounds(200,200,150,30);
        empText.setFont(new Font("serif",Font.BOLD,20));
        add(empText);

        JLabel dob=new JLabel(" Date of Birth:");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        JLabel dobdob=new JLabel();
        dobdob.setBounds(600,200,200,30);
        add(dobdob);

        JLabel address=new JLabel(" Address:");
        address.setBounds(50,250,200,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        textaddress=new JTextField();
        textaddress.setBounds(200,250,150,30);
        add(textaddress);

        JLabel phone=new JLabel(" Phone:");
        phone.setBounds(400,250,200,30);
        phone.setFont(new Font("serif",Font.BOLD,20));
        add(phone);

        textphone=new JTextField();
        textphone.setBounds(600,250,150,30);
        add(textphone);

        JLabel email=new JLabel(" Email:");
        email.setBounds(50,300,200,30);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);

        textemail=new JTextField();
        textemail.setBounds(200,300,150,30);
        add(textemail);

        JLabel M10=new JLabel(" Class X(%):");
        M10.setBounds(400,300,200,30);
        M10.setFont(new Font("serif",Font.BOLD,20));
        add(M10);

       JLabel textM10=new JLabel();
        textM10.setBounds(600,300,150,30);
        add(textM10);

        JLabel M12=new JLabel(" Class XII(%):");
        M12.setBounds(50,350,200,30);
        M12.setFont(new Font("serif",Font.BOLD,20));
        add(M12);

        JLabel textM12=new JLabel();
        textM12.setBounds(200,350,150,30);
        add(textM12);

        JLabel adharno=new JLabel(" Adhar number:");
        adharno.setBounds(400,350,200,30);
        adharno.setFont(new Font("serif",Font.BOLD,20));
        add(adharno);

        textadharno=new JTextField();
        textadharno.setBounds(600,350,150,30);
        add(textadharno);

        JLabel Qualification=new JLabel(" Qualification:");
        Qualification.setBounds(50,400,150,30);
        Qualification.setFont(new Font("serif",Font.BOLD,20));
        add(Qualification);

        textcourse=new JTextField();
        textcourse.setBounds(200,400,200,30);
        add(textcourse);

        JLabel Department=new JLabel(" Department:");
        Department.setBounds(400,400,200,30);
        Department.setFont(new Font("serif",Font.BOLD,20));
        add(Department);

        textbranch=new JTextField();
        textbranch.setBounds(600,400,150,30);
        add(textbranch);

        try{
            conn c=new conn();
            String query="select * from teacher where empId='"+cEMPID.getSelectedItem()+"'";
            ResultSet resultset=c.statement.executeQuery(query);
            while(resultset.next()){
                textName.setText(resultset.getString("name"));
                textfather.setText(resultset.getString("fname"));
                dobdob.setText(resultset.getString("dob"));
                textaddress.setText(resultset.getString("address"));
                textphone.setText(resultset.getString("phone"));
                textemail.setText(resultset.getString("email"));
                textM10.setText(resultset.getString("class_x"));
                textM12.setText(resultset.getString("class_xii"));
                textadharno.setText(resultset.getString("adharno"));
                empText.setText(resultset.getString("empId"));
                textcourse.setText(resultset.getString("education"));
                textbranch.setText(resultset.getString("department"));

            }
        }catch(Exception E){
            E.printStackTrace();
        }

        cEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                 try{
                     conn c=new conn();
                     String query="select * from teacher where empId='"+cEMPID.getSelectedItem()+"'";
                     ResultSet resultset=c.statement.executeQuery(query);
                     while(resultset.next()) {
                         textName.setText(resultset.getString("name"));
                         textfather.setText(resultset.getString("fname"));
                         dobdob.setText(resultset.getString("dob"));
                         textaddress.setText(resultset.getString("address"));
                         textphone.setText(resultset.getString("phone"));
                         textemail.setText(resultset.getString("email"));
                         textM10.setText(resultset.getString("class_x"));
                         textM12.setText(resultset.getString("class_xii"));
                         textadharno.setText(resultset.getString("adharno"));
                         empText.setText(resultset.getString("empId"));
                         textcourse.setText(resultset.getString("education"));
                         textbranch.setText(resultset.getString("department"));
                     }

                     }catch(Exception E){
                 E.printStackTrace();
                 }
            }

            });


        submit= new JButton("Update");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel= new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);


        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==submit){
        String empid=empText.getText();
        String address=textaddress.getText();
        String phone=textphone.getText();
        String email=textemail.getText();
        String course=textcourse.getText();
        String branch=textbranch.getText();

        try{
            String Q="update teacher set address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+course+"',department='"+branch+"' where empId='"+empid+"'";
            conn c=new conn();
            c.statement.executeUpdate(Q);

            JOptionPane.showMessageDialog(null,"Details Updated");
            setVisible(false);

        }catch(Exception E){
            E.printStackTrace();
        }
    }else{
        setVisible(false);
    }
    }

    public static void main(String[] args) {
        new UpdateTeacher();
    }
}
