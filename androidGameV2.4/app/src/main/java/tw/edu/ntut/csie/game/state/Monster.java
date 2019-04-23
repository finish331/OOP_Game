package tw.edu.ntut.csie.game.state;

import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.extend.Animation;

/**
 * Created by User on 2018/6/7.
 */

public class Monster{
    private Animation right = new Animation();
    private Animation left = new Animation();
    private Animation attackRight = new Animation();
    private Animation attackLeft = new Animation();
    private Animation remoteAttackRight = new Animation();
    private Animation remoteAttackLeft = new Animation();
    private Animation beAttackedRight = new Animation();
    private Animation beAttackedLeft = new Animation();
    private Animation deadRight = new Animation();
    private Animation deadLeft = new Animation();

    private int _x,_y,_hp = 0,_randMove = 0,_randMoveTime = 0,_mapNumber = 0,_dir = 1,_attackTime = 0,_dropSkill,_plugDied;   //掉落的技能 0為血瓶 1為苦無 2為衝擊波 -1為已掉落物品
    private boolean _beAttacked = false;
    public Monster(int x,int y,int hp,int type){
        _hp = hp;
        _x = x;
        _y = y;
        if(type == 1) {
            right.addFrame(R.drawable.m_run001);
            right.addFrame(R.drawable.m_run002);
            right.addFrame(R.drawable.m_run003);
            right.addFrame(R.drawable.m_run004);
            right.addFrame(R.drawable.m_run005);
            right.addFrame(R.drawable.m_run007);
            right.addFrame(R.drawable.m_run008);
            right.addFrame(R.drawable.m_run09);
            right.addFrame(R.drawable.m_run010);
            right.setDelay(1);

            left.addFrame(R.drawable.m_runl001);
            left.addFrame(R.drawable.m_runl002);
            left.addFrame(R.drawable.m_runl003);
            left.addFrame(R.drawable.m_runl004);
            left.addFrame(R.drawable.m_runl005);
            left.addFrame(R.drawable.m_runl007);
            left.addFrame(R.drawable.m_runl008);
            left.addFrame(R.drawable.m_runl09);
            left.addFrame(R.drawable.m_runl010);
            left.setDelay(1);

            attackRight.addFrame(R.drawable.m_attack002);
            attackRight.addFrame(R.drawable.m_attack003);
            attackRight.addFrame(R.drawable.m_attack004);
            attackRight.addFrame(R.drawable.m_attack005);
            attackRight.addFrame(R.drawable.m_attack008);
            attackRight.setDelay(2);

            attackLeft.addFrame(R.drawable.m_attackl002);
            attackLeft.addFrame(R.drawable.m_attackl003);
            attackLeft.addFrame(R.drawable.m_attackl004);
            attackLeft.addFrame(R.drawable.m_attackl005);
            attackLeft.addFrame(R.drawable.m_attackl008);
            attackLeft.setDelay(2);

            beAttackedRight.addFrame(R.drawable.hurt);
            beAttackedRight.setDelay(6);

            beAttackedLeft.addFrame(R.drawable.hurt_l);
            beAttackedLeft.setDelay(6);

            deadRight.addFrame(R.drawable.dead_001);
            deadRight.addFrame(R.drawable.dead_002);
            deadRight.addFrame(R.drawable.dead_003);
            deadRight.addFrame(R.drawable.dead_004);
            deadRight.addFrame(R.drawable.dead_007);
            deadRight.addFrame(R.drawable.dead_008);
            deadRight.addFrame(R.drawable.dead_011);
            deadRight.addFrame(R.drawable.dead_012);
            deadRight.addFrame(R.drawable.transparent);
            deadRight.addFrame(R.drawable.dead_012);
            deadRight.addFrame(R.drawable.transparent);
            deadRight.addFrame(R.drawable.dead_012);
            deadRight.addFrame(R.drawable.transparent);
            deadRight.addFrame(R.drawable.dead_012);
            deadRight.addFrame(R.drawable.transparent);
            deadRight.addFrame(R.drawable.dead_012);
            deadRight.addFrame(R.drawable.transparent);
            deadRight.setDelay(2);

            deadLeft.addFrame(R.drawable.dead_l_001);
            deadLeft.addFrame(R.drawable.dead_l_002);
            deadLeft.addFrame(R.drawable.dead_l_003);
            deadLeft.addFrame(R.drawable.dead_l_004);
            deadLeft.addFrame(R.drawable.dead_l_007);
            deadLeft.addFrame(R.drawable.dead_l_008);
            deadLeft.addFrame(R.drawable.dead_l_011);
            deadLeft.addFrame(R.drawable.dead_l_012);
            deadLeft.addFrame(R.drawable.transparent);
            deadLeft.addFrame(R.drawable.dead_l_012);
            deadLeft.addFrame(R.drawable.transparent);
            deadLeft.addFrame(R.drawable.dead_l_012);
            deadLeft.addFrame(R.drawable.transparent);
            deadLeft.addFrame(R.drawable.dead_l_012);
            deadLeft.addFrame(R.drawable.transparent);
            deadLeft.addFrame(R.drawable.dead_l_012);
            deadLeft.addFrame(R.drawable.transparent);
            deadLeft.setDelay(2);
        }
        else if(type == 2){
            right.addFrame(R.drawable.femalewalk_001);
            right.addFrame(R.drawable.femalewalk_002);
            right.addFrame(R.drawable.femalewalk_003);
            right.addFrame(R.drawable.femalewalk_004);
            right.addFrame(R.drawable.femalewalk_005);
            right.addFrame(R.drawable.femalewalk_006);
            right.addFrame(R.drawable.femalewalk_007);
            right.addFrame(R.drawable.femalewalk_008);
            right.addFrame(R.drawable.femalewalk_009);
            right.addFrame(R.drawable.femalewalk_010);
            right.setDelay(1);

            left.addFrame(R.drawable.femalewalk_l_001);
            left.addFrame(R.drawable.femalewalk_l_002);
            left.addFrame(R.drawable.femalewalk_l_003);
            left.addFrame(R.drawable.femalewalk_l_004);
            left.addFrame(R.drawable.femalewalk_l_005);
            left.addFrame(R.drawable.femalewalk_l_006);
            left.addFrame(R.drawable.femalewalk_l_007);
            left.addFrame(R.drawable.femalewalk_l_008);
            left.addFrame(R.drawable.femalewalk_l_009);
            left.addFrame(R.drawable.femalewalk_l_010);
            left.setDelay(1);

            attackRight.addFrame(R.drawable.femaleattack_002);
            attackRight.addFrame(R.drawable.femaleattack_003);
            attackRight.addFrame(R.drawable.femaleattack_004);
            attackRight.addFrame(R.drawable.femaleattack_005);
            attackRight.addFrame(R.drawable.femaleattack_008);
            attackRight.setDelay(2);

            attackLeft.addFrame(R.drawable.femaleattack_l_002);
            attackLeft.addFrame(R.drawable.femaleattack_l_003);
            attackLeft.addFrame(R.drawable.femaleattack_l_004);
            attackLeft.addFrame(R.drawable.femaleattack_l_005);
            attackLeft.addFrame(R.drawable.femaleattack_l_008);
            attackLeft.setDelay(2);

            beAttackedRight.addFrame(R.drawable.femalehurt);
            beAttackedRight.setDelay(6);

            beAttackedLeft.addFrame(R.drawable.femalehurt_l);
            beAttackedLeft.setDelay(6);

            deadRight.addFrame(R.drawable.femaledead_001);
            deadRight.addFrame(R.drawable.femaledead_002);
            deadRight.addFrame(R.drawable.femaledead_003);
            deadRight.addFrame(R.drawable.femaledead_004);
            deadRight.addFrame(R.drawable.femaledead_007);
            deadRight.addFrame(R.drawable.femaledead_008);
            deadRight.addFrame(R.drawable.femaledead_010);
            deadRight.addFrame(R.drawable.femaledead_011);
            deadRight.addFrame(R.drawable.femaledead_012);
            deadRight.addFrame(R.drawable.transparent);
            deadRight.addFrame(R.drawable.femaledead_012);
            deadRight.addFrame(R.drawable.transparent);
            deadRight.addFrame(R.drawable.femaledead_012);
            deadRight.addFrame(R.drawable.transparent);
            deadRight.addFrame(R.drawable.femaledead_012);
            deadRight.addFrame(R.drawable.transparent);
            deadRight.addFrame(R.drawable.femaledead_012);
            deadRight.addFrame(R.drawable.transparent);
            deadRight.setDelay(2);

            deadLeft.addFrame(R.drawable.femaledead_l_001);
            deadLeft.addFrame(R.drawable.femaledead_l_002);
            deadLeft.addFrame(R.drawable.femaledead_l_003);
            deadLeft.addFrame(R.drawable.femaledead_l_004);
            deadLeft.addFrame(R.drawable.femaledead_l_007);
            deadLeft.addFrame(R.drawable.femaledead_l_008);
            deadLeft.addFrame(R.drawable.femaledead_l_010);
            deadLeft.addFrame(R.drawable.femaledead_l_011);
            deadLeft.addFrame(R.drawable.femaledead_l_012);
            deadLeft.addFrame(R.drawable.transparent);
            deadLeft.addFrame(R.drawable.femaledead_l_012);
            deadLeft.addFrame(R.drawable.transparent);
            deadLeft.addFrame(R.drawable.femaledead_l_012);
            deadLeft.addFrame(R.drawable.transparent);
            deadLeft.addFrame(R.drawable.femaledead_l_012);
            deadLeft.addFrame(R.drawable.transparent);
            deadLeft.addFrame(R.drawable.femaledead_l_012);
            deadLeft.addFrame(R.drawable.transparent);
            deadLeft.setDelay(2);
        }
        if(type == 3){
            right.addFrame(R.drawable.king_run_001);
            right.addFrame(R.drawable.king_run_002);
            right.addFrame(R.drawable.king_run_003);
            right.addFrame(R.drawable.king_run_004);
            right.addFrame(R.drawable.king_run_005);
            right.addFrame(R.drawable.king_run_006);
            right.addFrame(R.drawable.king_run_007);
            right.addFrame(R.drawable.king_run_008);
            right.setDelay(1);

            left.addFrame(R.drawable.king_lrun_001);
            left.addFrame(R.drawable.king_lrun_002);
            left.addFrame(R.drawable.king_lrun_003);
            left.addFrame(R.drawable.king_lrun_004);
            left.addFrame(R.drawable.king_lrun_005);
            left.addFrame(R.drawable.king_lrun_006);
            left.addFrame(R.drawable.king_lrun_007);
            left.addFrame(R.drawable.king_lrun_008);
            left.setDelay(1);

            attackRight.addFrame(R.drawable.melee_002);
            attackRight.addFrame(R.drawable.melee_003);
            attackRight.addFrame(R.drawable.melee_004);
            attackRight.addFrame(R.drawable.melee_005);
            attackRight.addFrame(R.drawable.melee_006);
            attackRight.setDelay(2);

            attackLeft.addFrame(R.drawable.l_melee_002);
            attackLeft.addFrame(R.drawable.l_melee_003);
            attackLeft.addFrame(R.drawable.l_melee_004);
            attackLeft.addFrame(R.drawable.l_melee_005);
            attackLeft.addFrame(R.drawable.l_melee_006);
            attackLeft.setDelay(2);

            remoteAttackRight.addFrame(R.drawable.shoot_001);
            remoteAttackRight.addFrame(R.drawable.shoot_002);
            remoteAttackRight.addFrame(R.drawable.shoot_003);
            remoteAttackRight.addFrame(R.drawable.shoot_004);
            remoteAttackRight.setDelay(3);

            remoteAttackLeft.addFrame(R.drawable.lshoot_001);
            remoteAttackLeft.addFrame(R.drawable.lshoot_002);
            remoteAttackLeft.addFrame(R.drawable.lshoot_003);
            remoteAttackLeft.addFrame(R.drawable.lshoot_004);
            remoteAttackLeft.setDelay(3);

            beAttackedRight.addFrame(R.drawable.hurt_king);
            beAttackedRight.setDelay(6);

            beAttackedLeft.addFrame(R.drawable.lhurt_king);
            beAttackedLeft.setDelay(6);

            deadRight.addFrame(R.drawable.king_dead000);
            deadRight.addFrame(R.drawable.king_dead001);
            deadRight.addFrame(R.drawable.king_dead002);
            deadRight.addFrame(R.drawable.king_dead003);
            deadRight.addFrame(R.drawable.king_dead004);
            deadRight.addFrame(R.drawable.king_dead005);
            deadRight.addFrame(R.drawable.king_dead006);
            deadRight.addFrame(R.drawable.king_dead007);
            deadRight.addFrame(R.drawable.king_dead008);
            deadRight.addFrame(R.drawable.transparent);
            deadRight.addFrame(R.drawable.king_dead008);
            deadRight.addFrame(R.drawable.transparent);
            deadRight.addFrame(R.drawable.king_dead008);
            deadRight.addFrame(R.drawable.transparent);
            deadRight.addFrame(R.drawable.king_dead008);
            deadRight.addFrame(R.drawable.transparent);
            deadRight.addFrame(R.drawable.king_dead008);
            deadRight.addFrame(R.drawable.transparent);
            deadRight.setDelay(3);

            deadLeft.addFrame(R.drawable.lking_dead000);
            deadLeft.addFrame(R.drawable.lking_dead001);
            deadLeft.addFrame(R.drawable.lking_dead002);
            deadLeft.addFrame(R.drawable.lking_dead003);
            deadLeft.addFrame(R.drawable.lking_dead004);
            deadLeft.addFrame(R.drawable.lking_dead005);
            deadLeft.addFrame(R.drawable.lking_dead006);
            deadLeft.addFrame(R.drawable.lking_dead007);
            deadLeft.addFrame(R.drawable.lking_dead008);
            deadLeft.addFrame(R.drawable.lking_dead009);
            deadLeft.addFrame(R.drawable.transparent);
            deadLeft.addFrame(R.drawable.lking_dead009);
            deadLeft.addFrame(R.drawable.transparent);
            deadLeft.addFrame(R.drawable.lking_dead009);
            deadLeft.addFrame(R.drawable.transparent);
            deadLeft.addFrame(R.drawable.lking_dead009);
            deadLeft.addFrame(R.drawable.transparent);
            deadLeft.addFrame(R.drawable.lking_dead009);
            deadLeft.addFrame(R.drawable.transparent);
            deadLeft.setDelay(3);

        }
    }

