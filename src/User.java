import java.math.BigDecimal;

public class User {
    private String name;
    private String nationality;
    private BigDecimal money = new BigDecimal("0.0");

    public User(String name, String nationality) {
	this.name = name;
	this.nationality = nationality;
    }

    public void deposit(String amount) {
	this.money = this.money.add(new BigDecimal(amount));
    }

    public void withdraw(String amount) {
	this.money = this.money.subtract(new BigDecimal(amount));
    }

    public BigDecimal getMoney(){
	return this.money;
    }

    public String getName() {
	return this.name;
    }

    public void setName(String newName) {
	this.name = newName;
    }

    public String getNationality() {
	return this.nationality;
    }

    public void setNationality(String newNationality) {
	this.nationality = newNationality;
    }
    
}

