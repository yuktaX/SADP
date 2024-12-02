import java.util.ArrayList;

abstract class Element {

    String name;

    Element(String name){
        this.name = name;
    }

    abstract String show();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class SimpleElement extends Element{

    String body;

    SimpleElement(String name, String body){
        super(name);
        this.body = body;
    }

    public String show(){
        return "<" + this.name + ">" + getBody() + "</" + this.name + ">\n";
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

class ComplexElement extends Element {

    private ArrayList<Element> children;

    ComplexElement(String name) {
        super(name);
        this.children = new ArrayList<Element>();
    }

    public void addChild(Element child) {
        this.children.add(child);
    }

    public String show() {
        String ret;

        ret = "<" + getName() + ">";
        for (int i = 0; i < this.children.size(); i++) {
            Element curr = this.children.get(i);
            ret += curr.show();
        }

        ret += "</" + getName() + ">\n";

        return ret;
    }
}

public class XMLDocumentModel {

    Integer id;
    ComplexElement root;

    XMLDocumentModel(Integer id){
        this.id = id;
    }

    void setRoot(ComplexElement croot){
        root = croot;
    }

    public String show(){
        return root.show();
    }

    public static void main(String args[]) {
        ComplexElement e0 = new ComplexElement("Book");

        ComplexElement e1 = new ComplexElement("Chapter-1");
        ComplexElement e11 = new ComplexElement("Section-1.1");
        ComplexElement e12 = new ComplexElement("Section-1.2");
        ComplexElement e13 = new ComplexElement("Section-1.3");
        SimpleElement e111 = new SimpleElement("Section-1.1-Para", "This is a para of Section 1.1");
        //e111.setPara("This is a para of Section 1.1");
        SimpleElement e121 = new SimpleElement("Section-1.2-Para", "This is a para of Section 1.2");
        //e111.setPara("This is a para of Section 1.2");
        SimpleElement e131 = new SimpleElement("Section-1.3-Para", "This is a para of Section 1.3");
        //e111.setPara("This is a para of Section 1.3");


        ComplexElement e2 = new ComplexElement("Chapter-2");
        ComplexElement e21 = new ComplexElement("Section-2.1");
        ComplexElement e22 = new ComplexElement("Section-2.2");
        SimpleElement e211 = new SimpleElement("Section-2.1-Para", "This is a para of Section 2.1");
        //e211.setPara("This is a para of Section 2.1");
        SimpleElement e221 = new SimpleElement("Section-2.2-Para", "This is a para of Section 2.2");
        //e221.setPara("This is a para of Section 2.2");

        XMLDocumentModel demoXML = new XMLDocumentModel(100);
        demoXML.setRoot(e0);
        e0.addChild(e1);
        e0.addChild(e2);

        e1.addChild(e11);
        e1.addChild(e12);
        e1.addChild(e13);

        e2.addChild(e21);
        e2.addChild(e22);

        e11.addChild(e111);
        e12.addChild(e121);
        e13.addChild(e131);

        e21.addChild(e211);
        e22.addChild(e221);

        System.out.print(demoXML.show());
    }
}
//	<Book>
//		<Chapter-1>
//			<Section-1.1>
//				<Section-1.1-Para>This is a para of Section 1.1</Section-1.1-Para>
//			</Section-1.1>
//			<Section-1.2>
//				<Section-1.2-Para>This is a para of Section 1.2</Section-1.2-Para>
//			</Section-1.2>
//			<Section-1.3>
//				<Section-1.3-Para>This is a para of Section 1.1</Section-1.3-Para>
//			</Section-1.3>
//		</Chapter-1>
//		<Chapter-2>
//			<Section-2.1>
//				<Section-2.1-Para>This is a para of Section 2.1</Section-2.1-Para>
//			</Section-2.1>
//			<Section-2.2>
//				<Section-2.2-Para>This is a para of Section 2.2</Section-2.2-Para>
//			</Section-2.2>
//		</Chapter-2>
//	</Book>


