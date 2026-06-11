package lambda.lambda5.mystrem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

// static factory 추가
public class MyStreamV3<T> {

    private List<Integer> internalList;

    private MyStreamV3(List<Integer> internalList) {
        this.internalList = internalList;
    }

    // static factory
    public static MyStreamV3 of(List<Integer> internalList) {
        return new MyStreamV3(internalList);
    }

    public MyStreamV3 filter(Predicate<Integer> predicate) {
        List<Integer> filtered  = new ArrayList<>();
        for (Integer element : internalList) {
            if (predicate.test(element)) {
                filtered.add(element);
            }
        }
        return new MyStreamV3(filtered);
    }

    public MyStreamV3 map(Function<Integer, Integer> mapper) {
        List<Integer> mapped = new ArrayList<>();
        for (Integer element : internalList) {
            mapped.add(mapper.apply(element));
        }
        return new MyStreamV3(mapped);
    }

    public List<Integer> toList() {
        return internalList;
    }
}
