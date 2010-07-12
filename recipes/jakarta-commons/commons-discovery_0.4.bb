require jakarta-commons.inc

DESCRIPTION = "discovering, or finding, implementations for pluggable interfaces"

SRC_URI = "http://www.apache.org/dist/commons/discovery/source/${BP}-src.tar.gz"

DEPENDS += "commons-logging"
RDEPENDS = "libcommons-logging-java"

CP = "commons-logging"
