package tw.edu.ntut.csie.game.state;

import tw.edu.ntut.csie.game.core.MovingBitmap;

/**
 * Created by NTUTCSIE on 2018/6/15.
 */

public class DropItem{
    private MovingBitmap item;
    private boolean _onshow = false;
    private int _x,_y,_type,_pickupTime;    //掉落的技能 0為血瓶 1為苦無 2為衝擊波

    public DropItem(int resId){
        item = new MovingBitmap(resId);
    }

    public void setXY(int x,int y) {
        _x=x;
        _y=y;
        item.setLocation(x,y);
    }
    public int getX() {return _x;}
    public int getY() {return _y;}

    public int getHeight() {return item.getHeight();}
    public int getWidth() {return item.getWidth();}

    public void setOnShow(boolean onshow){ _onshow = onshow;}
    public boolean getOnShow(){ return _onshow;}

    public void setType(int type) { _type = type;}
    public int getType() { return _type;}

    public void show() {item.show();}

    public void setPickupTime(int pickup) { _pickupTime = pickup;}
    public int getPickupTime() { return _pickupTime;}
}
