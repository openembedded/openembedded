require jakarta-commons.inc

DESCRIPTION = "Robust, high-performance, file upload capability for Java servlets and web applications"

SRC_URI = "http://www.apache.org/dist/commons/fileupload/source/${BP}-src.tar.gz"

DEPENDS += "commons-beanutils commons-io servlet2.3"
RDEPENDS_${PN} = "libcommons-beanutils-java libcommons-io-java libservlet2.3-java"

CP = "commons-beanutils commons-io servlet-2.3"

# Exclude portlet stuff from compilation like Debian does.
COMPILE_FINDARGS = "-name '*.java' -not -wholename '*portlet*'"


SRC_URI[md5sum] = "c2bdb9264aec564e3f4fbbdf4344a844"
SRC_URI[sha256sum] = "08905cb3a0db4f7fa67f3b579b2c481060334d50d7f913c6974c7513243152f5"
