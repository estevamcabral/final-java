

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste AircraftTest.
 *
 * @author  (seu nome)
 * @version (um número da versão ou uma data)
 */
public class AircraftTest
{
    /**
     * Construtor default para a classe de teste AircraftTest
     */
    public AircraftTest()
    {
    }

    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Desfaz a 'fixture' do teste.
     *
     * Chamado após cada método de teste de caso.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testeShow()
    {
        Aircraft aircraft1 = new Aircraft();
        aircraft1.print("Recife", "19:30", "TAM6060");
    }
}






