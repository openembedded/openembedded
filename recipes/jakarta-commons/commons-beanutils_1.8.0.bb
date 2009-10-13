require jakarta-commons.inc

DESCRIPTION = "Static utility methods useful in manipulating Java classes that conform to the JavaBeans Specification"

SRC_URI = "http://www.apache.org/dist/commons/beanutils/source/${BP}-src.tar.gz"

DEPENDS += "commons-collections3 commons-logging"
RDEPENDS = "libcommons-collections3-java libcommons-logging-java"

CP = "commons-collections3 commons-logging"
