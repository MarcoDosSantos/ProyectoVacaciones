import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Licencia extends JFrame implements ActionListener, ChangeListener{
  private JLabel label1, label2;
  private JTextArea textarea1;
  private JScrollPane pane1;
  private JCheckBox check1;
  private JButton boton1, boton2;
  String nombre1 = "";

  public Licencia(){
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Licencia de uso");
    setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());
    Bienvenida bv = new Bienvenida();
    nombre1 = bv.usuario;

    label1= new JLabel("TÉRMINOS Y CONDICIONES");
    label1.setBounds(215,5,200,30);
    label1.setFont(new Font("Andale Mono", 1, 14));
    label1.setForeground(new Color(0,0,0));
    add(label1);

    ImageIcon imagen = new ImageIcon("images/coca-cola.png");
    label2= new JLabel(imagen);
    label2.setBounds(315,135,300,300);
    add(label2);

    textarea1= new JTextArea();
    textarea1.setEditable(false);
    textarea1.setFont(new Font("Andale Mono", 0, 9));
    textarea1.setText("\n\n          TÉRMINOS Y CONDICIONES" + "\n    Curso Java - En esta entrega vamos a programar el diseño de la interfaz de términos y condiciones, al mismo tiempo que\n aprenderás como estructurar el texto de manera elegante dentro de un JTextArea e\n    incluir los eventos de ActionLIstener\n & ChangedListener simultáneamente en una misma clase."
    + "\n    Curso Java - En esta entrega vamos a programar el diseño de la interfaz de términos y condiciones, al mismo tiempo que\n     aprenderás como estructurar el texto de manera elegante\n dentro de un JTextArea e incluir los eventos de ActionLIstener & ChangedListener\n    simultáneamente en una misma clase."
    + "\n    Curso Java - En esta entrega vamos a programar el diseño de la interfaz de términos y condiciones, al mismo tiempo que\n     aprenderás como estructurar el texto de manera elegante\n dentro de un JTextArea e incluir los eventos de ActionLIstener & ChangedListener\n    simultáneamente en una misma clase."
    + "\n    Curso Java - En esta entrega vamos a programar el diseño de la interfaz de términos y condiciones, al mismo tiempo que\n     aprenderás como estructurar el texto de manera elegante\n dentro de un JTextArea e incluir los eventos de ActionLIstener & ChangedListener\n    simultáneamente en una misma clase.");
    pane1= new JScrollPane(textarea1);
    pane1.setBounds(10,40,575,200);
    add(pane1);

    check1= new JCheckBox("Yo " + nombre1 + ", acepto.");
    check1.setBounds(10,250,300,30);
    check1.addChangeListener(this);
    add(check1);

    boton1= new JButton("Continuar");
    boton1.setBounds(10,290,100,30);
    boton1.setEnabled(false);
    boton1.addActionListener(this);
    add(boton1);

    boton2= new JButton("No acepto");
    boton2.setBounds(120,290,100,30);
    boton2.setEnabled(true);
    boton2.addActionListener(this);
    add(boton2);
  }

  public void stateChanged(ChangeEvent e){
    if(check1.isSelected()){
      boton1.setEnabled(true);
      boton2.setEnabled(false);
    } else {
      boton1.setEnabled(false);
      boton2.setEnabled(true);
    }
  }
  
  public void actionPerformed(ActionEvent e){
    if(e.getSource() == boton1){
      Principal principal = new Principal();
      principal.setBounds(0,0,640,535);
      principal.setVisible(true);
      principal.setResizable(false);
      principal.setLocationRelativeTo(null);
      this.setVisible(false);
    }
    if(e.getSource() == boton2){ 
      Bienvenida bienvenida = new Bienvenida();
      bienvenida.setBounds(0,0,350,450);
      bienvenida.setLocationRelativeTo(null);
      bienvenida.setVisible(true);
      bienvenida.setResizable(false);
      this.setVisible(false);
    }
  }
  public static void main(String args[]){
    Licencia licencia = new Licencia();
    licencia.setBounds(0,0,600,360);
    licencia.setLocationRelativeTo(null);
    licencia.setVisible(true);
    licencia.setResizable(false);    
  }
}