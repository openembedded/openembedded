inherit gpe

DEPENDS = "libxsettings libxsettings-client glib-2.0"
SECTION = "gpe"
DESCRIPTION = "GPE configuration utility"
LICENSE = "GPL"
SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.gz"

SRC_URI += "file://makefile-fix.patch;patch=1"

SRC_URI[md5sum] = "cbe38d183fa6cf0d7c29b4befd0d71d6"
SRC_URI[sha256sum] = "f5d79766715012ea7bb7ef164994963950c3343ef025ee71d1540aa26ab48c8c"
