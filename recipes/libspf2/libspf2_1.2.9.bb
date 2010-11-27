DESCRIPTION = "libspf2 is a complete and robust implementation of SPF which \
provides support for many MTAs."
SECTION = "libs/network"
LICENSE = "LGPL"
HOMEPAGE = "http://spf.anarres.org/index.html"
SRC_URI = "http://spf.anarres.org/spf/libspf2-${PV}.tar.gz"
S = "${WORKDIR}/libspf2-${PV}"

SRC_URI[md5sum] = "3305df4d1b13ca964d80b23bb5e4e2b6"
SRC_URI[sha256sum] = "4837f6b063b1431673754cbf6bef8979de5ffc4d7f26f6b93abd42787ba04862"

inherit autotools

PACKAGES =+ "${PN}-bin-dbg ${PN}-bin"
FILES_${PN}-bin = "${bindir}"
FILES_${PN}-bin-dbg = "${bindir}/.debug"
FILES_${PN} = "${libdir}/lib*.so.*"
