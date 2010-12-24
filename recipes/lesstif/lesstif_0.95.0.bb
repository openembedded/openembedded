SECTION = "libs"
DESCRIPTION = "Free OSM/Motif implementation."
LICENSE = "LGPL"
PR = "r2"

SRC_URI = "\
	${SOURCEFORGE_MIRROR}/lesstif/${BP}.tar.bz2 \
	file://000_bootstrap_script.diff \
	file://000_libtool_linking.diff \
	file://010_rebootstrap-small.diff \
	file://020_bad_integer_cast.diff \
	file://020_missing_xm_h.diff \
	file://020_render_table_crash.diff \
	file://020_unsigned_int.diff \
	file://020_xpmpipethrough.diff \
	file://021_xim_chained_list_crash.diff \
	file://030_manpage.diff \
	file://disable-docs.patch \
	"

DEPENDS = "flex-native bison-native libice libsm libx11 libxext libxp libxt libxrender libxft fontconfig freetype"

inherit autotools

do_preconfigure() {
	mkdir -p m4
	mv ac_debug.m4 m4/
	mv ac_have_libxp.m4 m4/
	mv ac_find_xft.m4 m4/
	mv acinclude.m4 m4/

	rm -f aclocal.m4

	sed -i -e "s|LT_HAVE_FREETYPE|HAVEFREETYPE|" m4/acinclude.m4
	sed -i -e "s|LT_HAVE_XRENDER|HAVEXRENDER|" m4/acinclude.m4
}

addtask preconfigure after do_patch before do_configure

EXTRA_OECONF = "\
	--with-gnu-ld --disable-verbose --disable-build-12 --disable-build-20 \
	--enable-build-21 --enable-xrender --enable-production --without-motif \
	--x-includes=. --x-libraries=. \
"

PACKAGES += "${PN}-bin"

FILES_${PN} = "${libdir}"
FILES_${PN}-bin = "${bindir}"

SRC_URI[md5sum] = "ab895165c149d7f95843c7584b1c7ad4"
SRC_URI[sha256sum] = "e5ef90ff30897448a7c090c2e31ceb302ed064a60411436e8995580848ed1a63"
