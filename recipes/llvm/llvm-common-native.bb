require llvm-common.bb

inherit native

do_install() {
	:
}

do_stage() {
	install -d ${STAGING_BINDIR}
  install -m 0755 ${WORKDIR}/llvm-config ${STAGING_BINDIR}
}
