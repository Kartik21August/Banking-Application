import java.util.Scanner;  
class BankDetails {  
	// creating properties of class and instance variable
    private String accno;  
    private String name;  
    private String acc_type;  
    private long balance;  
    Scanner sc = new Scanner(System.in);  
    //method to open new account  
    public void openAccount() {  
        System.out.print("Enter Account No: ");  
        accno = sc.next();  
        System.out.print("Enter Account type: ");  
        acc_type = sc.next();  
        System.out.print("Enter Name: ");  
        name = sc.next();  
        System.out.print("Enter Balance: ");  
        balance = sc.nextLong();  
    }  
    //method to display account details  
    public void showAccount() {  
        System.out.println("Name of account holder: " + name);  
        System.out.println("Account no.: " + accno);  
        System.out.println("Account type: " + acc_type);  
        System.out.println("Balance: " + balance);  
    }  
    //method to deposit money  
    public void deposit() {  
        long amt;  
        System.out.println("Enter the amount you want to deposit: ");  
        amt = sc.nextLong();  
        balance = balance + amt;  
    }  
    //method to withdraw money  
    public void withdrawal() {  
        long amt;  
        System.out.println("Enter the amount you want to withdraw: ");  
        amt = sc.nextLong();  
        if (balance >= amt) {  
            balance = balance - amt;  
            System.out.println("Balance after withdrawal: " + balance);  
        } else {  
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!" );  
        }  
    }  
public void computeInterest(int r, int t){
double Interest= (balance*r*t)/100;
System.out.println( " Interest =" + Interest);
}
    //method to search an account number  
    public   boolean search(String ac_no) {  
        if (accno.equals(ac_no)) {  
            showAccount();  
            return (true);  
        }  
        return (false);  
    }  
}  
public class BankingApplication {  
    public static void main(String args[]) {  
        try (Scanner sc = new Scanner(System.in)) {
            //create initial accounts  
            System.out.println("How many number of customers do you want to input? ");  
            int n = sc.nextInt(); 
            // CREATING ARRAY OF OBJECT OF CLASS
            BankDetails array[] = new BankDetails[n];  
            for (int i = 0; i < array.length; i++) {  
                array[i] = new BankDetails();  
                array[i].openAccount();  
            }  
              
            int ch;  
            do {  
                  
                System.out.println("1. Display all account details \n 2. Search by Account number\n 3. Deposit the amount \n 4. Withdraw the amount \n 5.Compute Interest \n 6.Exit ");  
                System.out.println("Enter your choice: ");  
                ch = sc.nextInt();  
                    switch (ch) {  
                        case 1:  
                            for (int i = 0; i < array.length; i++) {  
                                array[i].showAccount();  
                            }  
                            break;  
                        case 2:  
                            System.out.print("Enter account no. you want to search: ");  
                            String ac_no = sc.next();  
                            boolean found = false;  
                            for (int i = 0; i < array.length; i++) {  
                                found = array[i].search(ac_no);  
                                if (found) {  
                                    break;  
                                }  
                            }  
                            if (!found) {  
                                System.out.println("Search failed! Account doesn't exist..!!");  
                            }  
                            break;  
                        case 3:  
                            System.out.print("Enter Account no. : ");  
                            ac_no = sc.next();  
                            found = false;  
                            for (int i = 0; i < array.length; i++) {  
                                found = array[i].search(ac_no);  
                                if (found) {  
                                    array[i].deposit();  
                                    break;  
                                }  
                            }  
                            if (!found) {  
                                System.out.println("Search failed! Account doesn't exist..!!");  
                            }  
                            break;  
                        case 4:  
                            System.out.print("Enter Account No : ");  
                            ac_no = sc.next();  
                            found = false;  
                            for (int i = 0; i < array.length; i++) {  
                                found = array[i].search(ac_no);  
                                if (found) {  
                                    array[i].withdrawal();  
                                    break;  
                                }  
                            }  
                            if (!found) {  
                                System.out.println("Search failed! Account doesn't exist..!!");  
                            }  
                            break;  

                            case 5:  
                            System.out.print("Enter account no. : ");  
                            ac_no = sc.next(); 
                            System.out.print("Enter rate and Time ");
                             int r= sc.nextInt();
                             int t=sc.nextInt(); 
                            found = false;  
                            for (int i = 0; i < array.length; i++) {  
                                found = array[i].search(ac_no);  
                                if (found) {  
                                 array[i].computeInterest(r,t);
                                    break;  
                                }  
                            }  
                            if (!found) {  
                                System.out.println("Search failed! Account doesn't exist..!!");  
                            }  
                            break;  



                        case 6:  
                            System.out.println("WRONG CHOICE SELECTED !");  
                            break;  
                    }  
                }  
                while (ch != 6);
        }  
        }  
   }