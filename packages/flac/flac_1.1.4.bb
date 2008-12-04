DESCRIPTION = "FLAC is a Free Lossless Audio Codec."
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
LICENSE = "BSD GPL"
RDEPENDS = "libogg"
SECTION = "libs"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/flac/flac-${PV}.tar.gz \
	   file://disable-xmms-plugin.patch;patch=1 \
	   file://xmms.m4"
	   
S = "${WORKDIR}/flac-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-oggtest --disable-id3libtest \
		--with-ogg-libraries=${STAGING_LIBDIR} \
		--with-ogg-includes=${STAGING_INCDIR} \
		--without-xmms-prefix \
		--without-xmms-exec-prefix \
		--without-libiconv-prefix \
		--without-id3lib"

PACKAGES += "libflac libflac++"
FILES_${PN} = "${bindir}"
FILES_libflac = "${libdir}/libFLAC.so.*"
FILES_libflac++ = "${libdir}/libFLAC++.so.*"

do_configure () {
	for i in FLAC FLAC++ OggFLAC OggFLAC++; do
		rm -R ${STAGING_INCDIR}/$i || /bin/true;
	done;
	install -d ${S}/m4
	install -m 0644 ${WORKDIR}/xmms.m4 ${S}/m4/
	autotools_do_configure
}

do_stage () {
	autotools_stage_all
}
