package cavernicolaLabs;
import robocode.JuniorRobot;

public interface Strategy {
	public void run(JuniorRobot r);
	public void onScannedRobot(JuniorRobot r);
	public void onHitByBullet(JuniorRobot r);
	public void onHitWall(JuniorRobot r);
}
