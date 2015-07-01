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
import java.util.Set;
import com.googlecode.objectify.annotation.Index;

//@Entity
@Index
public class CharacterInfo {
    public static final Logger log = Logger.getLogger(CharacterInfo.class.getName());

    private Long               characterID;
    private String             characterName;
    private EveRace            race;
    private EveAncestry        ancestry;
    private Date               birthdate;
    private EveBloodline       bloodline;
    private String             gender;
    private double             accountBalance;
    private int                skillsPoints;
    private String             shipName;
    private long               shipTypeID;
    private String             shipTypeName;
    @Index private long               corporationID;
    private String             corporationName;
    private long               allianceID;
    private String             allianceName;


    public CharacterInfo(ApiAuthorization _auth) {
        // extends character bsae

        CharacterSheetParser parser = new CharacterSheetParser();
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


}
