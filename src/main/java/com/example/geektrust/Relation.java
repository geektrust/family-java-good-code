package com.example.geektrust;

public enum Relation {
    Son("Son"),
    Daughter("Daughter"),
    Siblings("Siblings"),
    Paternal_Uncle("Paternal-Uncle"),
    Maternal_Uncle("Maternal-Uncle"),
    Maternal_Aunt("Maternal-Aunt"),
    Paternal_Aunt ("Paternal-Aunt"),
    Sister_In_Law ("Sister-In-Law"),
    Brother_In_Law("Brother-In-Law");

    final String relation;
    Relation(String relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return this.relation;
    }

    public static Relation getValue(String value) {
        for (Relation r : values()){
            if (value.equalsIgnoreCase(r.toString())){
                return r;
            }
        }
        throw new IllegalArgumentException();
    }
}
