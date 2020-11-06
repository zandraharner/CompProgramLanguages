/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <iostream>
#include <string>
using namespace std;

string myname;

string changeName(string prefix){
    myname = prefix + " " + myname;
    return myname;
}

string changeName2(string prefix){
    string newname = prefix + " " + myname;
    return newname;
}

int main() {
    myname = "Alice";
    changeName("Lady");
    cout<<myname<<endl;
    myname = "Alice";
    changeName2("Lady");
    cout<<myname<<endl;
     // Does changeName has side effect?
    for (int i=0; i<3; i++){
        myname = "Alex";
        string outputname = "oldname: " + myname + " new name: " + changeName("Dr.");
        cout<<outputname<<endl; 
    }
    // Does ChangeName2 has side effect?
    for (int i=0; i<3; i++){
        myname = "Alex";
        string outputname = "oldname: " + myname + " new name: " + changeName2("Dr.");
        cout<<outputname<<endl; 
    }
    return 0;
}
