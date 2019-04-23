package tw.edu.ntut.csie.game.state;

import java.util.ArrayList;

import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.extend.Animation;

/**
 * Created by User on 2018/6/6.
 */

public class Role{
    private Animation roleRight = new Animation();
    private Animation roleLeft = new Animation();
    private Animation roleAttackRight = new Animation();
    private Animation roleAttackLeft = new Animation();
    private Animation roleSmiteRight = new Animation();
    private Animation roleSmiteLeft = new Animation();
    private Animation roleSildeRight = new Animation();
    private Animation roleSlideLeft = new Animation();
    private Animation roleBeAttackedRight = new Animation();
    private Animation roleBeAttackedLeft = new Animation();
    private Animation roleDeadRight = new Animation();
    private Animation roleDeadLeft = new Animation();
    private int _hp,_x,_y;
    private boolean _beAttacked = false;
    private boolean _skillKunai = false;
    private boolean _skillShockWave = false;

    public Role(){
        roleRight.addFrame(R.drawable.run_000);
        roleRight.addFrame(R.drawable.run_001);
        roleRight.addFrame(R.drawable.run_002);
        roleRight.addFrame(R.drawable.run_003);
        roleRight.addFrame(R.drawable.run_004);
        roleRight.addFrame(R.drawable.run_005);
        roleRight.addFrame(R.drawable.run_007);
        roleRight.addFrame(R.drawable.run_008);
        roleRight.addFrame(R.drawable.run_009);
        roleRight.setDelay(1);

        roleLeft.addFrame(R.drawable.runleft_000);
        roleLeft.addFrame(R.drawable.runleft_001);
        roleLeft.addFrame(R.drawable.runleft_002);
        roleLeft.addFrame(R.drawable.runleft_003);
        roleLeft.addFrame(R.drawable.runleft_004);
        roleLeft.addFrame(R.drawable.runleft_005);
        roleLeft.addFrame(R.drawable.runleft_007);
        roleLeft.addFrame(R.drawable.runleft_008);
        roleLeft.addFrame(R.drawable.runleft_009);
        roleLeft.setDelay(1);

        roleAttackRight.addFrame(R.drawable.attack__000);
        roleAttackRight.addFrame(R.drawable.attack__001);
        roleAttackRight.addFrame(R.drawable.attack__002);
        roleAttackRight.addFrame(R.drawable.attack__003);
        roleAttackRight.addFrame(R.drawable.attack__004);
        roleAttackRight.addFrame(R.drawable.attack__005);
        roleAttackRight.addFrame(R.drawable.attack__006);
        roleAttackRight.addFrame(R.drawable.attack__007);
        roleAttackRight.addFrame(R.drawable.attack__008);
        roleAttackRight.addFrame(R.drawable.attack__009);
        roleAttackRight.setDelay(1);

        roleAttackLeft.addFrame(R.drawable.attackleft__000);
        roleAttackLeft.addFrame(R.drawable.attackleft__001);
        roleAttackLeft.addFrame(R.drawable.attackleft__002);
        roleAttackLeft.addFrame(R.drawable.attackleft__003);
        roleAttackLeft.addFrame(R.drawable.attackleft__004);
        roleAttackLeft.addFrame(R.drawable.attackleft__005);
        roleAttackLeft.addFrame(R.drawable.attackleft__006);
        roleAttackLeft.addFrame(R.drawable.attackleft__007);
        roleAttackLeft.addFrame(R.drawable.attackleft__008);
        roleAttackLeft.addFrame(R.drawable.attackleft__009);
        roleAttackLeft.setDelay(1);

        roleSmiteRight.addFrame(R.drawable.throw__000);
        roleSmiteRight.addFrame(R.drawable.throw__001);
        roleSmiteRight.addFrame(R.drawable.throw__002);
        roleSmiteRight.addFrame(R.drawable.throw__003);
        roleSmiteRight.addFrame(R.drawable.throw__004);
        roleSmiteRight.addFrame(R.drawable.throw__005);
        roleSmiteRight.addFrame(R.drawable.throw__006);
        roleSmiteRight.addFrame(R.drawable.throw__007);
        roleSmiteRight.addFrame(R.drawable.throw__008);
        roleSmiteRight.addFrame(R.drawable.throw__009);
        roleSmiteRight.setDelay(1);

        roleSmiteLeft.addFrame(R.drawable.throwleft__000);
        roleSmiteLeft.addFrame(R.drawable.throwleft__001);
        roleSmiteLeft.addFrame(R.drawable.throwleft__002);
        roleSmiteLeft.addFrame(R.drawable.throwleft__003);
        roleSmiteLeft.addFrame(R.drawable.throwleft__004);
        roleSmiteLeft.addFrame(R.drawable.throwleft__005);
        roleSmiteLeft.addFrame(R.drawable.throwleft__006);
        roleSmiteLeft.addFrame(R.drawable.throwleft__007);
        roleSmiteLeft.addFrame(R.drawable.throwleft__008);
        roleSmiteLeft.addFrame(R.drawable.throwleft__009);
        roleSmiteLeft.setDelay(1);

        roleSildeRight.addFrame(R.drawable.slide__000);
        roleSildeRight.addFrame(R.drawable.slide__001);
        roleSildeRight.addFrame(R.drawable.slide__002);
        roleSildeRight.addFrame(R.drawable.slide__003);
        roleSildeRight.addFrame(R.drawable.slide__004);
        roleSildeRight.addFrame(R.drawable.slide__005);
        roleSildeRight.addFrame(R.drawable.slide__006);
        roleSildeRight.addFrame(R.drawable.slide__007);
        roleSildeRight.addFrame(R.drawable.slide__008);
        roleSildeRight.addFrame(R.drawable.slide__009);
        roleSildeRight.setDelay(1);

        roleSlideLeft.addFrame(R.drawable.slideleft__000);
        roleSlideLeft.addFrame(R.drawable.slideleft__001);
        roleSlideLeft.addFrame(R.drawable.slideleft__002);
        roleSlideLeft.addFrame(R.drawable.slideleft__003);
        roleSlideLeft.addFrame(R.drawable.slideleft__004);
        roleSlideLeft.addFrame(R.drawable.slideleft__005);
        roleSlideLeft.addFrame(R.drawable.slideleft__006);
        roleSlideLeft.addFrame(R.drawable.slideleft__007);
        roleSlideLeft.addFrame(R.drawable.slideleft__008);
        roleSlideLeft.addFrame(R.drawable.slideleft__009);
        roleSlideLeft.setDelay(1);

        roleBeAttackedRight.addFrame(R.drawable.rightattacked_001);
        roleBeAttackedRight.addFrame(R.drawable.rightattacked_001);
        roleBeAttackedRight.setDelay(1);

        roleBeAttackedLeft.addFrame(R.drawable.leftattacked_001);
        roleBeAttackedLeft.addFrame(R.drawable.leftattacked_001);
        roleBeAttackedLeft.setDelay(1);

        roleDeadRight.addFrame(R.drawable.died__001);
        roleDeadRight.addFrame(R.drawable.died__002);
        roleDeadRight.addFrame(R.drawable.died__003);
        roleDeadRight.addFrame(R.drawable.died_004);
        roleDeadRight.addFrame(R.drawable.died_005);
        roleDeadRight.addFrame(R.drawable.died_006);
        roleDeadRight.addFrame(R.drawable.died_007);
        roleDeadRight.addFrame(R.drawable.died_008);
        roleDeadRight.addFrame(R.drawable.died_009);
        roleDeadRight.setDelay(2);

        roleDeadLeft.addFrame(R.drawable.dead__l001);
        roleDeadLeft.addFrame(R.drawable.dead__l002);
        roleDeadLeft.addFrame(R.drawable.dead__l003);
        roleDeadLeft.addFrame(R.drawable.dead__l004);
        roleDeadLeft.addFrame(R.drawable.dead__l005);
        roleDeadLeft.addFrame(R.drawable.dead__l006);
        roleDeadLeft.addFrame(R.drawable.dead__l007);
        roleDeadLeft.addFrame(R.drawable.dead__l008);
        roleDeadLeft.addFrame(R.drawable.dead__l009);
        roleDeadLeft.setDelay(2);

    }

