package _03_intermediate_II._04_genericprog;

// We need to use <T>
public interface _04_GenericInterface<T> {

	void agregar(T elemento);

	T obtener(int indice);
}
