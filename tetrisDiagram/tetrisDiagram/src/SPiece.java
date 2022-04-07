import com.modeliosoft.modelio.javadesigner.annotations.mdl;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("caa6afec-1bdd-4830-8ee9-2210978ed361")
public class SPiece extends Shape {
    @mdl.prop
    @objid ("d40000c1-2289-4797-8933-f22af634d5b9")
    private ArrayList<int>[][] S;

    @mdl.propgetter
    public ArrayList<int>[][] getS() {
        // Automatically generated method. Please do not modify this code.
        return this.S;
    }

    @mdl.propsetter
    public void setS(ArrayList<int>[][] value) {
        // Automatically generated method. Please do not modify this code.
        this.S = value;
    }

    @objid ("14039de2-ffac-43ac-a244-0ada8ee3c9c6")
    public SPiece() {
    }

}
