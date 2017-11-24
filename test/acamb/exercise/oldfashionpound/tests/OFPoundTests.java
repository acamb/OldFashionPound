package acamb.exercise.oldfashionpound.tests;

import acamb.exercise.oldfashionpound.bl.OFPoundOperations;
import acamb.exercise.oldfashionpound.model.OFPound;
import acamb.exercise.oldfashionpound.model.OFPoundResult;
import org.junit.Assert;
import org.junit.Test;

public class OFPoundTests {

    @Test
    public void testSommaSemplice(){
        OFPound a = new OFPound(5,17,8);
        OFPound b = new OFPound(3,4,10);
        OFPoundResult expected = new OFPoundResult(new OFPound(9,2,6),0);
        Assert.assertEquals(expected, OFPoundOperations.somma(a,b));
    }

    @Test
    public void sommaCommutativa(){
        OFPound a = new OFPound(2,3,0);
        OFPound b = new OFPound(1,5,0);
        OFPoundResult expected = new OFPoundResult(new OFPound(3,8,0),0);
        Assert.assertEquals(expected, OFPoundOperations.somma(a,b));
        Assert.assertEquals(expected, OFPoundOperations.somma(b,a));
    }


    @Test
    public void fancyPoundInitializationTest(){
        OFPound a = new OFPound(3,-2,-3);
        OFPound expected = new OFPound(2,17,9);
        OFPoundOperations.applyOldFashionRules(a);
        Assert.assertEquals(expected,a);
    }

    @Test
    public void sottrazione(){
        OFPound a = new OFPound(5,17,8);
        OFPound b = new OFPound(3,4,10);
        OFPoundResult expected = new OFPoundResult(new OFPound(2,12,10),0);
        Assert.assertEquals(expected,OFPoundOperations.sottrazione(a,b));
    }


    @Test
    public void sottrazioneNegativa(){
        OFPound a = new OFPound(1,12,10);
        OFPound b = new OFPound(1,19,11);
        OFPoundResult expected = new OFPoundResult(new OFPound(0,-7,-1),0);
        Assert.assertEquals(expected,OFPoundOperations.sottrazione(a,b));
    }

    @Test
    public void moltiplicazione(){
        OFPound a = new OFPound(5,17,8);
        OFPoundResult expected = new OFPoundResult(new OFPound(11,15,4),0);
        Assert.assertEquals(expected,OFPoundOperations.moltiplicazione(a,2));
    }

    @Test
    public void divisione(){
        OFPound a = new OFPound(5,17,8);
        OFPoundResult expected = new OFPoundResult(new OFPound(1,19,2),2);
        Assert.assertEquals(expected,OFPoundOperations.divisione(a,3));
    }

    @Test
    public void outputOFPoun(){
        OFPound a = new OFPound(5,17,8);
        String expected = "5p 17s 8d";
        Assert.assertEquals(expected,a.toString());
    }

    @Test
    public void outputOFPoundResult(){
        OFPoundResult result = new OFPoundResult(new OFPound(5,17,8),2);
        String expected = "5p 17s 8d\t-2a";
        Assert.assertEquals(expected,result.toString());
    }
}
