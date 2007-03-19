require llvm.inc

inherit native

S = "${WORKDIR}/llvm-${PV}"

do_stage() {
	install -m 755 ${S}/Release/bin/* ${STAGING_BINDIR_NATIVE}/
}
