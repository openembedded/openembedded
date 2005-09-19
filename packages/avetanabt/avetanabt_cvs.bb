DESCRIPTION = "avetanaBT: Bluetooth API implementation for Java (JSR-82)"
SECTION = "devel"
DEPENDS = "findutils-native jikes-native kaffeh-native fastjar-native bluez-libs classpath"
#RDEPENDS = "bluez-utils"
# Matthias Ringwald <mringwal@inf.ethz.ch> was helping me in the first phase. Thanks.
MAINTAINER = "Mustafa Yuecel <yuecelm@ee.ethz.ch>"
LICENSE = "GPL"
HOMEPAGE = "http://sourceforge.net/projects/avetanabt/"

PV = "0.0cvs${CVSDATE}"
PR = "r2"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/avetanabt;module=avetanabt \
	   file://avetanalocaldevice.patch;patch=1"

S = "${WORKDIR}/avetanabt"

PACKAGES = "${PN}"
FILES_${PN} = "${libdir}/libavetanaBT.so ${datadir}/avetanabt/avetanaBT.jar"

do_compile() {

  # doing nearly the same as in Makefile written...

  mkdir -p build
  rm -fr build/*

  # javac -> jikes
  ${STAGING_BINDIR}/find {de,javax,com} -iname *.java > file.list
  ${STAGING_BINDIR}/jikes -verbose --bootclasspath ${STAGING_DIR}/${BUILD_SYS}/share/kaffeh/rt.jar -d build @file.list

  # create own version.xml (add version information at runtime)
  head -n 4 version.xml >> build/version.xml
  echo "    <build value=\"${PV}-${PR}\" date=\"${CVSDATE}\" time=\"${@time.strftime('%H:%M',time.gmtime())}\"/>" >> build/version.xml
  tail -n 3 version.xml >> build/version.xml

  # jar -> fastjar
  cd build
  ${STAGING_BINDIR}/fastjar -cf ../avetanaBT.jar de javax com version.xml
  cd ..

  # JNI generated header file - de_avetana_bluetooth_stack_BlueZ.h
  # javah -> kaffeh
  cd c
  ${STAGING_BINDIR}/kaffeh -jni -classpath ../avetanaBT.jar:${STAGING_DIR}/${BUILD_SYS}/share/kaffeh/rt.jar de.avetana.bluetooth.stack.BlueZ

  # Native language (C) library - libavetanaBT.so
  ${CXX} ${CXXFLAGS} -shared -lbluetooth -I${STAGING_INCDIR}/classpath BlueZ.cpp -o ../libavetanaBT.so ${LDFLAGS}
  cd ..

}

do_stage() {

  install -d ${STAGING_DIR}/${BUILD_SYS}/share/avetanabt
  install avetanaBT.jar ${STAGING_DIR}/${BUILD_SYS}/share/avetanabt/

}

do_install() {

  install -d ${D}${libdir}
  install -m 0755 libavetanaBT.so ${D}${libdir}/

  install -d ${D}${datadir}/avetanabt
  install avetanaBT.jar ${D}${datadir}/avetanabt/
 
}
