package api.endpoints;

public class Routes {
	
	/*User	Create	POST	https://petstore.swagger.io/v2/user
User	Get	GET	https://petstore.swagger.io/v2/user/{username}
User	Update	PUT	https://petstore.swagger.io/v2/user/{username}
User	Delete	DELETE	https://petstore.swagger.io/v2/user/{username}
*/
	public static String base_url="https://petstore.swagger.io/v2";
	
	//user module urls
	public static String post_url=base_url +"/user";
	public static String get_url=base_url +"/user/{username}";
	public static String put_url=base_url +"/user/{username}";
	public static String delete_url=base_url +"/user/{username}";

}
