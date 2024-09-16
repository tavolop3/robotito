package gargamelLabs;
import robocode.*;


public class GigaChadRobot extends JuniorRobot
{
	private Strategy strategy;	
	private Estratega estratega;
	
	public GigaChadRobot() {
		this.estratega = MaquiaveloEstratega.getInstance();
		this.strategy = estratega.checkStatus(this);
	}

	@Override	
	public void run() {
		setColors(black, yellow, black, yellow, red);
		while(true) {
			this.strategy = estratega.checkStatus(this);
			strategy.run(this);
		}
	}


	@Override
	public void onScannedRobot() {
		strategy.onScannedRobot(this);
	}

	@Override
	public void onHitByBullet() {
		strategy.onHitByBullet(this);
	}
	
	@Override
	public void onHitWall() {
		strategy.onHitWall(this);
	}	
	
}
