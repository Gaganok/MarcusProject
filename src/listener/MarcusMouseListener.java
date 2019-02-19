package listener;

import java.awt.Button;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javafx.scene.control.ButtonType;
import service.DIService;

public class MarcusMouseListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			DIService.spriteIndex++;
		} else if(e.getButton() == MouseEvent.BUTTON3) {
			DIService.spriteIndex += 10;
		}
		System.out.println(DIService.spriteIndex);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
