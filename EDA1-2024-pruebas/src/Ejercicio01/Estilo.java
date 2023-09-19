package Ejercicio01;

import java.util.ArrayList;

public class Estilo {
//	private ArrayList<String> arr = new ArrayList<String>();

//	public static void main (String[]args){
//		
//		Estilo ejemplo = new Estilo();
//		ejemplo.arr.add("3");
//		
//		System.out.println(ejemplo.arr.toString());
//		
//	}

///////////-----------Se puede trabajar en local para simplificar el codigo--------------/////////

//	public static void main (String[]args){
//		ArrayList<String> arr = new ArrayList<String>();
//		arr.add("3");
//		
//		System.out.println(arr.toString());
//		
//	}

////////////------------añadimos mas valores------///////////

//	public static void main (String[]args){
//		ArrayList<String> arr = new ArrayList<String>();
//		
//		for(int i=1;i<=50;i++)
//		{
//			arr.add(String.valueOf(i));
//		}
//		
//		System.out.println(arr.toString());
//		
//	}

/////////////-----------numeros negativos y positivos aleatorios con operador ternario------------////////////

//	public static void main (String[]args){
//	ArrayList<String> arr = new ArrayList<String>();
//	
//	
//	for(int i=1;i<=50;i++)
//	{
//		arr.add(String.valueOf(Math.random()< .5 ? i : -i));
//		
//	}
//	
//	System.out.println(arr.toString());
//	
//}

/////////////-----------contar numeros negativos------------////////////

//public static void main (String[]args){
//ArrayList<String> arr = new ArrayList<String>();
//
//
//for(int i=1;i<=50;i++){
//arr.add(String.valueOf(Math.random()< .5 ? i : -i));
//
//}
//
//int numNegativos = 0;
//for (String valorStr : arr)
//	if (Integer.valueOf(valorStr) < 0 ) numNegativos++;
//
//System.out.println("El número de elementos negativos según forma 3 : " + numNegativos);
//System.out.println(arr.toString());
//
//}

/////////////-----------contar numeros negativos y modificar para que pase a positivo------------////////////

//public static void main (String[]args){
//ArrayList<String> arr = new ArrayList<String>();
//
//
//for(int i=1;i<=50;i++){
//arr.add(String.valueOf(Math.random()< .5 ? i : -i));
//
//}
//
//System.out.println("antes de modificar la estructura: " +arr.toString());
//
//for(int i=0; i<arr.size(); i++) {
//	if(Integer.valueOf(arr.get(i))<0) arr.set(i, String.valueOf(-Integer.valueOf(arr.get(i))));
//} 
//
//System.out.println("después de modificar la estructura: "+arr.toString());
//
//}

/////////////-----------informar de numero negativo------------////////////

//public static void main (String[]args){
//ArrayList<String> arr = new ArrayList<String>();
//
//
//for(int i=1;i<=50;i++){
//arr.add(String.valueOf(Math.random()< .9 ? i : -i));
//
//}
//
//System.out.println(arr.toString());
//for(String valorStr : arr) {
//	if(Integer.valueOf(valorStr)>=0) {
//		continue;
//	}
//	System.out.println("He encontrado el primer valor negativo: "+valorStr);
//	break;
//}
//
//}

/////////////-----------informar de numero negativo usando while------------////////////

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();

		for (int i = 1; i <= 50; i++) {
			arr.add(String.valueOf(Math.random() < .9 ? i : -i));

		}
	}
}
