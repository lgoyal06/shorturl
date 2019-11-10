package com.example.shorter.utils;

public enum SchemaEnum {
    HTTPS("https://"), HTTP("http://"), FTP("ftp://");

    public String getSchemaRegex() {
        return schemaRegex;
    }

    private String schemaRegex;

    SchemaEnum(String s) {
        this.schemaRegex = s;
    }

    public static boolean containsSchemaRegex(String data) {
        for (SchemaEnum schema : SchemaEnum.values()) {
            if (data.contains(schema.getSchemaRegex())) {
                return true;
            }
        }
        return false;
    }
}