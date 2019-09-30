package collectionFrwrk;

class Result {

 
    public static String findDay(int month, int day, int year) {
int m= month-2;
if(m==-1){
    m=11;
}
else if(m==0){
m=12;
}

int D=year%100;
int C=year/100;

int dayOfTheWeek = day + ((13*m-1)/5) + D + (D/4) + (C/4) - 2*C;



dayOfTheWeek = dayOfTheWeek % 7;

if(dayOfTheWeek==0){
    return "sunday";
}
else if (dayOfTheWeek==1){
    return "monday";
}
  else if (dayOfTheWeek==2){
    return "tuesday";
}else if (dayOfTheWeek==3){
    return "wednesday";
}else if (dayOfTheWeek==4){
    return "thursday";
}else if (dayOfTheWeek==5){
    return "friday";
}
    return "saturday";
  }

    public static void main(String args[]) {
    	
    	System.out.println(Result.findDay(2, 29, 2004));
    }
    
}