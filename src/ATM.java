
import java.util.HashMap;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args){
        ATMop obj = new ATMop();
    }
}
class data{
    float balance;
}

class ATMop{
    // float balance;
    Scanner sc = new Scanner(System.in);
    HashMap<Integer , data > map  =  new HashMap<>();
     ATMop(){
        System.out.println("Welcome to ATM");
        op();
    }


    public void op() {
        System.out.println("Enter your pin");
        int pincode = sc.nextInt();

        if (map.containsKey(pincode) == true) {
            data obj = map.get(pincode);
            menu(obj);
        }
        else{
            System.out.println("Account did'nt exist");
            System.out.println("Create your pin code");
            int pin = sc.nextInt();
            data obj = new data();
            map.put(pin, obj);
            op();
        }
    }
    public void menu(data obj){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter valid number");
        System.out.println("1. Check balance");
        System.out.println("2. Deposit balance");
        System.out.println("3. Withdraw money");
        System.out.println("4. Check another account");
        System.out.println("4. Exit");

        int x = sc.nextInt();

        if(x == 1){
            check_balance(obj);
        }
        else if(x == 2){
            deposit(obj);
        }
        else if(x == 3){
            withdraw(obj);
        }
        else if(x==4){
            op();
        }
        else if( x== 5){
            System.out.println("Thank you");
        }
        else {
            System.out.println("Enter valid number");
            menu(obj);
        }
    }

    public void check_balance(data obj){
        System.out.println("your balance is : "+  obj.balance);
        menu(obj);
    }

    public void deposit(data obj){
        System.out.println("enter your amount");
        float a = sc.nextFloat();

        obj.balance = obj.balance + a ;
        System.out.println("amount deposit successfully");
        menu(obj);
    }

    public void withdraw(data obj){
        System.out.println("enter your amount");
        float a = sc.nextFloat();

        obj.balance = obj.balance - a ;
        menu(obj);
    }
}

