require genext2fs.inc


SRC_URI = "${SOURCEFORGE_MIRROR}/genext2fs/genext2fs-${PV}.tar.gz \
	   file://volume.patch;patch=1"

DEFAULT_PREFERENCE = "1"

inherit autotools

SRC_URI[md5sum] = "b7b6361bcce2cedff1ae437fadafe53b"
SRC_URI[sha256sum] = "404dbbfa7a86a6c3de8225c8da254d026b17fd288e05cec4df2cc7e1f4feecfc"
