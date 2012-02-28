public class XMail {

	public static void main(String[] args) {
		String tables = "deal_record		exchange_record		exchange_rule		opened_city		seller		seller_broadcast		seller_card		seller_card_department		seller_category		seller_category_stat		seller_company		seller_company_stat		seller_department		seller_stat		shop_comment		user		user_card		user_sms_record";
		for (String name : tables.split("		")) {
			name = name.trim();
			System.out
					.println("<table schema=\"dudcard\" tableName=\""
							+ name
							+ "\"><generatedKey column=\"id\" sqlStatement=\"SELECT LAST_INSERT_ID()\" identity=\"true\" /></table>");
		}
	}
}
