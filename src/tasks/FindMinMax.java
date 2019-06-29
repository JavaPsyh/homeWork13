package tasks;

import java.util.Collections;
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
                .collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
            return;
        }
        T min = Collections.min(list, order);
        T max = Collections.max(list, order);
        minMaxConsumer.accept(min, max);
    }
}
