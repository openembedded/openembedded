DESCRIPTION = "Library for interacting with ID3 tags."
SECTION = "libs/multimedia"
PRIORITY = "optional"
DEPENDS = "zlib"
LICENSE = "GPL"
PR = "r2"

inherit autotools

SRC_URI = "${SOURCEFORGE_MIRROR}/id3lib/id3lib-${PV}.tar.gz \
           http://ftp.de.debian.org/debian/pool/main/i/id3lib3.8.3/id3lib3.8.3_3.8.3-7.2.diff.gz;patch=1 \
          "

do_stage() {
	autotools_stage_all
}
