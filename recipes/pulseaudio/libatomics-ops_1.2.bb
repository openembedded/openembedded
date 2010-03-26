DESCRIPTION = "A library for atomic integer operations"
LICENSE = "MIT"

PR = "r3"

SRC_URI = "http://www.hpl.hp.com/research/linux/atomic_ops/download/libatomic_ops-1.2.tar.gz \
           file://fedora/libatomic_ops-1.2-ppclwzfix.patch;patch=1 \
           file://gentoo/libatomic_ops-1.2-mips.patch;patch=1 \
	   file://dont.install.header.twice.patch;patch=1"

S = "${WORKDIR}/libatomic_ops-${PV}"

ARM_INSTRUCTION_SET = "arm"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}	

FILES_${PN}-doc += "${datadir}/libatomic_ops/COPYING ${datadir}/libatomic_ops/*.txt"
