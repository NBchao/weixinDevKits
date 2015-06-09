package org.weixin4j.spi;

/**
 * ScanCodeInfo业务
 *
 * @author qsyang
 * @version 1.0
 */
public class ScanCodeInfo {

    private String ScanType;
    private String ScanResult;

    public String getScanType() {
        return ScanType;
    }

    public void setScanType(String ScanType) {
        this.ScanType = ScanType;
    }

    public String getScanResult() {
        return ScanResult;
    }

    public void setScanResult(String ScanResult) {
        this.ScanResult = ScanResult;
    }
}
