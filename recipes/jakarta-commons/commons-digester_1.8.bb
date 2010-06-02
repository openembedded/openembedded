require jakarta-commons.inc

DESCRIPTION = "Converts XML to a Java object by a set of mapping rules."

SRC_URI = "http://www.apache.org/dist/commons/digester/source/${BP}-src.tar.gz"

DEPENDS += "commons-logging commons-beanutils"
RDEPENDS_${PN} = "libcommons-logging-java libcommons-beanutils-java"

CP = "commons-logging commons-beanutils"

FINDARGS = "-name '*.dtd'"

SRC_URI[md5sum] = "689f41905a68c67f7231f9afbb3e2147"
SRC_URI[sha256sum] = "d9a965c82828a881d2ab6256fba7076f62815a9545b3af9d553dc5271577182b"
