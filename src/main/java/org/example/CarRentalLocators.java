package org.example;

public class CarRentalLocators {
    public static final String TAB_CAR_RENTAL = "//div[text()='Car Rental']";
    public static final String TAB_WITHOUT_DRIVER = "//h4[normalize-space()='Without Driver']";
    public static final String INPUT_LOCATION = "//input[@placeholder='Enter city or region']";
    public static final String TAB_PICKUP_LOCATION = "//div[@aria-label='%s']";
    public static final String FIELD_QUERY = "//div[contains(text(),'%s')]/parent::label/following-sibling::div[1]";
    public static final String DATE_QUERY = "(//div[@data-testid='date-cell-%s'])[%d]";
    public static final String TIME_HOUR_QUERY = "//div[normalize-space()='Hour']/following-sibling::div//div[text()='%d']";
    public static final String TIME_MINUTE_QUERY = "//div[normalize-space()='Minute']/following-sibling::div//div[text()='%d']";
    public static final String BTN_DONE = "//div[text()='Done']";
    public static final String BTN_SEARCH = "//div[@data-testid='rental-search-form-cta']";

    public static final String TOP_SEARCH_CAR = "(//div[text()='Continue'])[2]";
    public static final String TOP_CAR_PROVIDER = "(//div[text()='Continue'])[2]";

    public static final String RADIO_PICKUP_LOCATION = "(//div[text()='%s'])[1]";
    public static final String DROPDOWN_PICKUP_LOCATION_DETAIL = "//h4[normalize-space()='Pick-up Location']/following-sibling::div[1]";
    public static final String TOP_RADIO_LOCATION_DETAIL = "(" + DROPDOWN_PICKUP_LOCATION_DETAIL + "//div[@class='css-1dbjc4n r-18u37iz r-1wtj0ep'])[2]";

    public static final String RADIO_DROPOFF_LOCATION = "(//div[text()='%s'])[2]";
    public static final String INPUT_DROPOFF_LOCATION_DETAIL = "(//input[@placeholder='Search location or address'])[2]";
    public static final String TAB_DROPOFF_LOCATION_DETAIL = "//div[@aria-label='%s']";

    public static final String PROCEED = "(//div[text()='Continue'])[2]";

    public static final String INPUT_CONTACT_DETAILS_NAME = "//div[@data-testid='contact-detail']//input[@aria-labelledby='name.full']";
    public static final String INPUT_CONTACT_DETAILS_PHONE = "//div[@data-testid='contact-detail']//input[@aria-label='Phone Number']";
    public static final String INPUT_CONTACT_DETAILS_EMAIL = "//div[@data-testid='contact-detail']//input[@aria-labelledby='emailAddress']";

    public static final String INPUT_DRIVER_DETAILS_NAME = "//div[@id='adultForm0']//input[@type='text']";
    public static final String INPUT_DRIVER_DETAILS_PHONE = "//div[@id='adultForm0']//input[@aria-label='Phone Number']";

    public static final String TAB_REQUIREMENT = "//div[text()='Tap to check the requirements.']";
    public static final String RADIO_ALL_REQUIREMENT = "//div[text()='Check All']";
    public static final String BTN_SAVE_REQUIREMENT = "(//div[text()='Save'])[2]";

    public static final String PROCEED_PAYMENT = "(//div[text()='Continue to Payment'])[2]";
}
