DESCRIPTION = "Edje is the Enlightenment graphical design & layout library"
DEPENDS = "lua5.1 eet evas ecore embryo edje-native"
LICENSE = "MIT BSD"
PV = "0.5.0.050+svnr${SRCREV}"
PR = "r2"

inherit efl

# The new lua stuff is a bit broken...
do_configure_append() {
	for i in $(find "${S}" -name "Makefile") ; do
		sed -i -e 's:-L/usr/local/lib::g'  $i
	done
}

do_compile_append() {
	sed -i -e s:local/::g -e 's:-L${STAGING_LIBDIR}::g' ${S}/edje.pc
}

# gain some extra performance at the expense of RAM - generally i'd say bad
# and a possible source of bugs
#EXTRA_OECONF = "--enable-edje-program-cache"

PACKAGES =+ "${PN}-utils"
RDEPENDS_${PN}-utils = "cpp cpp-symlinks embryo-tests"

RRECOMMENDS_${PN}-utils = "\
  evas-saver-png \
  evas-saver-jpeg \
  evas-saver-eet \
  evas-saver-tiff \
"

DEBIAN_NOAUTONAME_${PN} = "1"
DEBIAN_NOAUTONAME_${PN}-themes = "1"
DEBIAN_NOAUTONAME_${PN}-utils = "1"
FILES_${PN}-utils = "\
  ${bindir}/edje_* \
  ${datadir}/edje/include/edje.inc \
"
