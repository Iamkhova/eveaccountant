import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.Collection;

import com.beimin.eveapi.account.accountstatus.EveAccountStatus;
import com.beimin.eveapi.account.apikeyinfo.ApiKeyInfoResponse;
import com.beimin.eveapi.account.characters.EveCharacter;
import com.beimin.eveapi.character.sheet.ApiSkill;
import com.beimin.eveapi.character.sheet.CharacterSheetResponse;
import com.beimin.eveapi.character.skill.queue.ApiSkillQueueItem;
import com.beimin.eveapi.eve.character.CharacterInfoResponse;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.EveApi;
import com.beimin.eveapi.api.calllist.Call;
  import com.beimin.eveapi.api.calllist.CallGroup;
  import com.beimin.eveapi.api.calllist.CallList;
//import com.beimin.eveapi.core.ApiException;


import java.util.ArrayList;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.account.apikeyinfo.ApiKeyInfoResponse;
import com.beimin.eveapi.account.characters.CharactersParser;
import com.beimin.eveapi.account.characters.CharactersResponse;
import com.beimin.eveapi.core.ApiAuthorization;
import com.beimin.eveapi.corporation.assetlist.AssetListParser;
import com.beimin.eveapi.corporation.wallet.transactions.WalletTransactionsParser;
import com.beimin.eveapi.shared.accountbalance.EveAccountBalance;
import com.beimin.eveapi.shared.assetlist.AbstractAssetListParser;
import com.beimin.eveapi.shared.assetlist.AssetListResponse;
import com.beimin.eveapi.shared.assetlist.EveAsset;
import com.beimin.eveapi.shared.wallet.transactions.AbstractWalletTransactionsParser;
import com.beimin.eveapi.shared.wallet.transactions.ApiWalletTransaction;
import com.beimin.eveapi.shared.wallet.transactions.WalletTransactionsResponse;

import java.util.Iterator;
import java.util.Set;

import com.beimin.eveapi.shared.KeyType;

import com.googlecode.objectify.annotation.AlsoLoad;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.IgnoreSave;
import com.googlecode.objectify.annotation.Load;
import com.googlecode.objectify.annotation.OnLoad;

import static com.googlecode.objectify.ObjectifyService.ofy;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;




public class WebTester extends HttpServlet {

   private int keyid;
   private String vcode;

  
  public void doGet(HttpServletRequest req, HttpServletResponse resp)

  {
    
         String   vcode = "CViRCKn7XRWC3UaVXZ0dkgl0QE7DPsypBPOZn3Y240bubHJ1ZfU4dtWC30lC6lSU";
   int  keyid = 4300877;

   
    ApiAuthorization auth = new ApiAuthorization(keyid,92113484,vcode);
    
    CharacterInfo cinfo = new CharacterInfo();
    WalletJournal wj = new WalletJournal();
    cinfo.refresh(auth);
    wj.refresh(auth);
    
    
    


  }
  
}
