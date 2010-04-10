DESCRIPTION = "XML pull parser API"
HOMEPAGE = "http://www.xmlpull.org"
PRIORITY = "optional"
SECTION = "libs"
LICENSE = "public domain"
PR = "r1"

inherit java-library

S = "${WORKDIR}/${PN}_1_1_3_4c"

JAR = "${PN}-${PV}.jar"

SRC_URI = "\
    http://xmlpull.org/v1/download/xmlpull_1_1_3_4c_src.tgz \
    file://makefile.patch;patch=1 \
    "

do_compile() {
 oe_runmake -C src/java/api \
    JAVAC_FLAGS="-sourcepath ." \
    JAR="oefatal \"No jar invocation expected here.\"" \

 oe_runmake -C src/java/api \
    JAVAC="oefatal \"No Java compilation expected here.\"" \
    jar
}

do_stage() {
  oe_jarinstall -s ${S}/src/java/api/${JAR} ${PN}.jar
}

do_install() {
  oe_jarinstall src/java/api/${JAR} ${PN}.jar
}

SRC_URI[md5sum] = "34c8a093e5678dd633411dfea88f8558"
SRC_URI[sha256sum] = "e17aa1a26119966258a3656a262bbba0f0b036eecb6d9bf192cf4b497686f4c3"
