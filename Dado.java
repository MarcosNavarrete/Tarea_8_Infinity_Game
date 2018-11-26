/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infinitygame;
import java.util.*;

/**
 *
 * @author WINDOWS 10
 */
public class Dado {
    
    public Dado(){
        
    }
    private Random azar = new Random();
    
    public int lanzarDados(int dado){
        for (int i = 0; i < 2; i++) {
            int lanzamiento = azar.nextInt(6)+1;
            dado = dado + lanzamiento;
        }
        System.out.println("Su lanzamiento es "+ dado);
        return dado;    
   }
}

 