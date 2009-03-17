require u-boot-openmoko.inc

SRC_URI = "\
  git://git.openmoko.org/git/u-boot.git;protocol=git;branch=stable \
  file://makefile-no-dirafter.patch;patch=1 \
"
S = "${WORKDIR}/git"
