package gargamelLabs;

public class ViolentStrategy extends Strategy {	
	public ViolentStrategy(GargamelRobot robot) {
		super(robot);
	}

	@Override
	public void run() {
		robot.ahead(100);
		robot.turnGunRight(360); 
		robot.back(100);
		robot.turnGunLeft(360);
	}

	@Override
	public void onScannedRobot() {
		robot.turnGunTo(robot.scannedAngle);
		robot.fire(3);
	}

	@Override
	public void onHitByBullet() {
		robot.turnAheadLeft(100, 90 - robot.hitByBulletBearing);
	}

	@Override
	public void onHitWall() {
		robot.back(100);
	}

	@Override
	public void onHitRobot() {
		if (robot.scannedBearing > -90 && robot.scannedBearing < 90) {
			robot.back(100);
		}
		else {
			robot.ahead(100);
		}		
	}

}
