DESCRIPTION = "Control Gembird SIS-PM programmable power outlet strips"
AUTHOR = "Mondrian Nuessle <nuessle@uni-mannheim.de>"
HOMEPAGE = "http://sispmctl.sourceforge.net/"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "libusb"

SRC_URI = "http://downloads.sourceforge.net/${PN}/${P}.tar.gz"

SRC_URI[md5sum] = "2457f76cd129f880634f3381be0aeb76"
SRC_URI[sha256sum] = "d24d34fc7e14992ac822cef3c5567b04a077cfc96252b0a6fb238c8a272c16f4"

inherit autotools

EXTRA_OECONF = "--enable-webless"
