class LegacyAPI {


    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature. Please use newFeature() instead.");
    }


    public void newFeature() {
        System.out.println("This is the new and improved feature.");
    }


    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
       
        // Calling the deprecated method (should show a warning)
        api.oldFeature();


        // Calling the new method
        api.newFeature();
    }
}
