package cavernicolaLabs;
import robocode.JuniorRobot;

public class ViolentStrategy implements Strategy {	
	public ViolentStrategy(JuniorRobot robot) {
	}

	@Override
	public void run(JuniorRobot robot) {
		robot.ahead(100);
		robot.turnGunRight(360); 
		robot.back(100);
		robot.turnGunLeft(360);
	}

	@Override
	public void onScannedRobot(JuniorRobot robot) {
		robot.turnGunTo(robot.scannedAngle);
		robot.fire(3);
	}

	@Override
	public void onHitByBullet(JuniorRobot robot) {
		robot.turnAheadLeft(100, 90 - robot.hitByBulletBearing);
	}

	@Override
	public void onHitWall(JuniorRobot robot) {
		robot.back(100);
	}

}
