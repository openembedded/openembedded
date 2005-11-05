DESCRIPTION = "The High Voltage SID Collection (HVSC) \
Commodore 64 music for the masses"
LICENSE = "PD"
SECTION = "multimedia"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"

SRC_URI = "http://gallium.prg.dtu.dk/HVSC/random/HVSC_${PV}-all-of-them.zip"
S = "${WORKDIR}"

do_install() {
	install -d ${D}${datadir}/hvsc
	unzip -d ${D}${datadir}/hvsc C64Music.zip
}

PACKAGE_ARCH = "all"
FILES = "${datadir}/hvsc"
