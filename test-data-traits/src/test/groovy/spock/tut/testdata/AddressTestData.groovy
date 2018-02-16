package spock.tut.testdata

trait AddressTestData {

  Address address(Map<String, Object> data = [:]) {
    new Address(
      street: getAddressProperty(data, "street"),
      city: getAddressProperty(data, "city"),
      zip: getAddressProperty(data, "zip"))
  }

  Map<String, Object> getAddressProperties() {
    defaultAddressProperties
  }

  Map<String, Object> getDefaultAddressProperties() {
    [
      street: "Am Planetarium 1",
      city  : "Jena",
      zip   : "07743"
    ]
  }

  public <T> T getAddressProperty(Map<String, Object> data, String key) {
    getAddressPropertyValue(data[key] ?: addressProperties[key]) as T
  }

  private Object getAddressPropertyValue(Object o) {
    o instanceof Closure ? o.call() : o
  }
}
