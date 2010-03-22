DESCRIPTION = "Edje is the Enlightenment graphical design & layout library"
DEPENDS = "lua5.1 eet evas ecore embryo edje-native"
LICENSE = "MIT BSD"
PV = "0.9.92.060+svnr${SRCPV}"
PR = "r6"

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

# Since r44323 edje has a fixed-point mode
require edje-fpu.inc
EXTRA_OECONF += "${@get_edje_fpu_setting(bb, d)}"


PACKAGES =+ "${PN}-utils"
RDEPENDS_${PN}-utils = "cpp cpp-symlinks embryo-tests"

RRECOMMENDS_${PN}-utils = "\
  evas-saver-png \
  evas-saver-jpeg \
  evas-saver-eet \
"

DEBIAN_NOAUTONAME_${PN}-utils = "1"
# Some upgrade path tweaking
AUTO_LIBNAME_PKGS = ""

RREPLACES_${PN} = "libedje-ver-pre-svn-00-0 libedje-ver-pre-svn-01-0"

FILES_${PN}-utils = "\
  ${bindir}/edje_* \
  ${datadir}/edje/include/edje.inc \
"
