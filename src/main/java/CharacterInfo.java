import com.beimin.eveapi.character.sheet.ApiAttributeEnhancer;
import com.beimin.eveapi.character.sheet.CharacterSheetParser;
import com.beimin.eveapi.character.sheet.CharacterSheetResponse;
import com.beimin.eveapi.core.ApiAuthorization;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.shared.character.EveAncestry;
import com.beimin.eveapi.shared.character.EveBloodline;
import com.beimin.eveapi.shared.character.EveRace;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import java.util.logging.Logger;
import org.joda.time.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import com.googlecode.objectify.annotation.Index;
import com.beimin.eveapi.core.AbstractContentHandler;
import static com.googlecode.objectify.ObjectifyService.ofy;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;


//@Entity
@Entity
public class CharacterInfo {
    public static final Logger log = Logger.getLogger(CharacterInfo.class.getName());

    @Id private Long               characterID;
    private String             characterName;
    private EveRace            race;
    private EveAncestry        ancestry;
    private Date               birthdate;
    private EveBloodline       bloodline;
    private String             gender;
    private double             accountBalance;
    @Index private long               corporationID;
    private String             corporationName;
    private String             allianceName;
  	 private Long allianceID;
	private int intelligence;
	private int memory;
	private int charisma;
	private int perception;
	private int willpower;
  private Set<ApiAttributeEnhancer> attributeEnhancers = new HashSet<ApiAttributeEnhancer>();

  public CharacterInfo()
    {
    
  }
  
    public void refresh(ApiAuthorization _auth) {
        // extends character bsae

        CharacterSheetParser parser = new CharacterSheetParser();
         OfyService.ofy();
        CharacterSheetResponse response;
        try {
            response = parser.getResponse(_auth);
            this.characterID = response.getCharacterID();
            this.characterName = response.getName();
            this.race = response.getRace();
            this.ancestry = response.getAncestry();
            this.birthdate = response.getDateOfBirth();
            this.bloodline = response.getBloodLine();
            this.gender = response.getGender();
            this.corporationName = response.getCorporationName();
            this.corporationID = response.getCorporationID();
            this.allianceName = response.getAllianceName();
            this.accountBalance = response.getBalance();
            this.allianceID = response.getAllianceID();
           this.intelligence = response.getIntelligence();
          this.memory = response.getMemory();
          this.charisma = response.getCharisma();
          this.perception = response.getPerception();
          this.willpower = response.getWillpower();
   
           
    ofy().save().entity(this).now();

        } catch (ApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public long getCharacterID() {
        return this.characterID;
    }

    public String getCharacterName() {
        return this.characterName;
    }

    public EveRace getRace() {
        return this.race;
    }

    public EveAncestry getAncestry() {
        return this.ancestry;
    }

    public Date birthdate() {
        return this.birthdate;
    }

    public EveBloodline getBloodline() {
        return this.bloodline;
    }

    public String getGender() {
        return this.gender;
    }

    public double getAccountBalance() {
        return this.accountBalance;
    }

    public String getCorporationName() {
        return this.corporationName;
    }

    public long getCorporationID() {
        return this.corporationID;
    }

    public String getAllianceName() {
        return this.allianceName;
    }
  
  	public Long getAllianceID() {
		return this.allianceID;
	}
  
  public int getIntelligence() {
    return this.intelligence;
  }
  
  public int getMemory() {
    return this.memory;
  }
  
  public int getCharisma() {
    return this.charisma;
  }
  
  public int getPerception() {
    return this.perception;
  }
  
  public int getWillpower() {
    return this.willpower;
  }



}
