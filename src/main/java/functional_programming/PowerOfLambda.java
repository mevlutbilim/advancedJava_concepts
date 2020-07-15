package functional_programming;

//Functional Generic Interface built for Lambda Expressions
public interface PowerOfLambda<T,E> {
    T lambda(E e);
}

interface Functional<T,E>{
    T lambda(E e1, E e2);
}
