package net.coreyjonoliver.domain.account
package model

import scalaz._
import Scalaz._

import java.util.{Date, Calendar}

trait AccountModel extends Serializable {this: AddressModel =>
 
  case class Account(id: Int, firstName: String, lastName: String, 
      phoneNumber: String, address: Address, 
      registerDate: Date = Calendar.getInstance.getTime ) {
    override def equals(that: Any) = id == that.asInstanceOf[Account].id
    override def hashCode = id
  }
  
  val accountFirstNameLens: Lens[Account, String] =
    Lens((a: Account) => a.firstName, (a: Account, f: String) => a.copy(firstName = f))
    
  val accountLastNameLens: Lens[Account, String] =
    Lens((a: Account) => a.lastName, (a: Account, l: String) => a.copy(lastName = l))
    
  val accountPhoneNumberLens: Lens[Account, String] =
    Lens((a: Account) => a.phoneNumber, (a: Account, p: String) => a.copy(phoneNumber = p))
    
  val accountAddressLens: Lens[Account, Address] =
    Lens((a: Account) => a.address, (a: Account, add: Address) => a.copy(address = add))
    
  val accountRegisterDateLens: Lens[Account, Date] =
    Lens((a: Account) => a.registerDate, (a: Account, r: Date) => a.copy(registerDate = r))
}

object AccountModel extends AccountModel with AddressModel 