    public void restart(int x,int y,int hp,int dir,int randMove,int randMoveTime,int mapNumber,int dropSkill){
        _x = x;
        _y = y;
        _hp = hp;
        _dir = dir;
        _randMove = randMove;
        _randMoveTime = randMoveTime;
        _mapNumber = mapNumber;
        _dropSkill  = dropSkill;
        setXY(_x,_y);
        setAttackRightCurrentFrame(1);
        setAttackLefttCurrentFrame(1);
        setDeadRightCurrentFrame(1);
        setDeadLefttCurrentFrame(1);
        _beAttacked = false;
        _attackTime = 0;
    }

    public void addRight(int resId) { right.addFrame(resId);}
    public void setRightDelay(int delay) {right.setDelay(delay);}
    public void addLeft(int resId) { left.addFrame(resId);}
    public void setLeftDelay(int delay) {left.setDelay(delay);}
    public void addAttackRight(int resId) {attackRight.addFrame(resId);}
    public void setAttackRightDelay(int delay) { attackRight.addFrame(delay);}
    public void addAttackLeft(int resId) {attackLeft.addFrame(resId);}
    public void setAttackLeftDelayy(int delay) { attackLeft.setDelay(delay);}
    public void addBeAttackRight(int resId) {beAttackedRight.addFrame(resId);}
    public void setBeAttackedRight(int delay) { beAttackedRight.setDelay(delay);}
    public void addBeAttackLeft(int resId) {beAttackedLeft.addFrame(resId);}
    public void setBeAttackedLeft(int delay) {beAttackedLeft.setDelay(delay);}

