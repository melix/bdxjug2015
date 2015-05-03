package com.acme
import spock.lang.Specification

class GreetingSpec extends Specification {

   def "should greet people"() {
      given: "a greeter instance"
         def greeter = new Greeter()
      when: "we greet someone"
         def greeting = greeter.greet(someone)
      then: "greeting looks correct"
         greeting == "Hello, $someone!"
      where:
         someone << ['Bob','Alice']
   }

}
