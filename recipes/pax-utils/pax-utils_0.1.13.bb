DESCRIPTION = "Various ELF utilities"
HOMEPAGE    = "http://www.gentoo.org/proj/en/hardened/pax-utils.xml"
LICENSE     = "GPLv2"
PR          = "r1"
SRC_URI     = "http://gentoo.osuosl.org/distfiles/pax-utils-${PV}.tar.bz2"
S           = "${WORKDIR}/pax-utils-${PV}"

CPPFLAGS   += "-D_GNU_SOURCE "

do_compile() {
    oe_runmake
}

do_install() {
    oe_runmake DESTDIR=${D} install
}


SRC_URI[md5sum] = "5f09df47a16e83462384b44b75310539"
SRC_URI[sha256sum] = "72f3cdad93b5436070dcc63b67764a06c594f324ccc001e8bfb974a8d1a86f36"
