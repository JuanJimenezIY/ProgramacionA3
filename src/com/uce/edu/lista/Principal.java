package com.uce.edu.lista;

import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Principal {

	
	public static void main(String[] args) {
		
/*
		Lista<Integer> n8 = Lista.of(8, Lista.NIL);
		Lista<Integer> n4 =  Lista.of(4, n8);
		Lista<Integer> n7 =  Lista.of(7, n4);
		Lista<Integer> n3 =  Lista.of(3, n7);
	
        //Cons no tendria acceso si el main esta en otro paquete 
		
		Lista<Integer> miLista = new Cons(2, n3);
		//System.out.println(miLista.head());
	*/
		Lista<Integer> miLista=Lista.of(2,3,7,4,8);
		System.out.println(miLista.toString1());
		System.out.println(miLista);
/*
		var tmp=miLista;
		while (tmp!= Lista.NIL) {
			System.out.println(tmp.head());
			tmp=tmp.tail();
		}
		*/
		//puedo crear una lista de listas
		Lista<?> empty=Lista.of();
		
		if(empty.isEmpty()) {
			System.out.println("vacia");
		}

	
		var nuevaLista=miLista.append(99);
		System.out.println(nuevaLista);
		
		var nuevaLista2=miLista.prepend(99);
		System.out.println(nuevaLista2);
		
		var lista3= miLista.remove(7);
		System.out.println("remove");
		
		System.out.println(lista3);
		
        Lista<Integer> nueva=Lista.of();
		
		var nL=miLista.drop(2);
		System.out.println("drop");
		System.out.println(nL);
		
		Lista<Integer> miLista2=Lista.of(1,2,3,4,5,6,7);
		var dropWhile=miLista2.dropWhile(t->t%2==0);
		System.out.println("dropWhile");
		System.out.println(dropWhile);
		
		var take=miLista.take(2);
		System.out.println("take");
		System.out.println(take);
		
		var takeWhile=miLista2.takeWhile(t->t%2==0);
		System.out.println("takeWhile");
		System.out.println(takeWhile);
		
		var concatenar=miLista.concat(miLista2);
		System.out.println("concatenar");
		System.out.println(concatenar);
		
		
	}
}