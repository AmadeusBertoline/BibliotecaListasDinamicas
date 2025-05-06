package model;

public class Lista<T> implements ILista<T> {

	No<T> primeiro;
	private static int size;

	public Lista() {

		primeiro = null;
		size = 0;

	}

	@Override
	public boolean isEmpty() {

		if (primeiro == null) {

			return true;

		} else {

			return false;

		}

	}

	@Override
	public int size() {

		return size;

	}

	@Override
	public void addFirst(T dado) {

		No<T> elemento = new No<>();

		elemento.dado = dado;

		elemento.proximo = primeiro;

		primeiro = elemento;
		
		size++;

	}

	@Override
	public void addLast(T dado) throws Exception {

		if (isEmpty()) {

			// throw new Exception("Lista vazia");
			addFirst(dado);

		}

		int size = size();

		No<T> elemento = new No<>();

		elemento.dado = dado;

		elemento.proximo = null;

		No<T> ultimo = getNo(size - 1);

		ultimo.proximo = elemento;

		size++;
		
	}

	@Override
	public void add(T dado, int posicao) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFirst() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeLast() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(int posicao) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public T get(int posicao) throws Exception {

		No<T> elemento = getNo(posicao);

		return elemento.dado;
	}

	private No<T> getNo(int posicao) throws Exception {

		if (isEmpty()) {
			throw new Exception("Lista vazia");
		}

		int tamanho = size();

		if (posicao < 0 || posicao > tamanho - 1) {

			throw new Exception("Posição inválida");

		}

		No<T> auxiliar = primeiro;

		int cont = 0;

		while (cont < posicao) {

			auxiliar = auxiliar.proximo;

			cont++;

		}

		return auxiliar;

	}

}
