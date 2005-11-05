DESCRIPTION = "camsource grabs images from a video4linux device and makes them \
available to various plugins for processing or handling."
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "jpeg libxml2"

SRC_URI = "${SOURCEFORGE_MIRROR}/camsource/camsource-${PV}.tar.bz2 \
	   file://gcc34.patch;patch=1"
S = "${WORKDIR}/camsource-${PV}"

inherit autotools
