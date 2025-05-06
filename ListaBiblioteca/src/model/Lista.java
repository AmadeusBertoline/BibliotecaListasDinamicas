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

		No<T> elemento = new No<>();

		elemento.dado = dado;

		int size = size();

		if (posicao == 0) {

			addFirst(dado);

		} else if (posicao == size) {

			addLast(dado);

		}

		if (posicao >= 0 && posicao <= size) {

			No<T> ocupado = new No<>();

			ocupado = getNo(posicao - 1);

			elemento.proximo = ocupado.proximo;
			ocupado.proximo = elemento;

		} else {
			throw new Exception("Posição inválida");
		}

	}

	@Override
	public void removeFirst() throws Exception {

		if (isEmpty()) {

			throw new Exception("Lista vazia");

		}

		primeiro = primeiro.proximo;
		size--;
	}

	@Override
	public void removeLast() throws Exception {

		if (isEmpty()) {

			throw new Exception("Lista vazia");

		}

		if (size() == 1) {
			removeFirst();
		}

		No<T> penultimo = new No<>();

		penultimo = getNo(size() - 2);

		penultimo.proximo = null;

		size--;

	}

	@Override
	public void remove(int posicao) throws Exception {

		if (isEmpty()) {

			throw new Exception("Lista vazia");

		}

		if (posicao < 0 || posicao > size() - 1) {

			throw new Exception("Lista vazia");

		}

		if (posicao == 0) {

			removeFirst();

		} else if (posicao == size() - 1) {

			removeLast();

		}

		if (size() == 1) {

			removeFirst();

		} else {

			No<T> saindo = new No<>();
			No<T> anterior = new No<>();

			saindo = getNo(posicao);
			anterior = getNo(posicao - 1);

			anterior.proximo = saindo.proximo;

		}
		size--;	
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
