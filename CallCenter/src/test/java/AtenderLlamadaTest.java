/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.almundo.callcenter.bussines.dto.Llamada;
import com.almundo.callcenter.controlador.Dispatcher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author andresalarcon
 */
public class AtenderLlamadaTest {

    public AtenderLlamadaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void asignarLlamadaTest() {
        Dispatcher dispatcher = new Dispatcher();
        for (int i = 0; i < 10; i++) {
            Llamada llamada = new Llamada();
            llamada.setId(Integer.valueOf(i).longValue());
            dispatcher.dispatchCall(llamada);
        }
        try {
            dispatcher.monitorearResultados();
        } catch (Exception ex) {
            fail("Error "+ex.getMessage());
        }

    }
    
      @Test
    public void asignarLlamadaTest() {
        Dispatcher dispatcher = new Dispatcher();
        for (int i = 0; i < 20; i++) {
            Llamada llamada = new Llamada();
            llamada.setId(Integer.valueOf(i).longValue());
            dispatcher.dispatchCall(llamada);
        }
        try {
            dispatcher.monitorearResultados();
        } catch (Exception ex) {
            fail("Error "+ex.getMessage());
        }

    }

}
