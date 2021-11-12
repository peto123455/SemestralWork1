import java.util.ArrayList;

/**
 * Segmentovka
 * 
 * @author Peter Hulák
 */
public class Segmentovka {
    private ArrayList<Segment> segmenty;
    
    public Segmentovka(int poziciaX, int poziciaY, int velkost) {
        this.segmenty = new ArrayList<>();
        this.generujSegmenty(poziciaX, poziciaY, velkost);
    }
    
    private void generujSegmenty(int poziciaX, int poziciaY, int velkost) {
        int sirka = velkost;
        int vyska = velkost / 5;
        
        this.segmenty.add(new Segment(sirka, vyska, vyska + poziciaX, poziciaY));
        this.segmenty.add(new Segment(vyska, sirka, vyska + sirka + poziciaX, vyska + poziciaY));
        this.segmenty.add(new Segment(vyska, sirka, vyska + sirka + poziciaX, 2 * vyska + sirka + poziciaY));
        this.segmenty.add(new Segment(sirka, vyska, vyska + poziciaX, 2 * vyska + 2 * sirka + poziciaY));
        this.segmenty.add(new Segment(vyska, sirka, poziciaX, 2 * vyska + sirka + poziciaY));
        this.segmenty.add(new Segment(vyska, sirka, poziciaX, vyska + poziciaY));
        this.segmenty.add(new Segment(sirka, vyska, vyska + poziciaX, vyska + sirka + poziciaY));
    }
    
    private void zobrazKonkretneSegmenty(boolean[] zoznamSegmentov) {
        for (int i = 0; i < zoznamSegmentov.length; ++i) {
            this.segmenty.get(i).prepni(zoznamSegmentov[i]);
        }
    }
    
    public void zobraz(int cislo) {
        switch(cislo) {
            case 0:
                this.zobrazKonkretneSegmenty(new boolean[] {true, true, true, true, true, true, false});
                break;
            case 1:
                this.zobrazKonkretneSegmenty(new boolean[] {false, true, true, false, false, false, false});
                break;
            case 2:
                this.zobrazKonkretneSegmenty(new boolean[] {true, true, false, true, true, false, true});
                break;
            case 3:
                this.zobrazKonkretneSegmenty(new boolean[] {true, true, true, true, false, false, false});
                break;
            case 4:
                this.zobrazKonkretneSegmenty(new boolean[] {false, true, true, false, false, true, true});
                break;
            case 5:
                this.zobrazKonkretneSegmenty(new boolean[] {true, false, true, true, false, true, true});
                break;
            case 6:
                this.zobrazKonkretneSegmenty(new boolean[] {true, false, true, true, true, true, true});
                break;
            case 7:
                this.zobrazKonkretneSegmenty(new boolean[] {true, true, true, false, false, false, false});
                break;
            case 8:
                this.zobrazKonkretneSegmenty(new boolean[] {true, true, true, true, true, true, true});
                break;
            case 9:
                this.zobrazKonkretneSegmenty(new boolean[] {true, true, true, true, false, true, true});
                break;
        }
    }
}
