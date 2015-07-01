import com.beimin.eveapi.core.ApiAuthorization;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class GameCharacter {
  
 @Id private long charID;
  private CharacterInfo characterInfo;
  
  public GameCharacter ()
    {
    
     String   vcode = "CViRCKn7XRWC3UaVXZ0dkgl0QE7DPsypBPOZn3Y240bubHJ1ZfU4dtWC30lC6lSU";
   int  keyid = 4300877;

   
    ApiAuthorization auth = new ApiAuthorization(keyid,92113484,vcode);
      this.characterInfo = new CharacterInfo(auth);
     this.charID = this.characterInfo.getCharacterID();
    
  }
}
