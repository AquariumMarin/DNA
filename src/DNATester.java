//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: DNATester.java
///////////////////////////////////////////////////////////////////////////////

import java.util.NoSuchElementException;

/**
 * Test methods to verify your implementation of the methods for P08.
 *
 */
public class DNATester {

  /**
   * test add and removing things from your queue(hint:useits toString method)
   * 
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testEnqueueDequeue() {

    try {

      // verify my LinkedQueue implementation directly
      LinkedQueue<String> newQueue = new LinkedQueue<String>();

      // set data
      newQueue.enqueue("marin");
      newQueue.enqueue("marin");

      if (!newQueue.toString().trim().equals("marin marin")) {
        return false; // incorrect
      }

      newQueue.dequeue();

      if (!newQueue.toString().trim().equals("marin")) {
        return false; // incorrect
      }

      try {

        newQueue.dequeue(); // size 0
        newQueue.dequeue(); // must throw exception

      } catch (NoSuchElementException e) {
        // correct
      }

      try {

        newQueue.peek(); // size 0, must throw exception

      } catch (NoSuchElementException e) {
        // correct
      }

    } catch (Exception e) {
      return false; // incorrect
    }

    return true;

  }

  /**
   * test the queue’s size and isEmpty methods
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testQueueSize() {

    try {
      // verify my LinkedQueue implementation directly
      LinkedQueue<String> newQueue = new LinkedQueue<String>();

      // set data
      newQueue.enqueue("marin");
      if (newQueue.size() != 1) {
        return false; // incorrect
      }

      newQueue.dequeue();
      if (newQueue.size() != 0) {
        return false; // incorrect
      }

      if (!newQueue.isEmpty()) {
        return false; // incorrect
      }
    } catch (Exception e) {
      return false;
    }

    return true;

  }

  /**
   * test the DNAclass’ mRNATranslate method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testMRNATranslate() {

    try {

      // case1
      {
        DNA testDNA = new DNA("GGA");

        if (!testDNA.transcribeDNA().toString().trim().replace(" ", "").equals("CCU")) {

          return false; // incorrect
        }

        // check mRNA translation (verify the mRNATranslate() method)
        if (!testDNA.mRNATranslate​(testDNA.transcribeDNA()).toString().trim().equals("P")) {

          System.out.println(testDNA.mRNATranslate​(testDNA.transcribeDNA()).toString().trim());
          return false; // incorrect
        }

      }

      // case2
      {
        DNA testDNA1 = new DNA("GATTACA");

        if (!testDNA1.transcribeDNA().toString().trim().replace(" ", "").equals("CUAAUGU")) {

          return false; // incorrect
        }

        // check mRNA translation (verify the mRNATranslate() method)
        if (!testDNA1.mRNATranslate​(testDNA1.transcribeDNA()).toString().trim().equals("L M")) {

          System.out.println(testDNA1.mRNATranslate​(testDNA1.transcribeDNA()).toString().trim());
          return false; // incorrect
        }

      }

      // case3
      {
        DNA testDNA2 = new DNA("CCGGCCCTCCGGTGGATCCAA");

        if (!testDNA2.transcribeDNA().toString().trim().replace(" ", "")
            .equals("GGCCGGGAGGCCACCUAGGUU")) {

          return false; // incorrect
        }

        // check mRNA translation (verify the mRNATranslate() method)
        if (!testDNA2.mRNATranslate​(testDNA2.transcribeDNA()).toString().trim()
            .equals("G R E A T")) {

          System.out.println(testDNA2.mRNATranslate​(testDNA2.transcribeDNA()).toString().trim());
          return false; // incorrect
        }

      }


    } catch (Exception e) {
      return false; // incorrect
    }

    return true;

  }

  /**
   * Tests the transcribeDNA() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testTranscribeDNA() {

    try {

      DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
      String mRNA = "CCUCAGUCAAUUCGCUGGCCCUGUAUGACAGAACCAUUAGAGGCUCGAUCUUUCAGAGAC";
      System.out.println(testDNA.transcribeDNA().toString());

      if (!testDNA.transcribeDNA().toString().trim().replaceAll(" ", "").equals(mRNA)) {
        return false;
      }
    } catch (Exception e) {
      return false; // incorrect
    }

    return true;

  }

  /**
   * Tests the translateDNA() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testTranslateDNA() {

    try {

      DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
      System.out.println(testDNA.translateDNA().toString());
      if (!testDNA.translateDNA().toString().trim().replaceAll(" ", "")
          .equals("PQSIRWPCMTEPLEARSFRD")) {
        return false; // incorrect
      }
    } catch (Exception e) {
      return false; // incorrect
    }
    return true;
  }

  /**
   * Main method - use this to run your test methods and output the results (ungraded)
   * 
   * @param args unused
   */
  public static void main(String[] args) {
    System.out.println("transcribeDNA: " + testTranscribeDNA());
    System.out.println("translateDNA: " + testTranslateDNA());
    System.out.println(testQueueSize());
    System.out.println(testMRNATranslate());
    System.out.println(testEnqueueDequeue());

  }

}
