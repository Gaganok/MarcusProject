package listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import service.DIService;

public class MarcusKeyboardListener implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		DIService.update = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		DIService.update = false;
	}

}
