//---TEMPLATE--
abstract class TemplateUser{
	String name;

	TemplateUser(String name){
		this.name = name;
	}

	abstract String prompt();
	abstract boolean check(String input);

	void authenticate(){
		boolean res = check(prompt());

		if(res){
			System.out.println(this.name + " successfully authenticated!");
		}
		else{
			System.out.println(this.name + " authentication failed");
		}
	}
}

class PasswordTemplateUser extends TemplateUser{
	PasswordTemplateUser(String name){
		super(name);
	}
	String prompt() {
		String pass = "";
		System.out.println("Enter Password");
		return pass;
	}
	boolean check(String pass){
		return true;
	}
}

class OTPTemplateUser extends TemplateUser{
	OTPTemplateUser(String name){
		super(name);
	}

	String prompt() {
		String otp = "";
		System.out.println("Enter OTP");
		return otp;
	}
	boolean check(String otp){
		return true;
	}
}

//---STRATEGY---
class StrategyUser{
	String name;
	Strategy strategy;

	StrategyUser(String name, Strategy strategy){
		this.name = name;
		this.strategy = strategy;
	}

	void authenticate(){
		boolean res = strategy.check(strategy.prompt());

		if(res){
			System.out.println(this.name + " successfully authenticated! - Using Strategy");
		}
		else{
			System.out.println(this.name + " authentication failed - Using Strategy");
		}
	}
}

abstract class Strategy{
	Strategy(){
	}

	abstract String prompt();
	abstract boolean check(String input);
}

class PasswordStrategy extends Strategy{

	PasswordStrategy(){
	}

	String prompt() {
		String pass = "";
		System.out.println("Enter Password");
		return pass;
	}
	boolean check(String pass){
		return true;
	}
}

class OTPStrategy extends Strategy{
	OTPStrategy(){
	}

	String prompt() {
		String otp = "";
		System.out.println("Enter OTP");
		return otp;
	}
	boolean check(String otp){
		return true;
	}
}


public class TemplateStrategyTest{

	public static void main(String[] args)
	{
		TemplateUser ptUser = new PasswordTemplateUser("ptuser1");
		ptUser.authenticate();

		TemplateUser otpUser = new OTPTemplateUser("otpuser1");
		otpUser.authenticate();

		PasswordStrategy pwStrategy = new PasswordStrategy();
		OTPStrategy otpStrategy = new OTPStrategy();

		StrategyUser stpwUser = new StrategyUser("stuser1", pwStrategy);
		stpwUser.authenticate();

		StrategyUser stotpUser = new StrategyUser("otpuser1", otpStrategy);
		stotpUser.authenticate();
	}
}
		