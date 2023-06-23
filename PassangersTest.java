

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste PassangersTest.
 *
 * @author  (seu nome)
 * @version (um número da versão ou uma data)
 */
public class PassangersTest
{
    /**
     * Construtor default para a classe de teste PassangersTest
     */
    public PassangersTest()
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
    public void testePassengers()throws Exception
    {
        Passangers passange1 = new Passangers("TAM2173", "B10");
    }

    @Test
    public void testePassangersRead()throws Exception
    {
        Passangers.read("TAM2173", "B10");
    }
}


