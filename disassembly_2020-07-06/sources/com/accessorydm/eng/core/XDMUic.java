package com.accessorydm.eng.core;

import android.text.TextUtils;
import com.accessorydm.interfaces.XDBInterface;
import com.accessorydm.interfaces.XDMInterface;
import com.accessorydm.interfaces.XUICInterface;
import com.samsung.android.fotaprovider.log.Log;

public class XDMUic implements XDMInterface, XUICInterface, XDBInterface {
    public static XDMUicOption xdmUicCreateUicOption() {
        XDMUicOption xDMUicOption = new XDMUicOption();
        xDMUicOption.text = new XDMText();
        xDMUicOption.defaultResponse = new XDMText();
        xDMUicOption.text = XDMList.xdmListCreateText(128, (Object) null);
        xDMUicOption.defaultResponse = XDMList.xdmListCreateText(128, (Object) null);
        return xDMUicOption;
    }

    public static XDMUicOption xdmUicFreeUicOption(XDMUicOption xDMUicOption) {
        if (xDMUicOption != null) {
            xDMUicOption.text = null;
            xDMUicOption.defaultResponse = null;
            for (int i = 0; i < xDMUicOption.uicMenuNumbers; i++) {
                xDMUicOption.uicMenuList[i] = null;
            }
            xDMUicOption.m_szUicMenuTitle = null;
        }
        return xDMUicOption;
    }

    public static int xdmUicGetUicType(String str) {
        Log.I("pType " + str);
        if (XDMInterface.ALERT_DISPLAY.compareTo(str) == 0) {
            return 1;
        }
        if (XDMInterface.ALERT_CONTINUE_OR_ABORT.compareTo(str) == 0) {
            return 2;
        }
        if (XDMInterface.ALERT_TEXT_INPUT.compareTo(str) == 0) {
            return 3;
        }
        if (XDMInterface.ALERT_SINGLE_CHOICE.compareTo(str) == 0) {
            return 4;
        }
        return XDMInterface.ALERT_MULTIPLE_CHOICE.compareTo(str) == 0 ? 5 : 0;
    }

    public static XDMUicOption xdmUicCopyUicOption(Object obj, Object obj2) {
        XDMUicOption xDMUicOption = (XDMUicOption) obj;
        XDMUicOption xDMUicOption2 = (XDMUicOption) obj2;
        Log.I("");
        xDMUicOption.appId = xDMUicOption2.appId;
        xDMUicOption.inputType = xDMUicOption2.inputType;
        xDMUicOption.echoType = xDMUicOption2.echoType;
        xDMUicOption.maxDT = xDMUicOption2.maxDT;
        xDMUicOption.maxLen = xDMUicOption2.maxLen;
        xDMUicOption.minDT = xDMUicOption2.minDT;
        xDMUicOption.progrCurSize = xDMUicOption2.progrCurSize;
        xDMUicOption.progrMaxSize = xDMUicOption2.progrMaxSize;
        xDMUicOption.progrType = xDMUicOption2.progrType;
        xDMUicOption.UICType = xDMUicOption2.UICType;
        xDMUicOption.text = new XDMText();
        if (xDMUicOption2.text != null) {
            xDMUicOption.text.len = xDMUicOption2.text.len;
            xDMUicOption.text.size = xDMUicOption2.text.size;
            if (!TextUtils.isEmpty(xDMUicOption2.text.text)) {
                xDMUicOption.text.text = xDMUicOption2.text.text;
            }
        } else {
            xDMUicOption.text.len = 0;
            xDMUicOption.text.size = 0;
        }
        xDMUicOption.defaultResponse = new XDMText();
        if (xDMUicOption2.defaultResponse != null) {
            xDMUicOption.defaultResponse.len = xDMUicOption2.defaultResponse.len;
            xDMUicOption.defaultResponse.size = xDMUicOption2.defaultResponse.size;
            if (!TextUtils.isEmpty(xDMUicOption2.defaultResponse.text)) {
                xDMUicOption.defaultResponse.text = xDMUicOption2.defaultResponse.text;
            }
        } else {
            xDMUicOption.defaultResponse.len = 0;
            xDMUicOption.defaultResponse.size = 0;
        }
        if ((xDMUicOption2.UICType == 4 || xDMUicOption2.UICType == 5) && xDMUicOption2.uicMenuNumbers == 0) {
            Log.I("xdmUicCopyUicOption uicMenuNumbers = 0 !!!");
        }
        xDMUicOption.uicMenuNumbers = xDMUicOption2.uicMenuNumbers;
        for (int i = 0; i < xDMUicOption2.uicMenuNumbers; i++) {
            if (!TextUtils.isEmpty(xDMUicOption2.uicMenuList[i]) && i < 32 && xDMUicOption2.uicMenuList[i].length() > 0) {
                xDMUicOption.uicMenuList[i] = xDMUicOption2.uicMenuList[i];
            }
        }
        if (!TextUtils.isEmpty(xDMUicOption2.m_szUicMenuTitle)) {
            xDMUicOption.m_szUicMenuTitle = xDMUicOption2.m_szUicMenuTitle;
        }
        return xDMUicOption;
    }

