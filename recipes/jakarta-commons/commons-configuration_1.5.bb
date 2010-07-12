require jakarta-commons.inc

DESCRIPTION = "Generic configuration interface for Java applications"

SRC_URI = "\
	http://www.apache.org/dist/commons/configuration/source/${BP}-src.tar.gz \
	http://ftp.hosting-studio.de/pub/linux/apache/ant/source/apache-ant-1.7.1-src.tar.bz2 \
"

DEPENDS += "commons-logging commons-collections3 commons-beanutils commons-codec commons-digester commons-jxpath commons-lang servlet2.4"
RDEPENDS = "libcommons-logging-java libcommons-collections3-java libcommons-beanutils-java libcommons-codec-java libcommons-digester-java libcommons-jxpath-java libcommons-lang-java libservlet2.4-java"

CP = "commons-logging commons-collections3 commons-beanutils commons-codec commons-digester commons-jxpath commons-lang servlet-api-2.4"

# Makes use of -sourcepath hack: We inject Ant sourcefiles into the build and remove them
# afterwards.
COMPILE_SOURCEPATH = "${WORKDIR}/apache-ant-1.7.1/src/main:src/java"

CLEAN_PATH = "build/org/apache/tools"
