require jakarta-commons.inc

DESCRIPTION = "discovering, or finding, implementations for pluggable interfaces"

SRC_URI = "http://www.apache.org/dist/commons/discovery/source/${BP}-src.tar.gz"

DEPENDS += "commons-logging"
RDEPENDS_${PN} = "libcommons-logging-java"

CP = "commons-logging"

SRC_URI[md5sum] = "1275ad4c6ce54b9323269e30dc42dd0e"
SRC_URI[sha256sum] = "596242302be4f0502073f5a934c608289bba6221591e7dbea53ce629f67498a3"