    public void moveRight() { right.move();}
    public void moveLeft() { left.move();}
    public void moveAttackRight() { attackRight.move();}
    public void moveAttackLeft() { attackLeft.move();}
    public void moveRemoteAttackRight() { remoteAttackRight.move();}
    public void moveRemoteAttackLeft() { remoteAttackLeft.move();}
    public void moveBeAttackedRight() { beAttackedRight.move();}
    public void moveBeAttackedLeft() { beAttackedLeft.move();}
    public void moveDeadRight() {deadRight.move();}
    public void moveDeadLeft() {deadLeft.move();}

    public void showRight() { right.show();}
    public void showLeft() { left.show();}
    public void showAttackRight() { attackRight.show();}
    public void showAttackLeft() { attackLeft.show();}
    public void showRemoteAttackRight() { remoteAttackRight.show();}
    public void showRemoteAttackLeft() { remoteAttackLeft.show();}
    public void showBeAttackedRight() { beAttackedRight.show();}
    public void showBeAttackedLeft() { beAttackedLeft.show();}
    public void showDeadRight() {deadRight.show();}
    public void showDeadLeft() {deadLeft.show();}

    public void setXY(int x,int y){
        _x = x;
        _y = y;
        right.setLocation(_x,_y);
        left.setLocation(_x,_y);
        attackRight.setLocation(_x,_y);
        attackLeft.setLocation(_x,_y);
        remoteAttackRight.setLocation(_x,_y);
        remoteAttackLeft.setLocation(_x,_y);
        beAttackedRight.setLocation(_x,_y);
        beAttackedLeft.setLocation(_x,_y);
        deadRight.setLocation(_x,_y);
        deadLeft.setLocation(_x,_y);
    }
    public int getX(){ return _x;}
    public int getY(){return _y;}

