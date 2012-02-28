package otherTest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlEncoding {

	public void test(){
		TestList test = new TestList();
		test.setI(10);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(URLDecoder.decode("https://login.oracle.com/pls/orasso/orasso.wwsso_app_admin.ls_login?Site2pstoreToken=v1.2~CA55CD32~1C07C87702C70DFA32AD358128C595CD8B6F2DA1342923CDC9A5008B9FAFBCD0A205AF72A67E026AD43CB086003EFBEDC90A73EE748417E43153F71330305CD09D129422BBB620102622F5D9B30AB5267CEB10B419C720BFF43CB8AD53AD84C3E4779833D6F3C08E7557A9EEFEB3CBBB9DDAFF96B0EA0B8773F92490C0A1FFA03F48C56E43082DA2D9D7D7E0E3A527F0A1B7A8219BEC6A6338F9DB98A5B4A1EC05485FA173B041A4D29B31EA7BCE39D3266FB408E6A609B3E23BE0CDAF097EBA7386FEA43FECA296240375103D9DC974B8CA68D4D0B148C8CEA73E514C1B0278409EB9BCC3598CC33DE609F62BF67A76","UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(URLEncoder.encode("http://download.oracle.com/otn/linux/oracle11g/R2/linux_11gR2_database_1of2.zip"));
	}

}
