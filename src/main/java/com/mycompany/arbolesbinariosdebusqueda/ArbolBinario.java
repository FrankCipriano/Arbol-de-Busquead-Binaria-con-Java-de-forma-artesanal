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
public class ArbolBinario {
    Nodo raiz;
    public ArbolBinario(){
        raiz=null;
    }
    //METODO PARA INSERTAR UN NODO EN EL ARBOL
    public void insertar(int edad,String nombre){
        Nodo nuevo = new Nodo(edad,nombre);
        if(raiz==null){
            raiz=nuevo;
        }else{
            Nodo auxiliar=raiz;
            Nodo padre;
            while(true){
                padre=auxiliar;
                if(edad<auxiliar.edad){
                auxiliar=auxiliar.hijoIzquierdo;
                if(auxiliar==null){
                    padre.hijoIzquierdo=nuevo;
                    return;
                }
            }else{
                    auxiliar=auxiliar.hijoDerecho;
                    if(auxiliar==null){
                        padre.hijoDerecho=nuevo;
                        return;
                    }
                }
            }
        }
    }
    //METODO PARA VERIFICAR SI EL ARBOL ESTA VACIO
    public boolean estaVacio(){
        return raiz==null;
    }
    //METODO PARA RECORRER EL ARBOL DE FORMA INORDEN
    public void inOrden(Nodo n){
        if(n!=null){
            inOrden(n.hijoIzquierdo);
            System.out.print(n.edad+", ");
            inOrden(n.hijoDerecho);
        }
    }
    //METODO PARA RECORRER EL ARBOL DE FORMA PREORDEN
    public void preOrden(Nodo n){
        if(n!=null){
            System.out.print(n.edad+", ");
            preOrden(n.hijoIzquierdo);
            preOrden(n.hijoDerecho);
        }
    }
    //METODO PARA RECORRER EL ARBOL DE FORMA POSTORDEN
    public void postOrden(Nodo n){
        if(n!=null){
            postOrden(n.hijoIzquierdo);
            postOrden(n.hijoDerecho);
            System.out.print(n.edad+", ");
        }
    }
    //METODO BARA BUSCAR UN NODO EN EL ARBOL
    public Object buscar(int edad){
        Nodo auxiliar=raiz;
        while(auxiliar.edad!=edad){
            if(edad<auxiliar.edad){
                auxiliar=auxiliar.hijoIzquierdo;
            }else{
                auxiliar=auxiliar.hijoDerecho;
            }
            if(auxiliar==null){
                return null;
            }
        }
        return auxiliar;
    }
    //METODO PARA ELIMINAR UN NODO EN EL ARBOL
    public boolean eliminar(int edad){
        Nodo auxiliar=raiz;
        Nodo padre=raiz;
        boolean esHijoIzquierdo=true;
        while(auxiliar.edad!=edad){
            padre=auxiliar;
            if(edad<auxiliar.edad){
                esHijoIzquierdo=true;
                auxiliar=auxiliar.hijoIzquierdo;
            }else{
                esHijoIzquierdo=false;
                auxiliar=auxiliar.hijoDerecho;
            }
            if(auxiliar==null){
                return false;
            }
        }//-FIN DEL WHILE
        if(auxiliar.hijoDerecho==null && auxiliar.hijoIzquierdo==null){
            if(auxiliar==raiz){
                raiz=null;
            }else if(esHijoIzquierdo){
                padre.hijoIzquierdo=null;
            }else{
                padre.hijoDerecho=null;
            }
        }else if(auxiliar.hijoDerecho==null){
            if(auxiliar==raiz){
                raiz=auxiliar.hijoIzquierdo;
            }else if(esHijoIzquierdo){
                padre.hijoIzquierdo=auxiliar.hijoIzquierdo;
            }else{
                padre.hijoDerecho=auxiliar.hijoIzquierdo;
            }
        }else if(auxiliar.hijoIzquierdo==null){
            if(auxiliar==raiz){
                raiz=auxiliar.hijoDerecho;
            }else if(esHijoIzquierdo){
                padre.hijoIzquierdo=auxiliar.hijoDerecho;
            }else{
                padre.hijoDerecho=auxiliar.hijoDerecho;//p
            }
        }else{
            Nodo reemplazo=elReemplazo(auxiliar);
            if(auxiliar==raiz){
                raiz=reemplazo;
            }else if(esHijoIzquierdo){
                padre.hijoIzquierdo=reemplazo;
            }else{
                padre.hijoIzquierdo=reemplazo;
            }
            reemplazo.hijoIzquierdo=auxiliar.hijoIzquierdo;
        }
        return true;
    }
    //METODO PARA OBTENER EL REEMPLAZO DEL NODO A ELIMINAR
    public Nodo elReemplazo(Nodo aEliminar){
        Nodo reemplazar_padre=aEliminar;
        Nodo reemplazo=aEliminar;
        Nodo auxiliar=aEliminar.hijoDerecho;
        while(auxiliar!=null){
            reemplazar_padre=reemplazo;
            reemplazo=auxiliar;
            auxiliar=auxiliar.hijoIzquierdo;
        }
        if(reemplazo!=aEliminar.hijoDerecho){
            reemplazar_padre.hijoIzquierdo=reemplazo.hijoDerecho;
            reemplazo.hijoDerecho=aEliminar.hijoDerecho;
        }
        System.out.println("El nodo reemplazo es: "+reemplazo);
        return reemplazo;
    }
}
