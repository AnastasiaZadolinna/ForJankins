package pages;

import org.openqa.selenium.*;

public class MyParcelsPage extends BasePage {

    public MyParcelsPage(WebDriver driver) {

        super(driver);
    }

    private final By trckNbrFld = By.xpath
            ("(//input)[2]");
    private final By btnSrch = By.xpath
            ("//button[@aria-label='search']");
    private final By fbr = By.xpath
            ("//div[@class='MuiPaper-root filter-container MuiPaper-elevation1 MuiPaper-rounded']");
    private final By lbStatus = By.xpath(
            "(//legend[contains(@class, 'MuiFormLabel-root')])[1]");
    private final By chkReceived = By.xpath
            ("(//span[@class='MuiIconButton-label'])[6]//input");
    private final By lbReceived = By.xpath
            ("(//span[@class='MuiTypography-root MuiFormControlLabel-label MuiTypography-body1'])[1]");
    private final By lbService = By.xpath
            ("(//legend[contains(@class, 'MuiFormLabel-root')])[2]");
    private final By chkNovaPoshta = By.xpath
            ("(//span[@class='MuiTypography-root MuiFormControlLabel-label MuiTypography-body1'])[2]");
    private final By btnParcel = By.xpath
            ("//div[@class='MuiButtonBase-root MuiAccordionSummary-root']");
    private final By imgNovaPoshta = By.xpath
            ("(//img[@alt='nova-poshta'])[1]");
    private final By nmbParcel = By.xpath
            ("(//div[@class='MuiAccordionSummary-content']//div//div//div//div)[1]");
    private final By stDelivered = By.xpath
            ("(//div[@class='delivered'])[1]");
    private final By btnDltParcel = By.xpath
            ("(//button[@class='MuiButtonBase-root MuiIconButton-root'])[2]");
    private final By btnMoreInfoBParcel = By.xpath
            ("(//div[@class='MuiButtonBase-root MuiIconButton-root MuiAccordionSummary-expandIcon MuiIconButton-edgeEnd'])[1]");
    private final By lbOrigin = By.xpath
            ("(//div[@class='MuiAccordionDetails-root']//div//div//div//div//h6)[1]");
    private final By nameOrigin = By.xpath
            ("//p[@class='MuiTypography-root MuiTypography-body2']");
    private final By disTime = By.xpath
            ("//p[@class='MuiTypography-root MuiTypography-body2']");
    private final By lbDestination = By.xpath
            ("//div[@class='MuiAccordionDetails-root']//div//div//div//div/following-sibling::div//h6");
    private final By nameDestination = By.xpath
            ("(//p[@class='MuiTypography-root MuiTypography-body2'])[3]");
    private final By delTime = By.xpath
            ("(//p[@class='MuiTypography-root MuiTypography-body2'])[4]");
    private final By lbInfo = By.xpath
            ("(//h6[contains(@class, 'MuiTypography-h6')])[5]");
    private final By lbWeight = By.xpath
            ("(//h6[contains(@class, 'MuiTypography-h6')])[5]/following-sibling::div//p");
    private final By stLbWeight = By.xpath
            ("(//p[@class='MuiTypography-root MuiTypography-body2'])[5]");
    private final By lbDelCost = By.xpath
            ("(//h6[contains(@class, 'MuiTypography-h6')])[5]/following-sibling::div/following-sibling::div//p");
    private final By stLbDelCost = By.xpath
            ("(//p[@class='MuiTypography-root MuiTypography-body2'])[6]");
    private final By lbCost = By.xpath
            ("(//h6[contains(@class, 'MuiTypography-h6')])[5]/following-sibling::div/following-sibling::div/following-sibling::div//p");
    private final By stLbCost = By.xpath
            ("(//p[@class='MuiTypography-root MuiTypography-body2'])[7]");
    private final By lbDepartment = By.xpath
            ("(//h6[contains(@class, 'MuiTypography-h6')])[5]/following-sibling::div/following-sibling::div/following-sibling::div/following-sibling::div//p");
    private final By stLbDepartment = By.xpath
            ("(//p[@class='MuiTypography-root MuiTypography-body2'])[8]");
    private final By lbStatusParcel = By.xpath
            ("(//h6[contains(@class, MuiTypography-h6)])[6]");
    private final By stStatusParcel = By.xpath
            ("(//p[contains(@class, 'MuiTypography-body2')])[13]");
    private final By lnkMoreInfo = By.xpath
            ("//a[contains(@class, 'MuiButton-textPrimary')]");
    private final By uaStatus = By.xpath
            ("//legend[text()='Статус']");
    private final By engStatus = By.xpath
            ("//legend[text()='Status']");
    private final By tbrBtnParcel = By.xpath
            ("//div[@class='MuiCollapse-container MuiCollapse-entered']");
    private final By nothingFoundImg = By.xpath("//div[@class='not-found']");


    public boolean isTrckNbrFldDisplayed() {

        return driver.findElement(trckNbrFld).isDisplayed();
    }

    public boolean isBtnSrchDisplayed() {

        return driver.findElement(btnSrch).isDisplayed();
    }

    public boolean isFbrDisplayed() {

        return driver.findElement(fbr).isDisplayed();
    }

    public boolean isLbStatusDisplayed() {

        return driver.findElement(lbStatus).isDisplayed();
    }

    public boolean isChkReceivedDisplayed() {

        return driver.findElement(chkReceived).isDisplayed();
    }

