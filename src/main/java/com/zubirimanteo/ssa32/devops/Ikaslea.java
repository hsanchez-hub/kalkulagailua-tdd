package com.zubirimanteo.ssa32.devops;

import java.util.Objects;

public class Ikaslea {
    private String id;
    private String izena;
    private boolean aktibo;
    private int[] notak;

    public Ikaslea(String id, String izena, boolean aktibo, int[] notak) {
        this.id = id;
        setIzena(izena); // Setter-a erabiltzen dugu balidazioa pasatzeko
        this.aktibo = aktibo;
        this.notak = notak;
    }

    public void setIzena(String izena) {
        if (izena == null) {
            throw new IllegalArgumentException("Izena ezin da hutsa (null) izan");
        }
        this.izena = izena;
    }

    public String getId() { return id; }
    public boolean isAktibo() { return aktibo; }
    public int[] getNotak() { return notak; }

    // Objektuak konparatzeko ezinbestekoa:
    // Bi ikasle BERDINAK direla esango dugu ID bera badute.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ikaslea ikaslea = (Ikaslea) obj;
        return Objects.equals(id, ikaslea.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
