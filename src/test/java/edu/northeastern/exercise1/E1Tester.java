package edu.northeastern.exercise1;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class E1Tester {
  
  /*Main method runs tests in this file*/ 
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("E1Tester");
  } 

  static ByteArrayOutputStream localOut, localErr;
  static PrintStream sysOut, sysErr;
  static String [] empty = {};

  @BeforeClass
  public static void setUp() throws Exception {
    sysOut = System.out;
    sysErr = System.err;
  }

  // Before every test is run, reset the streams to capture
  // stdout/stderr
  @Before
  public void setUpStreams() {
    localOut = new ByteArrayOutputStream();
    localErr = new ByteArrayOutputStream();
    System.setOut(new PrintStream(localOut));
    System.setErr(new PrintStream(localErr));
  }

  // After every test, restore stdout/stderr
  @After
  public void cleanUpStreams() {
    System.setOut(null);
    System.setErr(null);
    System.setOut(sysOut);
    System.setErr(sysErr);
  }

  // Determine what the newline is on the running system
  String newline = System.getProperty("line.separator");

  // Test the FirstJava class. This is a bit more complicated than usual
  // since we're sneaking a copy of the output from standard output!
  @Test public void HelloJava_main() {
    String expect = "Hello, Welcome to Java!\n";
    HelloJava.main(empty);
    String actual = localOut.toString();
    String actualNewline = actual.replaceAll("\\r?\\n","\n"); // Eliminate windows linebreaks
    String msg = String.format("Output mismatch\nEXPECTED:\n%s\nACTUAL:\n%s\n",expect,actual);
    assertTrue(msg,expect.equals(actualNewline));
  }

  // Test the  CSQuotes class. This is a bit more complicated than usual
  // since we're sneaking a copy of the output from standard output!
  @Test public void Quadratic_main() {
    String expect =	"The two roots are: -1.5 and -0.5\n";

    Quadratic.main(empty);
    String actual = localOut.toString();
    String actualNewline = actual.replaceAll("\\r?\\n","\n"); // Eliminate windows linebreaks
    String msg = String.format("Output mismatch\nEXPECTED:\n%s\nACTUAL:\n%s\n",expect,actual);
    assertTrue(msg,expect.equals(actualNewline));
  }
}