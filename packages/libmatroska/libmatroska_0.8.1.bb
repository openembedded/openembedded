DESCRIPTION = "Extensible multimedia container format based on EBML"
HOMEPAGE = "http://www.matroska.org/"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Andreas Frisch <andreas.frisch@multimedia-labs.de>"

LICENSE = "GPL-2"

DEPENDS = "libebml"

inherit pkgconfig autotools module-base

#EXTRA_OEMAKE += "CFLAGS='${CFLAGS} -I${STAGING_INCDIR}' LDFLAGS='${LDFLAGS} -L${STAGING_LIBDIR}"
#LDFLAGS += " -L${STAGING_LIBDIR}"
#EXTRA_OEMAKE += " LDFLAGS='${LDFLAGS}"

EXTRA_OECONF = " --enable-shared "

SRC_URI = "http://www.bunkus.org/videotools/mkvtoolnix/sources/${PN}-${PV}.tar.bz2\
           file://Makefile"

do_compile() {
	cp ${WORKDIR}/Makefile ${WORKDIR}/${PN}-${PV}
	oe_runmake CC="${CC}" CXX="${CXX}" AR="${AR} rcvu" INCDIR="${STAGING_INCDIR}" LIBDIR="${STAGING_LIBDIR}"
}

do_stage() {
	oe_libinstall -a -so -C ./ libmatroska ${STAGING_LIBDIR}
#	cd make/linux
#	oe_libinstall -so  ${STAGING_LIBDIR}
}

do_install() {
	oe_runmake install_headers CC="${CC}" CXX="${CXX}" AR="${AR} rcvu" INCDIR="${STAGING_INCDIR}" LIBDIR="${STAGING_LIBDIR}"
}
