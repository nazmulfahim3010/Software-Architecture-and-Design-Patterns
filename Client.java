class JSON {
    public JSON(String data) {
    }

    XML convertToXML() {
        return new XML("Stringfied JSON data");
    }
}

class XML {
    public XML(String data) {
        System.out.println(data);
    }
}

interface IAdapter {
    XML convert(JSON json);
}

class JsonToXmlAdapter implements IAdapter {
    private JSON json;

    public JsonToXmlAdapter(JSON json) {
        this.json = json;
    }

    @Override
    public XML convert(JSON json) {
        return json.convertToXML();
    }
}

public class Client {
    public static void main(String[] args) {
        JSON json = new JSON("json data");
    }
}