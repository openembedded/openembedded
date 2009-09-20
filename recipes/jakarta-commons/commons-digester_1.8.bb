require jakarta-commons.inc

DESCRIPTION = "Converts XML to a Java object by a set of mapping rules."

SRC_URI = "http://www.apache.org/dist/commons/digester/source/${BP}-src.tar.gz"

DEPENDS += "commons-logging commons-beanutils"
RDEPENDS = "libcommons-logging-java libcommons-beanutils-java"

CP = "commons-logging commons-beanutils"

FINDARGS = "-name '*.dtd'"
