package pattern.command;

public class Invoker {

	private Command command = null;
	
	public Invoker(){
	}
	
	public Invoker(Command command){
		this.command = command;
	}
	
	public void setCommand(Command command){
		this.command = command;
	}
	
	public void execute(){
		command.execute();
	}
}
