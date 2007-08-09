DESCRIPTION = "GPE panel clock"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ libschedule libgpewidget gpe-announce atd libgpelaunch"
RDEPENDS = "gpe-announce"

inherit autotools

SRC_URI = "${GPE_SVN} \
           file://svn-build.patch;patch=1"

S = "${WORKDIR}/${PN}"

DEFAULT_PREFERENCE = "-1"
