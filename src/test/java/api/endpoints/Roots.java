package api.endpoints;

public class Roots {
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	//User
	public static String create_user_url=base_url+"/user";
	
	public static String get_user_url=base_url+"/user/{username}";

	public static String update_user_url=base_url+"/user/{username}";

	public static String delete_user_url=base_url+"/user/{username}";


}
