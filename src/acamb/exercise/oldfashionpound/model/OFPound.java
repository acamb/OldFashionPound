package acamb.exercise.oldfashionpound.model;

public class OFPound {

    private long sterline;
    private long scellini;
    private long pence;

    public OFPound(long sterline,long scellini,long pence){
        this.sterline = sterline;
        this.scellini = scellini;
        this.pence = pence;
    }

    public long getSterline() {
        return sterline;
    }

    public void setSterline(long sterline) {
        this.sterline = sterline;
    }

    public long getScellini() {
        return scellini;
    }

    public void setScellini(long scellini) {
        this.scellini = scellini;
    }

    public long getPence() {
        return pence;
    }

    public void setPence(long pence) {
        this.pence = pence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OFPound)) return false;

        OFPound ofPound = (OFPound) o;

        if (sterline != ofPound.sterline) return false;
        if (scellini != ofPound.scellini) return false;
        return pence == ofPound.pence;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(sterline + "p ");
        sb.append(scellini + "s ");
        sb.append(pence + "d");
        return sb.toString();
    }
}
