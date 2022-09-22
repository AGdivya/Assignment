import io.restassured.path.json.JsonPath;

import org.testng.Assert;

public class ValidatePlayerDetails {

	public static void main(String[] args) {
		
		int indianPlayerCount = 0;
		int foreignPlayerCount = 0;
		int wicketKeeperCount = 0;

		JsonPath js = new JsonPath(Payload.teamRCBPlayer());

		// finding and printing total number of players
		int count = js.getInt("player.size()");
		System.out.println("Total number of players are: " + count);

		for (int i = 0; i < count; i++) {
			String countryName = js.getString("player[" + i + "].country");
			if (countryName.equalsIgnoreCase("India")) {
				indianPlayerCount++;
			} else {
				foreignPlayerCount++;
			}
			String role = js.getString("player[" + i + "].role");
			if (role.equalsIgnoreCase("Wicket-keeper")) {
				wicketKeeperCount++;
			}

		}
		System.out.println("Total number of Indian Players: " + indianPlayerCount);
		System.out.println("Total number of Foreign Players: " + foreignPlayerCount);
		System.out.println("Total number of WicketKeeper: " + wicketKeeperCount);

		// validates that team has atleast 1 Wicket-keeper
		Assert.assertTrue(wicketKeeperCount >= 1, "Validation failed for wicket keeper count");

		// validates that team has only 4 foreign player
		Assert.assertEquals(foreignPlayerCount, 4, "Validation failed for foreign player");

	}

}
