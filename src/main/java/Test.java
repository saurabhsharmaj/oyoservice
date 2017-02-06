
public class Test {

	public static void main(String[] args) {
		String q = "{\"bool\" : {\"should\" : ["
				+ "{\"regexp\" : {\"city\" : \"*\"}}"
				+ ",{\"regexp\" : {\"state\" : \"*\"}}"
				+ ",{\"regexp\" : {\"name\" : \"*\"}"
				+ "}]}}";
		System.out.println(q);
	}

}
