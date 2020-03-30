public class Tnode
{
  String data;
  Tnode left;
  Tnode right;
  Tnode(String data)
  {
    this.data = data;
    this.left = null;
    this.right = null;
  }

  Tnode(String data, Tnode parent)
  {
    this.data = data;
    this.left = null;
    this.right = null;
    parent.left.data = data;
  }

  Tnode(Tnode parent, String data)
  {
    this.data = data;
    this.left = null;
    this.right = null;
    parent.right.data = data;
  }

}
