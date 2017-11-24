package acamb.exercise.oldfashionpound.bl;

import acamb.exercise.oldfashionpound.model.OFPound;
import acamb.exercise.oldfashionpound.model.OFPoundResult;

public class OFPoundOperations {

    public static OFPoundResult somma(OFPound a, OFPound b){
        OFPoundResult result = new OFPoundResult(
                new OFPound(a.getSterline()+b.getSterline(),
                        a.getScellini()+b.getScellini(),
                        a.getPence()+b.getPence()),
                0);
        applyOldFashionRules(result.getOfPound());
        return result;
    }

    public static OFPoundResult sottrazione(OFPound a, OFPound b){
        OFPoundResult result = new OFPoundResult(
                new OFPound(a.getSterline()-b.getSterline(),
                        a.getScellini()-b.getScellini(),
                        a.getPence()-b.getPence()),
                0);
        applyOldFashionRules(result.getOfPound());
        return result;
    }

    public static OFPoundResult moltiplicazione(OFPound a, int multiply){
        OFPoundResult result = new OFPoundResult(
                new OFPound(a.getSterline() * multiply,
                        a.getScellini() * multiply,
                        a.getPence() * multiply),
                0);
        applyOldFashionRules(result.getOfPound());
        return result;
    }

    public static OFPoundResult divisione(OFPound a, int divider){
        long pennyTot = a.getPence()+a.getScellini()*12+a.getSterline()*20*12;
        int resto = (int)pennyTot % divider;
        pennyTot = pennyTot-resto;
        OFPoundResult result = new OFPoundResult(new OFPound(0,0,pennyTot/divider),resto);
        applyOldFashionRules(result.getOfPound());
        return result;

    }


    public static void applyOldFashionRules(OFPound a){
        if(a.getPence() > 11){
            long scellini = a.getPence() / 12;
            a.setPence(a.getPence()%12);
            a.setScellini(a.getScellini()+scellini);
        }
        if(a.getScellini() > 19){
            long sterline = a.getScellini() / 20;
            a.setScellini(a.getScellini()%20);
            a.setSterline(a.getSterline()+sterline);
        }

        while( (a.getPence() < 0 && (a.getScellini() > 0 || a.getSterline() > 0)) ||
                (a.getScellini() < 0 && a.getSterline() > 0) ) {
            if(a.getPence() < 0){
                a.setPence(a.getPence()+12);
                a.setScellini(a.getScellini()-1);
            }
            if(a.getScellini() < 0){
                a.setScellini(a.getScellini()+20);
                a.setSterline(a.getSterline()-1);
            }
        }
    }

}
