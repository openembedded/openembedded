LICENSE = "GPL"
DEPENDS = "nxcomp"

SRC_URI = "http://64.34.161.181/download/3.4.0/sources/${PN}-${PV}.tar.gz \
           "

SRC_URI[md5sum] = "95ce93520d463a3d18cdd5d19c321e85"
SRC_URI[sha256sum] = "ecf740db00f2a223f520809f6cf5623d05eb2709e2ea8eadfb9a97b906fabfa6"

S = "${WORKDIR}/${PN}"

inherit autotools

do_install () {
        oe_runmake "bindir=${D}${bindir}" \
                   "man1dir=${D}${mandir}" \
                   install
}
