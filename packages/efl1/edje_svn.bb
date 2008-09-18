DESCRIPTION = "Edje is the Enlightenment graphical design & layout library"
DEPENDS = "eet evas ecore embryo edje-native"
LICENSE = "MIT BSD"
PV = "0.5.0.043+svnr${SRCREV}"
PR = "r3"

inherit efl

# gain some extra performance at the expense of RAM
EXTRA_OECONF = "--enable-edje-program-cache"

PACKAGES =+ "${PN}-utils"
DEBIAN_NOAUTONAME_${PN}-utils = "1"
FILES_${PN}-utils = "\
  ${bindir}/edje_* \
  ${datadir}/edje/include/edje.inc \
"
