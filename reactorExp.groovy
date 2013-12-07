@GrabResolver(name='reactor-repo', root='http://repo.springsource.org/libs-snapshot')
@Grab('org.projectreactor:reactor-core:1.1.0.BUILD-SNAPSHOT')
@Grab('org.slf4j:slf4j-nop:1.7.5')

import reactor.core.*
import reactor.core.spec.*
import reactor.event.*
import static reactor.event.selector.Selectors.*

def env = new Environment()
def reactor = Reactors.reactor().env(env).dispatcher(Environment.RING_BUFFER).get()

reactor.on ($("topic")) { Event<String> ev ->
    println "Hello $ev.data\n"
}

reactor.notify ("topic", Event.wrap ('John Doe'))
Thread.sleep(10)
