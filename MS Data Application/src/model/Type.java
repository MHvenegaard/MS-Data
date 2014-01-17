package model;

/**
 * @author Marc Hvenegaard, Mikkel Bloch & Nikolaj Nielsen
 * @version 1.4
 */
public class Type {

    private int typeID;
    private String typeName;

    /**
     * Creates an object of Type
     *
     * @param typeID
     * @param typeName
     */
    public Type(int typeID, String typeName) {
        this.typeID = typeID;
        this.typeName = typeName;
    }

    /**
     * @return - typeID
     */
    public int getTypeID() {
        return typeID;
    }

    /**
     * @param typeID
     */
    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    /**
     * @return - typeName
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * @param typeName
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * @return - typeName
     */
    @Override
    public String toString() {
        return typeName;
    }

}
