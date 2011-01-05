DESCRIPTION = "libnl2 is a library for applications dealing with netlink sockets"
SECTION = "libs/network"
LICENSE = "LGPL"
HOMEPAGE = "http://www.infradead.org/~tgr/libnl/"
PE = "1"

inherit autotools pkgconfig

includedir = ${prefix}/include/libnl2

S = "${WORKDIR}/libnl-${PV}"
SRC_URI = "\
  http://www.infradead.org/~tgr/libnl/files/libnl-${PV}.tar.gz \
  file://fix-pc-file.patch \
"
SRC_URI[md5sum] = "6aaf1e9802a17a7d702bb0638044ffa7"
SRC_URI[sha256sum] = "5a40dc903d3ca1074da7424b908bec8ff16936484798c7e46e53e9db8bc87a9c"

PACKAGES =+ "${PN}-route ${PN}-nf ${PN}-genl ${PN}-cli"
FILES_${PN}-route = "${libdir}/libnl-route.so.*"
FILES_${PN}-nf    = "${libdir}/libnl-nf.so.*"
FILES_${PN}-genl  = "${libdir}/libnl-genl.so.*"
FILES_${PN}-cli   = "${libdir}/libnl-cli.so.*"
