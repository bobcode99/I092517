import java.util.PriorityQueue;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {

    public static Stream<Arguments> streamProviderInt(){
        return Stream.of(
                arguments(new int[] {3, 1, 2, 0}, new int[] {0, 1, 2, 3}),
                arguments(new int[] {5, 4, -3, 2}, new int[] {-3, 2, 4, 5}),
                arguments(new int[] {-9, 6, 8 ,-7}, new int[] {-9, -7, 6, 8}),
                arguments(new int[] {3, 9, 4, 3}, new int[] {3, 3, 4, 9}),
                arguments(new int[] {1, 7, 3, 6}, new int[] {1, 3, 6, 7}),
                arguments(new int[] {10, 15, 30, 20, 5}, new int[] {5, 10, 15, 20, 30})
//                , arguments(new int[] {-5, 8, 2, -3}, new int[] {2, 3, 8, 5}),
//                arguments(new int[] {-10, 15, -30, -20, -5}, new int[] {-5, -10, -30, -20, 15})


        );
    }

    @ParameterizedTest(name = "#{index} - Test with arguments{0},{1}")
    @MethodSource("streamProviderInt")
    void testStream_offer(int[] random, int[] correct){

        PriorityQueue pq_test = new PriorityQueue();
        for(int i:random){
            //System.out.println("before offer: "+ pq_test);
            pq_test.offer(i);
            // System.out.println("after offer: "+ pq_test);
        }

        //System.out.println("Here's come actual");
        for(int j:correct){
            //System.out.println(j);
            //System.out.println("before: "+pq_test);
            assertEquals(j, pq_test.poll());
            //System.out.println("after: "+pq_test);
        }

    }

    @Test
    void offer_nullException(){
        Exception exception = assertThrows(NullPointerException.class, ()-> {
            new PriorityQueue().offer(null);}
        );

        //assertTrue(exception.getMessage().contains("null"));

        //assertEquals(null, exception.getMessage());
        assertNull(exception.getMessage());

    }

    @Test
    void offer_addException(){
        Exception exception = assertThrows(NullPointerException.class, ()-> {
            new PriorityQueue().add(null);}
        );

        //assertTrue(exception.getMessage().contains("null"));
        //assertEquals(null, exception.getMessage());
        assertNull(exception.getMessage());

    }

    @Test
    void illegalTesting(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()-> {
            new PriorityQueue(-1, null);}
        );

        //assertTrue(exception.getMessage().contains("null"));
        assertNull(exception.getMessage());
        //assertEquals(null, exception.getMessage());
    }

//    @Test
//    void exceptionTesting() {
//
//        // 断言异常，抛出指定的异常，测试才会通过
//        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
//            throw new IllegalArgumentException("a message");
//        });
//        assertEquals("a message", exception.getMessage());
//    }

}
