public class FancyString
{
  String data;
  int rowNum;
  String rowString = "     "; //5 spaces

  FancyString()
  {
    data = null;
    rowNum = 0;
  }

  FancyString(FancyString fs, int j)
  {
    data = fs.data;
    rowNum = j;
    rowString = fs.rowString.concat(String.valueOf(j));
    rowString = rowString.concat("     "); //5 spaces
  }

  FancyString(String s, int i)
  {
    data = s;
    rowNum = i;
    rowString = rowString.concat(String.valueOf(i));
    rowString = rowString.concat("     ");  //5 spaces
  }

}
