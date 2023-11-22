package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import javax.swing.JOptionPane;

import view.MathInterface;

public class MathController implements ActionListener  {
	private MathInterface mathView;
	private Integer constant1;
	private Integer constant2;
	private Integer constant3;
	
	public MathController(MathInterface view) {
		mathView = view;
		mathView.getResultBtn().addActionListener(this);
		mathView.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
	}
	
	public MathInterface getMathView() {
		return mathView;
	}

	public void setMathView(MathInterface mathView) {
		this.mathView = mathView;
	}

	public Integer getConstant1() {
		return constant1;
	}

	public void setConstant1(Integer constant1) {
		this.constant1 = constant1;
	}

	public Integer getConstant2() {
		return constant2;
	}

	public void setConstant2(Integer constant2) {
		this.constant2 = constant2;
	}

	public Integer getConstant3() {
		return constant3;
	}

	public void setConstant3(Integer constant3) {
		this.constant3 = constant3;
	}

	public String solveEquation(Integer const1, Integer const2, Integer const3) {
		String ketqua = null;
        
        if (const1 == 0) {
            if (const2 == 0) {
                ketqua = "Phương trình vô nghiệm!";
            } else {
                ketqua = "Phương trình có một nghiệm: " + "x = " + (-const3 / const2);
            }
        }

        float delta = const2*const2 - 4*const1*const3;
        float x1;
        float x2;

        if (delta > 0) {
            x1 = (float) ((-const2 + Math.sqrt(delta)) / (2*const1));
            x2 = (float) ((-const2 - Math.sqrt(delta)) / (2*const1));
            ketqua = "Phương trình có 2 nghiệm là: " + "x1 = " 
            		+ BigDecimal.valueOf(x1).round(new MathContext(3, RoundingMode.HALF_UP))
                    + " và x2 = "
                    + BigDecimal.valueOf(x2).round(new MathContext(3, RoundingMode.HALF_UP));
        } else if (delta == 0) {
            x1 = (-const2 / (2 * const1));
            ketqua = "Phương trình có nghiệm kép: " + "x1 = x2 = " + x1;
        } else {
            ketqua = "Phương trình vô nghiệm!";
        }
         
        return ketqua;
	}
	
	public boolean validateTextInputs() {
		int value = mathView.isBlankValue();
		if (value > 0) {
			if (value == 1) {
				JOptionPane.showMessageDialog(mathView, "Hang so A khong duoc de trong");
			} else if (value == 2) {
				JOptionPane.showMessageDialog(mathView, "Hang so B khong duoc de trong");
			} else if (value == 3) {
				JOptionPane.showMessageDialog(mathView, "Hang so C khong duoc de trong");
			}
			return false;
		}
		return true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (validateTextInputs()) {
			try {
				constant1 = Integer.parseInt(mathView.getContanst1Txt().getText());
				constant2 = Integer.parseInt(mathView.getContanst2Txt().getText());
				constant3 = Integer.parseInt(mathView.getContanst3Txt().getText());
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(mathView, "Hang so phai la so tu nhien");
				System.out.println("cause: " + ex.getCause());
				System.out.println("stack trace" + ex.getStackTrace());
				return;
			}
			mathView.getResultLbl().setText(solveEquation(constant1, constant2, constant3));
		}
	}

}
