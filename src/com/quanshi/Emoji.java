package com.quanshi;

public class Emoji {
    private int[][] codePoints;
    private String[][] unicodes;
    private String[] codePointStr;
    private int resId;

    public Emoji(int[][] codePoints, int resId){
        if(codePoints != null && codePoints.length > 0){
            this.codePoints = codePoints;
            this.unicodes = new String[codePoints.length][];
            this.codePointStr = new String[codePoints.length];
            this.toUnicode();
        }
        this.resId = resId;
    }
    private void toUnicode(){
        for (int i = 0, len = this.codePoints.length; i < len; i++) {
            StringBuilder unicodeSB = new StringBuilder();
            StringBuilder codePointStrSB = new StringBuilder();
            int[] codePoints = this.codePoints[i];
            
            for(int j = 0, codePointLen = codePoints.length; j < codePointLen; j++){
                int codePoint = codePoints[j];
                unicodeSB.append(new String(Character.toChars(codePoint)));
                codePointStrSB.append(getCodePointStr(codePoint));
                if(j < codePointLen - 1){
                    codePointStrSB.append("_");
                }
            }
            this.unicodes[i] = new String[]{unicodeSB.toString()};
            this.codePointStr[i] = codePointStrSB.toString();
        }
    }
    private String getCodePointStr(int codePoint) {
        String codePointStr = Integer.toHexString(codePoint);
        int codePointStrLen = codePointStr.length();
        if(codePointStrLen < 4){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 4 - codePointStrLen; i++){
                sb.append("0");
            }
            codePointStr = sb.toString() + codePointStr;
        }
        return codePointStr;
    }

    public String[] getCodePointStr() {
		return codePointStr;
	}
	public void setCodePointStr(String[] codePointStr) {
		this.codePointStr = codePointStr;
	}
	public int[][] getCodePoints() {
        return codePoints;
    }

    public void setCodePoints(int[][] codePoints) {
        this.codePoints = codePoints;
    }

    public String[][] getUnicodes() {
        return unicodes;
    }

    public void setUnicodes(String[][] unicodes) {
        this.unicodes = unicodes;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}