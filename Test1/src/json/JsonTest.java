package json;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class Test{
	String a;
	int b;
	public Test(String a,int b){
		this.a = a;
		this.b = b;
	}
	public String getA() {
		return a;
	}
	public int getB() {
		return b;
	}
}

public class JsonTest {

	
	/**
	 * @param args
	 * @throws JSONException 
	 */
	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub

		ArrayList<Test> list = new ArrayList<Test>();
		list.add(new Test("abc",1));
		list.add(new Test("def",2));
		JSONObject json = new JSONObject();
//		json.put("abc", 123);
//		json.put("a","asdf");
		json.put("list", list);
		System.out.println(((Test)((JSONArray)json.get("list")).get(0)).a);
		
//		JSONTokener tokener = new JSONTokener("adfdsd");
//		System.out.println(tokener.next('a'));
//		System.out.println(tokener.nextClean());
//		System.out.println(tokener.nextValue());
		
//		System.out.println(tokener.nextString('s'));
//		System.out.println(tokener.next('d'));
	}

}
