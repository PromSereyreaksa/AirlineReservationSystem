public class PaymentSystem {
    private int payment_ID;
    private double amount;
    private String status;
    private String payment_Date;

    PaymentSystem(int payment_ID, double amount, String status, String payment_Date){
        this.payment_ID = payment_ID;
        this.amount = amount;
        this.status = status;
        this.payment_Date = payment_Date;
    }
    public String Status(){
        return "";
    }
    
}
