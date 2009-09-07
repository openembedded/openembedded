DESCRIPTION = "A collection of CAN utilities"
LICENSE = "GPL"

PRIORITY = "optional"
DEPENDS = "linux-libc-headers perl-native"
PR = "r0"

SRC_URI = "http://www.pengutronix.de/software/socket-can/download/canutils/v3.0/${P}.tar.bz2"

inherit autotools pkgconfig

