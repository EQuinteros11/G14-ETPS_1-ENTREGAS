package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.utilidades;

public class utilidades {


  // CONSTANTES CAMPOS TABLA DATOS_USUARIO
    public static String TABLA_DATOS_USUARIO ="mtn_datos_usuario";
    public static String CAMPO_ID_DU ="ID_DU";
    public static String CAMPO_NOMBRE ="NOMBRE";
    public static String CAMPO_APELLIDOS ="APELLIDOS";
    public static String CAMPO_EDAD ="EDAD";
    public static String CAMPO_CORREO ="CORREO";


    public static final String CREAR_TABLA_DATOS_USUARIO="CREATE TABLE "+TABLA_DATOS_USUARIO+"("+CAMPO_ID_DU+" INTEGER PRIMARY KEY AUTOINCREMENT," +
            " "+CAMPO_NOMBRE+" TEXT,"+CAMPO_APELLIDOS+" TEXT, "+CAMPO_EDAD+" TEXT, "+CAMPO_CORREO+" TEXT)";

    // FIN DE BLOQUE TABLA DATOS_USUARIO

    //CONSTANTES CAMPOS TABLA USUARIO

    public static String TABLA_USUARIO ="mtn_usuario";
    public static String CAMPO_ID_USER ="ID_USER";
    public static String CAMPO_USER_NICKNAME ="USER_NICKNAME";
    public static String CAMPO_PASS ="PASS";
    public static String CAMPO_ROL ="ROL";

    public static String CAMPO_FK_ID_DU ="ID_DU";

    public static final String CREAR_TABLA_USUARIO="CREATE TABLE "+TABLA_USUARIO+"("+CAMPO_ID_USER+" TEXT PRIMARY KEY," +
            " "+CAMPO_USER_NICKNAME+" TEXT, "+CAMPO_PASS+" TEXT,"+CAMPO_ROL+" TEXT, "+CAMPO_FK_ID_DU+" TEXT, " +
            " FOREIGN KEY("+CAMPO_FK_ID_DU+") REFERENCES "+TABLA_DATOS_USUARIO+"("+CAMPO_ID_DU+") )";

  // FIN BLOQUE TABLA USUARIO

    // CONSTANTES CAMPOS TABLA MEDICAMENTO

    public static String TABLA_MEDICAMENTO ="ctl_medicamento";
    public static String CAMPO_ID_MEDICA ="ID_MEDICA";
    public static String CAMPO_NOMBRE_MEDICA ="NOMBRE_MEDICA";
    public static String CAMPO_CANTIDAD ="CANTIDAD";
    public static String CAMPO_UM ="UM";

    public static final String CREAR_TABLA_MEDICAMENTO="CREATE TABLE "+TABLA_MEDICAMENTO+"("+CAMPO_ID_MEDICA+" INTEGER PRIMARY KEY AUTOINCREMENT," +
            ""+CAMPO_NOMBRE_MEDICA+" TEXT, "+CAMPO_CANTIDAD+" REAL, "+CAMPO_UM+" TEXT)";

    // FIN DE BLOQUE TABLA DATOS_USUARIO

    // CONSTANTES CAMPOS TABLA CAT_MEDICA

    public static String TABLA_CAT_MEDICA ="mnt_cat_medica";
    public static String CAMPO_ID_CAT ="ID_CAT";
    public static String CAMPO_CATE ="CATE";
      public static String CAMPO_FKCATE_ID ="FK_ID_MEDICA";
    public static final String CREAR_TABLA_CAT_MEDICA="CREATE TABLE "+TABLA_CAT_MEDICA+"("+CAMPO_ID_CAT+" INTEGER PRIMARY KEY AUTOINCREMENT," +
          ""+CAMPO_CATE+" TEXT, "+CAMPO_FKCATE_ID+" INTEGER,FOREIGN KEY("+CAMPO_FKCATE_ID+") REFERENCES "+TABLA_MEDICAMENTO+"("+CAMPO_ID_MEDICA+"))";

