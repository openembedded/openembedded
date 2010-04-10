DESCRIPTION = "A collection of CAN utilities"
LICENSE = "GPL"

PRIORITY = "optional"
DEPENDS = "linux-libc-headers perl-native"
PR = "r0"

SRC_URI = "http://www.pengutronix.de/software/socket-can/download/canutils/v3.0/${P}.tar.bz2"

inherit autotools pkgconfig


SRC_URI[md5sum] = "45787d61ba969bcf08b7a65143fad8e3"
SRC_URI[sha256sum] = "3b10a3e62de58c593d53b7913e4d16b7785469b66fd9da0190b01fa3f6c73f92"
