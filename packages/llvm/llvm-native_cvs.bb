require llvm.inc

inherit native

PV = "1.9+cvs${SRCDATE}"

SRC_URI = "cvs://anon@llvm.org/var/cvs/llvm;module=llvm"

S = "${WORKDIR}/llvm"

do_stage() {
	install -m 755 ${S}/Debug/bin/* ${STAGING_BINDIR_NATIVE}/
}
