/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocompra;

/**
 *
 * @author Alberto Limas
 */
public class Producto {
    private String _nombreProducto;
    private int _cantidad = 0;
    //Constructor parametrizado
    public Producto( String nombre, int cant ){
        _nombreProducto = nombre;
        _cantidad = cant;
    }
    //Se ha elegido un producto
    public void incrementarOcurrencia(){
        _cantidad++;
    }
    //Se decide eliminar el último producto
    public void reducirOcurrencia(){
        if( _cantidad > 0 )
            _cantidad--;
    }
    //Getter de las ocurrencias del producto
    public int getOcurrencias(){
        return _cantidad;
    }
    //Setter de las ocurrencias del producto
    public void setOcurrencias( int x ){
        _cantidad = x;
    }
}
