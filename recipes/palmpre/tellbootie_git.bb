DESCRIPTION = "Little utility to tell the bootloader of the palmpre to reboot/reset in bootloader mode; palmpre machine specific"
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "Simon Busch <morphis@gravedo.de>
SECTION = "console/utils"
LICENSE = "GPL"
PR = "r0"

SRCREV = "93a640dafa8ebebdb1a03f051cb1b566629b227c"
SRC_URI = "${FREESMARTPHONE_GIT}/utilities.git;protocol=git;branch=master"
S = "${WORKDIR}/git/palmpre/tellbootie"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools
