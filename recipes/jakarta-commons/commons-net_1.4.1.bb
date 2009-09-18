require jakarta-commons.inc

DESCRIPTION = "Java Internet protocol suite library"

SRC_URI = "http://www.apache.org/dist/commons/net/source/${BP}-src.tar.gz"

S = "${WORKDIR}/${BP}"

DEPENDS += "oro"
RDEPENDS = "liboro-java"

CP = "oro"

MAINSOURCES = "src/java/org"
