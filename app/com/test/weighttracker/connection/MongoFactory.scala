package com.test.weighttracker.connection

/**
  * Created by bharaka on 12/17/16.
  */
import com.mongodb.casbah.MongoConnection

object MongoFactory {
  private val SERVER = "localhost"
  private val PORT   = 27017
  private val DATABASE = "weighttrackerdb"
  private val COLLECTION1 = "metrics"
  private val COLLECTION2 = "alerts"
  val connection = MongoConnection(SERVER)
  val collection1 = connection(DATABASE)(COLLECTION1)
  val collection2= connection(DATABASE)(COLLECTION2)
}
