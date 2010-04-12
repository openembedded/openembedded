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

SRC_URI[md5sum] = "d133e77f625c496ae9d58629d7443596"
SRC_URI[sha256sum] = "b3e0409d69783ecfa90c893c817bb584296b4c45d9f17b0f2fdd7c07ef411a3f"
