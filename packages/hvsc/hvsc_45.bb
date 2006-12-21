DESCRIPTION = "The High Voltage SID Collection (HVSC) \
Commodore 64 music for the masses"
LICENSE = "PD"
SECTION = "multimedia"

SRC_URI = "http://gallium.prg.dtu.dk/HVSC/random/HVSC_${PV}-all-of-them.rar"
S = "${WORKDIR}"

do_install() {
	install -d ${D}${datadir}/hvsc
	cd ${D}${datadir}/hvsc && unrar x ${S}/HVSC_${PV}-all-of-them.rar
}

PACKAGE_ARCH = "all"
FILES = "${datadir}/hvsc"
