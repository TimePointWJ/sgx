package com.jtzh.pojo;

import java.util.List;

import com.jtzh.entity.UnionBallot;
import com.jtzh.entity.UnionBallotInfo;

public class BallotParam extends UnionBallot {
	private List<UnionBallotInfo> ballotInfo;
	public List<UnionBallotInfo> getBallotInfo() {
		return ballotInfo;
	}
	public void setBallotInfo(List<UnionBallotInfo> ballotInfo) {
		this.ballotInfo = ballotInfo;
	}
	
}
