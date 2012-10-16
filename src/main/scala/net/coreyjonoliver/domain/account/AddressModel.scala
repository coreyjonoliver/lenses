package net.coreyjonoliver.domain.account
package model

import scalaz._
import Scalaz._

trait AddressModel extends Serializable {
 
  case class Address(id: Int, address1: String, address2: String,
      city: String, state: String, zipcode: String) {
    override def equals(that: Any) = id == that.asInstanceOf[Address].id
    override def hashCode = id
  }
  
  val addressAddress1Lens: Lens[Address, String] =
    Lens((a: Address) => a.address1, (a: Address, a1: String) => a.copy(address1 = a1))
    
  val addressAddress2Lens: Lens[Address, String] =
    Lens((a: Address) => a.address2, (a: Address, a2: String) => a.copy(address2 = a2))
    
  val addressCityLens: Lens[Address, String] =
    Lens((a: Address) => a.city, (a: Address, c: String) => a.copy(city = c))
    
  val addressStateLens: Lens[Address, String] =
    Lens((a: Address) => a.state, (a: Address, s: String) => a.copy(state = s))
    
  val addressZipcodeLens: Lens[Address, String] =
    Lens((a: Address) => a.zipcode, (a: Address, z: String) => a.copy(zipcode = z))
}

object AddressModel extends AddressModel