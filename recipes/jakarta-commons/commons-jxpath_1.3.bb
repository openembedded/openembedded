require jakarta-commons.inc

DESCRIPTION = "JXPath interpreter for Java"

SRC_URI = "http://www.apache.org/dist/commons/jxpath/source/${BP}-src.tar.gz"

DEPENDS += "commons-logging commons-collections3 commons-beanutils servlet2.3 jdom"
RDEPENDS = "libcommons-logging-java libcommons-collections3-java libcommons-beanutils-java libservlet2.3-java libjdom-java"

CP = "commons-logging commons-collections3 commons-beanutils servlet-2.3 jdom"
