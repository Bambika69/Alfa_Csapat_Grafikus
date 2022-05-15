package GUI.view.panels;

import GUI.view.buttons.RoundedOutlinedButton;
import GUI.view.frames.GameFrame;
import GUI.view.view.View;
import GUI.view.view.VirologistView;
import GUI.view.view.agentView.AgentView;
import GUI.view.view.agentView.VaccineView;
import main.com.teamalfa.blindvirologists.agents.Vaccine;
import main.com.teamalfa.blindvirologists.agents.genetic_code.BearCode;
import main.com.teamalfa.blindvirologists.turn_handler.TurnHandler;
import main.com.teamalfa.blindvirologists.virologist.Virologist;
import main.com.teamalfa.blindvirologists.virologist.backpack.Backpack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class InventoryPanel extends JPanel implements View {
    AgentPanel agentPanel;
    EquipmentPanel equipmentPanel;
    GeneticCodePanel geneticCodePanel;
    ElementPanel elementPanel;

    /**
     * constructs a new inventory panel
     */
    public InventoryPanel() {
        // creating the layout of the panel. creating constraints that will later be manipulated at each element
        setLayout(new GridBagLayout());
        setBackground(Color.GRAY.darker().darker().darker());
        setOpaque(false);
        GridBagConstraints constraints = new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0,
                GridBagConstraints.PAGE_START, GridBagConstraints.NONE, new Insets(3, 0, 3, 0), 0, 0);


        // creating the title of the panel
        JLabel title = new JLabel("Inventory");
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Viner Hand ITC", Font.PLAIN, 15));
        title.setForeground(Color.RED);
        add(title, constraints);


        // Creating bag panels
        agentPanel = new AgentPanel(TurnHandler.getActiveVirologist().getBackpack().getAgentPocket());
        equipmentPanel = new EquipmentPanel(TurnHandler.getActiveVirologist().getBackpack().getEquipmentPocket());
        geneticCodePanel = new GeneticCodePanel(TurnHandler.getActiveVirologist().getBackpack().getGeneticCodePocket());

        // Creating the panel that will hold the bag panels
        JPanel bagPanelsPanel = new JPanel();
        bagPanelsPanel.setOpaque(false);
        GridLayout gridLayout = new GridLayout(1, 3);
        gridLayout.setHgap(20);
        gridLayout.setVgap(0);
        bagPanelsPanel.setLayout(gridLayout);

        // adding bag panels
        bagPanelsPanel.add(agentPanel);
        bagPanelsPanel.add(equipmentPanel);
        bagPanelsPanel.add(geneticCodePanel);

        // making the master panel scrollable by adding it to a scroll pane
        JScrollPane scrollPane = new JScrollPane(bagPanelsPanel);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        // manipulating the constraints and then adding the scrollable pane
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 20, 0, 20);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weighty = 1.0;
        add(scrollPane, constraints);


        // create the panel displaying the elements
        elementPanel = new ElementPanel(TurnHandler.getActiveVirologist().getBackpack().getElementBank());

        // adding the panel to the parent panel
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.weighty = 0.0;
        add(elementPanel, constraints);

        // create a new button to rob
        JButton rob = new RoundedOutlinedButton("Rob highlighted virologist");
        rob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VirologistView targetView = GameFrame.getHighlightedVirologistView();
                if (targetView != null) {
                    Virologist target = targetView.getVirologist();
                    System.out.println("itt vagyok");
                    JOptionPane dialog = new RobOptionPane(TurnHandler.getActiveVirologist().rob(target));
                    dialog.setVisible(true);
                }
            }
        });

        // adding it to the panel
        constraints.gridy = 3;
        add(rob, constraints);

    }

    /**
     * Prints the panel: makes the background have rounded corners.
     * @param g -  i have no idea what this is... :(
     */
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(getBackground());
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
        g2.dispose();

        //also call the original jpanl paint method
        super.paint(g);
    }

    /**
     * fill the invetory gui with the items in the backpack of the current virologist
     */
    public void update() {
        Backpack bp = TurnHandler.getActiveVirologist().getBackpack();

        agentPanel.setAgentPocket(bp.getAgentPocket());
        agentPanel.update();

        elementPanel.setElementBank(bp.getElementBank());
        elementPanel.update();

        equipmentPanel.setEquipmentPocket(bp.getEquipmentPocket());
        equipmentPanel.update();

        geneticCodePanel.setGeneticCodePocket(bp.getGeneticCodePocket());
        geneticCodePanel.update();
    }

    public void onClick() {
        //TODO
    }

}
