package org.rev317.min.ui;

import org.parabot.core.Context;
import org.parabot.core.paint.PaintDebugger;
import org.rev317.min.debug.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BotMenu implements ActionListener {

    public BotMenu(JMenuBar bar) {
        PaintDebugger debugger = Context.getInstance().getPaintDebugger();

        JMenu debug = new JMenu("Debug");

        JMenuItem inventory = newItem("Inventory");
        JMenuItem bank = newItem("Bank");
        JMenuItem map = newItem("Map");
        JMenuItem animation = newItem("Animation");
        JMenuItem objects = newItem("Objects");
        JMenuItem npcs = newItem("Npcs");
        JMenuItem items = newItem("GroundItems");
        JMenuItem interfaces = newItem("Interfaces");
        JMenuItem flags = newItem("Collision flags");
        JMenuItem actions = newItem("Actions");
        JMenuItem mouse = newItem("Mouse");

        debugger.addDebugger("Actions", new DActions());
        debugger.addDebugger("Animation", new DAnimation());
        debugger.addDebugger("Inventory", new DInventory());
        debugger.addDebugger("Bank", new DBank());
        debugger.addDebugger("Map", new DMap());
        debugger.addDebugger("Objects", new DSceneObjects());
        debugger.addDebugger("Npcs", new DNpcs());
        debugger.addDebugger("GroundItems", new DGroundItems());
        debugger.addDebugger("Interfaces", new DInterfaces());
        debugger.addDebugger("Collision flags", new DCollisionFlags());
        debugger.addDebugger("Mouse", new DMouse());

        debug.add(actions);
        debug.add(map);
        debug.add(animation);
        debug.add(objects);
        debug.add(npcs);
        debug.add(items);
        debug.add(interfaces);
        debug.add(flags);
        debug.add(inventory);
        debug.add(bank);
        debug.add(mouse);

        bar.add(debug);
    }

    private JMenuItem newItem(String name) {
        JMenuItem item = new JCheckBoxMenuItem(name);
        item.addActionListener(this);
        return item;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Context.getInstance().getPaintDebugger().toggle(e.getActionCommand());
    }

}
