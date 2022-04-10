package com.example.paycoin.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.paycoin.models.Usuario;

public class BancoSQLite extends SQLiteOpenHelper {

    //parametros
    private static final String NOME_BANCO = "Dados_Usuario.db";
    private static final String ID = "id";
    private static final String NOME = "nome";
    private static final String LOGIN = "login";
    private static final String SENHA = "senha";
    private static final String CPF = "cpf";
    private static final String CONTABANCARIA = "contabancaria";
    private static final String VALORINICIAL = "valorinicial";

    private static final String TABELA = "usuarios";
    private static int VERSAO =1;


    public BancoSQLite(Context context){
        super(context, NOME_BANCO, null, VERSAO);

    }

    @Override
    public void onCreate(SQLiteDatabase db){

        //criação das tabelas
       //CREATE TABLE usuarios ( id INTEREGER PRIMARY KEY AUTOINCREMENT, login TEXT, senha TEXT )

        String CREATE_USUARIOS_TABLE = "CREATE TABLE " + TABELA + " ( " +
                 ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NOME + " TEXT," +
                LOGIN + " TEXT," +
                SENHA + " TEXT," +
                CPF + " TEXT," +
                CONTABANCARIA + " TEXT," +
                VALORINICIAL + " TEXT )";
        db.execSQL(CREATE_USUARIOS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);

    }

    public boolean inserirUsuario(Usuario u){
        long result;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOME, u.getNome());
        values.put(LOGIN, u.getLogin());
        values.put(SENHA, u.getSenha());
        values.put(CPF, u.getCpf());
        values.put(CONTABANCARIA, u.getContaBancaria());
        values.put(VALORINICIAL, u.getValorInicial());


        result = db.insert(TABELA, null, values);
        db.close();

        if (result == -1) {
            return false;
        }else{
            return true;
        }
    }

    public Usuario selecionarUsuario(String login){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABELA,
                new String[]{ID,NOME,LOGIN,SENHA,CPF,CONTABANCARIA,VALORINICIAL},
               LOGIN + " = ?",
               new String[]{ String.valueOf(login)}, null, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();

            Usuario user = new Usuario(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6));

            return(Usuario) user.clone();
        } else
            return null;
        }

    public Usuario selecionarId(String id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABELA,
                new String[]{ID,NOME,LOGIN,SENHA,CPF,CONTABANCARIA,VALORINICIAL},
                ID + " = ?",
                new String[]{ String.valueOf(id)}, null, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();

            Usuario user = new Usuario(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6));

            return(Usuario) user.clone();
        } else
            return null;
    }



    }


