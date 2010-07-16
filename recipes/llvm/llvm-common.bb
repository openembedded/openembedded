DESCRIPTION = "Helper script for OE's llvm support"

PR = "r3"

SRC_URI = "file://llvm-config"

NATIVE_INSTALL_WORKS = "1"

do_install_virtclass-native() {
  install -d ${D}${bindir}
  install -m 0755 ${WORKDIR}/llvm-config ${D}${bindir}
}

do_install() {
  install -d ${STAGING_BINDIR_CROSS}
  install -m 0755 ${WORKDIR}/llvm-config ${STAGING_BINDIR_CROSS}
}

BBCLASSEXTEND = "native"
