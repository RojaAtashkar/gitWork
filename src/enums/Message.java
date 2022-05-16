package enums;

public enum Message {
    INVALID_Choice("Invalid choice"), 
    SUCCESS("OK"), WRONG_CREDENTIALS("wrong credentials"),
    NON_Alfa_Numeric_Password("non alfa numeric password"),
    MISMATCH_PASSWORD("mis match passwords"),
    SHORT_PASSWORD("wrong password"),
    LONG_PASSWORD("long password"), USER_EXIST("user exist"),
    INVALID_ROLE("invalid role"), PRODUCT_EXIST("product exists");
    private String message;
    Message(String message)
    {
        this.message = message;
    }
    @Override
    public String toString(){
        return this.message;
    }


}
