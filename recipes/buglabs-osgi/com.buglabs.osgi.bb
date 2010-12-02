inherit bug-java-library

PR = "r1"

SRC_URI = "file://osgi.jar.donotunpack"

S = "${WORKDIR}"

JARFILENAME = "osgi.jar"

do_removebinaries() {
   mv ${WORKDIR}/osgi.jar.donotunpack ${WORKDIR}/osgi.jar
}

PACKAGES = ""
