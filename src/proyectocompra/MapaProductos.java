/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocompra;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Alberto Limas
 */

public class MapaProductos {
     private Map<String,Producto> _mapaArticulos = new HashMap<String, Producto>(); //Mapa de productos
     private Stack<String> _pilaArticulos = new Stack<>(); //Pila con registro de artículos añadidos
     
     //Constructor por defecto
     public MapaProductos(){
        }
     
    //Función que dado un String incrementa la ocurrencia de un producto
    //Si el producto no está en el mapa, se añade y se le incrementa la ocurrencia
    public void addProducto( String str ){
        //No está -> se añade
        if( _mapaArticulos.get(str) == null){
            Producto p = new Producto(str, 0);
            _mapaArticulos.put(str, p);
        }
        _mapaArticulos.get(str).incrementarOcurrencia();
        _pilaArticulos.add(str);
    }
    
    //Función que inserta al mapa un producto que entra por formulario
    public void addProductoNuevo( String str, int num){
        Producto p = new Producto(str, num);
        _mapaArticulos.put( str, p );
    }
    
    //Función que quita la última elección -> Pila vacía: no hace nada
    public void quitarUltimo(){
        if( !_pilaArticulos.empty()){
            Producto p = _mapaArticulos.get( _pilaArticulos.pop() );
            p.reducirOcurrencia();
        }
    }
    
    //Función que genera un .txt en el escritorio con la lista completa
    public void guardadoTXT(){
        try{
            //Obtenemos la ruta del escritorio
            String desktopPath = System.getProperty("user.home") + "\\Desktop" + "\\lista.txt";
            desktopPath.replace("/","\\");
            
            File f = new File(desktopPath);
            PrintWriter pw = new PrintWriter(f);
            //Recorremos el mapa, si ocurrencia > 0, se añade a la lista.
            for (Map.Entry<String, Producto> entry : _mapaArticulos.entrySet()) {
                if( entry.getValue().getOcurrencias() > 0 )
                    pw.println(entry.getKey() + ": " + entry.getValue().getOcurrencias() );
            }
            pw.close();
        
        }catch(IOException e){
            System.err.println("Error escritura del fichero");
        }
    }
    
    //Función que limpia la lista de la compra -> borra elementos
    public void borradoCompleto(){
        _mapaArticulos.clear();
    }
    
    //Getter del mapa
    public Map<String,Producto> getMap(){
        return _mapaArticulos;
    }
}

//Función antigua -> reducía a 0 ocurrencias -> NO BORRABA MAPA
//public void borradoCompleto(){
//    for (Map.Entry<String, Producto> entry : _mapaArticulos.entrySet()) {
//        if( entry.getValue().getOcurrencias() > 0 )
//            entry.getValue().setOcurrencias(0);
//    }
//}