    public static XDMUicResult xdmUicCreateResult() {
        Log.I("");
        XDMUicResult xDMUicResult = new XDMUicResult();
        xDMUicResult.text = new XDMText();
        xDMUicResult.text = XDMList.xdmListCreateText(128, (Object) null);
        return xDMUicResult;
    }

    public static XDMUicResult xdmUicCopyResult(XDMUicResult xDMUicResult, XDMUicResult xDMUicResult2) {
        Log.I("");
        if (xDMUicResult2 == null) {
            return xDMUicResult;
        }
        xDMUicResult.appId = xDMUicResult2.appId;
        xDMUicResult.UICType = xDMUicResult2.UICType;
        xDMUicResult.result = xDMUicResult2.result;
        xDMUicResult.SingleSelected = xDMUicResult2.SingleSelected;
        if (xDMUicResult2.text != null) {
            xDMUicResult.text.len = xDMUicResult2.text.len;
            xDMUicResult.text.size = xDMUicResult2.text.size;
            if (!TextUtils.isEmpty(xDMUicResult2.text.text)) {
                xDMUicResult.text.text = xDMUicResult2.text.text;
            }
        }
        xDMUicResult.MenuNumbers = xDMUicResult2.MenuNumbers;
        for (int i = 0; i < xDMUicResult2.MultiSelected.length; i++) {
            xDMUicResult.MultiSelected[i] = xDMUicResult2.MultiSelected[i];
        }
        return xDMUicResult;
    }

    public static Object xdmUicFreeResult(XDMUicResult xDMUicResult) {
        Log.I("xdmUicFreeResult");
        xDMUicResult.text.text = null;
        xDMUicResult.text = null;
        return null;
    }

