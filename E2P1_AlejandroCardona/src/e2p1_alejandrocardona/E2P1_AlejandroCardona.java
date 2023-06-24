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
                            while ( ent <= 1){
                                System.out.println("Ha ingresado un valor no valido para el entero");
                                System.out.println("Ingrese un entero");
                                ent = read.nextInt();
                            }//fin while validar ent
                            System.out.println("Ingrese una base");
                            int base = read.nextInt();
                            while (base <2 || base> 35){
                                System.out.println("Ha ingresado un valor no valido para la base");
                                System.out.println("Ingrese una base");
                                base = read.nextInt();
                            }//fin while validar base
                            Numero nums = new Numero(base, ent);
                            n.add(nums);
                        }//fin case 1
                        break;
                        case 2 : {
                            System.out.println(printAL());
                            if(n.size()>0){
                                System.out.println("Ingrese el índice del Numero a eliminar");
                                int rem = read.nextInt();
                                while ( rem < 0 || rem >= n.size()){
                                    System.out.println("Ingrese un valor valido de indice");
                                    rem = read.nextInt();
                                }//fin while validacion indice
                                n.remove(rem);
                            }//fin if hay numeros almacenados
                            else{
                                System.out.println("No hay numeros almacenados");
                            }//fin else no hay numeros almacenados
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
                Numero nums = new Numero();
                boolean continuar = true;
                while(continuar){
                    
                    System.out.println("---Menu de Operaciones---\n");
                    System.out.println("1. Sumar Numeros\n2. Restar numeros\n3. Multiplicar numeros\n4. Menu Principal");
                    int opcion = read.nextInt();
                    switch(opcion){
                        
                        case 1 : {
                            System.out.println(printAL());
                            System.out.println("Ingrese el índice del primer numero a sumar");
                            int ind = read.nextInt();
                            System.out.println("Ingrese el indice del segundo numero a sumar");
                            int index = read.nextInt();
                            
                            while ( (ind <0 || ind >= n.size())||(index<0 ||index >= n.size())){
                                System.out.println("Ha ingresado valores no válidos para uno o más de los índices");
                                System.out.println("Ingrese el índice del primer numero a sumar");
                                ind = read.nextInt();
                                System.out.println("Ingrese el indice del segundo numero a sumar");
                                index = read.nextInt();
                            }//fin while validar indices
                            
                            int i1 = n.get(ind).getBase();
                            int i2 = n.get(index).getBase();
                            
                            if( i1 == i2){
                                int result = Integer.parseInt(n.get(ind).getNum(),n.get(ind).getBase())+Integer.parseInt(n.get(index).getNum(),n.get(index).getBase());
                                nums.setBase(n.get(ind).getBase());
                                String resu = (nums.decToBase(result));
                                System.out.println(resu);
                            }//fin if bases son las mismas
                            
                            else if (i1 > i2){
                                String x = n.get(index).baseToDec(n.get(index).getNum());
                                nums.setBase(i1);
                                String y = nums.decToBase(Integer.parseInt(x));
                                int result = Integer.parseInt(n.get(ind).getNum(),n.get(ind).getBase())+Integer.parseInt(y,i1);
                                String resu = (nums.decToBase(result));
                                System.out.println(resu);
                            }//fin if base1 > base 2
                            
                            else if (i2 > i1){
                                String x = n.get(ind).baseToDec(n.get(ind).getNum());
                                nums.setBase(i2);
                                String y = nums.decToBase(Integer.parseInt(x));
                                int result = Integer.parseInt(n.get(index).getNum(),n.get(index).getBase())+Integer.parseInt(y,i2);
                                String resu = (nums.decToBase(result));
                                System.out.println(resu);
                            }//fin if base 2 > base 1
                            
                        }//fin case 1
                        
                        break;
                        
                        case 2 : {
                            System.out.println(printAL());
                            System.out.println("Ingrese el índice del primer numero a restar");
                            int ind = read.nextInt();
                            System.out.println("Ingrese el indice del segundo numero a restar");
                            int index = read.nextInt();
                            
                            while ( (ind <0 || ind >= n.size())||(index<0 ||index >= n.size())){
                                System.out.println("Ha ingresado valores no válidos para uno o más de los índices");
                                System.out.println("Ingrese el índice del primer numero a restar");
                                ind = read.nextInt();
                                System.out.println("Ingrese el indice del segundo numero a restar");
                                index = read.nextInt();
                            }//fin while validar indices
                            
                            int i1 = n.get(ind).getBase();
                            int i2 = n.get(index).getBase();
                            
                            if( i1 == i2){
                                int result = Integer.parseInt(n.get(ind).getNum(),n.get(ind).getBase())-Integer.parseInt(n.get(index).getNum(),n.get(index).getBase());
                                nums.setBase(n.get(ind).getBase());
                                String resu = (nums.decToBase(result));
                                System.out.println(resu);
                            }//fin if bases son las mismas
                            
                            else if (i1 > i2){
                                
                                String x = n.get(index).baseToDec(n.get(index).getNum());
                                nums.setBase(i1);
                                String y = nums.decToBase(Integer.parseInt(x));
                                int result = Integer.parseInt(n.get(ind).getNum(),n.get(ind).getBase())-Integer.parseInt(y,i1);
                                String resu = (nums.decToBase(result));
                                System.out.println(resu);
                            }//fin if base1 > base 2
                            
                            else if (i2 > i1){
                                String x = n.get(ind).baseToDec(n.get(ind).getNum());
                                nums.setBase(i2);
                                String y = nums.decToBase(Integer.parseInt(x));
                                int result = Integer.parseInt(n.get(index).getNum(),n.get(index).getBase())-Integer.parseInt(y,i2);
                                String resu = (nums.decToBase(result));
                                System.out.println(resu);
                            }//fin if base 2 > base 1
                            
                        }//fin case 2
                        break;
                        case 3 : {
                            System.out.println(printAL());
                            System.out.println("Ingrese el índice del primer numero a multiplicar");
                            int ind = read.nextInt();
                            System.out.println("Ingrese el indice del segundo numero a multiplicar");
                            int index = read.nextInt();
                            while ( (ind <0 || ind >= n.size())||(index<0 ||index >= n.size())){
                                System.out.println("Ha ingresado valores no válidos para uno o más de los índices");
                                System.out.println("Ingrese el índice del primer numero a multiplicar");
                                ind = read.nextInt();
                                System.out.println("Ingrese el indice del segundo numero a multiplicar");
                                index = read.nextInt();
                            }//fin while validar indices
                            int i1 = n.get(ind).getBase();
                            int i2 = n.get(index).getBase();
                            
                            if( i1 == i2){
                                int result = Integer.parseInt(n.get(ind).getNum(),n.get(ind).getBase())*Integer.parseInt(n.get(index).getNum(),n.get(index).getBase());
                                nums.setBase(n.get(ind).getBase());
                                String resu = (nums.decToBase(result));
                                System.out.println(resu);
                            }//fin if bases son las mismas
                            
                            else if (i1 > i2){
                                
                                String x = n.get(index).baseToDec(n.get(index).getNum());
                                nums.setBase(i1);
                                String y = nums.decToBase(Integer.parseInt(x));
                                int result = Integer.parseInt(n.get(ind).getNum(),n.get(ind).getBase())*Integer.parseInt(y,i1);
                                String resu = (nums.decToBase(result));
                                System.out.println(resu);
                            }//fin if base1 > base 2
                            
                            else if (i2 > i1){
                                String x = n.get(ind).baseToDec(n.get(ind).getNum());
                                nums.setBase(i2);
                                String y = nums.decToBase(Integer.parseInt(x));
                                int result = Integer.parseInt(n.get(index).getNum(),n.get(index).getBase())*Integer.parseInt(y,i2);
                                String resu = (nums.decToBase(result));
                                System.out.println(resu);
                            }//fin if base 2 > base 1
                            
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
