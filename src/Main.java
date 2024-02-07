import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var numbers = IntStream
                .range(0, 100_000_000)
                .boxed()
                .toList();
        var start = Instant.now();
        var result = numbers
                .stream()
                        .filter(n -> n % 2 != 0)
                                .toList();
        var duration = Duration
                .between(start, Instant.now());
        System.out.printf("stream %d in %dms%n", result.size(), duration.toMillis());

        start = Instant.now();
        var lResult = new ArrayList<>();
        for (var number : numbers){
            if (number % 2 != 0){
                lResult.add(number);
            }
        }

        duration = Duration
                .between(start, Instant.now());
        System.out.printf("for %d in %dms%n", lResult.size(), duration.toMillis());
    }
}