import com.modeliosoft.modelio.javadesigner.annotations.mdl;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("4e255721-56f4-475f-8dd4-e930b1dee007")
public class Shape {
    @mdl.prop
    @objid ("c5daa787-cbe1-48ce-bb55-83e574d86235")
    private String JavaProperty;

    @mdl.propgetter
    public String getJavaProperty() {
        // Automatically generated method. Please do not modify this code.
        return this.JavaProperty;
    }

    @mdl.propsetter
    public void setJavaProperty(String value) {
        // Automatically generated method. Please do not modify this code.
        this.JavaProperty = value;
    }

    @objid ("6cd8aecc-5bdd-4f88-b11c-1c9ee6caf761")
    public void rotate() {
    }

    @objid ("02bc7105-0ee6-46d1-aa6f-ec6f54ed8d07")
    public void move() {
    }

}
