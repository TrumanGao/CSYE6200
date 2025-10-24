package edu.northeastern.project2;

/** Example of using unit tests for this assignment.  To run them on the command line, make
 * sure that the junit-cs211.jar is in the same directory.  
 * 
 * On Mac/Linux:
 *  javac -cp .:junit-cs211.jar *.java         # compile everything
 *  java -cp .:junit-cs211.jar P2Tester        # run tests
 * 
 * On windows replace colons with semicolons: (: with ;)
 *  demo$ javac -cp .;junit-cs211.jar *.java   # compile everything
 *  demo$ java -cp .;junit-cs211.jar P2Tester  # run tests
 */
import org.junit.*;
import static org.junit.Assert.*;

import java.time.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

  
public class P2Tester {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("P2Tester");
  }

  // ***** class Payment tests **********************************

  @Test public void test_payment1() {
    Payment p = new Payment("0000111122223333", "George Mason", 1, 2022);
    assertEquals("incorrect card number", "0000111122223333", p.getCardNo());
    assertEquals("incorrect card holder", "George Mason", p.getName());
    assertEquals("incorrect exp month", 1, p.getExpMonth());
    assertEquals("incorrect exp year", 2022, p.getExpYear());
    assertEquals("incorrect payment string", "#0000111122223333 (George Mason), exp 1/2022", p.toString());
  }
  
  @Test public void test_payment2() {
    Payment p = new Payment("4444555566667777", "Alan Turing", 2, 2023);
    assertEquals("incorrect card number", "4444555566667777", p.getCardNo());
    assertEquals("incorrect card holder", "Alan Turing", p.getName());
    assertEquals("incorrect exp month", 2, p.getExpMonth());
    assertEquals("incorrect exp year", 2023, p.getExpYear());
    assertEquals("incorrect payment string", "#4444555566667777 (Alan Turing), exp 2/2023", p.toString());
  }
  
  @Test public void test_payment3() {
    Payment p = new Payment("8888999900001111", "Grace Hopper", 3, 2024);
    assertEquals("incorrect card number", "8888999900001111", p.getCardNo());
    assertEquals("incorrect card holder", "Grace Hopper", p.getName());
    assertEquals("incorrect exp month", 3, p.getExpMonth());
    assertEquals("incorrect exp year", 2024, p.getExpYear());
    assertEquals("incorrect payment string", "#8888999900001111 (Grace Hopper), exp 3/2024", p.toString());
  }

  // ***** class Media tests **********************************

  @Test public void test_media1() {
    Media m = new Media("The Imitation Game", 2014);
    assertEquals("incorrect media name", "The Imitation Game", m.getName());
    assertEquals("incorrect publication year", 2014, m.getYear());
    assertEquals("incorrect media string", "The Imitation Game (2014)", m.toString());
  }

  @Test public void test_media2() {
    Media m = new Media("The Theory of Everything", 2014);
    assertEquals("incorrect media name", "The Theory of Everything", m.getName());
    assertEquals("incorrect publication year", 2014, m.getYear());
    assertEquals("incorrect media string", "The Theory of Everything (2014)", m.toString());
  }
  
  @Test public void test_media_equals() {
    Media m1 = new Media("The Imitation Game", 2014);
    Media m2 = new Media("The Imitation Game", 2014);
    Media m3 = new Media("The Imitation Game", 2015);
    Media m4 = new Media("The Theory of Everything", 2014);
    
    assertTrue("identical media objects should be equal", m1.equals(m1));
    assertTrue("media objects with the same contents should be equal", m1.equals(m2));
    assertFalse("media objects with the same name but different year should be unequal", m1.equals(m3));
    assertFalse("media objects with different names but same year should be unequal", m1.equals(m4));
 
    assertEquals("media objects with the same name should have the same hash code", m1.hashCode(), m2.hashCode());
    assertEquals("media objects with the same name should have the same hash code", m1.hashCode(), m3.hashCode());
  }

  // ***** class Video tests **********************************

  @Test public void test_video_inherits() {
    Object o = new Video("test", 2019, 100, "test", 0);
    assertTrue("a Video must be Media", o instanceof Media);
    Media m = (Media)o;
    assertEquals("incorrectly initialized base class name", "test", m.getName());
    assertEquals("incorrectly initialized base class year", 2019, m.getYear());
  }
  
  @Test public void test_video1() {
    Video v = new Video("The Imitation Game", 2014, 114, "PG-13", Video.DVD);
    assertEquals("incorrect video rating", "PG-13", v.getRating());
    assertEquals("incorrect video runtime", 114, v.getRuntime());
    assertEquals("incorrect video format", 0, v.getFormat());
    assertEquals("incorrect video string", "The Imitation Game (2014) DVD [PG-13, 114 min]", v.toString());
  }

  @Test public void test_video2() {
    Video v = new Video("The Theory of Everything", 2014, 124, "PG13", Video.BLURAY);
    assertEquals("incorrect video rating", "PG13", v.getRating());
    assertEquals("incorrect video runtime", 124, v.getRuntime());
    assertEquals("incorrect video format", 1, v.getFormat());
    assertEquals("incorrect video string", "The Theory of Everything (2014) BLURAY [PG13, 124 min]", v.toString());
  }

  // ***** class Game tests **********************************

  @Test public void test_game_inherits() {
    Object o = new Game("test", 2000, "test", "test", 0, false);
    assertTrue("a Game must be Media", o instanceof Media);
    Media m = (Media)o;
    assertEquals("incorrectly initialized base class name", "test", m.getName());
    assertEquals("incorrectly initialized base class year", 2000, m.getYear());
  }
  
  @Test public void test_game1() {
    Game g = new Game("Pong", 1972, "Atari", "E", 1, false);
    assertEquals("incorrect game platform", "Atari", g.getPlatform());
    assertEquals("incorrect game rating", "E", g.getRating());
    assertEquals("incorrect number of discs", 1, g.getDiscs());
    assertFalse("incorrectly reported as online", g.isOnline());
    assertEquals("incorrect game string", "Pong (1972) Atari [E, 1 discs]", g.toString());
  }

  @Test public void test_game2() {
    Game g = new Game("XPilot", 1992, "Unix", "Everyone", 0, true);
    assertEquals("incorrect game platform", "Unix", g.getPlatform());
    assertEquals("incorrect game rating", "Everyone", g.getRating());
    assertEquals("incorrect number of discs", 0, g.getDiscs());
    assertTrue("incorrectly reported as not online", g.isOnline());
    assertEquals("incorrect game string", "XPilot (1992) Unix [Everyone, 0 discs, online]", g.toString());
  }
  
  // ***** class Rental tests **********************************
  
  @Test public void test_rental1() {
    Media m = new Media("test", 2000);
    Payment p = new Payment("test", "test", 1, 2000);
    LocalDate d = LocalDate.of(2019,9,15);
    LocalDate d2 = LocalDate.of(2019,9,20);
    LocalDate d3 = LocalDate.of(2019,10,10);
    double f = 1.00;
    Rental r = new Rental(m, p, d, f);
    assertSame("incorrect rental media", m, r.getMedia());
    assertSame("incorrect payment info", p, r.getPayment());
    assertEquals("incorrect rental date", d, r.getRentDate());
    assertEquals("incorrect rental fee", f, r.getFee(), 0.001);
    assertEquals("incorrect total rental fee", f, r.getTotalFee(d), 0.001);
    assertEquals("incorrect total rental fee", f, r.getTotalFee(d2), 0.001);
    assertTrue("rental is initially rented out", r.isRented());
    assertEquals("incorrect rental string", "test (2000), rented on 2019-09-15 using #test (test), exp 1/2000", r.toString());
    
    assertEquals("incorrect days rented from 2019-09-15 to 2019-09-15", 0, r.daysRented(d));
    assertEquals("incorrect days rented from 2019-09-15 to 2019-09-20", 5, r.daysRented(d2));
    assertEquals("incorrect days rented from 2019-09-15 to 2019-10-10", 25, r.daysRented(d3));

    assertEquals("incorrect fee at dropoff", 1.00, r.dropoff(d2), 0.001);
    assertEquals("incorrect days rented after dropoff, 2019-09-15 to 2019-09-20", 5, r.daysRented(d2));
    assertEquals("incorrect days rented after 2019-09-20 dropoff, from 2019-09-15 to 2019-10-10", 5, r.daysRented(d3));

    assertEquals("incorrect fee after dropoff, 2019-09-15 to 2019-09-20", 1.00, r.getTotalFee(d2), 0.001);
    assertEquals("incorrect days rented after 2019-09-20 dropoff, from 2019-09-15 to 2019-10-10", 1.00, r.getTotalFee(d3), 0.001);    
  }
  
  @Test public void test_rental2() {
    Media m = new Video("The Imitation Game", 2014, 114, "PG-13", Video.DVD);
    Payment p = new Payment("0000111122223333", "George Mason", 10, 2025);
    LocalDate d = LocalDate.of(2019,9,16);
    LocalDate d2 = LocalDate.of(2019,9,21);
    LocalDate d3 = LocalDate.of(2019,10,5);
    double f = 1.50;
    Rental r = new Rental(m, p, d, f);
    assertSame("incorrect rental media", m, r.getMedia());
    assertSame("incorrect payment info", p, r.getPayment());
    assertEquals("incorrect rental date", d, r.getRentDate());
    assertEquals("incorrect rental fee", f, r.getFee(), 0.001);
    assertEquals("incorrect total rental fee", f, r.getTotalFee(d), 0.001);
    assertEquals("incorrect total rental fee", f, r.getTotalFee(d2), 0.001);
    assertTrue("rental is initially rented out", r.isRented());
    assertEquals("incorrect rental string", "The Imitation Game (2014) DVD [PG-13, 114 min], rented on 2019-09-16 using #0000111122223333 (George Mason), exp 10/2025", r.toString());
    
    assertEquals("incorrect days rented from 2019-09-16 to 2019-09-16", 0, r.daysRented(d));
    assertEquals("incorrect days rented from 2019-09-16 to 2019-09-21", 5, r.daysRented(d2));
    assertEquals("incorrect days rented from 2019-09-16 to 2019-10-05", 19, r.daysRented(d3));

    assertEquals("incorrect fee at dropoff", f, r.dropoff(d2), 0.001);
    assertEquals("incorrect days rented after dropoff, 2019-09-16 to 2019-09-21", 5, r.daysRented(d2));
    assertEquals("incorrect days rented after 2019-09-21 dropoff, from 2019-09-16 to 2019-10-05", 5, r.daysRented(d3));

    assertEquals("incorrect fee after dropoff, 2019-09-16 to 2019-09-21", f, r.getTotalFee(d2), 0.001);
    assertEquals("incorrect days rented after 2019-09-21 dropoff, from 2019-09-16 to 2019-10-05", f, r.getTotalFee(d3), 0.001);
  }

  // ***** class DailyRental tests **********************************
  
  @Test public void test_dailyrental_inherits() {
    Media m = new Media("test", 2000);
    Payment p = new Payment("test", "test", 1, 2000);
    LocalDate d = LocalDate.of(2019,9,15);
    Object o = new DailyRental(m, p, d, 1.0);
    assertTrue("a DailyRental must be a Rental", o instanceof Rental);
  }
  
  @Test public void test_dailyrental1() {
    Media m = new Media("test", 2000);
    Payment p = new Payment("test", "test", 1, 2000);
    LocalDate d = LocalDate.of(2019,9,15);
    LocalDate d2 = LocalDate.of(2019,9,20);
    LocalDate d3 = LocalDate.of(2019,10,10);
    double f = 1.00;
    double c = 0.00;
    DailyRental r = new DailyRental(m, p, d, f);
    assertEquals("incorrect rental credit", c, r.getCredit(), 0.001);
    assertEquals("incorrect total rental fee at rental", f, r.getTotalFee(d), 0.001);
    assertEquals("incorrect total rental fee after 5 days", 5*f, r.getTotalFee(d2), 0.001);
    
    assertEquals("incorrect fee at 5-day dropoff", 5*f, r.dropoff(d2), 0.001);

    assertEquals("incorrect fee after 5-day dropoff", 5*f, r.getTotalFee(d2), 0.001);
    assertEquals("incorrect fee after 5-day dropoff, 20 days total", 5*f, r.getTotalFee(d3), 0.001);    
  }
  
  @Test public void test_dailyrental2() {
    Media m = new Video("The Imitation Game", 2014, 114, "PG-13", Video.DVD);
    Payment p = new Payment("0000111122223333", "George Mason", 10, 2025);
    LocalDate[] dates = { LocalDate.of(2019,9,30), LocalDate.of(2019,10,1),
      LocalDate.of(2019,10,2), LocalDate.of(2019,10,3),
      LocalDate.of(2019,10,4), LocalDate.of(2019,10,5),
      LocalDate.of(2019,10,6), LocalDate.of(2019,10,7) };
    LocalDate d = dates[0];
    LocalDate d2 = dates[6];
    double f = 1.50;
    double c = 2.00;
    DailyRental r = new DailyRental(m, p, d, f, c);
    assertEquals("incorrect rental credit", c, r.getCredit(), 0.001);
    assertEquals("incorrect total rental fee at rental", 0.00, r.getTotalFee(d), 0.001);
    for (int i = 2;  i < dates.length;  i++) {
      String errMsg = String.format("incorrect total rental fee after %d days", i);
      assertEquals(errMsg, i*f-c, r.getTotalFee(dates[i]), 0.001);
    }
    
    assertEquals("incorrect fee at 6-day dropoff", 6*f-c, r.dropoff(d2), 0.001);

    assertEquals("incorrect fee after 6-day dropoff", 6*f-c, r.getTotalFee(d2), 0.001);
    assertEquals("incorrect fee after 6-day dropoff, 7 days total", 6*f-c, r.getTotalFee(dates[7]), 0.001);    
  }
  
  // ***** class RentalBox tests **********************************
  
  @Test public void test_rentalbox_capacity() {
    RentalBox rb = new RentalBox();
    assertEquals("incorrect default rental unit capacity", 100, rb.boxCapacity());
    rb = new RentalBox(5);
    assertEquals("incorrectly initialized rental unit capacity", 5, rb.boxCapacity());
    Media m = new Media("test", 2000);
    for (int i = 0; i < 5;  i++) {
      assertTrue("unable to place media into unit with capacity remaining: attempt " + (i+1), rb.put(m));
    }
    assertFalse("insertion succeeded when over capacity", rb.put(m));
  }
  
  @Test public void test_rentalbox_contents() {
    RentalBox rb = new RentalBox(5);
    String errMsg;
    for (int i = 0;  i < 5;  i++) {
      assertNull("rental unit should initially be empty", rb.get(i));
      Media m = new Media("test", i);
      rb.put(m);
    }
    for (int i = 0; i < 5; i++) {
      errMsg = String.format("media %d should be in stock", i);
      assertTrue(errMsg, rb.inStock(new Media("test", i)));
      errMsg = String.format("incorrect media in slot %d", i);
      assertEquals(errMsg, new Media("test", i), rb.get(i));
    }
    assertFalse("non-existent media should not be in stock", rb.inStock(new Media("test", 10)));
  }
  
  @Test public void test_rentalbox_dailyfee() {
    Video dvd = new Video("test", 2000, 100, "test", Video.DVD);
    Video bluray = new Video("test", 2000, 100, "test", Video.BLURAY);
    Game g = new Game("test", 2000, "test", "test", 1, false);
    RentalBox rb = new RentalBox();
    
    assertEquals("incorrect rental fee for DVDs", 1.50, rb.getDailyFee(dvd), 0.001);
    assertEquals("incorrect rental fee for Blurays", 2.00, rb.getDailyFee(bluray), 0.001);
    assertEquals("incorrect rental fee for video games", 3.00, rb.getDailyFee(g), 0.001);
  }
  
  @Test public void test_rentalbox_processpayment() {
    Payment p = new Payment("1111222233334444", "test", 11, 2222);
    double a = 1.23;
    setCapture();
    new RentalBox(1).processPayment(p, a);
    String actual = getCapture();
    unsetCapture();
    String expected = "$1.23 paid by #1111222233334444 (test), exp 11/2222\n";
    assertEquals("incorrect payment processing notification", expected, actual);
  }

  private final String boxcontents = ""
    + "The Imitation Game (2014) DVD [PG-13, 114 min]\n"
    + "The Imitation Game (2014) DVD [PG-13, 114 min]\n"
    + "The Imitation Game (2014) DVD [PG-13, 114 min]\n"
    + "The Imitation Game (2014) BLURAY [PG-13, 114 min]\n"
    + "The Imitation Game (2014) BLURAY [PG-13, 114 min]\n"
    + "The Theory of Everything (2014) DVD [PG-13, 124 min]\n"
    + "The Theory of Everything (2014) DVD [PG-13, 124 min]\n"
    + "Pong (1972) Atari [E, 1 discs]\n"
    ;
  
  @Test public void test_rentalbox_tostring1() {
    Media m1 = new Video("The Imitation Game", 2014, 114, "PG-13", Video.DVD); 
    Media m2 = new Video("The Imitation Game", 2014, 114, "PG-13", Video.BLURAY); 
    Media m3 = new Video("The Theory of Everything", 2014, 124, "PG-13", Video.DVD); 
    Media m4 = new Game("Pong", 1972, "Atari", "E", 1, false);
    RentalBox rb = new RentalBox(10);
    for (int i = 0;  i<3;  i++) rb.put(m1);
    for (int i = 0;  i<2;  i++) rb.put(m2);
    for (int i = 0;  i<2;  i++) rb.put(m3);
    for (int i = 0;  i<1;  i++) rb.put(m4);
    assertEquals("incorrect rental unit contents", boxcontents, rb.toString());
  }
  
  @Test public void test_rentalbox_tostring2() {
    Media m1 = new Video("The Imitation Game", 2014, 114, "PG-13", Video.DVD); 
    Media m2 = new Video("The Imitation Game", 2014, 114, "PG-13", Video.BLURAY); 
    Media m3 = new Video("The Theory of Everything", 2014, 124, "PG-13", Video.DVD); 
    Media m4 = new Game("Pong", 1972, "Atari", "E", 1, false);
    RentalBox rb = new RentalBox(10);
    for (int i = 0;  i<3;  i++) rb.put(m1);
    for (int i = 0;  i<2;  i++) rb.put(m2);
    for (int i = 0;  i<3;  i++) rb.put(m3);
    for (int i = 0;  i<1;  i++) rb.put(m4);
    rb.rent(m3, new Payment("test","test",1,1), LocalDate.of(2019,9,9));
    assertEquals("incorrect rental unit contents", boxcontents, rb.toString());
  }
  
  @Test public void test_rentalbox_rentals() {
    RentalBox rb = new RentalBox(5);
    Media[] media = {
      new Video("The Imitation Game", 2014, 114, "PG-13", Video.DVD),
      new Video("The Imitation Game", 2014, 114, "PG-13", Video.BLURAY), 
      new Video("The Theory of Everything", 2014, 124, "PG-13", Video.DVD), 
      new Video("The Theory of Everything", 2014, 124, "PG-13", Video.BLURAY), 
      new Game("Pong", 1972, "Atari", "E", 1, false),
    };
    Payment p = new Payment("0000111122223333", "George Mason", 10, 2025);
    LocalDate d = LocalDate.of(2019,9,15);
    for (int i = 0;  i < media.length;  i++) { rb.put(media[i]); }
    
    Rental r2 = rb.rent(media[2], p, d);
    assertSame("media 2 improperly rented", media[2], r2.getMedia());
    Rental r0 = rb.rent(media[0], p, d);
    assertSame("media 0 improperly rented", media[0], r0.getMedia());
    Rental r3 = rb.rent(media[3], p, d);
    assertSame("media 3 improperly rented", media[3], r3.getMedia());
    assertNull("media found when it should be out of stock", rb.rent(media[2], p, d));
    
    LocalDate d2 = LocalDate.of(2019,9,20);
    setCapture();
    assertTrue("unable to return a film with capacity remaining", rb.dropoff(r2, d2));
    assertFalse("media should no longer be rented after dropoff", r2.isRented());
    assertFalse("should be impossible to return a rental twice", rb.dropoff(r2, d2));
    assertTrue("unable to return a film with capacity remaining", rb.dropoff(r0, d2));
    assertTrue("unable to return a film with capacity remaining", rb.dropoff(r3, d2));
    String actual = getCapture();
    String expected = ""
      + "$7.50 paid by #0000111122223333 (George Mason), exp 10/2025\n"
      + "$7.50 paid by #0000111122223333 (George Mason), exp 10/2025\n"
      + "$10.00 paid by #0000111122223333 (George Mason), exp 10/2025\n"
      ;
    unsetCapture();
    assertEquals("incorrect payment records", expected, actual);
    
    int[] newOrder = { 2, 1, 0, 3, 4 };
    for (int i = 0;  i < 5;  i++) {
      assertSame("media not in correct order after dropoff", media[newOrder[i]], rb.get(i));
    }
    
    assertFalse("should be impossible to return a rental if there is no capacity", rb.dropoff(new Rental(media[0], p, d, 1.0), d2));
  }
  
  
  
  // ***************** No further test cases below *********************
  // *********************(I/O helper methods) ************************* 
  
  static ByteArrayOutputStream localOut, localErr;
  static PrintStream sOut, sErr;

  @BeforeClass public static void setup() throws Exception {
    sOut = System.out;
    sErr = System.err;
  }
  
  @AfterClass public static void cleanup() throws Exception {
    unsetCapture();
  }
  
  private static void setCapture() {
   localOut = new ByteArrayOutputStream();
   localErr = new ByteArrayOutputStream();
   System.setOut(new PrintStream( localOut ) );
   System.setErr(new PrintStream( localErr ) );
  }

  private static String getCapture() {
   return localOut.toString().replaceAll("\\r?\\n", "\n");
  }

  private static void unsetCapture() {
   System.setOut( null );
   System.setOut( sOut );
   System.setErr( null );
   System.setErr( sErr );
  }

}