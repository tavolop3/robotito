package cavernicolaLabs;
import robocode.*;

public class MaquiaveloEstratega implements Estratega {
	private final static Estratega INSTANCE = new MaquiaveloEstratega();

	static class DancerStrategy implements Strategy {

		@Override
		public void run(JuniorRobot r) {
			r.turnGunRight(360); 
			r.ahead(100);
			r.back(100);
			r.turnGunLeft(360);
	        this.zigzagMove(r, 75, 45);
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
	
	static class WallyStrategy implements Strategy {
		
		@Override
	    public void run(JuniorRobot r) {	        
	    	int h = r.fieldHeight;
	    	int w = r.fieldWidth;
	        int moveAmount = Math.max(w, h);
	        
	        if (r.heading % 90 != 0) {
				r.turnTo(0);
				r.turnGunRight(90);
			}
	        r.ahead(moveAmount);
	    }

	    @Override
	    public void onHitByBullet(JuniorRobot r) {
	    
	    }

	    @Override
	    public void onScannedRobot(JuniorRobot r) {
	    	if (r.energy > 50)
	    		r.fire(3);
	    	else {
	    		r.fire(1);
	    	}
	    }

		@Override
		public void onHitWall(JuniorRobot r) {
			r.turnRight(90);
		}
	}
	
	public static Estratega getInstance() {
		return INSTANCE;
	}
	
	@Override
	public Strategy checkStatus(JuniorRobot r) {
		if(r.energy > 80) {
			System.out.println("danger1");
			return new WallyStrategy();
		}
		else if (r.energy > 60){
			System.out.println("dancer");
			return new DancerStrategy();
		}
		else if (r.energy > 40){
			System.out.println("danger2");
			return new WallyStrategy();
		}
		else {
			System.out.println("dancer2");
			return new DancerStrategy();
		}
	}


}
