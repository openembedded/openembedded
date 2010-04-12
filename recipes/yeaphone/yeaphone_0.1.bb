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

SRC_URI[md5sum] = "476552b3b88b651ba161d22c1db5314d"
SRC_URI[sha256sum] = "2f596ef4c57e29708d6246949289341d9f9756d162bf49e89f0828180329aa51"
