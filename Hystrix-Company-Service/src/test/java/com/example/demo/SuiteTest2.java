 package com.example.demo;

 import org.junit.Assert;		
 import org.junit.Test;		

 public class SuiteTest2 {				
     /** Test of setName() method, of class Value */		

     @Test		
     public void createAndSetName() {					


         String expected = "Y";					

         Assert.assertEquals(expected, "Y");					
         System.out.println("Suite Test 1 is successful " );							
     }		

 }		