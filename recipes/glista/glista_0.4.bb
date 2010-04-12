DESCRIPTION = "Glista is very simple personal to-do list manager"
AUTHOR = "Shahar Evron <shahar at prematureoptimization.org>"
HOMEPAGE = "http://prematureoptimization.org/glista/"
SECTION = "x11/applications"
PRIORITY = "optional"
LICENSE = "GPLv3"
DEPENDS = "gtk+ (>=2.12.0) libxml2"
SRC_URI = "http://glista.googlecode.com/files/glista-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "db4afe3ba157232a6debe58885c693e6"
SRC_URI[sha256sum] = "39289c0fc3efd3b003730212201ce7d8a56b06fcf080188ecc76d4ad9375c807"
