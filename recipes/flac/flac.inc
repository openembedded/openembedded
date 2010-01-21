DESCRIPTION = "FLAC is a Free Lossless Audio Codec."
HOMEPAGE = "http://flac.sourceforge.net"
LICENSE = "BSD GPL"
SECTION = "libs"
DEPENDS = "libogg"

SRC_URI = "${SOURCEFORGE_MIRROR}/flac/flac-${PV}.tar.gz \
	   file://xmms.m4"

inherit autotools

EXTRA_OECONF = "--disable-oggtest --disable-id3libtest \
		--with-ogg-libraries=${STAGING_LIBDIR} \
		--with-ogg-includes=${STAGING_INCDIR} \
                --disable-xmms-plugin \
		--without-xmms-prefix \
		--without-xmms-exec-prefix \
		--without-libiconv-prefix \
		--without-id3lib"

do_configure () {
	install -d ${S}/m4
	install -m 0644 ${WORKDIR}/xmms.m4 ${S}/m4/
	autotools_do_configure
	# removes '-read-only-relocs' which is enabled for PowerPC builds.
	# It makes the build fail, other archs are not affected. Fixes #1775.
	sed -i 's/-Wl,-read_only_relocs,warning//g' src/libFLAC/Makefile
}

PACKAGES += "libflac libflac++ liboggflac liboggflac++"
FILES_${PN} = "${bindir}/*"
FILES_libflac = "${libdir}/libFLAC.so.*"
FILES_libflac++ = "${libdir}/libFLAC++.so.*"
FILES_liboggflac = "${libdir}/libOggFLAC.so.*"
FILES_liboggflac++ = "${libdir}/libOggFLAC++.so.*"
