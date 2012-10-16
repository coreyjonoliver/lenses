package net.coreyjonoliver.domain.account

import org.scalatest.{Spec, BeforeAndAfterAll}
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class AccountModelSpec extends Spec with ShouldMatchers with BeforeAndAfterAll {
  import java.util.Calendar
  import model.AccountModel._

  describe("lenses") {
    it("should work") {
      val a1 = Account(1, "Alonzo", "Church", "5555555", 
          Address(1, "555 Picadilly Lane", "Apt 333", "Seattle", "WA", "55555"))
      accountFirstNameLens.get(a1) should equal("Alonzo")
      
      val a2 = accountFirstNameLens.set(a1, "Kurt")
     a2.firstName should not equal a1.firstName
    }
  }
}