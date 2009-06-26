DESCRIPTION = "BYTE Magazine's native benchmarks (also called BYTEmark) \
designed to expose the capabilities of a system's CPU, FPU, \
and memory system."
HOMEPAGE = "http://www.tux.org/~mayer/linux/"
LICENSE = "freely distributable"
SECTION = "console/utils"

SRC_URI = "http://www.tux.org/~mayer/linux/${PN}-${PV}.tar.gz \
           file://nbench_32bits.patch;patch=1"

PR = "r1"

TARGET_CC_ARCH += "${CFLAGS} ${LDFLAGS}"
do_compile() {
	oe_runmake
}

do_install () {
	install -d ${D}${bindir}
	install -m 0644 NNET.DAT ${D}${bindir}/
	install -m 0755 nbench ${D}${bindir}/
}
