import java.util.List;

import io.restassured.path.json.JsonPath;

public class ValidateTeamData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js = new JsonPath(Payload.teamRCBPlayer());
		
		int count = js.getInt("player.size()");
		System.out.println(count);
		
//		String countryName =  js.getString("player[0].country");
//		System.out.println(countryName);
//		
//		String playerName= js.getString("player[1].name");
//		System.out.println(playerName);
		String countryName = null;
		for(int i=0;i<count;i++)
		{
			countryName =  js.getString("player["+i+"].country");
			System.out.println(countryName);
			
		}

	}

}
