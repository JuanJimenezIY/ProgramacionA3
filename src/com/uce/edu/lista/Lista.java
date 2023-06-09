package com.uce.edu.lista;

import java.util.List;
import java.util.function.Predicate;

public sealed interface Lista<T> permits Nil,Cons{
	
    Lista NIL= new Nil(); 
	T head();
	Lista<T> tail();
 
 
	boolean isEmpty();
	
	
	static<T> Lista<T> of(T h,Lista<T > t){
		return new Cons<>(h,t);
	}
	
	static <T> Lista<T> of(T... elems){
		Lista<T> ret=Lista.NIL;
		for(int i=elems.length-1; i>=0;i--) {
			T h =elems[i];
			var tmp= Lista.of(h,ret);
			ret = tmp;
		}
		return ret;
		
	}
	//imperativo
	default String toString1() {
		StringBuilder sb= new StringBuilder();
		var tmp =this;
		while(!tmp.isEmpty()) {
			sb.append(tmp.head());
			sb.append(",");
			tmp=tmp.tail();
		}
		sb.append("NIL");
		return sb.toString();
	}
	
	default  Lista<T> append(T elem){
	
		if(isEmpty()) {
			return Lista.of(elem);
		}else {
			return Lista.of(head(),tail().append(elem));
		}
	}
	
	default Lista<T> prepend(T elem){
		
			return Lista.of(elem,this);
		
	}
	default Lista<T> remove(T elem){

        if(isEmpty()) {
        	return NIL;
        }
        
        else {
        	if(head().equals(elem)) {
        
            return tail();
        }else {
            return Lista.of(head(),tail().remove(elem));
        }
        	
        }
    }
    
    
    default Lista<T> drop(int n){

    	if(isEmpty()|| n<=0) {
   		 return this;
   		 
    	}
  		 return drop(n-1).tail();
    	/*
    	
    	 if(isEmpty()) {
         	return NIL;
         }else
         {
        	 if(n<=0) {
        		 return this;
        	 }else {
        		 return drop(n-1).tail();
        	 }
         }*/
    }
    
    default Lista<T> dropWhile(Predicate<T> p)
    {
    	 if(isEmpty()) {
          	return NIL;
          }else
        	  if(p.test(head())){
        		
        		  return tail().dropWhile(p);
        
        	  }else {
        		  return Lista.of(head(),tail().dropWhile(p));
        		
          }
        	  
          
        	  
    }

    default Lista<T> take(int n){

    	
    	if(isEmpty()|| n<=0) {
    		return Lista.of();
    	}
    	 return tail().take(n-1).prepend(head());
    	
    	/*
    	 if(isEmpty()) {
         	return NIL;
         }else
         {
        	 if(n<=0) {
        		
        		 return Lista.of();
        					 
        	 }else {
        		 
        		 return tail().take(n-1).prepend(head());
        		
        	 }
         }
         */
    }
    
    default Lista<T> takeWhile(Predicate<T> p)
    {
    	 if(isEmpty()) {
          	return NIL;
          }else
        	  if(p.test(head())){
        		  return Lista.of(head(),tail().takeWhile(p));
        		 
        
        	  }else {
        		
        		  return tail().takeWhile(p);
          }
        	  
          
        	  
    }
    
    //copiar la priemra lista y le va a pasar a la otra  , reutuilizando la lsita  2 
    
    default Lista<T> concat(Lista<T> lista){
    	
    	 if(isEmpty()) {
          	return NIL;
          }else
        	  if(lista == NIL) {
        		  return this;
        	  }
        	  else {
        		
        		  return this.append(lista.head()).concat(lista.tail());
        	  }
        
    }
   
	
    }

