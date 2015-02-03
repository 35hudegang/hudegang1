package CompareNumber;

/**
 * Created by hu on 15-2-2.
 */
public class CompareNumber {
    /*public String show(int number1 ,int number2) {
        int[] number3=new int[4];
      int[] number4=new int[4];
        int result1=0;
        int result2=0;
        number3[3]=number1%10;
        number3[2]=number1/10%10;
        number3[1]=number1/100%10;
        number3[0]=number1/1000;
        number4[3]=number2%10;
        number4[2]=number2/10%10;
        number4[1]=number2/100%10;
        number4[0]=number2/1000;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //数字正确
                if(number3[i]==number4[j]){
                    //位置正确
                    if(i==j){
                        result2++;
                        break;
                    }
                    result1++;
                    break;
                }
            }
        }
        String result3=result2+"A"+result1+"B";
        return result3;
    }*/
   /*public String show(String input ,String answer){
        int a_count=0,b_count=0;
       for (int i = 0; i < input.length(); i++) {
           if (input.contains(String.valueOf(answer.charAt(i)))){
               b_count++;
           }
           if (answer.charAt(i)==input.charAt(i)){
               a_count++;
           }
       }


        return a_count+"A"+(b_count-a_count)+"B";
    }*/
    public String show(int number1,int number2){
        return null;
    }
}
