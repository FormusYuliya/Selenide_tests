package pages;

public interface SelectCouponTheme {
    enum Theme {
        CENTERED("Centered"), //Selected by default
        CLASSIC_RIGHT("Classic right"),
        CLASSIC_lEFT("Classic left"),
        CONTEMPORARY("Contemporary"),
        ELEGANT_RIGHT("Elegant right"),
        ELEGANT_LEFT("Elegant left"),
        MODERN("Modern");

        private String locator;

        Theme(String page) {
            this.locator = page;
        }

        public String getLocator() {
            locator = new StringBuilder().append("(//div[contains(.,'").append(locator).append("')])[16]").toString();
            return locator;
        }
    }
}

