require bug-osgi.inc
inherit jni-library

PR = "${INC_PR}.5+svnr${SRCREV}"
FILES_${PN} += "${JNI_LIB_DIR}/libCommon.so"

DEPENDS += "com.buglabs.common classpath"
