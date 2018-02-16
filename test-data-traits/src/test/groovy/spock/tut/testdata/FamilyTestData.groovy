package spock.tut.testdata

trait FamilyTestData {

    Family family(Map<String, Object> data = [:]) {
        new Family(
                firstProperty: getFamilyProperty(data, "firstProperty"),
                secondProperty: getFamilyProperty(data, "secondProperty"))
    }

    Map<String, Object> getFamilyProperties() {
        defaultFamilyProperties
    }

    Map<String, Object> getDefaultFamilyProperties() {
        [
                firstProperty: "Property Value",
                secondPropery: "Property Value"
        ]
    }

    Object getFamilyProperty(Map<String, Object> data, String key) {
        data[key] ?: familyProperties[key]
    }

}