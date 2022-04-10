import com.modeliosoft.modelio.javadesigner.annotations.mdl;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("2620fa3e-2b2c-44a2-b22d-55a9ddd68c7d")
public class TPiece extends Shape {
    @mdl.prop
    @objid ("b4e1ed36-4e60-414a-8ff0-c4e9c658cb3f")
    private ArrayList<int>[][] T;

    @mdl.propgetter
    private ArrayList<int>[][] getT() {
        // Automatically generated method. Please do not modify this code.
        return this.T;
    }

    @mdl.propsetter
    private void setT(ArrayList<int>[][] value) {
        // Automatically generated method. Please do not modify this code.
        this.T = value;
    }

}
