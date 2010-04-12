DESCRIPTION = "Print a random, hopefully interesting, adage"
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "recode-native recode"
DEBV = "2"
PR = "r2"

SRC_URI = "${DEBIAN_MIRROR}/main/f/fortune-mod/fortune-mod_${PV}.orig.tar.gz;name=archive \
           ${DEBIAN_MIRROR}/main/f/fortune-mod/fortune-mod_${PV}-${DEBV}.diff.gz;patch=1;name=patch"

PARALLEL_MAKE = ""
CFLAGS += '\$(DEFINES)'

do_configure() {
	unset CC LD CFLAGS LDFLAGS
	cd util && oe_runmake
}

do_install() {
	oe_runmake install prefix="${D}"
	mv -f ${D}/usr/games/fortune ${D}/${bindir}
}

FILES_${PN} += "${datadir}/games/fortunes/"

SRC_URI[archive.md5sum] = "f208805b3b712e32997d7667e0ec52d8"
SRC_URI[archive.sha256sum] = "fc51aee1f73c936c885f4e0f8b6b48f4f68103e3896eaddc6a45d2b71e14eace"
SRC_URI[patch.md5sum] = "5f059f7c997adbc0a260f27947605be1"
SRC_URI[patch.sha256sum] = "d68c7c8ff6fe94341a3a73d22ab976da42921e3bec9bed628a428518c2c5f67a"
