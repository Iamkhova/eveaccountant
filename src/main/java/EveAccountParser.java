import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Set;

import javax.swing.ImageIcon;

import com.beimin.eveapi.account.accountstatus.AccountStatusParser;
import com.beimin.eveapi.account.accountstatus.EveAccountStatus;
import com.beimin.eveapi.account.apikeyinfo.ApiKeyInfoParser;
import com.beimin.eveapi.account.apikeyinfo.ApiKeyInfoResponse;
import com.beimin.eveapi.account.characters.CharactersParser;
import com.beimin.eveapi.account.characters.CharactersResponse;
import com.beimin.eveapi.account.characters.EveCharacter;
import com.beimin.eveapi.character.assetlist.AssetListParser;
import com.beimin.eveapi.character.sheet.CharacterSheetParser;
import com.beimin.eveapi.character.sheet.CharacterSheetResponse;
import com.beimin.eveapi.character.skill.intraining.SkillInTrainingParser;
import com.beimin.eveapi.character.skill.intraining.SkillInTrainingResponse;
import com.beimin.eveapi.character.skill.queue.ApiSkillQueueItem;
import com.beimin.eveapi.character.skill.queue.SkillQueueParser;
import com.beimin.eveapi.core.ApiAuthorization;
import com.beimin.eveapi.corporation.accountbalance.AccountBalanceParser;
import com.beimin.eveapi.eve.character.CharacterInfoParser;
import com.beimin.eveapi.eve.character.CharacterInfoResponse;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.shared.accountbalance.EveAccountBalance;
import com.beimin.eveapi.shared.assetlist.EveAsset;

public class EveAccountParser {
  
  protected int		keyID;
	protected String	vCode;
	
	public EveAccountParser(int keyID, String vCode) {
		this.keyID = keyID;
		this.vCode = vCode;
	}
	
	public ApiAuthorization authCreator() {
		return new ApiAuthorization(this.keyID, this.vCode);
	}
	
	public ApiAuthorization authCreator(long charID) {
		return new ApiAuthorization(this.keyID, charID, this.vCode);
	}
	
	public Collection<EveCharacter> parseCharacters() throws ApiException {
		CharactersParser parser = CharactersParser.getInstance();
		CharactersResponse response = parser.getResponse(this.authCreator());
		return response.getAll();
	}
	
	public ApiKeyInfoResponse parseAPIKey() throws ApiException {
		ApiKeyInfoParser apiKeyInfoParser = ApiKeyInfoParser.getInstance();
		return apiKeyInfoParser.getResponse(this.authCreator());
	}
	
	public EveAccountStatus parseAccountStatus() throws ApiException {
		AccountStatusParser parser = AccountStatusParser.getInstance();
		return parser.getResponse(this.authCreator()).get();
	}
	
	public Set<EveAccountBalance> parseBalance(long charID) throws ApiException {
		AccountBalanceParser parser = AccountBalanceParser.getInstance();
		return parser.getResponse(this.authCreator(charID)).getAll();
	}
	
	public CharacterInfoResponse parseCharInfo(long charID) throws ApiException {
		CharacterInfoParser parser = CharacterInfoParser.getInstance();
		return parser.getResponse(this.authCreator(charID));
	}
	
	public Set<EveAsset<EveAsset<?>>> parseAssets(long charID) throws ApiException {
		AssetListParser parser = AssetListParser.getInstance();
		return parser.getResponse(this.authCreator(charID)).getAll();
	}
	
	public SkillInTrainingResponse parseTrainingSkill(long charID) throws ApiException {
		SkillInTrainingParser parser = SkillInTrainingParser.getInstance();
		return parser.getResponse(this.authCreator(charID));
	}
	
	public CharacterSheetResponse parseCharSheet(long charID) throws ApiException {
		CharacterSheetParser parser = CharacterSheetParser.getInstance();
		return parser.getResponse(this.authCreator(charID));
	}
	
	public Set<ApiSkillQueueItem> parseQueuedSkill(long charID) throws ApiException {
		SkillQueueParser parser = SkillQueueParser.getInstance();
		return parser.getResponse(this.authCreator(charID)).getAll();
	}
	
	public ImageIcon parseCharIdPicture(EveCharacter charToGetPictureOf) {
		long charId = charToGetPictureOf.getCharacterID();
		URL url = null;
		try {
			url = new URL("https://image.eveonline.com/Character/" + charId + "_256.jpg");
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return new ImageIcon(url);
	}
	
	public ImageIcon parseCharIdPicture(EveCharacter charToGetPictureOf, int picSize) {
		long charId = charToGetPictureOf.getCharacterID();
		URL url = null;
		try {
			url = new URL("https://image.eveonline.com/Character/" + charId + "_" + picSize + ".jpg");
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return new ImageIcon(url);
	}
}
