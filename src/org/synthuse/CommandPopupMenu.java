/*
 * Copyright 2014, Synthuse.org
 * Released under the Apache Version 2.0 License.
 *
 * last modified by ejakubowski
*/

package org.synthuse;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JMenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CommandPopupMenu extends JPopupMenu {
	
	public static interface menuEvents {
		void menuItemClicked(String command, int paramCount, boolean useXpath, ActionEvent e);
	}
	public menuEvents events = new menuEvents() {
		public void menuItemClicked(String command, int paramCount, boolean useXpath, ActionEvent e) {
			JOptionPane.showMessageDialog(null, command);
		}
	};
	
	public CommandPopupMenu() {
		
		JMenu mnKeyboard = new JMenu("Keyboard");
		add(mnKeyboard);
		
		CommandMenuItem mntmSendkeys = new CommandMenuItem("sendKeys", 2, false);
		mnKeyboard.add(mntmSendkeys);
		
		CommandMenuItem mntmKeydown = new CommandMenuItem("keyDown", 2, false);
		mnKeyboard.add(mntmKeydown);
		
		CommandMenuItem mntmKeyup = new CommandMenuItem("keyUp", 2, false);
		mnKeyboard.add(mntmKeyup);
		
		CommandMenuItem mntmKeycopy = new CommandMenuItem("keyCopy", 1);
		mnKeyboard.add(mntmKeycopy);
		
		CommandMenuItem mntmKeypaste = new CommandMenuItem("keyPaste", 1);
		mnKeyboard.add(mntmKeypaste);
		
		CommandMenuItem mntmKeyEsc = new CommandMenuItem("keyEscape", 1);
		mnKeyboard.add(mntmKeyEsc);
		
		CommandMenuItem mntmKeyFunc = new CommandMenuItem("keyFunctionX", 2, false);
		mnKeyboard.add(mntmKeyFunc);
		
		JMenu mnMouse = new JMenu("Mouse");
		add(mnMouse);
		
		CommandMenuItem mntmClick = new CommandMenuItem("click", 1, false);
		mnMouse.add(mntmClick);
		
		CommandMenuItem mntmDoubleclick = new CommandMenuItem("doubleClick", 1, false);
		mnMouse.add(mntmDoubleclick);

		CommandMenuItem mntmRightclick = new CommandMenuItem("rightClick", 1, false);
		mnMouse.add(mntmRightclick);

		CommandMenuItem mntmwinClick = new CommandMenuItem("winClick", 2);
		mnMouse.add(mntmwinClick);
		
		CommandMenuItem mntmwinDoubleClick = new CommandMenuItem("winDoubleClick", 2);
		mnMouse.add(mntmwinDoubleClick);

		CommandMenuItem mntmwinRightClick = new CommandMenuItem("winRightClick", 2);
		mnMouse.add(mntmwinRightClick);

		CommandMenuItem mntmDraganddrop = new CommandMenuItem("dragAndDrop", 3);
		mnMouse.add(mntmDraganddrop);
		
		CommandMenuItem mntmMousedown = new CommandMenuItem("mouseDown", 1, false);
		mnMouse.add(mntmMousedown);
		
		CommandMenuItem mntmMouseup = new CommandMenuItem("mouseUp", 1, false);
		mnMouse.add(mntmMouseup);
		
		CommandMenuItem mntmMousedownright = new CommandMenuItem("mouseDownRight", 1, false);
		mnMouse.add(mntmMousedownright);
		
		CommandMenuItem mntmMouseupright = new CommandMenuItem("mouseUpRight", 1, false);
		mnMouse.add(mntmMouseupright);
		
		CommandMenuItem mntmMousemove = new CommandMenuItem("mouseMove", 3, false);
		mnMouse.add(mntmMousemove);
		
		JMenu mnWinMessages = new JMenu("Win Messages");
		add(mnWinMessages);
		
		CommandMenuItem mntmWindowfocus = new CommandMenuItem("windowFocus", 2);
		mnWinMessages.add(mntmWindowfocus);
		
		CommandMenuItem mntmWindowSwitchToThis = new CommandMenuItem("windowSwitchToThis", 2);
		mnWinMessages.add(mntmWindowSwitchToThis);
		
		CommandMenuItem mntmSetcursorposition = new CommandMenuItem("setCursorPosition", 3);
		mnWinMessages.add(mntmSetcursorposition);
		
		CommandMenuItem mntmWindowminimize = new CommandMenuItem("windowMinimize", 2);
		mnWinMessages.add(mntmWindowminimize);
		
		CommandMenuItem mntmWindowmaximize = new CommandMenuItem("windowMaximize", 2);
		mnWinMessages.add(mntmWindowmaximize);
		
		CommandMenuItem mntmWindowrestore = new CommandMenuItem("windowRestore", 2);
		mnWinMessages.add(mntmWindowrestore);
		
		CommandMenuItem mntmWindowhide = new CommandMenuItem("windowHide", 2);
		mnWinMessages.add(mntmWindowhide);
		
		CommandMenuItem mntmWindowshow = new CommandMenuItem("windowShow", 2);
		mnWinMessages.add(mntmWindowshow);
		
		CommandMenuItem mntmWindowclose = new CommandMenuItem("windowClose", 2);
		mnWinMessages.add(mntmWindowclose);
		
		CommandMenuItem mntmSetwindowtext = new CommandMenuItem("setWindowText", 3);
		mnWinMessages.add(mntmSetwindowtext);

		CommandMenuItem mntmGetwindowtext = new CommandMenuItem("getWindowText", 2);
		mnWinMessages.add(mntmGetwindowtext);
		
		CommandMenuItem mntmGetwindowclass = new CommandMenuItem("getWindowClass", 2);
		mnWinMessages.add(mntmGetwindowclass);
		
		CommandMenuItem mntmPause = new CommandMenuItem("pause", 2, false);
		add(mntmPause);
		
		CommandMenuItem mntmWaitfortitle = new CommandMenuItem("waitForTitle", 2, false);
		add(mntmWaitfortitle);
		
		CommandMenuItem mntmWaitfortext = new CommandMenuItem("waitForText", 2, false);
		add(mntmWaitfortext);
		
		CommandMenuItem mntmWaitforclass = new CommandMenuItem("waitForClass", 2, false);
		add(mntmWaitforclass);
		
		CommandMenuItem mntmWaitforvisible = new CommandMenuItem("waitForVisible", 2);
		add(mntmWaitforvisible);
		
		CommandMenuItem mntmSettimeout = new CommandMenuItem("setTimeout", 2, false);
		add(mntmSettimeout);
		
		CommandMenuItem mntmSetspeed = new CommandMenuItem("setSpeed", 2, false);
		add(mntmSetspeed);
	}
	
	class CommandMenuItem extends JMenuItem {
		public String commandText = "";
		public int paramCount = 2;
		public boolean useXpath = true;
		
		public CommandMenuItem(String arg0, int paramCount) {
			super(arg0);
			init(arg0, paramCount, true);
		}
		
		public CommandMenuItem(String arg0, int paramCount, boolean useXpath) {
			super(arg0);
			init(arg0, paramCount, useXpath);
		}
		
		public void init(String arg0, int paramCount, boolean useXpath) {
			this.commandText = arg0;
			this.paramCount = paramCount;
			this.useXpath = useXpath;
			this.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					events.menuItemClicked(commandText, CommandMenuItem.this.paramCount, CommandMenuItem.this.useXpath, e);
				}
			});
		}
	}
	
	public static String buildSkeletonCommand(String command, int paramCount, String xpathStr, boolean useXpath) {
		String xpathItem = xpathStr;
		if (!useXpath)
			xpathItem = "";
		String actionStr = "| do | " + command + " | ";
		if (paramCount > 1)
			actionStr += "on | " + xpathItem + " | ";
		if (paramCount > 2)
			actionStr += "with |  |";
		return actionStr;
	}
}
