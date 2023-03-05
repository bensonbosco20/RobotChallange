package com.user.benson.RobotChallenge;

public class RobotPlacement {
	
	public void setRobotPosition(String command, int xPosition, int yPosition, String fDirection, Robot robot) {
		try {
			if(null == command || command.isBlank()) {
				throw new Exception("Invalid Command");
			}
			if(command.equalsIgnoreCase("PLACE")) {
				if(validatePosition(xPosition,yPosition,"Cannot place the robotList in table")) {
					robot.setXPosition(xPosition);
					robot.setYPosition(yPosition);
					robot.setFaceDirection(getFaceDirectionObject(fDirection));
				}
			}
			else if (command.equalsIgnoreCase("MOVE")) {
				moveRobot(robot);
			}
			else if (command.equalsIgnoreCase("LEFT")) {
				robot.setFaceDirection(getFaceDirectionObject(robot.getFaceDirection().getLeftDirection().toString()));
			}
			else if (command.equalsIgnoreCase("RIGHT")) {
				robot.setFaceDirection(getFaceDirectionObject(robot.getFaceDirection().getRightDirection().toString()));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void moveRobot(Robot robot) {
		if(robot.getFaceDirection().getCurrentDirection() == Direction.North) {
			robot.setYPosition(robot.getYPosition() < 3 ? robot.getYPosition() + 1 : 4);
		}
		else if(robot.getFaceDirection().getCurrentDirection() == Direction.South) {
			robot.setYPosition(robot.getYPosition() > 0 ? robot.getYPosition() - 1 : 0);
		}
		else if(robot.getFaceDirection().getCurrentDirection() == Direction.East) {
			robot.setXPosition(robot.getXPosition() < 3 ? robot.getXPosition() + 1 : 4);
		}
		else if(robot.getFaceDirection().getCurrentDirection() == Direction.West) {
			robot.setXPosition(robot.getXPosition() > 0 ? robot.getXPosition() - 1 : 0);
		}
		
	}

	private FaceDirection getFaceDirectionObject(String fDirection) {
		
		switch(fDirection.toUpperCase()) {
			case "NORTH":
				return new FaceDirection(Direction.North, Direction.West, Direction.East);
			case "SOUTH":
				return new FaceDirection(Direction.South, Direction.East, Direction.West);
			case "WEST":
				return new FaceDirection(Direction.West, Direction.South, Direction.North);
			case "EAST":
				return new FaceDirection(Direction.East, Direction.North, Direction.South);
			default:
				return null;
		}
	}

	public boolean validatePosition(int xPosition, int yPosition, String errMsg) {
		boolean returnValue = true;
		try {
			if(xPosition < 0 || xPosition > 4 || yPosition < 0 || yPosition >4) {
				returnValue = false;
				throw new Exception(errMsg);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return returnValue;
		
	}
	

}