    public boolean isLbReceivedDisplayed() {

        return driver.findElement(lbReceived).isDisplayed();
    }

    public boolean isLbServiceDisplayed() {

        return driver.findElement(lbService).isDisplayed();
    }

    public boolean isChkNovaPoshtaDisplayed() {

        return driver.findElement(chkNovaPoshta).isDisplayed();
    }

    public boolean isBtnParcelDisplayed() {

        return driver.findElement(btnParcel).isDisplayed();
    }

    public boolean isImgNovaPoshtaDisplayed() {

        return driver.findElement(imgNovaPoshta).isDisplayed();
    }

    public boolean isNmbParcelDisplayed() {

        return driver.findElement(nmbParcel).isDisplayed();
    }

    public boolean isStDeliveredDisplayed() {

        return driver.findElement(stDelivered).isDisplayed();
    }

    public boolean isBtnDltParcelDisplayed() {

        return driver.findElement(btnDltParcel).isDisplayed();
    }

    public boolean isBtnMoreInfoBParcelDisplayed() {

        return driver.findElement(btnMoreInfoBParcel).isDisplayed();
    }

    public boolean isLbOriginDisplayed() {

        return driver.findElement(lbOrigin).isDisplayed();
    }

    public boolean isNameOriginDisplayed() {

        return driver.findElement(nameOrigin).isDisplayed();
    }

    public boolean isDisTimeDisplayed() {

        return driver.findElement(disTime).isDisplayed();
    }

    public boolean isLbDestinationDisplayed() {

        return driver.findElement(lbDestination).isDisplayed();
    }

    public boolean isNameDestinationDisplayed() {

        return driver.findElement(nameDestination).isDisplayed();
    }

    public boolean isDelTimeDisplayed() {

        return driver.findElement(delTime).isDisplayed();
    }

    public boolean isLbInfoDisplayed() {

        return driver.findElement(lbInfo).isDisplayed();
    }

    public boolean isLbWeightDisplayed() {

        return driver.findElement(lbWeight).isDisplayed();
    }

    public boolean isStLbWeightDisplayed() {

        return driver.findElement(stLbWeight).isDisplayed();
    }

    public boolean isLbDelCostDisplayed() {

        return driver.findElement(lbDelCost).isDisplayed();
    }

    public boolean isStLbDelCostDisplayed() {

        return driver.findElement(stLbDelCost).isDisplayed();
    }

    public boolean isLbCostDisplayed() {

        return driver.findElement(lbCost).isDisplayed();
    }

    public boolean isStLbCostDisplayed() {

        return driver.findElement(stLbCost).isDisplayed();
    }

    public boolean isLbDepartmentDisplayed() {

        return driver.findElement(lbDepartment).isDisplayed();
    }

    public boolean isStLbDepartmentDisplayed() {

        return driver.findElement(stLbDepartment).isDisplayed();
    }

    public boolean isLbStatusParcelDisplayed() {

        return driver.findElement(lbStatusParcel).isDisplayed();
    }

    public boolean isStStatusParcelDisplayed() {

        return driver.findElement(stStatusParcel).isDisplayed();
    }

    public boolean isLnkMoreInfoDisplayed() {

        return driver.findElement(lnkMoreInfo).isDisplayed();
    }

    public boolean isNothinfFoundImgDisplayed() {

        return driver.findElement(nothingFoundImg).isDisplayed();
    }

    /**
     * Methods for input track number in track number fold and search this track number
     */
    public MyParcelsPage inpTrckNbrAndClkEnter(String trckNbr) {
        driver.findElement(trckNbrFld).sendKeys(trckNbr, Keys.ENTER);
        return this;
    }

    public MyParcelsPage inpTrckNbrAndClkBtnSrch(String trckNbr) {
        driver.findElement(trckNbrFld).sendKeys(trckNbr);
        driver.findElement(btnSrch).click();
        return this;
    }

    /**
     * Method get parcel number from tag
     */
    public String getParcelNumber() {
        WebElement parcelNumber = waitElementIsVisible(nmbParcel);
        String parcelNmbr = parcelNumber.getText();
        return parcelNmbr;
    }

    /**
     * Click checkbox Received
     */
    public MyParcelsPage clkChkReceived() {
        driver.findElement(chkReceived).click();
        return this;
    }

    /**
     * Click checkbox Nova Poshta
     */
    public MyParcelsPage clkChkNovaPoshta() {
        driver.findElement(chkNovaPoshta).click();
        return this;
    }

    /**
     * Click button Parcel
     */
    public MyParcelsPage clkBtnParcel() {
        driver.findElement(btnParcel).click();
        return this;
    }

    /**
     * Click button btnMoreInfoBParcel
     */
    public MyParcelsPage clkBtnMoreInfoBParcel() {
        driver.findElement(btnMoreInfoBParcel).click();
        return this;
    }

    /**
     * is 'status' on UA displayed
     */
    public boolean isUaStatusDsp() {

        return driver.findElement(uaStatus).isDisplayed();
    }

    /**
     * is 'status' on ENG displayed
     */
    public boolean isEngStatusDsp() {

        return driver.findElement(engStatus).isDisplayed();
    }

    /**
     * Is tbr Info About Parcel displayed
     */
    public boolean isTbrParcelDsp() {

        return driver.findElement(tbrBtnParcel).isDisplayed();
    }

    /**
     * Parcel Btn disappears after click checkbox
     */
    public boolean isntBtnParcelDsp() {
        try {
            driver.findElement(btnParcel);
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }
}
