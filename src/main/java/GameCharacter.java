import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import com.beimin.eveapi.core.ApiAuthorization;
import com.beimin.eveapi.exception.ApiException;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.beimin.eveapi.character.wallet.journal.WalletJournalParser;
import com.beimin.eveapi.shared.wallet.journal.AbstractWalletJournalParser;
import com.beimin.eveapi.shared.wallet.journal.WalletJournalResponse;
import com.beimin.eveapi.shared.wallet.journal.ApiJournalEntry;
import java.util.logging.Logger;

@Entity
public class GameCharacter {
  public static final Logger log = Logger.getLogger(GameCharacter.class.getName());
  
 @Id private long charID;
  private CharacterInfo characterInfo;
//  private ArrayList<WalletJournal> walletJournal = new ArrayList<WalletJournal>();
 // Set<Key<GameCharacter>> wj;
  
  public GameCharacter () 
    {
    
     String   vcode = "CViRCKn7XRWC3UaVXZ0dkgl0QE7DPsypBPOZn3Y240bubHJ1ZfU4dtWC30lC6lSU";
   int  keyid = 4300877;

   
    ApiAuthorization auth = new ApiAuthorization(keyid,92113484,vcode);

   //   this.characterInfo = new CharacterInfo(auth);
    
   
     this.charID = this.characterInfo.getCharacterID();
      log.info("loop done");
  
    
  }
}