package view;

import model.Lista;

public class main {

	public static void Main(String[] args) {

		Lista<Integer> lista = new Lista<>();

		try {

			lista.addFirst(1);
			lista.addLast(2);
			lista.add(10, 1);
			lista.addFirst(10);
			int valor = lista.get(1);
			System.out.println(valor);
			lista.add(20, 2);
			valor = lista.get(3);
			System.out.println(valor);
			lista.removeFirst();
			lista.removeLast();
			lista.remove(1);
			valor = lista.get(1);
			System.out.println(valor);
			int tamanho = lista.size();
			System.out.println("Tamanho: " + tamanho);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
