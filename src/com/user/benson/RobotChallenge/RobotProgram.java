package com.user.benson.RobotChallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RobotProgram {

	public static List<Robot> robotList = new ArrayList<Robot>();

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			List<String> commandList = new ArrayList<>();
			String inputCommand = scanner.nextLine();
			while (!inputCommand.equalsIgnoreCase("REPORT")) {
				commandList.add(inputCommand);
				inputCommand = scanner.nextLine();
			}
			executeCommands(commandList);
			main(args);
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void executeCommands(List<String> commandList) {
		try {
			Robot currentRobot = null;
			if(!commandList.isEmpty()) {
				if (commandList.get(0).toLowerCase().startsWith("robot")) {
					int robotId = Integer.parseInt(commandList.get(0).split(" ")[1]);
					Robot selectedRobot = robotList.stream().filter(bot -> bot.getRobotId() == robotId).findFirst()
							.orElseThrow(() -> new Exception("Robot " + robotId + " not exist"));
					if (selectedRobot != null) {
						inactiveAllRobots();
						selectedRobot.setActive(true);
						currentRobot = selectedRobot;
					} else {
						throw new Exception("Robot not exist");
					}
				}
				RobotPlacement placement = new RobotPlacement();
				String command = "";
				int xPosition = 0;
				int yPosition = 0;
				String fDirection = "";

				for (String comm : commandList) {
					String[] splitArray = comm.split(" ");
					command = splitArray[0];
					if (command.toUpperCase().equalsIgnoreCase("PLACE")) {
						if (splitArray.length > 1) {
							String[] splitedCommand = splitArray[1].split(",");
							xPosition = Integer.parseInt(splitedCommand[0]);
							yPosition = Integer.parseInt(splitedCommand[1]);
							fDirection = splitedCommand[2];
						}
						if (placement.validatePosition(xPosition, yPosition, "Cannot place the robotList in table")) {
							Robot bot = createNewRobot();
							robotList.add(bot);
							currentRobot = bot;
						}
					}else if(currentRobot == null) {
						currentRobot = robotList.stream().filter(bot->bot.isActive()).findFirst().orElseThrow(() -> new Exception("No ACTIVE Robot"));
					}
					if (currentRobot != null) {
						placement.setRobotPosition(command, xPosition, yPosition, fDirection, currentRobot);
					}
				}
			}
			else {
				currentRobot = robotList.stream().filter(bot->bot.isActive()).findFirst().orElseThrow(() -> new Exception("No robot available in table"));
			}
			reportOutput(currentRobot);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void reportOutput(Robot currentRobot) {
		int count = robotList.size();
		if (count > 0) {
			Robot activeRobot = robotList.stream().filter(bot -> bot.isActive()).findFirst().get();
			String outputMsg = "OUTPUT: " + currentRobot.getXPosition() + "," + currentRobot.getYPosition() + ","
					+ currentRobot.getFaceDirection().getCurrentDirection();
			System.out.println(outputMsg);
			System.out.println("Robot Count :: " + count + " Active Robot :: " + activeRobot.getRobotName());
		} else {
			System.out.println("No Robots in the table");
		}
	}

	private static void inactiveAllRobots() {
		robotList.stream().forEach(bot -> bot.setActive(false));
	}

	private static Robot createNewRobot() {
		Robot bot = new Robot();
		bot.setRobotId(robotList.size() + 1);
		bot.setRobotName("Robot" + bot.getRobotId());
		if (bot.getRobotId() == 1) {
			bot.setActive(true);
		}
		return bot;
	}
}
