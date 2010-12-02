require bug-osgi.inc
inherit jni-library
PR = "r3"
FILES_${PN} += "${JNI_LIB_DIR}/librxtxParallel.so"
FILES_${PN} += "${JNI_LIB_DIR}/librxtxRaw.so"
FILES_${PN} += "${JNI_LIB_DIR}/librxtxSerial.so"
FILES_${PN} += "${JNI_LIB_DIR}/librxtxI2C.so"
DEPENDS += "com.buglabs.common com.buglabs.bug.jni.common classpath virtual/kernel"

