package com.user.benson.RobotChallenge;

public class FaceDirection {

	private Direction currentDirection;
	private Direction leftDirection;
	private Direction rightDirection;
	
	
	public FaceDirection(Direction currentDirection, Direction leftDirection, Direction rightDirection) {
		this.currentDirection = currentDirection;
		this.leftDirection = leftDirection;
		this.rightDirection = rightDirection;
	}
	
	public Direction getCurrentDirection() {
		return currentDirection;
	}
	public void setCurrentDirection(Direction currentDirection) {
		this.currentDirection = currentDirection;
	}
	public Direction getLeftDirection() {
		return leftDirection;
	}
	public void setLeftDirection(Direction leftDirection) {
		this.leftDirection = leftDirection;
	}
	public Direction getRightDirection() {
		return rightDirection;
	}
	public void setRightDirection(Direction rightDirection) {
		this.rightDirection = rightDirection;
	}
	
}
