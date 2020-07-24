package com.sec.spp.push.dlc.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IDlcService extends IInterface {
    int requestSend(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7) throws RemoteException;

    int requestSendAggregation(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, int i, long j2, long j3, long j4, long j5, long j6) throws RemoteException;

    int requestSendSummary(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, long j2, long j3, long j4, long j5, long j6) throws RemoteException;

    int requestSendUrgent(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7) throws RemoteException;

    public static abstract class Stub extends Binder implements IDlcService {
        private static final String DESCRIPTOR = "com.sec.spp.push.dlc.api.IDlcService";
        static final int TRANSACTION_requestSend = 1;
        static final int TRANSACTION_requestSendAggregation = 3;
        static final int TRANSACTION_requestSendSummary = 4;
        static final int TRANSACTION_requestSendUrgent = 2;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDlcService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IDlcService)) {
                return new Proxy(iBinder);
            }
            return (IDlcService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = i;
            Parcel parcel3 = parcel;
            Parcel parcel4 = parcel2;
            if (i3 == 1) {
                parcel3.enforceInterface(DESCRIPTOR);
                int requestSend = requestSend(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel4.writeInt(requestSend);
                return true;
            } else if (i3 == 2) {
                parcel3.enforceInterface(DESCRIPTOR);
                int requestSendUrgent = requestSendUrgent(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel4.writeInt(requestSendUrgent);
                return true;
            } else if (i3 == 3) {
                parcel3.enforceInterface(DESCRIPTOR);
                int requestSendAggregation = requestSendAggregation(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong());
                parcel2.writeNoException();
                parcel4.writeInt(requestSendAggregation);
                return true;
            } else if (i3 == 4) {
                parcel3.enforceInterface(DESCRIPTOR);
                int requestSendSummary = requestSendSummary(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong());
                parcel2.writeNoException();
                parcel4.writeInt(requestSendSummary);
                return true;
            } else if (i3 != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel4.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements IDlcService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public int requestSend(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeString(str5);
                    obtain.writeString(str6);
                    obtain.writeString(str7);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int requestSendUrgent(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeString(str5);
                    obtain.writeString(str6);
                    obtain.writeString(str7);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int requestSendAggregation(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, int i, long j2, long j3, long j4, long j5, long j6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    String str8 = str;
                    obtain.writeString(str);
                    String str9 = str2;
                    obtain.writeString(str2);
                    long j7 = j;
                    obtain.writeLong(j);
                    String str10 = str3;
                    obtain.writeString(str3);
                    String str11 = str4;
                    obtain.writeString(str4);
                    String str12 = str5;
                    obtain.writeString(str5);
                    String str13 = str6;
                    obtain.writeString(str6);
                    String str14 = str7;
                    obtain.writeString(str7);
                    obtain.writeInt(i);
                    obtain.writeLong(j2);
                    obtain.writeLong(j3);
                    obtain.writeLong(j4);
                    obtain.writeLong(j5);
                    obtain.writeLong(j6);
                    try {
                        this.mRemote.transact(3, obtain, obtain2, 0);
                        obtain2.readException();
                        int readInt = obtain2.readInt();
                        obtain2.recycle();
                        obtain.recycle();
                        return readInt;
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public int requestSendSummary(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, long j2, long j3, long j4, long j5, long j6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    String str9 = str;
                    obtain.writeString(str);
                    String str10 = str2;
                    obtain.writeString(str2);
                    long j7 = j;
                    obtain.writeLong(j);
                    String str11 = str3;
                    obtain.writeString(str3);
                    String str12 = str4;
                    obtain.writeString(str4);
                    String str13 = str5;
                    obtain.writeString(str5);
                    String str14 = str6;
                    obtain.writeString(str6);
                    String str15 = str7;
                    obtain.writeString(str7);
                    obtain.writeString(str8);
                    obtain.writeLong(j2);
                    obtain.writeLong(j3);
                    obtain.writeLong(j4);
                    obtain.writeLong(j5);
                    obtain.writeLong(j6);
                    try {
                        this.mRemote.transact(4, obtain, obtain2, 0);
                        obtain2.readException();
                        int readInt = obtain2.readInt();
                        obtain2.recycle();
                        obtain.recycle();
                        return readInt;
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }
    }
}
