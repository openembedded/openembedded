DESCRIPTION = "Policy based mounter that gives the ability to mount removable devices as a user"
HOMEPAGE = "http://pmount.alioth.debian.org/"
LICENSE = "GPLv2"
PR = "r0"

DEPENDS = "hal util-linux-ng"
RDEPENDS_${PN}-hal = "${PN}"
RRECOMMENDS_${PN}-hal = "hal"

SRC_URI = "https://alioth.debian.org/frs/download.php/2867/pmount-0.9.19.tar.gz \
	   file://gettext.patch;patch=1 \
	   file://install.patch;patch=1 \
	  "

inherit autotools gettext

EXTRA_OECONF = "--enable-hal"

PACKAGES =+ "${PN}-hal"

FILES_${PN}-hal = "${bindir}/pmount-hal"

