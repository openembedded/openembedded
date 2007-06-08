DESCRIPTION = "A VoIP SIP phone for the Yealink USB handset"
HOMEPAGE = "http://www.devbase.at/voip/"
LICENSE = "GPLv2"
PRIORITY = "optional"
DEPENDS = "liblinphone"
RDEPENDS = "liblinphone"
RRECOMMENDS = "\
	linphonec \
	kernel-module-yealink \
	kernel-module-usbhid \
	kernel-module-snd-usb-audio \
	"

PR = "r3"

SRC_URI = "http://download.devbase.at/voip/yeaphone-${PV}.tar.gz"

S = "${WORKDIR}/yeaphone-${PV}"

inherit autotools
