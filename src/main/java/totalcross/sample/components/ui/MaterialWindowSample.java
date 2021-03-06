package totalcross.sample.components.ui;

import totalcross.io.IOException;
import totalcross.sample.util.Colors;
import totalcross.sys.Vm;
import totalcross.ui.Button;
import totalcross.ui.Check;
import totalcross.ui.Container;
import totalcross.ui.Edit;
import totalcross.ui.ImageControl;
import totalcross.ui.MaterialWindow;
import totalcross.ui.OutlinedEdit;
import totalcross.ui.Presenter;
import totalcross.ui.ScrollContainer;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;
import totalcross.ui.layout.HBox;
import totalcross.ui.layout.VBox;

public class MaterialWindowSample extends Container {
	@Override
	public void initUI() {
		Button btn1 = new Button("Sign Up");
		btn1.setBackForeColors(Colors.P_500, Colors.ON_P_500);

		this.add(btn1, CENTER, TOP);
		btn1.addPressListener((e) -> {
			final MaterialWindow mw = new MaterialWindow("Sign Up", false, new Presenter() {
				@Override
				public Container getView() {
					return new ScrollContainer() {
						@Override
						public void initUI() {
							VBox layout = new VBox();
							layout.setBackForeColors(Colors.BACKGROUND, Colors.ON_BACKGROUND);
							
							setBackForeColors(Colors.BACKGROUND, Colors.ON_BACKGROUND);
							ImageControl ic = null;
							try {
								ic = new ImageControl(new Image("images/logo.png"));
							} catch (IOException e1) {
								e1.printStackTrace();
							} catch (ImageException e1) {
								e1.printStackTrace();
							}
							ic.scaleToFit = true;
							ic.centerImage = true;
							add(ic, LEFT, TOP + 100, FILL, PARENTSIZE + 30);

							OutlinedEdit outUsu = new OutlinedEdit();
							outUsu.caption = "User";
							outUsu.captionColor = Color.BRIGHT;
							layout.add(outUsu);
							
							OutlinedEdit outPass = new OutlinedEdit();
							outPass.caption = "Password";
							outPass.captionColor = Color.BRIGHT;
							outPass.setMode(Edit.PASSWORD_ALL);
							layout.add(outPass);
							
							OutlinedEdit outPassConf = new OutlinedEdit();
							outPassConf.caption = "Confirm Password";
							outPassConf.captionColor = Color.BRIGHT;
							outPassConf.setMode(Edit.PASSWORD_ALL);
							layout.add(outPassConf);
							
							OutlinedEdit outEmail = new OutlinedEdit();
							outEmail.caption = "Email";
							outEmail.captionColor = Color.BRIGHT;
							layout.add(outEmail);

							HBox hbox = new HBox();
							hbox.add(new Button("Sign Up"));
							hbox.add(new Button("Cancel"));
							hbox.setLayout(HBox.LAYOUT_STACK_CENTER, HBox.ALIGNMENT_CENTER);
							layout.add(hbox);
							
							layout.setSpacing(10);
							add(layout, CENTER, AFTER, PARENTSIZE, PARENTSIZE);
							layout.setLayout(VBox.LAYOUT_STACK_TOP, VBox.ALIGNMENT_CENTER);
						}
					};
				}
			});
			mw.popup();
		});

		Button btn2 = new Button("Sign in");
		btn2.setBackForeColors(Colors.P_500, Colors.ON_P_500);

		this.add(btn2, CENTER, AFTER);
		btn2.addPressListener((e) -> {
			MaterialWindow mw = new MaterialWindow("Sign in", false, new Presenter() {
				@Override
				public Container getView() {
					return new ScrollContainer() {
						@Override
						public void initUI() {
							Edit edPass, edLogin;
							Check ch;
							Button btLogin, btRegister;
							ImageControl ic = null;

							setBackForeColors(Colors.BACKGROUND, Colors.ON_BACKGROUND);
							try {
								ic = new ImageControl(new Image("images/logo.png"));
							} catch (IOException e1) {
								e1.printStackTrace();
							} catch (ImageException e1) {
								e1.printStackTrace();
							}
							ic.scaleToFit = true;
							ic.centerImage = true;
							add(ic, LEFT, TOP + 100, FILL, PARENTSIZE + 30);

							edLogin = new Edit();
							edLogin.caption = "Login";
							add(edLogin, CENTER, AFTER + 60, PARENTSIZE + 90, PREFERRED + 30);

							edPass = new Edit();
							edPass.caption = "Password";
							edPass.setMode(Edit.PASSWORD_ALL);
							add(edPass, SAME, AFTER + 70, PARENTSIZE + 90, PREFERRED + 30);

							ch = new Check("Remember Me");
							add(ch, LEFT + 86, AFTER + 100, PARENTSIZE, PREFERRED + 30);

							btLogin = new Button("Login");
							btLogin.setBackColor(Color.WHITE);
							add(btLogin, CENTER, AFTER + 140, PARENTSIZE + 80, PREFERRED + 60);

							btRegister = new Button("Register Now");
							btRegister.transparentBackground = true;
							btRegister.setBorder(BORDER_NONE);
							add(btRegister, CENTER, AFTER, PARENTSIZE + 30, PREFERRED + 20);
							btRegister.addPressListener(e -> {
								Vm.exec("url", "http://www.totalcross.com", 0, true);
							});

						}
					};
				}
			});
			mw.popup();
		});
	}
}