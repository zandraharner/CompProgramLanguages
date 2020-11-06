#include <stdio.h>

int fibonacci(int i) {
   <----------  1 
   if(i == 0) {
      return 0;
   }
	
   if(i == 1) {
      return 1;
   }
   return fibonacci(i-1) + fibonacci(i-2);
}

int  main() {
    printf("%d\t\n", fibonacci(i));
    <---------- 3
    return 0;
}
