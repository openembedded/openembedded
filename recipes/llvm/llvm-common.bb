DESCRIPTION = "Helper script for OE's llvm support"

SRC_URI = "file://llvm-config"

PACKAGES = ""

do_install() {
	:
}

do_stage() {
	install -d ${STAGING_BINDIR_CROSS}
  install -m 0755 ${WORKDIR}/llvm-config ${STAGING_BINDIR_CROSS}
}
