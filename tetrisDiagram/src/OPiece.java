import com.modeliosoft.modelio.javadesigner.annotations.mdl;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("d9de94f8-e3e3-4848-aeb2-610e3e30698f")
public class OPiece extends Shape {
    @mdl.prop
    @objid ("b9b6c008-b1c4-44f7-8eba-be399dc8e7bc")
    private ArrayList<int>[][] O;

    @mdl.propgetter
    private ArrayList<int>[][] getO() {
        // Automatically generated method. Please do not modify this code.
        return this.O;
    }

    @mdl.propsetter
    private void setO(ArrayList<int>[][] value) {
        // Automatically generated method. Please do not modify this code.
        this.O = value;
    }

}
