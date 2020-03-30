import java.lang.Math.*;

public class Build
{
  public static void build(String[] arr)
  {
    int n = arr.length;
    int start = (int) (Math.log(n) / Math.log(2));

    double rows = Math.ceil((float) (Math.log(n) / Math.log(2)));
    double val = 2;
    double a = (float) (Math.log(n) / Math.log(2));
    //double b = a -
    double leaves = Math.ceil(((a) - start)*(Math.pow(val, start)));
    System.out.println("num rows:  " + rows);
    System.out.println("num start insert at:  " + start);
    System.out.println("num leaves:  " + leaves);

    //Tnode root = new Tnode(arr[0]);
    //Tnode l = new Tnode(arr[1], root);
    //Tnode r = new Tnode(root, arr[2]);

    for(int i = 0; i < 20; i++)
    {
      System.out.println(i+2);
    }




  }
}
