package com.kither;

import java.io.Serializable;

public class Response implements Serializable {

    private boolean success;
    private String successMessgae;
    private String errMessage;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getSuccessMessgae() {
        return successMessgae;
    }

    public void setSuccessMessgae(String successMessgae) {
        this.successMessgae = successMessgae;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
