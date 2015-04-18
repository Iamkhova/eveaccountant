
import java.util.ArrayList;

import com.beimin.eveapi.account.characters.EveCharacter;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.account.apikeyinfo.ApiKeyInfoResponse;
import com.beimin.eveapi.account.characters.CharactersParser;
import com.beimin.eveapi.account.characters.CharactersResponse;
import com.beimin.eveapi.core.ApiAuthorization;
import java.util.Iterator;
import java.util.Collection;
import java.util.logging.Logger;


public class EveApi {
  
  public static final Logger log = Logger.getLogger(EveApi.class.getName());
  
  private static ArrayList<EveApi> apiList = new ArrayList<EveApi>();
  
  private int keyid;
  private String vcode;
  private EveAccountParser accountParser;
  private String desc;
  private ArrayList<EveCharacter> selectedChars = new ArrayList<EveCharacter>();
  
  public EveApi(int keyid, String vcode, String apiDesc)  
  {
    this.keyid = keyid;
    this.vcode = vcode;
    
    try {
    CharactersParser parser = CharactersParser.getInstance();
    ApiAuthorization auth = new ApiAuthorization(keyid, vcode);
    CharactersResponse response = parser.getResponse(auth);
    Collection<EveCharacter> eveCharacters = response.getAll();
      
       Iterator itr = eveCharacters.iterator();
      while (itr.hasNext()) {
        String str = (String) itr.next();
        log.info(str);}
       
    	}
catch (ApiException e) {
        log.info("ERROR");
			e.printStackTrace();
		}
    
    /*
    
		try {
			this.selectedChars.addAll(this.accountParser.parseCharacters());
			if(this.accountParser.parseAPIKey().getError() != null)
           log.info(this.accountParser.parseAPIKey().getError() + "API ERROR");
        
			
			else log.info("Correct API entered,\n please wait for the api.eveonline.com server to respond, \n this might take a while. API Addition");
		}
		catch (ApiException e) {
        log.info("ERROR");
			e.printStackTrace();
		}
		if(this.selectedChars.size() != 0) {
			EveApi.apiList.add(this);
		//	EveAPIQueryContainer.insertInto(keyID, vCode, apiDesc);
		}
    */
  }
  
  
  
  
}
