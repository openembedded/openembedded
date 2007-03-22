DESCRIPTION = "A VoIP SIP phone for the Yealink USB handset"
HOMEPAGE = "http://www.devbase.at/voip/"
MAINTAINER = "Thomas Reitmayr <treitmayr@yahoo.com>"
LICENSE = "GPLv2"
PRIORITY = "optional"
DEPENDS = "liblinphone"
RDEPENDS = "liblinphone"
RRECOMMENDS = "\
	kernel-module-yealink \
	kernel-module-usbhid \
	kernel-module-snd-usb-audio \
	"

PR = "r2"

SRC_URI = "http://download.devbase.at/voip/yeaphone-${PV}.tar.gz"

S = "${WORKDIR}/yeaphone-${PV}"

inherit autotools
