package data.evaluationRecord;

import java.util.List;

public class SocialPerformance {
    private Integer leadership;
    private Integer openness;
    private Integer socialBehaviour;
    private Integer attitude;
    private Integer communication;
    private Integer Integrity;

    public SocialPerformance(){

    }

    public SocialPerformance(Integer leadership, Integer openness, Integer socialBehaviour, Integer attitude, Integer communication, Integer integrity) {
        this.leadership = leadership;
        this.openness = openness;
        this.socialBehaviour = socialBehaviour;
        this.attitude = attitude;
        this.communication = communication;
        Integrity = integrity;
    }

    public Integer getLeadership() {
        return leadership;
    }

    public void setLeadership(Integer leadership) {
        this.leadership = leadership;
    }

    public Integer getOpenness() {
        return openness;
    }

    public void setOpenness(Integer openness) {
        this.openness = openness;
    }

    public Integer getSocialBehaviour() {
        return socialBehaviour;
    }

    public void setSocialBehaviour(Integer socialBehaviour) {
        this.socialBehaviour = socialBehaviour;
    }

    public Integer getAttitude() {
        return attitude;
    }

    public void setAttitude(Integer attitude) {
        this.attitude = attitude;
    }

    public Integer getCommunication() {
        return communication;
    }

    public void setCommunication(Integer communication) {
        this.communication = communication;
    }

    public Integer getIntegrity() {
        return Integrity;
    }

    public void setIntegrity(Integer integrity) {
        Integrity = integrity;
    }

    @Override
    public String toString() {
        return "\nleadership=" + leadership +
                ",\nopenness=" + openness +
                ",\nsocialBehaviour=" + socialBehaviour +
                ",\nattitude=" + attitude +
                ",\ncommunication=" + communication +
                ",\nIntegrity=" + Integrity;
    }
}
