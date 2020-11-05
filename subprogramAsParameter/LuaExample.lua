function sub1()
  function sub2()
    print(x);
  end
  function sub3()
    x = 3;
    sub4(sub2);
  end
  function sub4(subx)
    x = 4;
    subx();
  end
  x = 1;
  sub3();
end

sub1();
