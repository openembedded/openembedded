require bug-osgi.inc
inherit jni-library

SRC_URI = "svn://bugcamp.net/bug/branches/trunk-precleaned;module=${PN};proto=svn "
PR = "${INC_PR}.5+svnr${SRCREV}"
FILES_${PN} += "${JNI_LIB_DIR}/libMotion.so"

DEPENDS += "com.buglabs.common com.buglabs.bug.jni.common com.buglabs.bug.jni.accelerometer classpath virtual/kernel"
