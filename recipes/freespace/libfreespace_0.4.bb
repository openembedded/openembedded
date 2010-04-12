DESCRIPTION = "The open-source libfreespace library provides an easy-to-use interface to Hillcrest Labs Freespace®-based devices such as in-air remote controls. "
LICENSE = "LGPLv2"
DEPENDS = "libusb1"

SRC_URI = "http://launchpad.net/libfreespace/${PV}/${PV}/+download/libfreespace-${PV}.tar.gz"

inherit autotools



SRC_URI[md5sum] = "96a081e3b7fe2337344b8adc61259eb4"
SRC_URI[sha256sum] = "cc1e5f6751e27b2f403e85d394312c283b74f55e095c8ed8a3327a23549263de"
