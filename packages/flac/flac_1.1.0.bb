DESCRIPTION = "FLAC is a Free Lossless Audio Codec."
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
LICENSE = "BSD GPL"
SECTION = "libs"
DEPENDS = "libogg"
PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/flac/flac-${PV}.tar.gz \
	   file://disable-xmms-plugin.patch;patch=1 \
	   file://xmms.m4"
S = "${WORKDIR}/flac-${PV}"

inherit autotools

EXTRA_OECONF = "--disable-oggtest --disable-id3libtest \
		--with-ogg-libraries=${STAGING_LIBDIR} \
		--with-ogg-includes=${STAGING_INCDIR} \
		--without-xmms-prefix \
		--without-xmms-exec-prefix \
		--without-libiconv-prefix \
		--without-id3lib"

PACKAGES += "libflac libflac++ liboggflac liboggflac++"
FILES_${PN} = "${bindir}"
FILES_libflac = "${libdir}/libFLAC.so.*"
FILES_libflac++ = "${libdir}/libFLAC++.so.*"
FILES_liboggflac = "${libdir}/libOggFLAC.so.*"
FILES_liboggflac++ = "${libdir}/libOggFLAC++.so.*"

do_configure () {
	install -d ${S}/m4
	install -m 0644 ${WORKDIR}/xmms.m4 ${S}/m4/
	autotools_do_configure
}

do_stage () {
	autotools_stage_all
}
