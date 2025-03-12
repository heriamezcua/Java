package _02_intermediate_I._07_lambdas;

@FunctionalInterface
public interface Operation {
	int subtract(int x, int y);

//	int calculate(int x);  ERROR if +1
}
