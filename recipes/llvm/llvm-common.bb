DESCRIPTION = "Helper script for OE's llvm support"

BBCLASSEXTEND = "native"

SRC_URI = "file://llvm-config"

PACKAGES = ""

do_install() {
  install -d ${D}${bindir}
  install -m 0755 ${WORKDIR}/llvm-config ${D}${bindir}
}
