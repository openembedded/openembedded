DESCRIPTION = "TagLib is a library for reading and editing the meta-data \
of several popular audio formats. Currently it supports both ID3v1 and ID3v2 \
for MP3 files, Ogg Vorbis comments and ID3 tags and Vorbis comments in FLAC files"
SECTION = "libs"
HOMEPAGE = "http://developer.kde.org/~wheeler/taglib.html"
DEPENDS = "taglib"
LICENSE = "LGPL"

SRC_URI = "http://developer.kde.org/~wheeler/files/src/taglib-${PV}.tar.gz"
S = "${WORKDIR}/taglib-${PV}"

inherit autotools qmake-base pkgconfig binconfig

do_configure() {
	echo running oe_runconf to get pkgconfig and binconfig files created          
	oe_runconf
	cd ${S}/bindings/c && rm -f Makefile* && qmake -project -o tag_c.pro -t lib && \
	qmake -spec ${QMAKESPEC} -after CONFIG=console INCLUDEPATH+=${STAGING_INCDIR}/taglib LIBS+=-ltag
}

do_compile() {
	oe_runmake -C bindings/c
}

do_stage_append() {
	install -d ${STAGING_INCDIR}/taglib
	install -m 0644 bindings/c/tag_c.h ${STAGING_INCDIR}
	oe_libinstall -so -C bindings/c libtag_c ${STAGING_LIBDIR}
}

do_install() {
    oe_libinstall -so -C bindings/c libtag_c ${D}${libdir}
}
