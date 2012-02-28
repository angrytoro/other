package pattern.command;

/**
 * 开机命令的实现，实现Command接口，
 * 持有开机命令的真正实现，通过调用接收者的方法来实现命令
 */
public class OpenCommand implements Command{

	private MainBoardApi mainBoard = null; //持有真正实现命令的接收者——主板对象
	
	// 构造方法，传入主板对象
	public OpenCommand(MainBoardApi board){
		this.mainBoard = board;
	}
	
	public void execute() {
		this.mainBoard.open();
	}

}
