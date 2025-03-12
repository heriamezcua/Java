package _03_intermediate_II._04_genericprog;

import java.util.ArrayList;
import java.util.List;

// When you implement the generic interface you can specify
// the type or generic again
public class _05_ClassImpGenInterface implements _04_GenericInterface<String> {

	private List<String> elementos = new ArrayList<>();

	@Override
	public void agregar(String elemento) {
		elementos.add(elemento);
	}

	@Override
	public String obtener(int indice) {
		return elementos.get(indice);
	}

}

// ** Same code but know we maintain the generic type **
//
class _05_ClassImpGenInterface implements _04_GenericInterface<T> {

	private List<T> elementos = new ArrayList<>();

	@Override
	public void agregar(T elemento) {
		elementos.add(elemento);
	}

	@Override
	public String obtener(T indice) {
		return elementos.get(indice);
	}

}
