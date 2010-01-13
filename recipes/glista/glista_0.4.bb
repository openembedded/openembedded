DESCRIPTION = "Glista is very simple personal to-do list manager"
AUTHOR = "Shahar Evron <shahar at prematureoptimization.org>"
HOMEPAGE = "http://prematureoptimization.org/glista/"
SECTION = "x11/applications"
PRIORITY = "optional"
LICENSE = "GPLv3"
DEPENDS = "gtk+ (>=2.12.0) libxml2"
SRC_URI = "http://glista.googlecode.com/files/glista-${PV}.tar.gz"

inherit autotools
