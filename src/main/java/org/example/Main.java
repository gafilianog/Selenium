package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    private WebDriver driver;

    private void runAutomation() {
        driver = new ChromeDriver();
        driver.get("https://www.traveloka.com/en-id");
        driver.manage().window().maximize();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        selectCarRental();
        selectTabWithoutDriver();
        selectPickUpLocation();
        selectTime(true);
        selectTime(false);
        clickSearchBtn();
        selectTopCarProvider();
        selectPickUpDropOffLocation();
        proceedBooking();
        fillContactDriverDetail("John Doe", "8123456789", "johndoe@mailinator.com");
        proceedBooking();
        selectAllRequirement();
        proceedPayment();

        driver.quit();
    }

    private void selectCarRental() {
        WebElement carRentalTab = driver.findElement(By.xpath(CarRentalLocators.TAB_CAR_RENTAL));
        carRentalTab.click();
    }

    private void selectTabWithoutDriver() {
        WebElement withoutDriverTab = driver.findElement(By.xpath(CarRentalLocators.TAB_WITHOUT_DRIVER));
        withoutDriverTab.click();
    }

    private void selectPickUpLocation() {
        String city = "Jakarta";
        WebElement fieldPickUpLocation = driver.findElement(By.xpath(String.format(CarRentalLocators.FIELD_QUERY, "Your Rental Location")));
        fieldPickUpLocation.click();
        WebElement inputLocation = driver.findElement(By.xpath(CarRentalLocators.INPUT_LOCATION));
        inputLocation.sendKeys(city);
        WebElement cityTab = driver.findElement(By.xpath(String.format(CarRentalLocators.TAB_PICKUP_LOCATION, city)));
        cityTab.click();
    }

    private void selectTime(boolean isPickUp) {
        String dateQuery = "Rental End Date";
        String timeQuery = "End Time";
        int timeHour = 11;
        int timeMinute = 0;
        int dateLocatorIdx = 2;
        int plusDays = 5;

        if (isPickUp) {
            dateQuery = "Rental Start Date";
            timeQuery = "Start Time";
            timeHour = 9;
            dateLocatorIdx = 1;
            plusDays = 2;
        }

        WebElement fieldPickUpDate = driver.findElement(By.xpath(String.format(CarRentalLocators.FIELD_QUERY, dateQuery)));
        fieldPickUpDate.click();
        String datePickUp = datePlusDaysFormat(plusDays);
        WebElement date = driver.findElement(By.xpath(String.format(CarRentalLocators.DATE_QUERY, datePickUp, dateLocatorIdx)));
        date.click();

        WebElement fieldPickUpTime = driver.findElement(By.xpath(String.format(CarRentalLocators.FIELD_QUERY, timeQuery)));
        fieldPickUpTime.click();
        WebElement hourPickUp = driver.findElement(By.xpath(String.format(CarRentalLocators.TIME_HOUR_QUERY, timeHour)));
        hourPickUp.click();
        WebElement minutePickUp = driver.findElement(By.xpath(String.format(CarRentalLocators.TIME_MINUTE_QUERY, timeMinute)));
        minutePickUp.click();
        WebElement btnDone = driver.findElement(By.xpath(CarRentalLocators.BTN_DONE));
        btnDone.click();
    }

    private void clickSearchBtn() {
        WebElement btnSearch = driver.findElement(By.xpath(CarRentalLocators.BTN_SEARCH));
        btnSearch.click();
    }

    private void selectTopCarProvider() {
        WebElement btnProceedTopCar = driver.findElement(By.xpath(CarRentalLocators.TOP_SEARCH_CAR));
        btnProceedTopCar.click();
        WebElement btnProceedTopProvider = driver.findElement(By.xpath(CarRentalLocators.TOP_CAR_PROVIDER));
        btnProceedTopProvider.click();
    }

    private void selectPickUpDropOffLocation() {
        WebElement radioPickUpLocation = driver.findElement(By.xpath(String.format(CarRentalLocators.RADIO_PICKUP_LOCATION, "Rental Office")));
        radioPickUpLocation.click();
        WebElement dropDownPickUpLocationDetail = driver.findElement(By.xpath(CarRentalLocators.DROPDOWN_PICKUP_LOCATION_DETAIL));
        dropDownPickUpLocationDetail.click();
        WebElement topRadioLocationDetail = driver.findElement(By.xpath(CarRentalLocators.TOP_RADIO_LOCATION_DETAIL));
        topRadioLocationDetail.click();

        WebElement radioDropOffLocation = driver.findElement(By.xpath(String.format(CarRentalLocators.RADIO_DROPOFF_LOCATION, "Other Location")));
        radioDropOffLocation.click();
        WebElement inputDropOffLocationDetail = driver.findElement(By.xpath(CarRentalLocators.INPUT_DROPOFF_LOCATION_DETAIL));
        inputDropOffLocationDetail.sendKeys("Gambir Station");
        WebElement tabDropOffLocationDetail = driver.findElement(By.xpath(String.format(CarRentalLocators.TAB_DROPOFF_LOCATION_DETAIL, "Gambir Station")));
        tabDropOffLocationDetail.click();
    }

    private void proceedBooking() {
        WebElement btnProceed = driver.findElement(By.xpath(CarRentalLocators.PROCEED));
        btnProceed.click();
    }

    private void fillContactDriverDetail(String name, String phone, String email) {
        WebElement inputContactName = driver.findElement(By.xpath(CarRentalLocators.INPUT_CONTACT_DETAILS_NAME));
        inputContactName.sendKeys(name);
        WebElement inputContactPhone = driver.findElement(By.xpath(CarRentalLocators.INPUT_CONTACT_DETAILS_PHONE));
        inputContactPhone.sendKeys(phone);
        WebElement inputContactEmail = driver.findElement(By.xpath(CarRentalLocators.INPUT_CONTACT_DETAILS_EMAIL));
        inputContactEmail.sendKeys(email);

        WebElement inputDriverName = driver.findElement(By.xpath(CarRentalLocators.INPUT_DRIVER_DETAILS_NAME));
        inputDriverName.sendKeys(name);
        WebElement inputDriverPhone = driver.findElement(By.xpath(CarRentalLocators.INPUT_DRIVER_DETAILS_PHONE));
        inputDriverPhone.sendKeys(phone);
    }

    private void selectAllRequirement() {
        WebElement tabRequirement = driver.findElement(By.xpath(CarRentalLocators.TAB_REQUIREMENT));
        tabRequirement.click();
        WebElement btnAllRequirement = driver.findElement(By.xpath(CarRentalLocators.RADIO_ALL_REQUIREMENT));
        btnAllRequirement.click();
        WebElement btnSaveRequirement = driver.findElement(By.xpath(CarRentalLocators.BTN_SAVE_REQUIREMENT));
        btnSaveRequirement.click();
    }

    private void proceedPayment() {
        WebElement btnProceedPayment = driver.findElement(By.xpath(CarRentalLocators.PROCEED_PAYMENT));
        btnProceedPayment.click();
    }

    private String datePlusDaysFormat(int plusDays) {
        LocalDate datePlusN = LocalDate.now().plusDays(plusDays);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
        return datePlusN.format(formatter);
    }

    public Main() {
        runAutomation();
    }

    public static void main(String[] args) {
        new Main();
    }
}