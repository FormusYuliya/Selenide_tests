package pages;

public interface SelectRaffleTheme {

    enum theme {
        MOON("Moon"), //Selected by default
        DEIMOS("Deimos"),
        CALLISTO("Callisto"),
        DIONE("Dione"),
        OBERON("Oberon"),
        TRITON("Triton");

        private String locator;

        theme(String page) {
            this.locator = page;
        }

        public String getLocator() {
            locator = new StringBuilder().append("(//div[contains(.,'").append(locator).append("')])[16]").toString();
            return locator;
        }
    }
}
