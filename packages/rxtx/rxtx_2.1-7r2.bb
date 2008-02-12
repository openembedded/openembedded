DESCRIPTION = "RXTX provides serial and parallel communication for Java applications"
LICENSE = "LGPL"
SECTION = "libs"
HOMEPAGE = "http://rxtx.org"

inherit autotools java-library

SRC_URI = "\
    http://rxtx.qbang.org/pub/rxtx/${PN}-${PV}.zip \
    file://rxtx-fixes-from-debian.patch;patch=1 \
    "

do_install() {
  install -d ${D}/${libdir_jni}
  install -d ${D}/${datadir_java}

  oe_runmake install \
    RXTX_PATH=${D}/${libdir_jni} \
    JHOME=${D}/${datadir_java}
}

do_stage() {
  oe_jarinstall -s RXTXcomm.jar
}

PACKAGES = "${JPN} lib${PN}-jni lib${PN}-dev lib${PN}-jni-dbg"

FILES_lib${PN}-jni = "${libdir_jni}/lib*.so"
FILES_lib${PN}-dev = "${libdir_jni}/lib*.la"
FILES_lib${PN}-jni-dbg = "${libdir_jni}/.debug/lib*.so"
