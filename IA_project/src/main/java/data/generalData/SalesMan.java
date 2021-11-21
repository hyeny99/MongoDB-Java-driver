package data.generalData;

public class SalesMan {

    private String _id;
    private Integer sid;
    private String firstname;
    private String lastname;

    public SalesMan(){

    }

    public SalesMan(Integer sid, String firstname, String lastname ) {
        this.sid = sid;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public SalesMan(String _id, Integer sid, String firstname, String lastname) {
        this._id = _id;
        this.sid = sid;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "SalesMan{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", sid=" + sid +
                '}';
    }
}
