DESCRIPTION = "libspf2 is a complete and robust implementation of SPF which \
provides support for many MTAs."
SECTION = "libs/network"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
LICENSE = "GPL"
SRC_URI = "http://www.libspf2.org/spf/libspf2-${PV}.tar.gz"
S = "${WORKDIR}/libspf2-${PV}"

inherit autotools

PACKAGES =+ "${PN}-bin"
FILES_${PN}-bin = "${bindir}"
FILES_${PN} = "${libdir}/lib*.so.*"
