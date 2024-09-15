package gargamelLabs;
import robocode.*;

public class MaquiaveloEstratega implements Estratega {
	private final static Estratega INSTANCE = new MaquiaveloEstratega();

	static class DancerChadStrategy implements Strategy {

		@Override
		public void run(JuniorRobot r) {
			r.ahead(100);
			r.turnGunRight(360); 
			r.back(100);
			r.turnGunLeft(360);
	        this.zigzagMove(r, 75, 45);
	        r.turnGunRight(360);
		}

	    private void zigzagMove(JuniorRobot r, int distance, int angle) {
	        r.ahead(distance);

	        r.turnRight(angle);
	        r.ahead(distance);

	        r.turnLeft(angle);
	        r.ahead(distance);
	    }

	    @Override
	    public void onScannedRobot(JuniorRobot r) {
	        int enemyDistance = r.scannedDistance;
	        int angle = r.scannedAngle;
	        int powerDistance = (r.energy > 30 ? 400 : 100);

	        r.turnGunTo(angle);
	        this.fireStrategy(r, enemyDistance, powerDistance);
	    }

	    private void fireStrategy(JuniorRobot r, int enemyDistance, int powerDistance) {
	        if (enemyDistance < powerDistance) {
	            r.fire(3);
	        } else {
	            r.fire(1);
	        }
	    }

	    @Override
	    public void onHitByBullet(JuniorRobot r) {
	        r.ahead(100);
	    }

	    @Override
	    public void onHitWall(JuniorRobot r) {
	        r.turnRight(90);
	        r.ahead(150);
	    }
		
	}
	
	static class DangerStrategy implements Strategy {
	    boolean peek;
	    
	    public void run(JuniorRobot r) {	        
	    	int h = r.fieldHeight;
	    	int w = r.fieldWidth;
	        int moveAmount = Math.max(w, h);
	        peek = false;

	        r.turnLeft(r.heading % 90);
	        r.ahead(moveAmount);
	        peek = true;
	        r.turnGunRight(90);
	        r.turnRight(90);

	        while (true) {
	            peek = true;
	            r.ahead(moveAmount);
	            peek = false;
	            r.turnRight(90);
	        }
	    }


	    public void onHitByBullet(JuniorRobot r) {
//	        r.turnTo(r.hitByBulletAngle);
//	        r.ahead(100);
	    }

	    public void onScannedRobot(JuniorRobot r) {
            r.fire(2);
            if (peek) {
        		r.turnGunRight(360); 
            }
	    }

		@Override
		public void onHitWall(JuniorRobot r) {
//			r.back(20);
//	        r.turnRight(90);
		}
	}
	
	public static Estratega getInstance() {
		return INSTANCE;
	}
	
	@Override
	public Strategy checkStatus(JuniorRobot r) {
		if(r.energy < 50) {
			System.out.println("dancer");
			return new DancerChadStrategy();
		} else {
			System.out.println("danger");
			return new DangerStrategy();
		}
	}


}
