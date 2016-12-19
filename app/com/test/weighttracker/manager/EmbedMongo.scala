package com.test.weighttracker.manager

import com.test.weighttracker.connection.MongoFactory
import de.flapdoodle.embed.mongo.MongodStarter
import de.flapdoodle.embed.mongo.distribution.Version
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder
import de.flapdoodle.embed.mongo.config.Net
import de.flapdoodle.embed.process.runtime.Network
/**
  * Created by bharaka on 12/18/16.
  */

  object StartEmbedMongo {
    val mongoVersion = Version.V2_4_9
    private val mongodStarter = MongodStarter.getDefaultInstance
    private val mongodConfig = new MongodConfigBuilder().version(mongoVersion).net(new Net(12345, Network.localhostIsIPv6())).build()
    val mongodExec = mongodStarter.prepare(mongodConfig)
    val mongod = mongodExec.start()

    MongoFactory.connection.dropDatabase("weighttrackerdb")
  }

  object StopEmbedMongo {
    StartEmbedMongo.mongod.stop()
    StartEmbedMongo.mongodExec.stop()
  }

