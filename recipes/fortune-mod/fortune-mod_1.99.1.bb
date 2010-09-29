DESCRIPTION = "Print a random, hopefully interesting, adage"
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "recode-native recode"
DEBV = "4"
PR = "r3"

SRC_URI = "${DEBIAN_MIRROR}/main/f/fortune-mod/fortune-mod_${PV}.orig.tar.gz;name=archive \
           ${DEBIAN_MIRROR}/main/f/fortune-mod/fortune-mod_${PV}-${DEBV}.diff.gz;name=patch"

PARALLEL_MAKE = ""
CFLAGS += '\$(DEFINES)'

do_configure() {
	unset CC LD CFLAGS LDFLAGS
	cd util && oe_runmake
}

do_install() {
	oe_runmake install prefix="${D}"
	mv -f ${D}/usr/games/fortune ${D}/${bindir}
	rm ${D}/usr/bin/strfile ${D}/usr/bin/unstr
}

FILES_${PN} += "${datadir}/games/fortunes/"

SRC_URI[archive.md5sum] = "f208805b3b712e32997d7667e0ec52d8"
SRC_URI[archive.sha256sum] = "fc51aee1f73c936c885f4e0f8b6b48f4f68103e3896eaddc6a45d2b71e14eace"
SRC_URI[patch.md5sum] = "b8844cdc7f972cc851d156127a7d5cfa"
SRC_URI[patch.sha256sum] = "fbf51f94ead6e83ab879a4477ec5d52eb53823b392297f038f9f0398a9afc7b2"

