DESCRIPTION = "USB Device Firmware Upgrade utility (special atmel-version)"
SECTION = "devel"
AUTHOR = "Weston Schmidt <weston_schmidt@alumni.purdue.edu>"
LICENSE = "GPL"

PV = "0.5.2"
PR = "r0"

DEPENDS = "libusb"

SRC_URI = " \
	${SOURCEFORGE_MIRROR}/project/${PN}/${PN}/${PV}/${PN}-${PV}.tar.gz;name=tar \
	"
SRC_URI[tar.md5sum] = "ce882d37383df698a1c530080724b191"
SRC_URI[tar.sha256sum] = "e3c8bc1429fe1681c56ddc14fb05d29a7933aac566d13f894dca6fd916829cb9"

inherit autotools
