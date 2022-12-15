package pages.coupon;

public interface SelectColorScheme {

     enum colorScheme {
        Night_in_desert("(//div[contains(@class,'color-container')])[1]"),
        Digital_drop("(//div[contains(@class,'color-container')])[2]"),
        Summertime("(//div[contains(@class,'color-container')])[3]"),
        Pearl_powder("(//div[contains(@class,'color-container')])[4]"),
        Achievement("(//div[contains(@class,'color-container')])[5]"),
        Cosmopolitan("(//div[contains(@class,'color-container')])[6]"),
        Colibri("(//div[contains(@class,'color-container')])[7]"),
        Breath_of_dawn("(//div[contains(@class,'color-container')])[8]");

        private String locator;

        colorScheme(String color) {
            this.locator = color;
        }

        public String getColorLocator() {
            return locator;
        }

    }
}
