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

SRC_URI[md5sum] = "af4785f615b9d87b9c86a32af4ecc225"
SRC_URI[sha256sum] = "0f8a034107fc7593f28e77b276f964c1309343b4702ecdf0d61bb3e57ad0cb5f"
