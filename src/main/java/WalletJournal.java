import java.util.Collection;
import java.util.Date;

import com.beimin.eveapi.core.ApiAuthorization;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.character.wallet.journal.WalletJournalParser;
import com.beimin.eveapi.shared.wallet.RefType;
import com.beimin.eveapi.shared.wallet.journal.AbstractWalletJournalParser;
import com.beimin.eveapi.shared.wallet.journal.WalletJournalResponse;
import com.beimin.eveapi.shared.wallet.journal.ApiJournalEntry;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Parent;
import java.util.logging.Logger;

import static com.googlecode.objectify.ObjectifyService.ofy;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

@Entity
public class WalletJournal {

    public static final Logger log = Logger.getLogger(WalletJournal.class.getName());

    //  @Parent Key<GameCharacter> owner;
    private Date               date;
    @Id
    private long               refID;
    private int                refTypeID;
    private RefType            refType;
    private String             ownerName1;
    private long               ownerID1;
    private String             ownerName2;
    private long               ownerID2;
    private String             argName1;
    private long               argID1;
    private double             amount;
    private double             balance;
    private String             reason;
    private Long               taxReceiverID;
    private Double             taxAmount;

   public WalletJournal()
     {
     
   }
    
    public void getWalletEntry(ApiJournalEntry journalEntry) {

        this.date = journalEntry.getDate();
        this.refID = journalEntry.getRefID();
        this.refType = journalEntry.getRefType();
        this.ownerID1 = journalEntry.getOwnerID1();
        this.ownerName1 = journalEntry.getOwnerName1();
        this.ownerID2 = journalEntry.getOwnerID2();
        this.ownerName2 = journalEntry.getOwnerName2();
        this.argName1 = journalEntry.getArgName1();
        this.argID1 = journalEntry.getArgID1();
        this.amount = journalEntry.getAmount();
        this.reason = journalEntry.getReason();
        this.taxReceiverID = journalEntry.getTaxReceiverID();
        this.taxAmount = journalEntry.getTaxAmount();
    }

    public void refresh(ApiAuthorization _auth) {
        AbstractWalletJournalParser parser = WalletJournalParser.getInstance();
        try {
            WalletJournalResponse response = parser.getResponse(_auth, 1000);
            Collection<ApiJournalEntry> entries = response.getAll();

            OfyService.ofy();

            log.info("Wallet Joutnal Collections Size: " + String.valueOf(entries.size()));

            for (ApiJournalEntry journalEntry : entries) {
                WalletJournal wj = new WalletJournal();
                wj.getWalletEntry(journalEntry);
                ofy().save().entity(wj).now();
            }


        } catch (ApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}
