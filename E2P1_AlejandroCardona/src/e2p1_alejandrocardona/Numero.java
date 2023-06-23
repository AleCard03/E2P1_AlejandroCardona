/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e2p1_alejandrocardona;

/**
 *
 * @author jets
 */
public class Numero {
    private int base;
    private String num;
    
    public Numero(int baseN, int numN){
        this.base = baseN;
        this.num = decToBase(numN);
    }
    
    public char numToChar(int res){
        char numero = ' ';
        for (int i = 1; i<35; i++){
            if (i+9 == res){
                numero = (char) (96+i);
            }//fin if
        }//fin for i
        return numero;
    }//fin method numToChar
    
    public int charToNum(char res){
        int numero = 0;
        for (int i = 10; i< 35; i++){
            if(i== (int)(res)-96){
                numero = i;
            }//fin if
        }//fin for i
        return numero;
    }//fin method charToNum
    
    public String decToBase ( int numN ){
        String conversion = "";
        String ups = "";
        int base = getBase();
        int x = numN;
        for (int i = 0; i<x; i++){
            if(numN/base<base){
                if(numN%base < base&&numN%base>=10){
                    conversion+=numToChar(numN%base);
                }//fin if num residuo base menor que base y mayor a 10
                else{
                    conversion+=numN%base;
                }//fin else
                
                conversion+=numN/base;
                break;
            }//fin if numN sobre base es menor que base
            
            else if (numN == base){
                conversion+=numN/base;
                break;
            }//fin else if numN == base
            
            else if( numN > base){
                
                conversion += numN%base;
            }//fin else if numN es mayor a base
            numN/=base;
        }//fin for i
        for (int i = 0; i<conversion.length();i++){
            ups+=conversion.charAt(conversion.length()-1-i);
        }//fin for corregir string orden
        System.out.println(ups);
        return ups;
        
    }//fin method decToBase
    
    public String baseToDec(String num){
        
        int y = Integer.parseInt(num,getBase());
        return Integer.toString(y);
        
    }//fin method baseToDec
    
    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
    
}
