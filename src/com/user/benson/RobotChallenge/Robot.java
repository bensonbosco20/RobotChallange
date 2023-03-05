package com.user.benson.RobotChallenge;

public class Robot {

	private int robotId;
	private String robotName;
	private int XPosition;
	private int YPosition;
	private FaceDirection faceDirection;
	private boolean isActive;
	
	public int getRobotId() {
		return robotId;
	}
	public void setRobotId(int robotId) {
		this.robotId = robotId;
	}
	public String getRobotName() {
		return robotName;
	}
	public void setRobotName(String robotName) {
		this.robotName = robotName;
	}
	public int getXPosition() {
		return XPosition;
	}
	public void setXPosition(int xPosition) {
		XPosition = xPosition;
	}
	public int getYPosition() {
		return YPosition;
	}
	public void setYPosition(int yPosition) {
		YPosition = yPosition;
	}
	public FaceDirection getFaceDirection() {
		return faceDirection;
	}
	public void setFaceDirection(FaceDirection faceDirection) {
		this.faceDirection = faceDirection;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
}
