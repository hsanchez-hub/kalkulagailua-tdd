package com.zubirimanteo.ssa32.devops;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IkasleaTest {

    @Test
    void testObjektuenEgoera_Null_NotNull_True_False() {
        Ikaslea ikasle1 = new Ikaslea("100", "Ane", true, new int[]{7, 8, 9});
        Ikaslea ikasleHutsa = null;

        // assertNotNull / assertNull: Objektua memorian existitzen den egiaztatzeko
        assertNotNull(ikasle1, "Ikaslea ondo sortu beharko litzateke");
        assertNull(ikasleHutsa, "Objektuak null izan behar du");

        // assertTrue / assertFalse: Boolearrak egiaztatzeko
        assertTrue(ikasle1.isAktibo(), "Ikasleak aktibo egon beharko luke");

        Ikaslea ikasle2 = new Ikaslea("101", "Jon", false, new int[]{5, 6});
        assertFalse(ikasle2.isAktibo(), "Ikasle honek ez luke aktibo egon behar");
    }

    @Test
    void testObjektuenKonparazioa_Equals_NotEquals() {
        Ikaslea ikasleA = new Ikaslea("100", "Ane", true, new int[]{7, 8, 9});
        // ikasleB-k ID bera du (100), nahiz eta izena desberdina izan
        Ikaslea ikasleB = new Ikaslea("100", "Ane M.", true, new int[]{7, 8, 9});
        Ikaslea ikasleC = new Ikaslea("102", "Mikel", true, new int[]{5, 5, 5});

        // assertEquals-ek guk idatzitako Object.equals() erabiltzen du atzealdean.
        assertEquals(ikasleA, ikasleB, "ID bera duten ikasleak berdinak dira gure sistemarentzat");

        // assertNotEquals
        assertNotEquals(ikasleA, ikasleC, "ID desberdina duten ikasleak ez dira berdinak");
    }

    @Test
    void testArrayKonparazioa_ArrayEquals() {
        Ikaslea ikasle1 = new Ikaslea("100", "Ane", true, new int[]{7, 8, 9});
        int[] esperoDirenNotak = {7, 8, 9};

        // assertArrayEquals elementuz elementu konparatzen du
        assertArrayEquals(esperoDirenNotak, ikasle1.getNotak(), "Noten zerrendak zehatz-mehatz berdina izan behar du");
    }

    @Test
    void testSalbuespenak_Fail() {
        try {
            // Honek IllegalArgumentException bat bota beharko luke
            Ikaslea ikasleAkastuna = new Ikaslea("103", null, true, new int[]{});

            // Kodea hona iristen bada, ez du salbuespena bota
            fail("Testak huts egin du: ez du espero zen IllegalArgumentException bota (izena null delako)");

        } catch (IllegalArgumentException e) {
            // Salbuespena ondo harrapatu bada, testak arrakasta izango du
            assertNotNull(e.getMessage());
        }
    }

    @Test
    void testDatuOkerrak_Fail() {
        Ikaslea ikaslea = new Ikaslea("104", "Miren", true, new int[]{6, 7});
        try {
            // Izen huts bat ezartzen saiatzen gara: salbuespena bota beharko luke
            ikaslea.setIzena(null);

            // Hona iristen bada, setIzena-k ez du salbuespena bota
            fail("setIzena(null)-ek IllegalArgumentException bota beharko luke");

        } catch (IllegalArgumentException e) {
            // Salbuespena harrapatu da: mezua zuzena dela egiaztatzen dugu
            assertEquals("Izena ezin da hutsa (null) izan", e.getMessage());
        }
    }
}
