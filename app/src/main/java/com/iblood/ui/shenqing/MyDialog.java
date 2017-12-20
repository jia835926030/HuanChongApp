package com.iblood.ui.shenqing;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;

import com.iblood.R;
import com.iblood.ui.PlayApForActivity;

public class MyDialog extends Dialog implements OnClickListener {

	public MyDialog(Context context) {
		super(context, R.style.myDialog);
		//��ʼ������
				setContentView(R.layout.layout_select_photo);
				Window dialogWindow = getWindow();
		        dialogWindow.setLayout(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
				dialogWindow.setGravity(Gravity.BOTTOM);
		        setCanceledOnTouchOutside(true);

				findViewById(R.id.btn_camera).setOnClickListener(this);
				findViewById(R.id.btn_gallery).setOnClickListener(this);
				findViewById(R.id.btn_cancel).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_camera:
			onButtonClickListener.camera();
			break;
		case R.id.btn_gallery:
			onButtonClickListener.gallery();
			break;
		case R.id.btn_cancel:
			onButtonClickListener.cancel();
			break;

		default:
			break;
		}
	}
	/**
	 * ��ť�ļ�����
	 * @author Orathee
	 * @date 2014��3��20�� ����4:28:39
	 */
	public interface OnButtonClickListener{
		void camera();
		void gallery();
		void cancel();
	}
	private OnButtonClickListener onButtonClickListener;

	public OnButtonClickListener getOnButtonClickListener() {
		return onButtonClickListener;
	}

	public void setOnButtonClickListener(PlayApForActivity onButtonClickListener) {
		this.onButtonClickListener = onButtonClickListener;
	}

}
