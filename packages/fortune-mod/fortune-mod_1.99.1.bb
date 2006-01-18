DESCRIPTION = "Print a random, hopefully interesting, adage"
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "recode-native recode"
DEBV = "2"
PR = "r2"

SRC_URI = "${DEBIAN_MIRROR}/main/f/fortune-mod/fortune-mod_${PV}.orig.tar.gz \
           ${DEBIAN_MIRROR}/main/f/fortune-mod/fortune-mod_${PV}-${DEBV}.diff.gz;patch=1"

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
