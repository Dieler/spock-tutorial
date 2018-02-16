package spock.tut.testdata

trait PersonTestData {

  Person person(Map<String, Object> data = [:]) {
    new Person(
      firstName: getPersonProperty(data, "firstName"),
      lastName: getPersonProperty(data, "lastName"),
      zip: getPersonProperty(data, "zip"),
      addresses: getPersonProperty(data, "addresses"))
  }

  Map<String, Object> getPersonProperties() {
    defaultPersonProperties
  }

  Map<String, Object> getDefaultPersonProperties() {
    [
      firstName: "Franz",
      lastName : "Müller"
    ]
  }

  public <T> T getPersonProperty(Map<String, Object> data, String key) {
    getPersonPropertyValue(data[key] ?: personProperties[key]) as T
  }

  private Object getPersonPropertyValue(Object o) {
    o instanceof Closure ? o.call() : o
  }
}
