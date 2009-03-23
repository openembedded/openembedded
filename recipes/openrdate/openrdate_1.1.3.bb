DESCRIPTION = "Date and time setting software implementing RFC 868 and RFC 2030 protocols"
HOMEPAGE = "http://sourceforge.net/projects/openrdate/"
SECTION = "admin"
LICENSE = "BSD"
PR="r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/openrdate/openrdate-${PV}.tar.gz \
           file://debian.patch;patch=1"

inherit autotools

do_stage() {
        autotools_stage_all
}
