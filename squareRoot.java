import java.util.*;
class squareRoot{
    Scanner scanner=new Scanner(System.in);
    int n=scanner.nextInt();
    void Root(int n){
        if(n < 0){
            throw new IllegalArgumentException("Number should be greater than 0");
        }
        int i = 1;
        while(i*i <= n){
            i++;
        }
        System.out.println(i-1);
    }
    public static void main(String[] args){
        squareRoot obj = new squareRoot();
        obj.Root(obj.n);
    }
    
}
    
