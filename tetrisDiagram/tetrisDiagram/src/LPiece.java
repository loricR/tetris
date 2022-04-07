import com.modeliosoft.modelio.javadesigner.annotations.mdl;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("37fd9f6f-0665-41a0-9e9c-ca663239b4bf")
public class LPiece extends Shape {
    @mdl.prop
    @objid ("34f3d58b-f688-4ab1-84b6-efe7c4f94ac7")
    private ArrayList<int>[][] L;

    @mdl.propgetter
    private ArrayList<int>[][] getL() {
        // Automatically generated method. Please do not modify this code.
        return this.L;
    }

    @mdl.propsetter
    private void setL(ArrayList<int>[][] value) {
        // Automatically generated method. Please do not modify this code.
        this.L = value;
    }

    @objid ("f28ee5e6-e282-4bf7-9522-9285744af652")
    public LPiece() {
    }

}
