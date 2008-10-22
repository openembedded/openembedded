DESCRIPTION = "avetanaBT: Bluetooth API implementation for Java (JSR-82)"
SECTION = "devel"
DEPENDS = "findutils-native virtual/javac-native kaffeh-native fastjar-native bluez-libs classpath"
LICENSE = "GPL"
HOMEPAGE = "http://sourceforge.net/projects/avetanabt/"

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/avetanabt/avetanaBluetooth-${PV}.tgz"

S = "${WORKDIR}/avetanabt"

FILES_${PN} = "${libdir}/libavetanaBT.so ${datadir}/avetanabt/avetanaBT.jar"

do_compile() {

  # doing nearly the same as in Makefile written...

  # clean build directory
  mkdir -p build
  rm -fr build/*

  # generate classes
  ${STAGING_BINDIR_NATIVE}/find {de,javax,com} -iname *.java > file.list
  ${STAGING_BINDIR_NATIVE}/javac -verbose -bootclasspath ${STAGING_DATADIR_NATIVE}/kaffeh/rt.jar -d build @file.list

  # create own version.xml (add version information available at runtime)
  head -n 4 version.xml >> build/version.xml
  echo "    <build value=\"cvs${SRCDATE}\" date=\"${SRCDATE}\" time=\"${@time.strftime('%H:%M',time.gmtime())}\"/>" >> build/version.xml
  tail -n 3 version.xml >> build/version.xml

  # move classes into jar archive
  # jar -> fastjar
  ${STAGING_BINDIR_NATIVE}/fastjar -v -cf avetanaBT.jar -C build de -C build javax -C build com -C build version.xml

  # JNI generated header file - de_avetana_bluetooth_stack_BlueZ.h
  # javah -> kaffeh
  ${STAGING_BINDIR_NATIVE}/kaffeh -jni -classpath avetanaBT.jar:${STAGING_DATADIR_NATIVE}/kaffeh/rt.jar -d c de.avetana.bluetooth.stack.BlueZ

  # Native language (C) library - libavetanaBT.so
  ${CXX} ${CXXFLAGS}  -shared -lbluetooth -I${STAGING_INCDIR}/classpath c/BlueZ.cpp -o libavetanaBT.so ${LDFLAGS}

}

do_stage() {

  install -d ${STAGING_DATADIR_NATIVE}/avetanabt
  install avetanaBT.jar ${STAGING_DATADIR_NATIVE}/avetanabt/

}

do_install() {

  install -d ${D}${libdir}
  install -m 0755 libavetanaBT.so ${D}${libdir}/

  install -d ${D}${datadir}/avetanabt
  install avetanaBT.jar ${D}${datadir}/avetanabt/

}
