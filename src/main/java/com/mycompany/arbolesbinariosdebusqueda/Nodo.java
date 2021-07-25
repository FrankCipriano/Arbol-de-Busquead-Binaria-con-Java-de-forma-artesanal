/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arbolesbinariosdebusqueda;

/**
 *
 * @author frankdev
 */
public class Nodo {
    int edad;
    String nombre;
    Nodo hijoIzquierdo,hijoDerecho;
    public Nodo(int edad,String nombre){
        this.edad=edad;
        this.nombre=nombre;
        this.hijoDerecho=null;
        this.hijoIzquierdo=null;
    }
    public String toString(){
        return nombre+": tiene "+edad+" años";
    }
}
