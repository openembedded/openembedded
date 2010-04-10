DESCRIPTION = "camsource grabs images from a video4linux device and makes them \
available to various plugins for processing or handling."
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "jpeg libxml2"

SRC_URI = "${SOURCEFORGE_MIRROR}/camsource/camsource-${PV}.tar.bz2 \
	   file://gcc34.patch;patch=1"
S = "${WORKDIR}/camsource-${PV}"

inherit autotools

SRC_URI[md5sum] = "ffd824f13f99011984399fc3b7526c71"
SRC_URI[sha256sum] = "837ba51635e01209dc2886491afbc2e97629bfaf32e73566a1862ea0dc090756"
