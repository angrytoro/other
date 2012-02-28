package pattern.command;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MainBoardApi mainBoard = new GiGaMainBoard();
		Command command = new OpenCommand(mainBoard);
		Invoker  invoker = new Invoker();
		invoker.setCommand(command);
		invoker.execute();
	}

}
