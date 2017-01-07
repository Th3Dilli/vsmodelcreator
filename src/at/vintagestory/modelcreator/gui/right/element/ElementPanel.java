package at.vintagestory.modelcreator.gui.right.element;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import at.vintagestory.modelcreator.gui.right.rotation.ElementRotationPanel;
import at.vintagestory.modelcreator.interfaces.IElementManager;
import at.vintagestory.modelcreator.interfaces.IValueUpdater;
import at.vintagestory.modelcreator.model.Element;

public class ElementPanel extends JPanel implements IValueUpdater
{
	private static final long serialVersionUID = 1L;

	private IElementManager manager;

	private ElementSizePanel panelSize;
	private ElementPositionPanel panelPosition;
	private ElementRotationPanel panelRotation;
	private ElementPropertiesPanel panelExtras;
	
	private ModelPropertiesPanel panelGlobal;
	

	public ElementPanel(IElementManager manager)
	{
		this.manager = manager;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initComponents();
		addComponents();
	}

	public void initComponents()
	{
		panelSize = new ElementSizePanel(manager);
		panelPosition = new ElementPositionPanel(manager);
		panelRotation = new ElementRotationPanel(manager);
		panelExtras = new ElementPropertiesPanel(manager);
		panelGlobal = new ModelPropertiesPanel(manager);
		
	}

	public void addComponents()
	{
		add(Box.createRigidArea(new Dimension(188, 5)));
		add(panelSize);
		//add(Box.createRigidArea(new Dimension(188, 5)));
		add(panelPosition);
		//add(Box.createRigidArea(new Dimension(188, 5)));
		add(panelRotation);
		//add(Box.createRigidArea(new Dimension(188, 5)));

		add(panelExtras);
		//add(Box.createRigidArea(new Dimension(188, 5)));

		//add(new JSeparator(JSeparator.HORIZONTAL));
		//add(panelGlobal);
	}

	@Override
	public void updateValues(Element cube)
	{
		panelSize.updateValues(cube);
		panelPosition.updateValues(cube);
		panelExtras.updateValues(cube);
		panelRotation.updateValues(cube);
		//panelGlobal.updateValues(cube);
	}
}
