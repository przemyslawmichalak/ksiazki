package models

import java.util.{Date}

import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SqlParser._

case class Computer(id: Pk[Long] = NotAssigned, tytul: String, autor:String, data: Option[Date], opinia: String, ocena: Option[Int], stron: Option[Int])

/**
 * Helper for pagination.
 */
case class Page[A](items: Seq[A], page: Int, offset: Long, total: Long) {
  lazy val prev = Option(page - 1).filter(_ >= 0)
  lazy val next = Option(page + 1).filter(_ => (offset + items.size) < total)
}

object Computer {
  
  // -- Parsers
  
  /**
   * Parse a Computer from a ResultSet
   */
  val simple = {
    get[Pk[Long]]("computer.id") ~
    get[String]("computer.tytul") ~
    get[String]("computer.autor") ~
    get[Option[Date]]("computer.data") ~
    get[String]("computer.opinia") ~
    get[Option[Int]]("computer.ocena") ~
    get[Option[Int]]("computer.stron") map {
      case id~tytul~autor~data~opinia~ocena~stron => Computer(id,tytul,autor,data,opinia,ocena,stron)
    }
  }
  
  /**
   * Parse a (Computer,Company) from a ResultSet
   */
  val withCompany = Computer.simple  map {
    case computer => (computer)
  }
  
  // -- Queries
  
  /**
   * Retrieve a computer from the id.
   */
  def findById(id: Long): Option[Computer] = {
    DB.withConnection { implicit connection =>
      SQL("select * from computer where id = {id}").on('id -> id).as(Computer.simple.singleOpt)
    }
  }
  
  /**
   * Return a page of (Computer,Company).
   *
   * @param page Page to display
   * @param pageSize Number of computers per page
   * @param orderBy Computer property used for sorting
   * @param filter Filter applied on the name column
   */
  def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, filter: String = "%"): Page[(Computer)] = {
    
    val offest = pageSize * page
    
    DB.withConnection { implicit connection =>
      
      val computers = SQL(
        """
          select * from computer 
          where computer.tytul like {filter}
          order by {orderBy} nulls last
          limit {pageSize} offset {offset}
        """
      ).on(
        'pageSize -> pageSize, 
        'offset -> offest,
        'filter -> filter,
        'orderBy -> orderBy
      ).as(Computer.withCompany *)

      val totalRows = SQL(
        """
          select count(*) from computer 
          where computer.tytul like {filter}
        """
      ).on(
        'filter -> filter
      ).as(scalar[Long].single)

      Page(computers, page, offest, totalRows)
      
    }
    
  }
  
  /**
   * Update a computer.
   *
   * @param id The computer id
   * @param computer The computer values.
   */
  def update(id: Long, computer: Computer) = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          update computer
          set tytul = {tytul}, autor = {autor}, data = {data}, opinia = {opinia}, ocena = {ocena}, stron = {stron}
          where id = {id}
        """
      ).on(
        'id -> id,
        'tytul -> computer.tytul,
        'autor -> computer.autor,
        'data -> computer.data,
        'opinia -> computer.opinia,
        'ocena -> computer.ocena,
        'stron -> computer.stron
      ).executeUpdate()
    }
  }
  
  /**
   * Insert a new computer.
   *
   * @param computer The computer values.
   */
  def insert(computer: Computer) = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          insert into computer values (
            (select next value for computer_seq), 
          {tytul},{autor},{data},{opinia},{ocena},{stron}
          )
        """
      ).on(
        'tytul -> computer.tytul,
        'autor -> computer.autor,
        'data -> computer.data,
        'opinia -> computer.opinia,
        'ocena -> computer.ocena,
        'stron -> computer.stron
      ).executeUpdate()
    }
  }
  
  /**
   * Delete a computer.
   *
   * @param id Id of the computer to delete.
   */
  def delete(id: Long) = {
    DB.withConnection { implicit connection =>
      SQL("delete from computer where id = {id}").on('id -> id).executeUpdate()
    }
  }
  
}

