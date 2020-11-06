function main(){
  var dayName = function() {
    var names = ["Sunday", "Monday", "Tuesday", "Wednesday",
                 "Thursday", "Friday", "Saturday"];
    return {
      getDay: function(number) {
          curname = names[number];
           // <------- 1 
          return curname;
      },
      setDay: function(number, newName) {
          names[number] = newName;
          // <-------- 2
      }
    };
  }();

  console.log(dayName.getDay(3)); // prints "Wednesday"
  dayName.setDay(3, "Mercredi");
  console.log(dayName.getDay(3)); // prints "Mercredi"
}
main()
