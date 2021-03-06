public class Displej implements IUIPrvok {
    private Segmentovka[] segmentovky;
    private int hodnota;
    private int najvacsiaHodnota;
    private boolean jeViditelny;

    public Displej(int poziciaX, int poziciaY, int velkost, int najvacsiaHodnota) {
        this.segmentovky = new Segmentovka[2];
        this.hodnota = 0;
        this.najvacsiaHodnota = najvacsiaHodnota;
        this.jeViditelny = true;

        this.segmentovky[0] = new Segmentovka(poziciaX, poziciaY, velkost);
        this.segmentovky[1] = new Segmentovka(poziciaX + velkost / 5 * 8 , poziciaY, velkost);

        this.zobraz(this.hodnota);
    }

    public void zobraz() {
        this.jeViditelny = true;
        this.zobraz(this.hodnota);
    }

    public void zobraz(int cislo) {
        if (!this.jeViditelny) {
            return;
        }
        this.hodnota = cislo;
        this.segmentovky[0].zobraz(cislo / 10);
        this.segmentovky[1].zobraz(cislo % 10);
    }

    public boolean pridaj() {
        ++this.hodnota;

        if (this.hodnota >= this.najvacsiaHodnota && this.najvacsiaHodnota != -1) {
            this.zobraz(0);
            return true;
        }

        this.zobraz(this.hodnota);
        return false;
    }

    public void vynuluj() {
        this.zobraz(0);
    }

    public void skry() {
        this.segmentovky[0].zobraz(-1);
        this.segmentovky[1].zobraz(-1);
        this.jeViditelny = false;
    }

    public int getHodnota() {
        return this.hodnota;
    }
}
