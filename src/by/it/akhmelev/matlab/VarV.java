package by.it.akhmelev.matlab;

import java.util.Arrays;

/**
 * Created by user on 09.09.2016.
 */
public class VarV extends Var {
    public double[] value;


    public VarV(double[] value) {
        this.value=new double[value.length];
        //System.arraycopy(value,0,this.value,0,value.length);
        for (int i = 0; i < value.length; i++) {
            this.value[i]=value[i];
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(value);
    }

    @Override
    public Var add(VarF v) {
        VarV res=new VarV(value);
        for (int i = 0; i < res.value.length; i++) {
            res.value[i]=res.value[i]+v.value;
        }
        return res;
    }

    @Override
    public Var add(VarV v) {
        if (this.value.length==v.value.length) {
            VarV res=new VarV(value);
            for (int i = 0; i < res.value.length; i++) {
                res.value[i]=res.value[i]+v.value[i];
            }
            return res;
        }
        else
        {
            Log.print("Разные размеры векторов");
            return null;
        }
    }
}