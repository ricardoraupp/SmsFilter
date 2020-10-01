public class Sms {
    String msisdn;
    String message_id;
    String re;
    String loja;
    String sistema;
    String date;
    String tz;
    String custID;
    String muID;
    String tvID;
    String acdID;
    String logonID;
    String ssn;
    String agentName;
    String modify;
    String exception;
    String minutes;
    String externalID;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String getRe() {
        return re;
    }

    public void setRe(String re) {
        this.re = re;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getMuID() {
        return muID;
    }

    public void setMuID(String muID) {
        this.muID = muID;
    }

    public String getTvID() {
        return tvID;
    }

    public void setTvID(String tvID) {
        this.tvID = tvID;
    }

    public String getAcdID() {
        return acdID;
    }

    public void setAcdID(String acdID) {
        this.acdID = acdID;
    }

    public String getLogonID() {
        return logonID;
    }

    public void setLogonID(String logonID) {
        this.logonID = logonID;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getModify() {
        return modify;
    }

    public void setModify(String modify) {
        this.modify = modify;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public String getExternalID() {
        return externalID;
    }

    public void setExternalID(String externalID) {
        this.externalID = externalID;
    }

    @Override
    public String toString() {
        return msisdn + '|'
                + message_id + '|'
                + re + '|'
                + loja + '|'
                + sistema + '|'
                + date + '|'
                + tz + '|'
                + custID + '|'
                + muID + '|'
                + tvID + '|'
                + acdID + '|'
                + logonID + '|'
                + ssn + '|'
                + agentName + '|'
                + modify + '|'
                + exception + '|'
                + minutes + '|'
                + externalID + '|';
    }
}
