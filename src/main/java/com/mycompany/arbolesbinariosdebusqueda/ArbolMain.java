/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arbolesbinariosdebusqueda;

import javax.swing.JOptionPane;

/**
 *
 * @author frankdev
 */
public class ArbolMain {

    public static void main(String args[]) {
        int op = 0, edad;
        String nombre;
        ArbolBinario arbol = new ArbolBinario();
        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Ingresar un dato al arbol\n"
                        + "2. Recorrer el arbol de forma inOrden\n"
                        + "3. Recorrer el arbol en forma preOrden\n"
                        + "4. Recorrer el arbol en forma postOrden\n"
                        + "5. Buscar un dato en el arbol\n"
                        + "6. Eliminar un nodo del arbol\n"
                        + "7. Salir\n"
                        + "Que desea hacer",
                        "Menu de opciones",
                        JOptionPane.INFORMATION_MESSAGE));
                switch (op) {
                    case 1:
                        edad = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa tu edad", "Ingresando nodo",
                                JOptionPane.QUESTION_MESSAGE));
                        nombre = JOptionPane.showInputDialog(null, "Ingresa tu nombre",
                                "Ingresando nodo", JOptionPane.QUESTION_MESSAGE);
                        arbol.insertar(edad, nombre);
                        break;
                    case 2:
                        if (!arbol.estaVacio()) {
                            System.out.println();
                            arbol.inOrden(arbol.raiz);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "El arbol esta vacio! Nada que mostrar",
                                    "Datos del Arbol Binario",
                                    JOptionPane.QUESTION_MESSAGE);
                        }
                        break;
                    case 3:
                        if (!arbol.estaVacio()) {
                            System.out.println();
                            arbol.preOrden(arbol.raiz);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "El arbol esta Vacio!  Nada que mostrar",
                                    "Datos del Arbol Binario",
                                    JOptionPane.QUESTION_MESSAGE);
                        }
                        break;
                    case 4:
                        if(!arbol.estaVacio()){
                            System.out.println();
                            arbol.postOrden(arbol.raiz);
                        }else{
                            JOptionPane.showMessageDialog(null,
                                    "El arbol esta Vacion!  Nada que mostrar",
                                    "Datos del Arbol Binario",
                                    JOptionPane.QUESTION_MESSAGE);
                        }
                        break;
                    case 5:
                        if(!arbol.estaVacio()){
                            edad=Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingrese la edad","Buscar datos en el arbol",
                                    JOptionPane.QUESTION_MESSAGE));
                            if(arbol.buscar(edad)!=null){
                                JOptionPane.showMessageDialog(null, "Encontrado.\n"+arbol.buscar(edad),
                                        "Datos del arbol",JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(null, "El dato no existe en el arbol",
                                        "Datos del arbol",JOptionPane.INFORMATION_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,
                                    "El arbol esta vacio!. Nada que buscar",
                                    "Datos del arbol",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 6:
                        if(!arbol.estaVacio()){
                            edad=Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingrese la edad a eliminar","Eliminando en el árbol",
                                    JOptionPane.QUESTION_MESSAGE));
                            if(arbol.eliminar(edad)){
                                JOptionPane.showMessageDialog(null,"El dato ha sido eliminado",
                                        "Eliminando Nodo",JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(null,"El dato no se encontró en el árbol",
                                        "Eliminando Nodo",JOptionPane.INFORMATION_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,"El arbol esta vacio.! Nada que eliminar",
                                    "Eliminando Nodo",JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null, "Gracias por utilizar los servicios de FrankDev");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion ingresado no es valido",
                                "Accion Desconocida", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
            }
        } while (op != 7);
    }
}
