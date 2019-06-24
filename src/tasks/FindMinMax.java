package tasks;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindMinMax {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<? extends T> list = stream
                .sorted(order)
                .collect(Collectors.toList());
        if (list.size() == 0) {
            minMaxConsumer.accept(null, null);
            return;
        }
        T min = list.get(0);
        T max = list.get(list.size() - 1);
        minMaxConsumer.accept(min, max);
    }
}
