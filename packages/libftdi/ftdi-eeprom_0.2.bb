DESCRIPTION = "ftdi-eeprom is a flashing utility for FTDI  chips."
HOMEPAGE = "http://www.intra2net.com/de/produkte/opensource/ftdi"
LICENSE = "GPL"
DEPENDS = "libftdi confuse"
PR = "r1"

SRC_URI = "http://www.intra2net.com/de/produkte/opensource/ftdi/TGZ/ftdi_eeprom-${PV}.tar.gz \
           file://ftdi_eeprom-0.2-moko.patch;patch=1"
S = "${WORKDIR}/ftdi_eeprom-${PV}"

inherit autotools

EXTRA_OECONF = "--disable-docs"
