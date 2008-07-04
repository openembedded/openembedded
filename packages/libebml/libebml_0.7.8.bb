DESCRIPTION = "Extensible binary format library (kinda like XML)"
HOMEPAGE = "http://www.matroska.org/"
SECTION = "libs"
PRIORITY = "optional"

LICENSE="LGPL-2.1"

inherit pkgconfig

SRC_URI = "http://www.bunkus.org/videotools/mkvtoolnix/sources/${PN}-${PV}.tar.bz2"

#S="${S}/make/linux"

do_compile() {
	cd ${S}/make/linux
	oe_runmake CC="${CC}" CXX="${CXX}" AR="${AR} rcvu"
}

do_stage () {
	oe_libinstall -a -so -C make/linux libebml ${STAGING_LIBDIR}
}

do_install() {
	install -m 0644 ebml/*.h ${STAGING_INCDIR}
	install -d ${STAGING_INCDIR}/ebml
	(cd ${S}/ebml; cp *.h ${STAGING_INCDIR}/ebml/; mkdir ${STAGING_INCDIR}/ebml/c; cp c/libebml_t.h ${STAGING_INCDIR}/ebml/c;)
}
