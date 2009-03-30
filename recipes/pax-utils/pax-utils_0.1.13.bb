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

