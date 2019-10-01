package main.webapp.Backend.Banking.Managers.ServletManagerRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SMRBuilder {
    private static SMR smr = new SMR();

    public static SMR build() {
        return smr;
    }

    public static SMRBuilder req(HttpServletRequest req){
        smr.setReq(req);
        return null;
    }

    public static SMRBuilder resp(HttpServletResponse resp){
        smr.setResp(resp);
        return null;
    }

    public static SMRBuilder failPath(String failPath){
        smr.setFailPath(failPath);
        return null;
    }

    public static SMRBuilder successRedir(String successRedir){
        smr.setSuccessRedir(smr.getReq().getContextPath() + successRedir);
        return null;
    }
}
