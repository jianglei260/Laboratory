package cn.edu.cuit.liyun.laboratory;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kelin.mvvmlight.command.ReplyCommand;
import com.myworld.ide.struct.annotation.Extends;
import com.myworld.ide.struct.annotation.NewInterface;
import com.myworld.ide.struct.annotation.NewObservable;
import com.myworld.ide.struct.annotation.OpMethod;
import com.myworld.ide.struct.external.model.DetailVMModel;
import com.myworld.ide.struct.external.model.ListVMModel;
import com.myworld.ide.struct.external.model.LoaddingVMModel;
import com.myworld.ide.struct.external.model.MainActivityModel;
import com.myworld.ide.struct.model.ActivityModel;
import com.myworld.ide.struct.model.FragmentModel;
import com.myworld.ide.struct.model.PackageModel;
import com.myworld.ide.struct.model.VMModel;
import com.myworld.ide.struct.op.FieldObject;
import com.myworld.ide.struct.op.GoToOp;
import com.myworld.ide.struct.op.Op;
import com.myworld.ide.struct.op.Widget;

import cn.edu.cuit.liyun.laboratory.base.BaseActivity;

/**
 * Created by jianglei on 2017/4/15.
 */

public class StructConfig {
    PackageModel login = new PackageModel() {
        @Extends(BaseActivity.class)
        ActivityModel userLogin = new ActivityModel() {
            @Override
            public VMModel[] getVmModels() {
                return new VMModel[]{login};
            }
        };
        LoaddingVMModel login = new LoaddingVMModel() {
            Widget<TextView> titleText, signUpText;
            Widget<EditText> accountEdit, passwordEdit;
            Widget<TextView> loginButton;
            @NewObservable
            FieldObject<String> account, password;
            @NewInterface
            FieldObject<View.OnClickListener> loginClick;
            @NewInterface
            FieldObject<View.OnClickListener> signClick;
            @OpMethod
            public void initModel() {
                super.init();
//                  Binder.textView(titleText).text("\"用户登录\"");
                Binder.textView(signUpText).onClick(signClick);
                Binder.textView(loginButton).onClick(loginClick);
                Binder.editText(accountEdit).text(account);
                Binder.editText(passwordEdit).text(password);
                Op.command(signClick, GoToOp.go(userSign));

            }

        };
        @Extends(BaseActivity.class)
        ActivityModel userSign = new ActivityModel() {
            @Override
            public VMModel[] getVmModels() {
                return new VMModel[]{signUp};
            }

        };
        DetailVMModel signUp = new DetailVMModel() {
            Widget<TextView> titleText, signUpText;
            Widget<EditText> accountEdit, passwordEdit;
            @NewObservable
            FieldObject<String> account, password;
            @NewInterface
            FieldObject<View.OnClickListener> signClick;
            @OpMethod
            public void initModel() {
                super.init();
//                  Binder.textView(titleText).text("\"用户登录\"");
                Binder.textView(signUpText).onClick(signClick);
                Binder.editText(accountEdit).text(account);
                Binder.editText(passwordEdit).text(password);
            }

        };



    };
    PackageModel main = new PackageModel() {
    };

}
