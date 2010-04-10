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

# Allow empty package to fix SDK depchains
ALLOW_EMPTY_${PN} = "1"

FILES_${PN}-doc += "${datadir}/libatomic_ops/COPYING ${datadir}/libatomic_ops/*.txt"

SRC_URI[md5sum] = "1b65e48271c81e3fa2d7a9a69bab7504"
SRC_URI[sha256sum] = "a3d8768aa8fd2f6ae79be2d756b3a6b48816b3889ae906be3d5ffb2de5a5c781"
