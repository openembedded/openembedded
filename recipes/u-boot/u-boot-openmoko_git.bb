require u-boot-openmoko.inc

SRCREV = "650149a53dbdd48bf6dfef90930c8ab182adb512"
SRC_URI = "\
  git://git.openmoko.org/git/u-boot.git;protocol=git;branch=stable \
  file://makefile-no-dirafter.patch;patch=1 \
"
S = "${WORKDIR}/git"
