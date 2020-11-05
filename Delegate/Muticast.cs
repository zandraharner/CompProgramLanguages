using System;  
  
namespace Delegates  
{  
    public class Operation  
    {  
        public static void Add(int a)  
        {  
            Console.WriteLine("Addition={0}", a + 10);  
        }  
        public static void Square(int a)  
        {  
            Console.WriteLine("Multiple={0}",a * a);  
        }  
    }  
    class Program  
    {  
        delegate void DelOp(int x);  
   
        static void Main(string[] args)  
        {  
            // Delegate instantiation  
            DelOp obj = Operation.Add;  
            obj += Operation.Square;  
   
            obj(2);  
            obj(8);  
   
            Console.ReadLine();  
        }  
    }  
}  
