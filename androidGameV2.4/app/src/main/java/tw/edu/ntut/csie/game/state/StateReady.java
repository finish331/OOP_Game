package tw.edu.ntut.csie.game.state;

import java.util.Map;

import tw.edu.ntut.csie.game.Game;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.engine.GameEngine;
import tw.edu.ntut.csie.game.extend.BitmapButton;
import tw.edu.ntut.csie.game.extend.ButtonEventHandler;

public class StateReady extends AbstractGameState {

    private MovingBitmap _helpInfo;
    private MovingBitmap _aboutInfo;
    private MovingBitmap _background;
    private MovingBitmap _helpInfo_2;

    private BitmapButton _exitButton;
    private BitmapButton _helpButton;
    private BitmapButton _menuButton;
    private BitmapButton _aboutButton;
    private BitmapButton _startButton;
    private BitmapButton _nextButton;
    private BitmapButton _prevButton;

    private boolean _showHelp;
    private boolean _showAbout;
    private boolean _page2;

    public StateReady(GameEngine engine) {
        super(engine);
    }

    @Override
    public void initialize(Map<String, Object> data) {
        addGameObject(_helpInfo = new MovingBitmap(R.drawable.help_info));
        addGameObject(_background = new MovingBitmap(R.drawable.state_ready));
        addGameObject(_aboutInfo = new MovingBitmap(R.drawable.about_info));
        addGameObject(_helpInfo_2 = new MovingBitmap(R.drawable.help_info_2));
        initializeStartButton();
        initializeExitButton();
        initializeMenuButton();
        initializeHelpButton();
        initializeAboutButton();
        initializeNextButton();
        initializePrevButton();
        setVisibility(false, false,false);
    }

    /**
     * ��l�ơyAbout�z�����s�C
     */
    // �}�o²��
    private void initializeAboutButton() {
        addGameObject(_aboutButton = new BitmapButton(R.drawable.about, R.drawable.about_pressed, 465, 270));
        _aboutButton.addButtonEventHandler(new ButtonEventHandler() {
            @Override
            public void perform(BitmapButton button) {
                setVisibility(false, true,false);
            }
        });
        addPointerEventHandler(_aboutButton);
    }

    /**
     * ��l�ơyHelp�z�����s�C
     */
    // �C������
    private void initializeHelpButton() {
        addGameObject(_helpButton = new BitmapButton(R.drawable.help, R.drawable.help_pressed, 465, 220));
        _helpButton.addButtonEventHandler(new ButtonEventHandler() {
            @Override
            public void perform(BitmapButton button) {
                setVisibility(true, false,false);
            }
        });
        addPointerEventHandler(_helpButton);
    }

    /**
     * ��l�ơyMenu�z�����s�C
     */
    private void initializeMenuButton() {
        addGameObject(_menuButton = new BitmapButton(R.drawable.menu, R.drawable.menu_pressed, 465, 320));
        _menuButton.addButtonEventHandler(new ButtonEventHandler() {
            @Override
            public void perform(BitmapButton button) {
                setVisibility(false, false,false);
            }
        });
        addPointerEventHandler(_menuButton);
    }

    /**
     * ��l�ơyExit�z�����s�C
     */
    private void initializeExitButton() {
        addGameObject(_exitButton = new BitmapButton(R.drawable.exit, R.drawable.exit_pressed, 465, 320));
        _exitButton.addButtonEventHandler(new ButtonEventHandler() {
            @Override
            public void perform(BitmapButton button) {
                _engine.exit();
            }
        });
        addPointerEventHandler(_exitButton);
    }

    /**
     * ��l�ơyStart�z�����s�C
     */
    private void initializeStartButton() {
        addGameObject(_startButton = new BitmapButton(R.drawable.start, R.drawable.start_pressed, 465, 170));
        _startButton.addButtonEventHandler(new ButtonEventHandler() {
            @Override
            public void perform(BitmapButton button) {
                changeState(Game.RUNNING_STATE);
            }
        });
        addPointerEventHandler(_startButton);
    }

    private void initializeNextButton() {
        addGameObject(_nextButton = new BitmapButton(R.drawable.next, R.drawable.next_pressed, 465, 270));
        _nextButton.addButtonEventHandler(new ButtonEventHandler() {
            @Override
            public void perform(BitmapButton button) {
                setVisibility(false, false,true);
            }
        });
        addPointerEventHandler(_nextButton);
    }

    private void initializePrevButton() {
        addGameObject(_prevButton = new BitmapButton(R.drawable.prev, R.drawable.prev_pressed, 465, 270));
        _prevButton.addButtonEventHandler(new ButtonEventHandler() {
            @Override
            public void perform(BitmapButton button) {
                setVisibility(true, false,false);
            }
        });
        addPointerEventHandler(_prevButton);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    /**
     * �]�w�e���W���ǹϤ�����ܡA���ǹϤ������áC
     *
     * @param showHelp  ���Help�e��
     * @param showAbout ���About�e��
     */
    private void setVisibility(boolean showHelp, boolean showAbout, boolean page2) {
        _showHelp = showHelp;
        _showAbout = showAbout;
        _page2 = page2;
        boolean showMenu = !_showAbout && !_showHelp && !_page2;
        _helpInfo.setVisible(_showHelp);
        _aboutInfo.setVisible(_showAbout);
        _helpInfo_2.setVisible(_page2);
        _background.setVisible(showMenu);

        _exitButton.setVisible(showMenu);
        _helpButton.setVisible(showMenu);
        _aboutButton.setVisible(showMenu);
        _startButton.setVisible(showMenu);
        _nextButton.setVisible(_showHelp);
        _menuButton.setVisible(!showMenu);
        _prevButton.setVisible(_page2);
    }
}

