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

SRC_URI[md5sum] = "5394dac412dbe34d2dfe63cb91bdce8d"
SRC_URI[sha256sum] = "6068499eeb3aad19d2f860390c65496cf38c5f5e5b54422db6ec2f67abbb8d10"
