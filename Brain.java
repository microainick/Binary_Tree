import java.util.*;
import java.io.*;

public class Brain
{
  public static File inputFile;
  public static final String EOF = null;
  public static BufferedReader inStream;
  public static String words = null; // for array size
  public static int wc = 0;  // for array size
  public static String s;
  public static int numLines = 0;

  public static void main(String[] args)
  {
    getFileNameAndPath();
    int arraySize = getArraySize();
    String[] allWordsArray = fillInputArray(arraySize);
    FancyString[] outputArray = fillInputArrayFancy(arraySize);
    String[] noDupesArray = alphaSort(Arrays.stream(allWordsArray).distinct().toArray(String[]::new));
    Tree myTree = new Tree();
    System.out.println("\n\n\n ");
    for (int x = 0; x < noDupesArray.length; x++)
    {
      System.out.print("\n" + noDupesArray[x]);
      for (int p = 0; p < (16 - noDupesArray[x].length()); p++)
      {
        System.out.print(" ");
      } //end for loop p
      for (int y = 0; y < outputArray.length; y++)
      {
        //int var1 = str1.compareTo( str2 );
        if (noDupesArray[x].compareTo(outputArray[y].data) == 0)
        {
          System.out.print(outputArray[y].rowNum);
          //System.out.println("hello");
          for (int q = 0; q < (6 - (String.valueOf(outputArray[y].rowNum).length()));q++)
          {
            System.out.print(" ");
          }
        } //end if
      } //end for loop y
    } //end for loop x
    System.out.println("\n\n\n ");
  } //end main

  public static void getFileNameAndPath()
  {
    String inputData = null;
    String fileName = null;
    String filePath = null;
    Scanner scanIn = new Scanner(System.in);
    System.out.println("\nPlease Enter the full absolute path of the file "
        + "\nThen, without spaces, enter ~ "
        + "Then enter the name of the file.\n"
        + "i.e.  /Users/nic/spring20/csci/tree/~le.txt\n");
    inputData = scanIn.nextLine();
    String[] inputDataArray = inputData.split("~");
    filePath = inputDataArray[0];
    fileName = inputDataArray[1];
    inputFile = new File(filePath, fileName);
    scanIn.close();
  }  // end method getFileNameAndPath()

  public static void openInputFile()
  {
    try
    {
      FileReader fileReader = new FileReader(inputFile);
      inStream = new BufferedReader(fileReader);
    }
    catch (IOException e1)
    {
      e1.printStackTrace(System.err);
      System.exit(-1);
    }
  } // end method

  public static int getArraySize()
  {
    openInputFile();
    int arraySize = 0;
    String line = "";
    String str1;
    String str2;
    try
    {
      line = inStream.readLine();
      while (line != EOF)
      {
        numLines++;
        str1 = line.replaceAll("\\p{Punct}", "");
        str2 = str1.replaceAll("  ", " ");
        String[] tLineArray = str2.split(" ");
        for (String i : tLineArray)
        {
          arraySize++;
        }
        line = inStream.readLine();
      }
    }
    catch (IOException e2)
    {
      e2.printStackTrace(System.err);
      System.exit(-1);
    }
    finally
    {
      closeInStream();
    }
    arraySize--;
    numLines--;
    return arraySize;
  }

  public static String[] fillInputArray(int size)
  {
    openInputFile();
    String[] myArray = new String[size];
    String line = "";
    String str1;
    String str2;
    try
    {
      line = inStream.readLine();
      for(int x = 0; x < size;)
      {
          str1 = line.replaceAll("\\p{Punct}", "");
          str2 = str1.replaceAll("  ", " ");
          String[] tLineArray = str2.split(" ");
          if (tLineArray[0].length() > 10)
          {
            myArray[x] = tLineArray[0].substring(0, 10);
          }
          else
          {
            myArray[x] = tLineArray[0];
          }
          x++;
          for (int i = 1; i < tLineArray.length; i++)
          {
            if (tLineArray[i].length() > 10)
            {
              myArray[x] = tLineArray[i].substring(0, 10);
              x++;
            }
            else
            {
              myArray[x] = tLineArray[i];
              x++;
            }
          }// end for i
        line = inStream.readLine();
      } // end for loop x
    } //end try
    catch (IOException e2)
    {
      e2.printStackTrace(System.err);
      System.exit(-1);
    }
    finally
    {
      closeInStream();
    }
    return myArray;
  } //end method

  public static void closeInStream()
  {
    try
    {
      inStream.close();
    }
    catch (IOException e3)
    {
      e3.printStackTrace(System.err);
      System.exit(-1);
    }
  } // end close method

  public static String[] alphaSort(String[] strArray)
  {
    String temp;
    int count = strArray.length;
    for (int i = 0; i < count; i++)
    {
        for (int j = i + 1; j < count; j++)
        {
            if (strArray[i].compareTo(strArray[j]) > 0)
            {
                temp = strArray[i];
                strArray[i] = strArray[j];
                strArray[j] = temp;
            } //end if
        } //end for j
    } //end for i
    return strArray;
  } //end method sort alphabetically

  public static FancyString[] fillInputArrayFancy(int size)
  {
    openInputFile();
    FancyString[] myArray = new FancyString[size];
    String line = "";
    String str1;
    String str2;
    try
    {
      line = inStream.readLine();
      int counter = 0;
      for(int x = 0; x < size;)
      {
          counter++;
          str1 = line.replaceAll("\\p{Punct}", "");
          str2 = str1.replaceAll("  ", " ");
          String[] tLineArray = str2.split(" ");
          if (tLineArray[0].length() > 10)
          {
            FancyString temp1 = new FancyString(tLineArray[0].substring(0, 10), counter);
            myArray[x] = temp1;
          }
          else
          {
            FancyString temp2 = new FancyString(tLineArray[0], counter);
            myArray[x] = temp2;
          }
          x++;
          for (int i = 1; i < tLineArray.length; i++)
          {
            if (tLineArray[i].length() > 10)
            {
              FancyString temp3 = new FancyString(tLineArray[i].substring(0, 10), counter);
              myArray[x] = temp3;
              x++;
            }
            else
            {
              FancyString temp4 = new FancyString(tLineArray[i], counter);
              myArray[x] = temp4;
              x++;
            }
          } // end for i
          line = inStream.readLine();
      } //end for loop x
    } //end try
    catch (IOException e2)
    {
      e2.printStackTrace(System.err);
      System.exit(-1);
    }
    finally
    {
      closeInStream();
    }
    return myArray;
  } //end method
} //end class
