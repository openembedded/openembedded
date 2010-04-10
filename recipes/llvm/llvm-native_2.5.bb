require llvm.inc

SRC_URI = "http://llvm.org/releases/2.5/llvm-${PV}.tar.gz"

inherit native

S = "${WORKDIR}/llvm-${PV}"

do_stage() {
	install -m 755 ${S}/Release/bin/* ${STAGING_BINDIR_NATIVE}/
}

do_rm_work() {
        :
}

SRC_URI[md5sum] = "55df2ea8665c8094ad2ef85187b9fc74"
SRC_URI[sha256sum] = "8f3d69e63bc5d1ee2c2ee49ff07ccb7e070070a0e937813d2a6179b9e2e173ed"
