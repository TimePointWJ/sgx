package com.jtzh.entity;

public class UnionBallotInfo {
    private Integer id;

    private Integer ballotId;

    private String type;

    private String name;

    private Integer ballotNum;

    private String delflag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBallotId() {
        return ballotId;
    }

    public void setBallotId(Integer ballotId) {
        this.ballotId = ballotId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBallotNum() {
        return ballotNum;
    }

    public void setBallotNum(Integer ballotNum) {
        this.ballotNum = ballotNum;
    }

    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }
}