require jakarta-commons.inc

DESCRIPTION = "Static utility methods useful in manipulating Java classes that conform to the JavaBeans Specification"

SRC_URI = "http://www.apache.org/dist/commons/beanutils/source/${BP}-src.tar.gz"

DEPENDS += "commons-collections3 commons-logging"
RDEPENDS_${PN} = "libcommons-collections3-java libcommons-logging-java"

CP = "commons-collections3 commons-logging"

SRC_URI[md5sum] = "1bce3cfa4ae33c94686422e78abc0792"
SRC_URI[sha256sum] = "aff3c8c772e4ff32f2d9a37a727a488583372e45535a3d5aad09662691851dcf"
