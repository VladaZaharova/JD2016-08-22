package by.it.aborisenok.matLab;

/**
 * Created by Лёша on 09.09.2016.
 */
public abstract class Var implements IOperation{


    @Override
    public Var add(Var v) {
        if (v instanceof VarF) return add((VarF) v);
        if (v instanceof VarV) return add((VarV) v);
        if (v instanceof VarM) return add((VarM) v);
        return null;
    }

    public Var add(VarF v){
        Log.print("Сложение со скаляром невозможно");
        return null;
    }

    public Var add(VarV v){
        Log.print("Сложение с вектором невозможно");
        return null;
    }
    public Var add(VarM v){
        Log.print("Сложение с матрицей невозможно");
        return null;
    }

    @Override
    public Var sub(Var v) {
        if (v instanceof VarF) return sub((VarF) v);
        if (v instanceof VarV) return sub((VarV) v);
        if (v instanceof VarM) return sub((VarM) v);
        return null;
    }

    public Var sub(VarF v){
        Log.print("Вычитание со скаляром невозможно");
        return null;
    }
    public Var sub(VarV v){
        Log.print("Вычитание с вектором невозможно");
        return null;
    }
    public Var sub(VarM v){
        Log.print("Вычитание с матрицей невозможно");
        return null;
    }

    @Override
    public Var mul(Var v) {
        if (v instanceof VarF) return mul((VarF) v);
        if (v instanceof VarV) return mul((VarV) v);
        if (v instanceof VarM) return mul((VarM) v);
        return null;
    }

    public Var mul(VarF v){
        Log.print("Перемножение со скаляром невозможно");
        return null;
    }
    public Var mul(VarV v){
        Log.print("Перемножение с вектором невозможно");
        return null;
    }
    public Var mul(VarM v){
        Log.print("Перемножение с матрицей невозможно");
        return null;
    }
}
