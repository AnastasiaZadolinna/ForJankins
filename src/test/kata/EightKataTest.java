package test.kata;

import kata.EightKata;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EightKataTest {

    public static final double EPS = 0.00001;

    @ParameterizedTest
    @MethodSource("provideImpl")
    public void getVolumeOfCuboidTest(EightKata eightKata){
        double expected = 40.157208;
        double length = 2.34;
        double actual = eightKata.getVolumeOfCuboid(length, 3.78, 4.54);
        assertEquals(expected, actual, EPS, "Wrong result for parameters " + length + ", " + 3 + ", " +4);
    }

    private static Stream<Arguments> provideImpl() {
        return Stream.of(
                Arguments.of(new kata.impl.VolodimirD.EightKataImpl()),
                Arguments.of(new kata.impl.AnastasiaZadolinna.EightKataImpl()),
                Arguments.of(new kata.impl.DmytroHursrkyi.EightKataImpl())
        );
    }
}