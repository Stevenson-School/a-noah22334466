import java.util.Comparator;
public class MaxArrayDeque<T> extends ArrayDeque<T>{
    private Comparator<T> comp;
    public MaxArrayDeque(Comparator<T> c){
        comp = c;
    }
    public MaxArrayDeque(){
        super();
    }
    public T max(){
        T max = arr[nextFirst+1]; //can't be arr[0] because its circular array deque
        for(int i = 0; i < size(); i++){
            if (comp.compare(this.get(i), max) > 0){
                max = this.get(i);
            }
        }
        return max;
    }
    public T max(Comparator<T> c){
        comp = c;
        return max();
    }

    public static void main(String[] args) {
        Comparator<Integer> sc = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };
        MaxArrayDeque<Integer> a1 = new MaxArrayDeque<>(sc);
        a1.addLast(2);
        a1.addLast(5);
        a1.addLast(9);
        System.out.println(a1);
        int x = a1.max();
    }
}