    // FIN DE BLOQUE TABLA PRECIOS

    // CONSTANTES CAMPOS TABLA DIRECCIONES

    public static String TABLA_DIRECCIONES ="mnt_direcciones";
    public static String CAMPO_ID_DIR="ID_DIR";
    public static String CAMPO_LOCATION="LOCATION";
    public static String CAMPO_DEPARTAMENTO="DEPARTAMENTO";
    public static String CAMPO_MUNICIPIO="MUNICIPIO";
    public static String CAMPO_COMPLEMENTO="COMPLEMENTO";

  public static final String CREAR_TABLA_DIRECCIONES="CREATE TABLE "+TABLA_DIRECCIONES+"("+CAMPO_ID_DIR+" INTEGER PRIMARY KEY AUTOINCREMENT," +
          ""+CAMPO_LOCATION+" TEXT, "+CAMPO_DEPARTAMENTO+" TEXT,"+CAMPO_MUNICIPIO+" TEXT,"+CAMPO_COMPLEMENTO+" TEXT)";

    // FIN DE BLOQUE TABLA PRECIOS
  /*--------------------------------------------------------------------------------------------------------------------------------------*/
    // CONSTANTES CAMPOS TABLA FARMACIAS

    public static String TABLA_FARMACIAS ="mnt_farmacias";
    public static String CAMPO_ID_FAR ="ID_FAR";
    public static String CAMPO_RASON_S ="RASON_S";
    public static String CAMPO_SUCURSAL ="SUCURSAL";
    public static String CAMPO_FK_ID_DIR ="ID_DIR";

    public static final String CREAR_TABLA_FARMACIAS="CREATE TABLE "+TABLA_FARMACIAS+"("+CAMPO_ID_FAR+" INTEGER PRIMARY KEY AUTOINCREMENT," +
          ""+CAMPO_RASON_S+" TEXT, "+CAMPO_SUCURSAL+" TEXT,"+CAMPO_FK_ID_DIR+" INTEGER,"+
            "FOREIGN KEY("+CAMPO_FK_ID_DIR+") REFERENCES "+TABLA_DIRECCIONES+"("+CAMPO_ID_DIR+"))";

    // FIN DE BLOQUE TABLA FARMACIAS
  /*--------------------------------------------------------------------------------------------------------------------------------------*/
  // CONSTANTES CAMPOS TABLA FARMACIAS_DETALLE

  public static String TABLA_FARMACIAS_DETALLE ="mnt_farmacias_detalle";
  public static String CAMPO_ID_FAR_DET ="ID_FAR_DET";
  public static String CAMPO_FK_ID_CAT_DET ="ID_CAT_DET";
  public static String CAMPO_FK_ID_MEDICA_DET ="ID_MEDICA_DET";
  public static String CAMPO_CANTIDAD_DET ="CANTIDAD_DET";
  public static String CAMPO_PRECIO_DET ="CANTIDAD_DET";


  public static final String CREAR_TABLA_FARMACIA_DETALLE ="CREATE TABLE "+TABLA_FARMACIAS_DETALLE+"("+CAMPO_ID_FAR_DET+" INTEGER PRIMARY KEY AUTOINCREMENT," +
          ""+CAMPO_FK_ID_CAT_DET+" INTEGER, "+CAMPO_FK_ID_MEDICA_DET+" INTEGER,"+CAMPO_CANTIDAD_DET+" REAL, "+CAMPO_PRECIO_DET+" REAL "+
          "FOREIGN KEY("+CAMPO_FK_ID_CAT_DET+") REFERENCES "+TABLA_CAT_MEDICA+"("+CAMPO_ID_CAT+")," +
          "FOREIGN KEY("+CAMPO_FK_ID_MEDICA_DET+") REFERENCES "+TABLA_MEDICAMENTO+"("+CAMPO_ID_MEDICA+") )";

  // FIN DE BLOQUE TABLA FARMACIAS














}
