DESCRIPTION = "Libcgroup"
PRIORITY = "optional"
SECTION = "libs"
LICENSE = "LGPL"
#DEPENDS = "bison-native flex-native"
PR = "r1"

inherit autotools pkgconfig

DEPENDS = "libpam"

SRC_URI = "${SOURCEFORGE_MIRROR}/project/libcg/${PN}/v${PV}/${PN}-${PV}.tar.bz2"

SRC_URI[md5sum] = "2b0fedf37e8f3e915a2f4f3f10879076"
SRC_URI[sha256sum] = "7fdb171c09d7e9d13d118045a5651b8c146ede979c05aca0f6bb20624e6a73e3"
