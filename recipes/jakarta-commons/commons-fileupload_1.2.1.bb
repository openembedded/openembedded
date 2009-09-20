require jakarta-commons.inc

DESCRIPTION = "Robust, high-performance, file upload capability for Java servlets and web applications"

SRC_URI = "http://www.apache.org/dist/commons/fileupload/source/${BP}-src.tar.gz"

DEPENDS += "commons-beanutils commons-io servlet2.3"
RDEPENDS = "libcommons-beanutils-java libcommons-io-java libservlet2.3-java"

CP = "commons-beanutils commons-io servlet-2.3"

# Exclude portlet stuff from compilation like Debian does.
COMPILE_FINDARGS = "-name '*.java' -not -wholename '*portlet*'"

