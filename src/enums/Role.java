package enums;

public enum Role {
    CEO,
    MANAGEMENT,
    ACCOUNTANT,
    SIMPLE;
    public static Role getRoleFromString(String role){
        switch (role){
            case "ceo":
                return CEO;
            case "management":
                return MANAGEMENT;
            case "accountantT":
                return ACCOUNTANT;
            case "simple":
                return SIMPLE;
            default:
                return null;
        }
    }
}
