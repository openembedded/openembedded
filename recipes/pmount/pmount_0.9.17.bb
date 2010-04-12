DESCRIPTION = "Policy based mounter that gives the ability to mount removable devices as a user"
HOMEPAGE = "http://pmount.alioth.debian.org/"
LICENSE = "GPLv2"
PR = "r0"

DEPENDS = "hal util-linux-ng sysfsutils"
RDEPENDS_${PN}-hal = "${PN}"
RRECOMMENDS_${PN}-hal = "hal"

SRC_URI = "http://alioth.debian.org/frs/download.php/2247/${P}.tar.gz \
	   file://gettext.patch;patch=1 \
	   file://install.patch;patch=1 \
	  "

inherit autotools gettext

EXTRA_OECONF = "--enable-hal"

PACKAGES =+ "${PN}-hal"

FILES_${PN}-hal = "${bindir}/pmount-hal"


SRC_URI[md5sum] = "24a676bf495bec367b2d971cdca1c54c"
SRC_URI[sha256sum] = "2632d931b5732eb1d0de7a2e2d92c75d64412438958ee96dceb4443e4fc2a62f"
