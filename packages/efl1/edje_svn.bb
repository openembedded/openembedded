DESCRIPTION = "Edje is the Enlightenment graphical design & layout library"
DEPENDS = "eet evas ecore embryo edje-native"
LICENSE = "MIT BSD"
PV = "0.5.0.043+svnr${SRCREV}"
PR = "r6"

inherit efl

# gain some extra performance at the expense of RAM - generally i'd say bad
# and a possible source of bugs
#EXTRA_OECONF = "--enable-edje-program-cache"

PACKAGES =+ "${PN}-utils"
RDEPENDS_${PN}-utils = "cpp cpp-symlinks embryo-tests"

RRECOMMENDS_${PN}-utils = "\
  libevas-saver-png \
  libevas-saver-jpeg \
  libevas-saver-eet \
  libevas-saver-tiff \
"

DEBIAN_NOAUTONAME_${PN}-utils = "1"
FILES_${PN}-utils = "\
  ${bindir}/edje_* \
  ${datadir}/edje/include/edje.inc \
"
