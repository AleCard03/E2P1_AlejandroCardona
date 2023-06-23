/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package e2p1_alejandrocardona;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.util.ArrayList;
/**
 *
 * @author jets
 */
public class E2P1_AlejandroCardona {
    static Scanner read = new Scanner(System.in);
    static JFrame b = new JFrame();
    static JLabel lab = new JLabel("Examen II");
    static JButton b1 = new JButton("Numeros");
    static JButton b2 = new JButton("Operaciones");
    static JButton b3 = new JButton("Salir");
    static ArrayList <Numero> n = new ArrayList<>();
    static boolean button1 = false;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            b.setLayout(null);
            b.setVisible(true);
            b.setSize(720,720);
            b.setDefaultCloseOperation(b.EXIT_ON_CLOSE);

            lab.setBounds(320, 30 -20, 240 , 40);
            b1.setBounds(240, 120 -20, 240 , 80);
            b2.setBounds(240, 360 -20, 240 , 80);
            b3.setBounds(240, 600-20 , 240 , 80);
            b.add(b1);
            b.add(b2);
            b.add(b3);
            b.add(lab);
            b1.addActionListener(e ->{
                button1 = true;
                boolean continuar = true;
                while (continuar){
                    System.out.println("---Menu Numeros---\n");
                    System.out.println("1. Agregar numero\n2. Eliminar numero\n3. Menu Principal");
                    int opcion = read.nextInt();
                    switch ( opcion ) {
                        case 1 : {
                            System.out.println("Ingrese un entero");
                            int ent = read.nextInt();
                            System.out.println("Ingrese una base");
                            int base = read.nextInt();
                            Numero nums = new Numero(base, ent);
                            n.add(nums);
                        }//fin case 1
                        break;
                        case 2 : {
                            System.out.println(printAL());
                            System.out.println("Ingrese el índice del Numero a eliminar");
                            int rem = read.nextInt();
                            n.remove(rem);
                        }//fin case 2
                        break;
                        case 3 : {
                            continuar = false;
                        }//fin case 3
                        break;
                        default : {
                            System.out.println("Has ingresado un valor no válido");
                        }//fin default
                        break;
                    }//fin switch opcion
                }//fin while continuar
                
            });
            b2.addActionListener( e -> {
                boolean continuar = true;
                while(continuar){
                    System.out.println("---Menu de Operaciones---\n");
                    System.out.println("1. Sumar Numeros\n2. Restar numeros\n3. Multiplicar numeros\n4. Menu Principal");
                    int opcion = read.nextInt();
                    switch(opcion){
                        case 1 : {
                            
                        }//fin case 1
                        break;
                        case 2 : {
                            
                        }//fin case 2
                        break;
                        case 3 : {
                            
                        }//fin case 3
                        break;
                        case 4 : {
                            continuar = false;
                        }//fin case 4
                        break;
                        default : {
                            System.out.println("Se ha ingresado un valor no valido");
                        }
                    }
                }
            });
            b3.addActionListener(e -> System.exit(0));
        }//fin method main
        // TODO code application logic here
    
    static String printAL (){
        String acum = "";
        for (int i = 0; i<n.size(); i++){
            acum+=i+". "+n.get(i).getNum()+" base "+n.get(i).getBase()+": "+n.get(i).baseToDec(n.get(i).getNum());
        }
        return acum;
    }
}//fin clase
