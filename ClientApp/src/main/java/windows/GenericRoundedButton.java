package windows;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;

public class GenericRoundedButton extends JButton {

	public GenericRoundedButton(String title) {
		super(title);
		init();
	}

	private void init() {
		setForeground(new Color(33, 82, 151));
		setBackground(new Color(248, 209, 23));
		setFocusable(false);
	}

	public void paint(Graphics g) {

		this.setContentAreaFilled(false);
		this.setBorderPainted(false);

		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		super.paint(g);

		// Colocando as cores do banco do brasil

		g2d.setColor(new Color(248, 209, 23));
		g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 18, 18);
		g2d.setColor(new Color(33, 82, 151));
		g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 18, 18);

		FontRenderContext frc = new FontRenderContext(null, false, false);
		Rectangle2D r = getFont().getStringBounds(getText(), frc);

		float xMargin = (float) (getWidth() - r.getWidth()) / 2;
		float yMargin = (float) (getHeight() - getFont().getSize()) / 2;

		g2d.drawString(getText(), xMargin, (float) getFont().getSize() + yMargin);
	}
}