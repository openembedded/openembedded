DESCRIPTION = "Various ELF utilities"
HOMEPAGE    = "http://www.gentoo.org/proj/en/hardened/pax-utils.xml"
LICENSE     = "GPLv2"
MAINTAINER  = "freyther@handhelds.org"

SRC_URI     = "${GENTOO_MIRROR}/pax-utils-${PV}.tar.bz2;md5sum=71e8d13d072efcbc4123960211a34d4f"
S           = "${WORKDIR}/pax-utils-${PV}"

do_compile() {
    oe_runmake
}

do_install() {
    oe_runmake DESTDIR=${D} install
}

