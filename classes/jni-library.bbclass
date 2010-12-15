# we need javah
DEPENDS += "openjdk-langtools-native zip-native icedtea6-native"

JNI_LIB_DIR = "/usr/lib/jni"

PACKAGE_ARCH = "${MACHINE_ARCH}"

EXTRA_OEMAKE +=" \
	JAVAH_OUT=${D}${JNI_LIB_DIR} \
	LIB_DIR=${D}${JNI_LIB_DIR} \
	JAVAH_CLASSPATH=${S}/build --debug \
	COMMON_CLASSPATH=${STAGING_LIBDIR}/com.buglabs.bug.jni.common.jar \
	STAGING_BUG_INCDIR=${STAGING_INCDIR}/bug \
	BUG_LINUX_SRC=${STAGING_KERNEL_DIR} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	CLASSPATH_INCDIR=${STAGING_INCDIR}/classpath \
	ROOTFS_BUG=${STAGING_LIBDIR}/../../ \
	JAVAH=${STAGING_LIBDIR_JVM_NATIVE}/icedtea6-native/bin/javah \
"

addtask jni_compile after do_compile before do_install
do_jni_compile() {
        cd ${S}/src/c
        oe_runmake jni
}

addtask jni_install after do_install before do_package
do_jni_install() {
  install -d ${D}${JNI_LIB_DIR}
  cd ${S}/src/c
  oe_runmake libs
}

addtask jni_update_jar after do_jni_install before do_package
do_jni_update_jar(){
  cd ${S}/src/c/
  install -d lib/
  cp *.so lib/
  zip -u ${D}${datadir_java}/${JARFILENAME} lib/*.so
}

addtask jni_staging after do_jni_install before do_package
do_jni_staging() {
  if test -e ${S}/src/c/*.so; then
	install -d ${STAGING_LIBDIR}/bug
	cp -r ${S}/src/c/*.so ${STAGING_LIBDIR}/bug
	cp -r ${S}/src/c/*.so ${STAGING_LIBDIR}/
  fi

  if test -e ${S}/src/c/include/*.h; then
	  install -d ${STAGING_INCDIR}/bug
	  cp -r ${S}/src/c/include/*.h ${STAGING_INCDIR}/bug
	  cp -r ${S}/src/c/include/*.h ${STAGING_INCDIR}/
  fi
}
