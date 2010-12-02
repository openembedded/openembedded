require bug-osgi.inc
inherit jni-library

PR = "${INC_PR}.7+svnr${SRCREV}"
FILES_${PN} += "${JNI_LIB_DIR}/libCamera.so"

DEPENDS += "com.buglabs.common com.buglabs.bug.jni.common classpath jpeg virtual/kernel jpeg"
