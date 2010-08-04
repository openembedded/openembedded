require jakarta-commons.inc

DESCRIPTION = "Java Internet protocol suite library"

SRC_URI = "http://www.apache.org/dist/commons/net/source/${BP}-src.tar.gz"

S = "${WORKDIR}/${BP}"

DEPENDS += "oro"
DEPENDS_virtclass-native += "oro-native"

RDEPENDS_${PN} = "liboro-java"
RDEPENDS_${PN}_virtclass-native = ""

CP = "oro"

MAINSOURCES = "src/java/org"

SRC_URI[md5sum] = "ccbb3f67b55e8a7a676499db4386673c"
SRC_URI[sha256sum] = "fdea779f261f70b9bbec40121c830b11e3e63b6188f662f95505045ff8d44add"

NATIVE_INSTALL_WORKS = "1"
BBCLASSEXTEND = "native"
