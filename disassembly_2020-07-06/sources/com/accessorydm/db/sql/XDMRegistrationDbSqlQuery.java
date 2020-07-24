package com.accessorydm.db.sql;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.accessorydm.db.XDMDbManager;
import com.accessorydm.db.file.XDBRegistrationInfo;
import com.accessorydm.db.file.XDBUserDBException;
import com.accessorydm.interfaces.XDBInterface;
import com.samsung.android.fotaprovider.log.Log;

public class XDMRegistrationDbSqlQuery implements XDBInterface {
    static void createDBRegistration(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            Log.E("db is null");
            return;
        }
        try {
            sQLiteDatabase.execSQL(XDBInterface.DATABASE_REGISTER_INFO_CREATE);
        } catch (SQLException e) {
            Log.E(e.toString());
        }
    }

    static void deleteDBRegistration(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            Log.E("db is null");
            return;
        }
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS register");
        } catch (SQLException e) {
            Log.E(e.toString());
        }
    }

    public static long insertRegistrationInfo(XDBRegistrationInfo xDBRegistrationInfo) {
        SQLiteDatabase xdmDbGetWritableDatabase = XDMDbManager.xdmDbGetWritableDatabase();
        long j = -1;
        if (xdmDbGetWritableDatabase == null) {
            Log.E("db is null");
            return -1;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(XDBInterface.XDM_SQL_REGISTER_TERMS_STATE, Integer.valueOf(xDBRegistrationInfo.getTermStatus()));
            contentValues.put("register", Integer.valueOf(xDBRegistrationInfo.getDeviceRegistrationStatus()));
            contentValues.put(XDBInterface.XDM_SQL_REGISTER_PUSH_STATE, Integer.valueOf(xDBRegistrationInfo.getPushRegistrationStatus()));
            contentValues.put(XDBInterface.XDM_SQL_REGISTER_CONSUMER_STATE, Integer.valueOf(xDBRegistrationInfo.getConsumerStatus()));
            j = xdmDbGetWritableDatabase.insert("register", (String) null, contentValues);
        } catch (SQLException e) {
            Log.E(e.toString());
        } catch (Throwable th) {
            XDMDbManager.xdmDbCloseSQLiteDatabase(xdmDbGetWritableDatabase);
            throw th;
        }
        XDMDbManager.xdmDbCloseSQLiteDatabase(xdmDbGetWritableDatabase);
        return j;
    }

    public static void updateRegistrationInfo(long j, XDBRegistrationInfo xDBRegistrationInfo) throws XDBUserDBException {
        SQLiteDatabase xdmDbGetWritableDatabase = XDMDbManager.xdmDbGetWritableDatabase();
        if (xdmDbGetWritableDatabase == null) {
            Log.E("db is null");
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(XDBInterface.XDM_SQL_REGISTER_TERMS_STATE, Integer.valueOf(xDBRegistrationInfo.getTermStatus()));
            contentValues.put("register", Integer.valueOf(xDBRegistrationInfo.getDeviceRegistrationStatus()));
            contentValues.put(XDBInterface.XDM_SQL_REGISTER_PUSH_STATE, Integer.valueOf(xDBRegistrationInfo.getPushRegistrationStatus()));
            contentValues.put(XDBInterface.XDM_SQL_REGISTER_CONSUMER_STATE, Integer.valueOf(xDBRegistrationInfo.getConsumerStatus()));
            xdmDbGetWritableDatabase.update("register", contentValues, "rowId=" + j, (String[]) null);
            XDMDbManager.xdmDbCloseSQLiteDatabase(xdmDbGetWritableDatabase);
        } catch (SQLException e) {
            Log.E(e.toString());
            throw new XDBUserDBException(1);
        } catch (Throwable th) {
            XDMDbManager.xdmDbCloseSQLiteDatabase(xdmDbGetWritableDatabase);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0075, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0076, code lost:
        if (r0 != null) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0080, code lost:
        throw r2;
     */
    public static XDBRegistrationInfo getQueryRegistrationInfo() throws XDBUserDBException {
        SQLiteDatabase xdmDbGetReadableDatabase = XDMDbManager.xdmDbGetReadableDatabase();
        XDBRegistrationInfo xDBRegistrationInfo = null;
        if (xdmDbGetReadableDatabase == null) {
            Log.E("db is null");
            return null;
        }
        try {
            Cursor query = xdmDbGetReadableDatabase.query(true, "register", new String[]{XDBInterface.XDM_SQL_DB_ROWID, XDBInterface.XDM_SQL_REGISTER_TERMS_STATE, "register", XDBInterface.XDM_SQL_REGISTER_PUSH_STATE, XDBInterface.XDM_SQL_REGISTER_CONSUMER_STATE}, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
            if (query == null) {
                Log.E("cursor is null");
                if (query != null) {
                    query.close();
                }
                XDMDbManager.xdmDbCloseSQLiteDatabase(xdmDbGetReadableDatabase);
                return null;
            }
            if (query.getCount() > 0 && query.moveToFirst()) {
                xDBRegistrationInfo = new XDBRegistrationInfo();
                xDBRegistrationInfo.setTermStatus(query.getInt(1));
                xDBRegistrationInfo.setDeviceRegistrationStatus(query.getInt(2));
                xDBRegistrationInfo.setPushRegistrationStatus(query.getInt(3));
                xDBRegistrationInfo.setConsumerStatus(query.getInt(4));
            }
            if (query != null) {
                query.close();
            }
            XDMDbManager.xdmDbCloseSQLiteDatabase(xdmDbGetReadableDatabase);
            return xDBRegistrationInfo;
        } catch (SQLException e) {
            try {
                Log.E(e.toString());
                throw new XDBUserDBException(1);
            } catch (Throwable th) {
                XDMDbManager.xdmDbCloseSQLiteDatabase(xdmDbGetReadableDatabase);
                throw th;
            }
        } catch (Throwable th2) {
            r1.addSuppressed(th2);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005e, code lost:
        if (r12 != null) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0068, code lost:
        throw r0;
     */
    public static boolean existRegistrationInfo(long j) {
        SQLiteDatabase xdmDbGetReadableDatabase = XDMDbManager.xdmDbGetReadableDatabase();
        if (xdmDbGetReadableDatabase == null) {
            Log.E("db is null");
            return false;
        }
        String[] strArr = {XDBInterface.XDM_SQL_DB_ROWID, XDBInterface.XDM_SQL_REGISTER_TERMS_STATE, "register", XDBInterface.XDM_SQL_REGISTER_PUSH_STATE, XDBInterface.XDM_SQL_REGISTER_CONSUMER_STATE};
        try {
            Cursor query = xdmDbGetReadableDatabase.query(true, "register", strArr, "rowId=" + j, (String[]) null, (String) null, (String) null, (String) null, (String) null);
            if (query == null) {
                Log.E("cursor is null");
                if (query != null) {
                    query.close();
                }
                XDMDbManager.xdmDbCloseSQLiteDatabase(xdmDbGetReadableDatabase);
                return false;
            }
            boolean z = query.getCount() > 0;
            if (query != null) {
                query.close();
            }
            XDMDbManager.xdmDbCloseSQLiteDatabase(xdmDbGetReadableDatabase);
            return z;
        } catch (SQLException e) {
            try {
                Log.E(e.toString());
                XDMDbManager.xdmDbCloseSQLiteDatabase(xdmDbGetReadableDatabase);
                return false;
            } catch (Throwable th) {
                XDMDbManager.xdmDbCloseSQLiteDatabase(xdmDbGetReadableDatabase);
                throw th;
            }
        } catch (Throwable th2) {
            r13.addSuppressed(th2);
        }
    }
}
