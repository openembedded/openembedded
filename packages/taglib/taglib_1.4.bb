DESCRIPTION = "TagLib is a library for reading and editing the meta-data of several popular audio formats"
SECTION = "libs"
HOMEPAGE = "http://developer.kde.org/~wheeler/taglib.html"
LICENSE = "LGPL"
PR = "r1"

SRC_URI = "http://developer.kde.org/~wheeler/files/src/taglib-${PV}.tar.gz"
S = "${WORKDIR}/taglib-${PV}"

inherit autotools qmake-base pkgconfig binconfig

export OE_QMAKE_LINK="${CXX}"

do_configure() {
	# calling oe_runconf to generate pkgconfig and binconfig files
	oe_runconf
	cd ${S}/taglib && rm -f Makefile* && qmake -project -o tag.pro -t lib && \
	qmake -spec ${QMAKESPEC} -after CONFIG=console INCLUDEPATH+=${S}
}

do_compile() {
	oe_runmake -C taglib
}

do_stage_append() {
	install -d ${STAGING_INCDIR}/taglib
	for i in `find taglib -name "*.h"`
	do
		install $i ${STAGING_INCDIR}/taglib/
	done
    for i in `find taglib -name "*.tcc"`
    do
        install $i ${STAGING_INCDIR}/taglib/
    done
    oe_libinstall -so -C taglib libtag ${STAGING_LIBDIR}
}

do_install() {
	install -d ${D}${libdir}
	oe_libinstall -so -C taglib libtag ${D}${libdir}
}
