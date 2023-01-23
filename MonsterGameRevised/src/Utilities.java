public class Utilities {
    public static int generateGuessingNumber(){
        return (int) (Math.random() * (3) + 1);
    }
    public static int generateGuessingNumber(int min, int max){
        return (int) (Math.random() * (max - min + 1) + min);
    }

}
