/**
 * @ClassName: City
 * @Description: TODO
 * @author: Bruce Young
 * @date: 2020年02月02日 17:48
 */
public class City {
    private int centerX;    //城市x坐标
    private int centerY;    //城市y坐标

    public City(int centerX, int centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }
}
