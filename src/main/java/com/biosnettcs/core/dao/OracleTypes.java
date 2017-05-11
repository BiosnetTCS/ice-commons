package com.biosnettcs.core.dao;

/**
 * <p>Constantes para tipos de datos de Oracle.<br/>
 * <b>Declaradas para eliminar dependencias hacia el driver JDBC Oracle.<b/>
 * <p/>
 */
public class OracleTypes {
    
    public static final int TIMESTAMPNS = -100;

    public static final int TIMESTAMPTZ = -101;

    public static final int TIMESTAMPLTZ = -102;

    public static final int INTERVALYM = -103;

    public static final int INTERVALDS = -104;

    public static final int CURSOR = -10;

    public static final int BFILE = -13;

    public static final int OPAQUE = 2007;

    public static final int JAVA_STRUCT = 2008;

    public static final int PLSQL_INDEX_TABLE = -14;

    public static final int BINARY_FLOAT = 100;

    public static final int BINARY_DOUBLE = 101;

    public static final int NUMBER = 2;

    public static final int RAW = -2;

    public static final int FIXED_CHAR = 999;

}