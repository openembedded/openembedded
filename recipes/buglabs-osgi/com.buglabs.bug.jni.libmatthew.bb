require bug-osgi.inc
inherit jni-library

PR = "${INC_PR}.7+svnr${SRCREV}"
FILES_${PN} += "${JNI_LIB_DIR}/libcgi-java.so"
FILES_${PN} += "${JNI_LIB_DIR}/libunix-java.so"
DEPENDS += "classpath"
JAVAC_OPTIONS="-source 1.5"
