DESCRIPTION = "libnl2 is a library for applications dealing with netlink sockets"
SECTION = "libs/network"
LICENSE = "LGPL"
HOMEPAGE = "http://people.suug.ch/~tgr/libnl"
PV = "1.9+gitr${SRCREV}"
PR = "r1"

inherit autotools

includedir = ${prefix}/include/libnl2

SRC_URI = "\
  git://git.kernel.org/pub/scm/libs/netlink/libnl.git;protocol=git \
  file://fix-pc-file.patch;patch=1 \
"
S = "${WORKDIR}/git"

PACKAGES =+ "${PN}-route ${PN}-nf ${PN}-genl ${PN}-cli"
FILES_${PN}-route = "${libdir}/libnl-route.so.*"
FILES_${PN}-nf    = "${libdir}/libnl-nf.so.*"
FILES_${PN}-genl  = "${libdir}/libnl-genl.so.*"
FILES_${PN}-cli   = "${libdir}/libnl-cli.so.*"
