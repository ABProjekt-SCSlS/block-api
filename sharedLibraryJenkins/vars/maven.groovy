//Dependencies in Pom fehlen noch


import connection.*
import core.*

class Maven {
def maven (message) { 
    Service service = new Service ()
    Imvncompile mavencomp = new Imvncompile()

    String mvncompile = mavencomp.compilemaven() + "${message}"
    println(mvn compile)
    }
}






