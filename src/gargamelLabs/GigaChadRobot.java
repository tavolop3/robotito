package gargamelLabs;
import robocode.*;


public class GigaChadRobot extends JuniorRobot
{
	private Strategy strategy;	
	private Estratega estratega;
	
	public GigaChadRobot() {
		super();
		this.estratega = MaquiaveloEstratega.getInstance();

		this.strategy = estratega.checkStatus(this);
	}

	@Override	
	public void run() {
		setColors(green, green, black, black, black);
		while(true) {
			this.strategy = estratega.checkStatus(this);
			System.out.println("chequeo estrategia");
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