    public int getHeight(){ return right.getHeight();}
    public int getWidth(){ return right.getWidth();}

    public void setHP(int hp){ _hp = hp;}
    public int getHP(){ return _hp;}

    public void setRandMove(int randMove) { _randMove = randMove;}
    public int getRandMove() { return _randMove;}

    public void setRandMoveTime(int randMoveTime) { _randMoveTime = randMoveTime;}
    public int getRandMoveTime() { return _randMoveTime;}

    public void setDir(int dir) { _dir = dir;}
    public int getDir() {return _dir;}

    public void setMapNumber(int mapNumber) { _mapNumber = mapNumber;}
    public int getMapNumber() {return _mapNumber;}

    public void setAttackTime(int attackTime){_attackTime = attackTime;}
    public int getAttackTime(){return _attackTime;}

    public void setBeAttacked(boolean beAttacked){_beAttacked = beAttacked;}
    public boolean getBeAttacked(){return _beAttacked;}

    public void setAttackRightCurrentFrame(int index) { attackRight.setCurrentFrameIndex(index);}
    public void setAttackLefttCurrentFrame(int index) { attackLeft.setCurrentFrameIndex(index);}

    public void setDeadRightCurrentFrame(int index) { deadRight.setCurrentFrameIndex(index);}
    public void setDeadLefttCurrentFrame(int index) { deadLeft.setCurrentFrameIndex(index);}

    public void setDropSkill(int skill) { _dropSkill = skill;}
    public int getDropSkill() { return _dropSkill;}

    public void setPlugDied(int died) { _plugDied = died;}
    public int getPlugDied() { return _plugDied;}
}
