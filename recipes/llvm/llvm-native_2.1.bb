require llvm.inc

SRC_URI = "http://llvm.org/releases/2.1/llvm-${PV}.tar.gz"


inherit native

S = "${WORKDIR}/llvm-${PV}"

do_stage() {
	install -m 755 ${S}/Release/bin/* ${STAGING_BINDIR_NATIVE}/
}

do_rm_work() {
        :
}
