package cavernicolaLabs;
import robocode.JuniorRobot;

public interface Strategy {
	public abstract void run(JuniorRobot r);
	public abstract void onScannedRobot(JuniorRobot r);
	public abstract void onHitByBullet(JuniorRobot r);
	public abstract void onHitWall(JuniorRobot r);
}
