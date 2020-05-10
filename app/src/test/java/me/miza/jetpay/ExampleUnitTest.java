package me.miza.jetpay;

import org.junit.Test;

import java.util.ArrayList;
import java.util.regex.Pattern;

import me.miza.jetpay.model.Bundle;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test public void calculateDiscount() {
        double constant = 0.2;
        ArrayList<Bundle> packages = new ArrayList<>();
        packages.add(new Bundle(25,3,null,0));
        packages.add(new Bundle(45,5,null,0));
        packages.add(new Bundle(100,10,null,0));
        packages.add(new Bundle(200,15, null,0));
        packages.add(new Bundle(500,35, null,0));
        for (Bundle pkg :packages) {
            System.out.println(pkg.amount*constant-pkg.cost);
        }
    }

    @Test public void extractString() {
        String res = "45 0921315122";
        String[] split = res.split("\\s+");
        System.out.println(split[0]);
        System.out.println(split[1]);


    }
}