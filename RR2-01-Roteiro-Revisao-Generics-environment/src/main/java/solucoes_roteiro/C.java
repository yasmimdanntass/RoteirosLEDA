package solucoes_roteiro;

import java.util.Collection;

public class C<T> implements A<T>{

    @Override
    public void m(Object object) {
        System.out.println(object);
    }

    public void n(Collection<?> obj){
        System.out.println(obj);
    }

    public void o(Collection<? extends T> obj){
        System.out.println(obj);
    }

    public void p(Collection<? super T> obj){
        System.out.println(obj);
    }

}
