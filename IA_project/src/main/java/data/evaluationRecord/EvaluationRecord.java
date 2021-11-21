package data.evaluationRecord;

public class EvaluationRecord {

    private String _id;
    private Integer sid;
    private Integer year;
    private OrdersEvaluation order;
    private SocialPerformance socialPerformance;

    public EvaluationRecord(){

    }

    public EvaluationRecord(String _id, Integer sid, Integer year, OrdersEvaluation order, SocialPerformance socialPerformance) {
        this._id = _id;
        this.sid = sid;
        this.year = year;
        this.order = order;
        this.socialPerformance = socialPerformance;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public OrdersEvaluation getOrder() {
        return order;
    }

    public void setOrder(OrdersEvaluation order) {
        this.order = order;
    }

    public SocialPerformance getSocialPerformance() {
        return socialPerformance;
    }

    public void setSocialPerformance(SocialPerformance socialPerformance) {
        this.socialPerformance = socialPerformance;
    }

    @Override
    public String toString() {
        return "EvaluationRecord{" +
                "_id='" + _id + '\'' +
                ",\nsid=" + sid +
                ",\nyear=" + year +
                ",\norders evaluation=" + order +
                ",\n\nsocial Performance=" + socialPerformance +
                '}';
    }
}
