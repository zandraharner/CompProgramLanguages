def sub1():
  x = 1;
  def sub2():
    print(x);
  
  def sub3():
    x = 3;
    sub4(sub2);
  
  def sub4(subx):
    x = 4;
    subx();
  
  x = 1;
  sub3();

sub1();
