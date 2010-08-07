DESCRIPTION = "ftdi-eeprom is a flashing utility for FTDI  chips."
HOMEPAGE = "http://www.intra2net.com/de/produkte/opensource/ftdi"
LICENSE = "GPL"
DEPENDS = "libftdi confuse"
PR = "r0"

SRC_URI = "http://www.intra2net.com/en/developer/libftdi/download/ftdi_eeprom-${PV}.tar.gz \
           file://ftdi_eeprom-0.3-moko.patch"

S = "${WORKDIR}/ftdi_eeprom-${PV}"

inherit autotools

EXTRA_OECONF = "--disable-docs"

BBCLASSEXTEND = "native"
SRC_URI[md5sum] = "331652a593f0b0afd5f2874b37b7973a"
SRC_URI[sha256sum] = "7b40ec5abb2c93362b9636974e4e4715cb588121c1e1da09d7f499ac7f12d056"
