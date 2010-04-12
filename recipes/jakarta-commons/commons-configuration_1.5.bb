require jakarta-commons.inc

DESCRIPTION = "Generic configuration interface for Java applications"

SRC_URI = "\
	http://www.apache.org/dist/commons/configuration/source/${BP}-src.tar.gz;name=archive \
	http://ftp.hosting-studio.de/pub/linux/apache/ant/source/apache-ant-1.7.1-src.tar.bz2;name=ant \
"

DEPENDS += "commons-logging commons-collections3 commons-beanutils commons-codec commons-digester commons-jxpath commons-lang servlet2.4"
RDEPENDS = "libcommons-logging-java libcommons-collections3-java libcommons-beanutils-java libcommons-codec-java libcommons-digester-java libcommons-jxpath-java libcommons-lang-java libservlet2.4-java"

CP = "commons-logging commons-collections3 commons-beanutils commons-codec commons-digester commons-jxpath commons-lang servlet-api-2.4"

# Makes use of -sourcepath hack: We inject Ant sourcefiles into the build and remove them
# afterwards.
COMPILE_SOURCEPATH = "${WORKDIR}/apache-ant-1.7.1/src/main:src/java"

CLEAN_PATH = "build/org/apache/tools"

SRC_URI[archive.md5sum] = "6a019d26d576a87eda2ef84c8ffc2e31"
SRC_URI[archive.sha256sum] = "06e5dd81c1302118298156f70b8138fa131ed8f258671b1b67e36a34d80357a0"
SRC_URI[ant.md5sum] = "0d68db4a1ada5c91bcbf53cefd0c2fd7"
SRC_URI[ant.sha256sum] = "4dc49a7260ef90a6dc6611b7e96b9f047d507589736d4a2ad6efbe3edfc6fba6"
