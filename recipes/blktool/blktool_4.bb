DESCRIPTION = "Display or change block device settings"
LICENSE = "GPLv2"

DEPENDS = "glib-2.0"
PR = "r2"

SRC_URI = "${DEBIAN_MIRROR}/main/b/blktool/blktool_4.orig.tar.gz"

S = "${WORKDIR}/${PN}-${PV}.orig"

inherit pkgconfig autotools

SRC_URI[md5sum] = "62edc09c9908107e69391c87f4f3fd40"
SRC_URI[sha256sum] = "b1e6d5912546d2a4b704ec65c2b9664aa3b4663e7d800e06803330335a2cb764"