    public void restart(){
        _hp = 10;
        _skillKunai = false;
        _skillShockWave = false;
        setAttackRightCurrentFrame(1);
        setAttackLefttCurrentFrame(1);
        setSmiteLefttCurrentFrame(1);
        setSmiteRightCurrentFrame(1);
    }

    public void moveRight() {roleRight.move();}
    public void moveLeft() { roleLeft.move();}
    public void moveAttackRight() { roleAttackRight.move();}
    public void moveAttackLeft() { roleAttackLeft.move();}
    public void moveSmiteRight() { roleSmiteRight.move();}
    public void moveSmiteLeft() { roleSmiteLeft.move();}
    public void moveSlideRight() { roleSildeRight.move();}
    public void moveSlideLeft() { roleSlideLeft.move();}
    public void moveBeAttackedRight() { roleBeAttackedRight.move();}
    public void moveBeAttackedLeft() { roleBeAttackedLeft.move();}
    public void moveDeadRight() {roleDeadRight.move();}
    public void moveDeadLeft() {roleDeadLeft.move();}

    public void showRight() { roleRight.show();}
    public void showLeft() { roleLeft.show();}
    public void showAttackRight() { roleAttackRight.show();}
    public void showAttackLeft() { roleAttackLeft.show();}
    public void showSmiteRight() { roleSmiteRight.show();}
    public void showSmiteLeft() { roleSmiteLeft.show();}
    public void showSlideRight() { roleSildeRight.show();}
    public void showSlideLeft() { roleSlideLeft.show();}
    public void showBeAttackedRight() { roleBeAttackedRight.show();}
    public void showBeAttackedLeft() { roleBeAttackedLeft.show();}
    public void showDeadRight() {roleDeadRight.show();}
    public void showDeadLeft() {roleDeadLeft.show();}

