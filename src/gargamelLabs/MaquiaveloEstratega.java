package gargamelLabs;
import robocode.*;

public class MaquiaveloEstratega implements Estratega {
	private final static Estratega INSTANCE = new MaquiaveloEstratega();

	static class ChadStrategy implements Strategy {

		@Override
		public void run(JuniorRobot r) {
			while(true) {
				r.ahead(100);
				r.turnGunRight(360); 
				r.back(100);
				r.turnGunLeft(360);
			}
		}

		@Override
		public void onScannedRobot(JuniorRobot r) {
			r.turnGunTo(r.scannedAngle);
			r.fire(3);
		}

		@Override
		public void onHitByBullet(JuniorRobot r) {
			
		}

		@Override
		public void onHitWall(JuniorRobot r) {
			
		}

		@Override
		public void onHitRobot(JuniorRobot r) {
			
		}
		
	}
	
	static class SimpStrategy implements Strategy {

		@Override
		public void run(JuniorRobot r) {
			r.back(100);
			r.turnGunRight(360); 
			r.back(100);
			r.turnGunLeft(360);
		}

		@Override
		public void onScannedRobot(JuniorRobot r) {
			r.turnGunTo(r.scannedAngle);
			r.fire(3);
		}

		@Override
		public void onHitByBullet(JuniorRobot r) {
			
		}

		@Override
		public void onHitWall(JuniorRobot r) {
			
		}

		@Override
		public void onHitRobot(JuniorRobot r) {
			
		}
		
	}
	
	public static Estratega getInstance() {
		return INSTANCE;
	}
	
	@Override
	public Strategy checkStatus(JuniorRobot r) {
		if(r.energy > 50) {
			return new ChadStrategy();
		} else
			return new SimpStrategy();
	}


}
