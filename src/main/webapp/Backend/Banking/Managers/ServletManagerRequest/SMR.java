package main.webapp.Backend.Banking.Managers.ServletManagerRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SMR {
    private HttpServletRequest req;
    private HttpServletResponse resp;
    private String failPath;
    private String successRedir;

    public SMR(){}

    public HttpServletRequest getReq() {
        return req;
    }

    public void setReq(HttpServletRequest req) {
        this.req = req;
    }

    public HttpServletResponse getResp() {
        return resp;
    }

    public void setResp(HttpServletResponse resp) {
        this.resp = resp;
    }

    public String getFailPath() {
        return failPath;
    }

    public void setFailPath(String failPath) {
        this.failPath = failPath;
    }

    public String getSuccessRedir() {
        return successRedir;
    }

    public void setSuccessRedir(String successRedir) {
        this.successRedir = successRedir;
    }
}
