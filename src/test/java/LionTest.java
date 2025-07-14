import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    private Feline feline;

    @Test
    void testInvalidSexThrowsException() {
        assertThrows(Exception.class, () -> new Lion("Неизвестно", feline));
    }

    @Test
    void testGetKittens() throws Exception {

        int expectedKittensCount = 1;
        when(feline.getKittens(expectedKittensCount)).thenReturn(expectedKittensCount);

        Lion lion = new Lion("Самец", feline);


        assertEquals(expectedKittensCount, lion.getKittens(expectedKittensCount));
    }

    @Test
    void testGetFood() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", feline);

        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}