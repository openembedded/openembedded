require jakarta-commons.inc

DESCRIPTION = "Java Internet protocol suite library"

SRC_URI = "http://www.apache.org/dist/commons/logging/source/${BP}-src.tar.gz"

DEPENDS += "log4j1.2 servlet2.3 logkit"

CP = "log4j-1.2 servlet-2.3 logkit"

COMPILE_FINDARGS = "-name '*.java' -and -not -name '*Avalon*'"

