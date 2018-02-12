package com.example.demo;

import static org.junit.Assert.assertEquals;				

import org.junit.Test;		

public class SuiteTest1 {				



    @Test				
    public void testJUnitMessage() {					

        System.out.println("Junit Message is printing ");					

    }		

    @Test		
    public void testJUnitHiMessage() {					
        System.out.println("Junit Hi Message is printing ");					
        System.out.println("Suite Test 2 is successful ");							
    }		
}	