    public static String xdmUicOptionProcess(String str, XDMUicOption xDMUicOption) {
        int i;
        char c;
        int i2;
        int i3;
        int i4;
        char c2;
        int i5;
        int i6;
        char c3;
        char[] cArr;
        char c4;
        int i7;
        int i8;
        char c5;
        int i9;
        char c6;
        int i10;
        char[] charArray = str.toCharArray();
        Log.I("pUicOptions :" + str);
        Log.I("uicOption :" + xDMUicOption.toString());
        if (charArray[0] == 0) {
            return String.valueOf(charArray);
        }
        int i11 = 0;
        while (true) {
            if (charArray[i11] != ' ' && charArray[i11] != 9) {
                break;
            }
            i11++;
        }
        int i12 = 0;
        while (true) {
            i = i11 + i12;
            if (i >= charArray.length || charArray[i] == '=') {
                char[] cArr2 = new char[(charArray.length - i11)];
                String.valueOf(charArray).getChars(i11, charArray.length - i11, cArr2, 0);
            } else {
                i12++;
            }
        }
        char[] cArr22 = new char[(charArray.length - i11)];
        String.valueOf(charArray).getChars(i11, charArray.length - i11, cArr22, 0);
        if (String.valueOf(cArr22).contains("MINDT") || String.valueOf(cArr22).contains("MDT")) {
            i2 = i + 1;
            int i13 = 0;
            while (true) {
                i4 = i2 + i3;
                if (i4 < charArray.length && charArray[i4] != '&' && charArray[i4] != 0) {
                    i13 = i3 + 1;
                }
            }
            if (i4 < charArray.length) {
                c2 = charArray[i4];
                charArray[i4] = 0;
            } else {
                c2 = 0;
            }
            try {
                xDMUicOption.minDT = Integer.valueOf(String.valueOf(charArray).substring(i2, i4)).intValue();
            } catch (Exception e) {
                Log.E(e.toString());
                xDMUicOption.minDT = 0;
            }
        } else if (String.valueOf(cArr22).contains("MAXDT")) {
            i2 = i + 1;
            i3 = 0;
            while (true) {
                i10 = i2 + i3;
                if (i10 < charArray.length && charArray[i10] != '&' && charArray[i10] != 0) {
                    i3++;
                }
            }
            if (i10 < charArray.length) {
                c = charArray[i10];
                charArray[i10] = 0;
            } else {
                c = 0;
            }
            String substring = String.valueOf(charArray).substring(i2, i10);
            Log.I("temp :" + substring);
            try {
                xDMUicOption.maxDT = Integer.valueOf(substring).intValue();
            } catch (Exception e2) {
                Log.E(e2.toString());
                xDMUicOption.maxDT = 0;
            }
        } else if (String.valueOf(cArr22).contains("DR")) {
            i2 = i + 1;
            int i14 = 0;
            while (true) {
                i9 = i2 + i3;
                if (i9 < charArray.length && charArray[i9] != '&' && charArray[i9] != 0) {
                    i14 = i3 + 1;
                }
            }
            if (i9 < charArray.length) {
                c6 = charArray[i9];
                charArray[i9] = 0;
            } else {
                c6 = 0;
            }
            xDMUicOption.defaultResponse = XDMList.xdmListCopyStrText(xDMUicOption.defaultResponse, String.valueOf(charArray).substring(i2, i9));
        } else if (String.valueOf(cArr22).contains("MAXLEN")) {
            i2 = i + 1;
            int i15 = 0;
            while (true) {
                i8 = i2 + i3;
                if (i8 < charArray.length && charArray[i8] != '&' && charArray[i8] != 0) {
                    i15 = i3 + 1;
                }
            }
            if (i8 < charArray.length) {
                c5 = charArray[i8];
                charArray[i8] = 0;
            } else {
                c5 = 0;
            }
            try {
                xDMUicOption.maxLen = Integer.valueOf(String.valueOf(charArray).substring(i2, i8)).intValue();
            } catch (Exception e3) {
                Log.E(e3.toString());
                xDMUicOption.maxLen = 0;
            }
        } else {
            if (String.valueOf(cArr22).contains("IT")) {
                i2 = i + 1;
                i5 = 0;
                while (true) {
                    i7 = i2 + i5;
                    if (i7 < charArray.length && charArray[i7] != '&' && charArray[i7] != 0) {
                        i5++;
                    }
                }
                if (i7 < charArray.length) {
                    c3 = charArray[i7];
                    charArray[i7] = 0;
                } else {
                    c3 = 0;
                }
                cArr = new char[i5];
                String.valueOf(charArray).getChars(i2, i7, cArr, 0);
                char c7 = charArray[i2];
                if (c7 == 'A') {
                    xDMUicOption.inputType = 1;
                } else if (c7 == 'D') {
                    xDMUicOption.inputType = 3;
                } else if (c7 == 'I') {
                    xDMUicOption.inputType = 6;
                } else if (c7 == 'N') {
                    xDMUicOption.inputType = 2;
                } else if (c7 == 'P') {
                    xDMUicOption.inputType = 5;
                } else if (c7 == 'T') {
                    xDMUicOption.inputType = 4;
                }
            } else if (!String.valueOf(cArr22).contains("ET")) {
                return String.valueOf(cArr22);
            } else {
                i2 = i + 1;
                int i16 = 0;
                while (true) {
                    i6 = i2 + i5;
                    if (i6 < charArray.length && charArray[i6] != '&' && charArray[i6] != 0) {
                        i16 = i5 + 1;
                    }
                }
                if (i6 < charArray.length) {
                    c4 = charArray[i6];
                    charArray[i6] = 0;
                } else {
                    c4 = 0;
                }
                cArr = new char[i5];
                String.valueOf(charArray).getChars(i2, i6, cArr, 0);
                char c8 = charArray[i2];
                if (c8 == 'P') {
                    xDMUicOption.echoType = 2;
                } else if (c8 == 'T') {
                    xDMUicOption.echoType = 1;
                }
            }
            c = c3;
            cArr22 = cArr;
        }
        if (c != '&') {
            return String.valueOf(cArr22);
        }
        int i17 = i2 + i3 + 1;
        char[] cArr3 = new char[(charArray.length - i17)];
        String.valueOf(charArray).getChars(i17, charArray.length, cArr3, 0);
        return xdmUicOptionProcess(new String(cArr3), xDMUicOption);
    }
}
