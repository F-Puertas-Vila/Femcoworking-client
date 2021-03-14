/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOCaldades;

import IOCaltasques.JsonParse;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Xavi
 */
public class OperacionsServidorTest {

    public OperacionsServidorTest() {
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

    /**
     * Test of login method, of class OperacionsServidor.
     */
    @Test
    public void testLoginSensePosarDades() throws Exception {
        System.out.println("login");
        DadesAcces dades = new DadesAcces("", "");;
        OperacionsServidor instance = new OperacionsServidor();
        String resEsperat = "El camp email és obligatori";
        JsonParse jsonParse = new JsonParse();
        String result = instance.login(dades);
        if (jsonParse.isJSONValid(result)) {
            JSONObject object = new JSONObject(result);
            String missatge = object.getString("message");
            String str = missatge.replace("\"", "");

            if (resEsperat.equals(str)) {
                System.out.println("Correcte");

            }
        }
    }

    @Test
    public void testLoginNomesUsuari() throws Exception {
        System.out.println("login");
        DadesAcces dades = new DadesAcces("", "");;
        OperacionsServidor instance = new OperacionsServidor();
        String resEsperat = "El camp contrasenya és obligatori";
        JsonParse jsonParse = new JsonParse();
        String result = instance.login(dades);
        if (jsonParse.isJSONValid(result)) {
            JSONObject object = new JSONObject(result);
            String missatge = object.getString("message");
            String str = missatge.replace("\"", "");

            if (resEsperat.equals(str)) {
                System.out.println("Correcte");

            }
        }
    }

    @Test
    public void testLoginNomesContrasenya() throws Exception {
        System.out.println("login");
        DadesAcces dades = new DadesAcces("", "");;
        OperacionsServidor instance = new OperacionsServidor();
        String resEsperat = "El camp usuari és obligatori";
        JsonParse jsonParse = new JsonParse();
        String result = instance.login(dades);
        if (jsonParse.isJSONValid(result)) {
            JSONObject object = new JSONObject(result);
            String missatge = object.getString("message");
            String str = missatge.replace("\"", "");

            if (resEsperat.equals(str)) {
                System.out.println("Correcte");

            }
        }
    }

    @Test
    public void testLoginUsuariCorrecteContrasenyaIncorrecta() throws Exception {
        System.out.println("login");
        DadesAcces dades = new DadesAcces("hola@hola.com", "");;
        OperacionsServidor instance = new OperacionsServidor();
        String resEsperat = "La contrasenya no és vàlida";
        JsonParse jsonParse = new JsonParse();
        String result = instance.login(dades);
        if (jsonParse.isJSONValid(result)) {
            JSONObject object = new JSONObject(result);
            String missatge = object.getString("message");
            String str = missatge.replace("\"", "");

            if (resEsperat.equals(str)) {
                System.out.println("Correcte");

            }
        }
    }

    @Test
    public void testLoginUsuariInexistent() throws Exception {
        System.out.println("login");
        DadesAcces dades = new DadesAcces("jomateix@jomateix.com", "12345");;
        OperacionsServidor instance = new OperacionsServidor();
        String resEsperat = "L'usuari no existeix";
        JsonParse jsonParse = new JsonParse();
        String result = instance.login(dades);
        if (jsonParse.isJSONValid(result)) {
            JSONObject object = new JSONObject(result);
            String missatge = object.getString("message");
            String str = missatge.replace("\"", "");

            if (resEsperat.equals(str)) {
                System.out.println("Correcte");

            }
        }
    }

    @Test
    public void testLoginCorrecte() throws Exception {
        System.out.println("login");
        DadesAcces dades = new DadesAcces("hola@hola.com", "1234");;
        OperacionsServidor instance = new OperacionsServidor();
        String resEsperat = "L'usuari no existeix";
        JsonParse jsonParse = new JsonParse();
        String result = instance.login(dades);
        if (jsonParse.isJSONValid(result)) {
            JSONObject object = new JSONObject(result);
            String missatge = object.getString("message");
            String str = missatge.replace("\"", "");

            if (resEsperat.equals(str)) {
                System.out.println("Correcte");

            }
        }
    }

    /**
     * Test of canviarContrasenya method, of class OperacionsServidor.
     */
//    @Test
//    public void testCanviarContrasenya() throws Exception {
//        System.out.println("canviarContrasenya");
//        DadesAcces dades = new DadesAcces("tu@tu.com", "1234");;
//        OperacionsServidor instance = new OperacionsServidor();
//        String codiAccess = instance.login(dades);
//        Contrasenya novaContrasenya = new Contrasenya("12345");
//        instance.canviarContrasenya(novaContrasenya, codiAccess);
//    }
    /**
     * Test of desconectar method, of class OperacionsServidor.
     */
    @Test
    public void testDesconectar() throws Exception {
        System.out.println("Desconectar");
        DadesAcces dades = new DadesAcces("jo@jo.com", "12345");;
        OperacionsServidor instance = new OperacionsServidor();
        String codiAccess = instance.login(dades);
        instance.desconectar(codiAccess);
    }

    /**
     * Test of registrarUsuari method, of class OperacionsServidor.
     */
//    @Test
//    public void testRegistrarUsuariCorrecte() throws Exception {
//        System.out.println("registrarUsuari");
//        Usuari usuari = new Usuari("PROVEIDOR", "Joan", "Ctra. Nova", "52223444", "Vic", "Barcelona", "pep@pep.com", "1234");
//        OperacionsServidor instance = new OperacionsServidor();
//        instance.registrarUsuari(usuari);
//    }
    @Test
    public void testIntentRegistreSenseCampNom() throws Exception {
        System.out.println("registrarUsuari");
        Usuari usuari = new Usuari("PROVEIDOR", null, "Ctra. Nova", "52223444", "Vic", "Barcelona", "pep@pep.com", "1234");
        OperacionsServidor instance = new OperacionsServidor();
        instance.registrarUsuari(usuari);
    }

    @Test
    public void testIntentRegistreSenseCampDireccio() throws Exception {
        System.out.println("registrarUsuari");
        Usuari usuari = new Usuari("PROVEIDOR", "Marc", null, "52223444", "Vic", "Barcelona", "pep@pep.com", "1234");
        OperacionsServidor instance = new OperacionsServidor();
        instance.registrarUsuari(usuari);
    }

    @Test
    public void testIntentRegistreSenseCampCif() throws Exception {
        System.out.println("registrarUsuari");
        Usuari usuari = new Usuari("PROVEIDOR", "Marc", "Ctra. Nova", null, "Vic", "Barcelona", "pep@pep.com", "1234");
        OperacionsServidor instance = new OperacionsServidor();
        instance.registrarUsuari(usuari);
    }

    @Test
    public void testIntentRegistreSenseCampPoblacio() throws Exception {
        System.out.println("registrarUsuari");
        Usuari usuari = new Usuari("PROVEIDOR", "Marc", "Ctra. Nova", "52223444", null, "Barcelona", "pep@pep.com", "1234");
        OperacionsServidor instance = new OperacionsServidor();
        instance.registrarUsuari(usuari);
    }

    @Test
    public void testIntentRegistreSenseCampProvincia() throws Exception {
        System.out.println("registrarUsuari");
        Usuari usuari = new Usuari("PROVEIDOR", "Marc", "Ctra. Nova", "52223444", "Vic", null, "pep@pep.com", "1234");
        OperacionsServidor instance = new OperacionsServidor();
        instance.registrarUsuari(usuari);
    }

    @Test
    public void testIntentRegistreSenseCampEmail() throws Exception {
        System.out.println("registrarUsuari");
        Usuari usuari = new Usuari("PROVEIDOR", "Marc", "Ctra. Nova", "52223444", "Vic", "Barcelona", null, "1234");
        OperacionsServidor instance = new OperacionsServidor();
        instance.registrarUsuari(usuari);
    }

    @Test
    public void testIntentRegistreSenseCampContrasenya() throws Exception {
        System.out.println("registrarUsuari");
        Usuari usuari = new Usuari("PROVEIDOR", "Marc", "Ctra. Nova", "52223444", "Vic", "Barcelona", "pep@pep.com", null);
        OperacionsServidor instance = new OperacionsServidor();
        instance.registrarUsuari(usuari);
    }

    @Test
    public void testIntentRegistreUsuariJaExisteix() throws Exception {
        System.out.println("registrarUsuari");
        Usuari usuari = new Usuari("PROVEIDOR", "Marc", "Ctra. Nova", "52223444", "Vic", "Barcelona", "proveidor@email.com", "1234");
        OperacionsServidor instance = new OperacionsServidor();
        instance.registrarUsuari(usuari);
    }

}
