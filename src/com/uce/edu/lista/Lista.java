package com.uce.edu.lista;

import java.util.function.Predicate;

public sealed interface Lista<T> permits Nil, Cons {

	Lista NIL = new Nil();

	T head();

	Lista<T> tail();

	boolean isEmpty();

	static <T> Lista<T> of(T h, Lista<T> t) {
		return new Cons<>(h, t);
	}

	static <T> Lista<T> of(T... elems) {
		Lista<T> ret = Lista.NIL;
		for (int i = elems.length - 1; i >= 0; i--) {
			T h = elems[i];
			var tmp = Lista.of(h, ret);
			ret = tmp;
		}
		return ret;

	}

	// imperativo
	default String toString1() {
		StringBuilder sb = new StringBuilder();
		var tmp = this;
		while (!tmp.isEmpty()) {
			sb.append(tmp.head());
			sb.append(",");
			tmp = tmp.tail();
		}
		sb.append("NIL");
		return sb.toString();
	}

	default Lista<T> append(T elem) {

		return isEmpty() 
				? Lista.of(elem) 
						: Lista.of(head(), tail().append(elem));
	}
	/*
	 * 
	 * 
	 * 
	 * if(isEmpty()) { return Lista.of(elem); }else { return
	 * Lista.of(head(),tail().append(elem)); } }
	 */

	default Lista<T> prepend(T elem) {

		return Lista.of(elem, this);

	}

	default Lista<T> remove(T elem) {

		return isEmpty() 
				? NIL 
					: head().equals(elem) 
						? tail() 
								: Lista.of(head(), tail().remove(elem));

		/*
		 * if(isEmpty()) { return NIL; }
		 * 
		 * else { if(head().equals(elem)) {
		 * 
		 * return tail(); }else { return Lista.of(head(),tail().remove(elem)); }
		 * 
		 * }
		 */
	}

	default Lista<T> drop(int n) {

		return isEmpty() || n < 0 
				? this 
						: drop(n - 1).tail();

		/*
		 * if(isEmpty()|| n<=0) { return this;
		 * 
		 * } return drop(n-1).tail(); /*
		 * 
		 * if(isEmpty()) { return NIL; }else { if(n<=0) { return this; }else { return
		 * drop(n-1).tail(); } }
		 */
	}

	default Lista<T> dropWhile(Predicate<T> p) {

		return isEmpty()
				? NIL 
						: p.test(head())
						? tail().dropWhile(p) 
								: Lista.of(head(), tail().dropWhile(p));
		/*
		 * if(isEmpty()) { return NIL; }else if(p.test(head())){
		 * 
		 * return tail().dropWhile(p);
		 * 
		 * }else { return Lista.of(head(),tail().dropWhile(p));
		 * 
		 * }
		 * 
		 */

	}

	default Lista<T> take2(int n) {

		if (isEmpty() || n <= 0) {
			return Lista.of();
		}
		return tail().take2(n - 1).prepend(head());

		/*
		 * if(isEmpty()) { return NIL; }else { if(n<=0) {
		 * 
		 * return Lista.of();
		 * 
		 * }else {
		 * 
		 * return tail().take(n-1).prepend(head());
		 * 
		 * } }
		 */
	}

	default Lista<T> take(int n) {

		return isEmpty() || n <= 0 
				? NIL 
						: Lista.of(head(), tail().take(n - 1));

		/*
		 * if(isEmpty()||n<=0 ) { return NIL; } else { return
		 * Lista.of(head(),tail().take(n-1)); } /* if(isEmpty()) { return NIL; }else {
		 * if(n<=0) {
		 * 
		 * return NIL;
		 * 
		 * } return Lista.of(head(),tail().take(n-1)); }
		 */
	}

	default Lista<T> takeWhile(Predicate<T> p) {
		return isEmpty() 
				? NIL 
						: p.test(head()) 
						   	? Lista.of(head(), tail().takeWhile(p))
								: tail().takeWhile(p);
		/*
		 * 
		 * 
		 * 
		 * if(isEmpty()) { return NIL; }else if(p.test(head())){ return
		 * Lista.of(head(),tail().takeWhile(p));
		 * 
		 * 
		 * }else {
		 * 
		 * return tail().takeWhile(p); }
		 * 
		 */

	}

	default Lista<T> concatMio(Lista<T> lista) {

		if (isEmpty()) {
			return NIL;
		} else if (lista == NIL) {
			return this;
		} else {

			return this.append(lista.head()).concat(lista.tail());
		}

	}

	default Lista<T> concat(Lista<T> lista) {

		return isEmpty() 
				? lista
						: Lista.of(head(), tail().concat(lista));
		/*
		 * if(isEmpty()) { return lista; }else
		 * 
		 * 
		 * return Lista.of(head(),tail().concat(lista));
		 */
	}
	
	static  Integer maxAux(Lista<Integer> l,Integer max) {
		if (l==NIL) {
			return max;
		}else 
			if(max<l.head()) {
				return maxAux(l.tail(),l.head() );
			}else
				return maxAux(l.tail(),max );
		
	}
	static Integer max(Lista<Integer> t) {
		
		return maxAux(t, t.head());
}
	
	
	
	static  Integer sumaAux(Lista<Integer> lista , Integer t) {
		if (lista==NIL) {
			return t;
		}
		else
		
			return t+sumaAux(lista.tail(),lista.head());
	}
	
	
	
	static Integer suma(Lista<Integer> t) {
		
			return sumaAux(t.tail(), t.head());
	}
	

	
	
	
	
	
	
	/*
	 * size isempty return 0 else return 1+ tail.size
	 */

}
