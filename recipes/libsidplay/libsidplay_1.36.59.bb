DESCRIPTION = "A library for replaying C64 SID music"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"
PR = "r2"

SRC_URI = "\
  ftp://ftp.uni-frankfurt.de/pub/Mirrors2/gentoo.org/distfiles/libsidplay-1.36.59.tgz;name=archive \
  http://ftp.debian.org/debian/pool/main/libs/libsidplay/libsidplay_1.36.59-5.diff.gz;name=patch \
"

inherit autotools

SRC_URI[archive.md5sum] = "37c51ba4bd57164b1b0bb7b43b9adece"
SRC_URI[archive.sha256sum] = "3da9b38d4eb5bf9e936b9604ba92da0594ef38047d50cf806a8e11c400008024"
SRC_URI[patch.md5sum] = "c2945a19ebfc94cb3a04b394ba2e07ed"
SRC_URI[patch.sha256sum] = "a6b13f25e5e6b91ad490fe9e8afac22c484f372e4e245d397a813ea6563abdb3"
