require genext2fs.inc


SRC_URI = "${SOURCEFORGE_MIRROR}/genext2fs/genext2fs-${PV}.tar.gz \
	   file://volume.patch;patch=1"

DEFAULT_PREFERENCE = "1"

inherit autotools