    public void setXY(int x,int y){
        _x = x;
        _y = y;
        roleRight.setLocation(_x,_y);
        roleLeft.setLocation(_x,_y);
        roleAttackRight.setLocation(_x,_y);
        roleAttackLeft.setLocation(_x,_y);
        roleSmiteRight.setLocation(_x,_y);
        roleSmiteLeft.setLocation(_x,_y);
        roleSildeRight.setLocation(_x,_y);
        roleSlideLeft.setLocation(_x,_y);
        roleBeAttackedRight.setLocation(_x,_y);
        roleBeAttackedLeft.setLocation(_x,_y);
        roleDeadRight.setLocation(_x,_y);
        roleDeadLeft.setLocation(_x,_y);
    }
    public int getX() { return _x;}
    public int getY() { return  _y;}

    public int getWidth() { return roleRight.getWidth();}
    public int getHeight() { return roleRight.getHeight();}

    public void setAttackRightCurrentFrame(int index) { roleAttackRight.setCurrentFrameIndex(index);}
    public void setAttackLefttCurrentFrame(int index) { roleAttackLeft.setCurrentFrameIndex(index);}

    public void setSmiteRightCurrentFrame(int index) { roleSmiteRight.setCurrentFrameIndex(index);}
    public void setSmiteLefttCurrentFrame(int index) { roleSmiteLeft.setCurrentFrameIndex(index);}

    public void setHP(int hp){
        _hp = hp;
    }
    public int getHp(){
        return _hp;
    }

    public void setBeAttacked(boolean beAttacked){_beAttacked = beAttacked;}
    public boolean getBeAttacked(){return _beAttacked;}

    public void setSkillKunai(boolean bol) { _skillKunai = bol;}
    public boolean getSkillKunai() { return _skillKunai;}

    public void setSkillShockWave(boolean bol) { _skillShockWave = bol;}
    public boolean getSkillShockWave() { return _skillShockWave;}

}
