/*********************************************************************************
 *  TotalCross Software Development Kit                                          *
 *  Copyright (C) 2000-2012 SuperWaba Ltda.                                      *
 *  All Rights Reserved                                                          *
 *                                                                               *
 *  This library and virtual machine is distributed in the hope that it will     *
 *  be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of    *
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.                         *
 *                                                                               *
 *  This file is covered by the GNU LESSER GENERAL PUBLIC LICENSE VERSION 3.0    *
 *  A copy of this license is located in file license.txt at the root of this    *
 *  SDK or can be downloaded here:                                               *
 *  http://www.gnu.org/licenses/lgpl-3.0.txt                                     *
 *                                                                               *
 *********************************************************************************/

package totalcross.sample.components.phone;

import totalcross.io.IOException;
import totalcross.phone.Dial;
import totalcross.sample.util.Colors;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Edit;
import totalcross.ui.PushButtonGroup;
import totalcross.ui.Spacer;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.font.Font;

public class PhoneDialerSample extends Container {
  private PushButtonGroup pbg;
  private  Edit ed;
  private Button dial;

  @Override
  public void initUI() {
    super.initUI();
    setBackForeColors(Colors.BACKGROUND, Colors.ON_BACKGROUND);
    Font big = Font.getFont(true, Font.NORMAL_SIZE + 2);
    ed = new Edit();
    ed.setFont(Font.getFont(true, Font.NORMAL_SIZE * 2));
    ed.setEnabled(false);
    ed.alignment = CENTER;
    add(ed, LEFT, TOP, FILL, SCREENSIZE+8);
    
    add(new Spacer(),LEFT, AFTER, 1, SCREENSIZE+5);

    pbg = new PushButtonGroup(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "P", "0", " << " }, 5, 4);
    pbg.setFont(big);
    add(pbg, CENTER, AFTER, SCREENSIZE + 80, SCREENSIZE+65);
    pbg.setFocusLess(true);
    add(new Spacer(),LEFT, AFTER, 1, SCREENSIZE+2);
    dial = new Button("Dial");
    dial.setFont(big);
    add(dial, CENTER, AFTER, SCREENSIZE+30, SCREENSIZE+10);
    dial.setBackForeColors(Colors.P_600, Colors.ON_P_600);
  }

  @Override
  public void onEvent(Event e) {
    switch (e.type) {
    case ControlEvent.PRESSED:
      if (e.target == pbg) {
        switch (pbg.getSelectedIndex()) {
        case 11:
          if (ed.getLength() > 0) {
            ed.setText(ed.getText().substring(0, ed.getText().length() - 1));
          }
          break;
        case -1:
          break;
        default:
          String s = pbg.getSelectedItem();
          ed.setText(ed.getText() + s);
          break;
        }
        dial.setEnabled(ed.getLength() > 0);
      } else if (e.target == dial) {
        try {
          Dial.number(ed.getText());
        } catch (IOException ex) {
          MessageBox.showException(ex, true);
        }
      }
    }
  }
}
