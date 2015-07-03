import java.util.Collection;
import java.util.Date;

import com.beimin.eveapi.core.ApiAuthorization;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.corporation.wallet.journal.WalletJournalParser;
import com.beimin.eveapi.shared.wallet.RefType;
import com.beimin.eveapi.shared.wallet.journal.AbstractWalletJournalParser;
import com.beimin.eveapi.shared.wallet.journal.WalletJournalResponse;
import com.beimin.eveapi.shared.wallet.journal.ApiJournalEntry;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Id;

@Index
public class WalletJournal {

    private Date    date;
    @Index
    private long    refID;
    private int     refTypeID;
    private RefType refType;
    private String  ownerName1;
    private long    ownerID1;
    private String  ownerName2;
    private long    ownerID2;
    private String  argName1;
    private long    argID1;
    private double  amount;
    private double  balance;
    private String  reason;
    private Long    taxReceiverID;
    private Double  taxAmount;

    public WalletJournal(ApiJournalEntry journalEntry) {
        
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

   
}
