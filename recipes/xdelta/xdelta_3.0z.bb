DESCRIPTION = "utilities for creating binary deltas"
LICENSE = "GPLv2+"
PR = "r1"
SRC_URI = "http://xdelta.googlecode.com/files/xdelta${PV}.tar.gz \
        file://xdelta-3.0z-use-oe-cflags.patch;apply=yes"

S = "${WORKDIR}/${PN}${PV}"

do_compile() {
        oe_runmake
}

do_install() {
        install -d ${D}${bindir}
        install -m 0755 ${S}/xdelta3 ${D}${bindir}/xdelta3
}

SRC_URI[md5sum] = "2b5b3c33438cff581ce5c12d66c28b6c"
SRC_URI[sha256sum] = "5504b25eb21c743a651367976b40655ea874603976d83fd50ea8a3ef8725f3e6"
