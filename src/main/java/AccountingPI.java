import com.googlecode.objectify.cmd.Query;

import java.util.logging.Logger;
import static com.googlecode.objectify.ObjectifyService.ofy;
import com.beimin.eveapi.shared.wallet.RefType;

public class AccountingPI {
    public static final Logger log = Logger.getLogger(AccountingPI.class.getName());

    public AccountingPI() {
    }


    public long calcPlanetExpense(int _id, RefType _refType) {
        long total = 0;
        total = planetExpense(_id, _refType);
        return total;
    }

    public long calcPlanetExpense(int _id) {
        long total = 0;
        total = planetExpense(_id, null);
        return total;

    }

    private long planetExpense(int _id, RefType _refType) {
        long total = 0;
        OfyService.ofy();
        Query<WalletJournal> q;

        if (_refType != null) {
            q = ofy().load().type(WalletJournal.class).filter("argID1 =", _id).filter("refType =", _refType);
        } else {
            q = ofy().load().type(WalletJournal.class).filter("argID1 =", _id);
        }
        for (WalletJournal wj : q) {
            total += wj.getAmount();

        }

        log.info("Planet Expense - Total Amount Found: " + "-" + String.valueOf(_id) + "-" + String.valueOf(_refType) + "-" + String.valueOf(total));
        return total;
    }

}
