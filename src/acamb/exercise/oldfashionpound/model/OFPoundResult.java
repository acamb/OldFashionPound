package acamb.exercise.oldfashionpound.model;

public class OFPoundResult {

    private OFPound ofPound;
    private int resto;

    public OFPoundResult(OFPound ofPound,int resto){
        this.ofPound=ofPound;
        this.resto = resto;
    }

    public OFPound getOfPound() {
        return ofPound;
    }

    public void setOfPound(OFPound ofPound) {
        this.ofPound = ofPound;
    }

    public int getResto() {
        return resto;
    }

    public void setResto(int resto) {
        this.resto = resto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OFPoundResult)) return false;

        OFPoundResult that = (OFPoundResult) o;

        if (resto != that.resto) return false;
        return ofPound != null ? ofPound.equals(that.ofPound) : that.ofPound == null;
    }

    @Override
    public int hashCode() {
        int result = ofPound != null ? ofPound.hashCode() : 0;
        result = 31 * result + resto;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(ofPound.toString());
        if(resto > 0){
            res.append("\t" + "-" + resto + "a");
        }
        return res.toString();
    }
}
