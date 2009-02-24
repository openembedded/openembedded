DESCRIPTION = "A library for replaying C64 SID music"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "\
  ftp://ftp.uni-frankfurt.de/pub/Mirrors2/gentoo.org/distfiles/libsidplay-1.36.59.tgz \
  http://ftp.debian.org/debian/pool/main/libs/libsidplay/libsidplay_1.36.59-5.diff.gz;patch=1 \
"

inherit autotools_stage
