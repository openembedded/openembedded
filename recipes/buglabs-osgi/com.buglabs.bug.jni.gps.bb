require bug-osgi.inc
inherit jni-library

PR = "${INC_PR}.5+svnr${SRCREV}"
FILES_${PN} += "${JNI_LIB_DIR}/libGPS.so"

DEPENDS += "com.buglabs.common com.buglabs.bug.jni.common classpath virtual/kernel"
