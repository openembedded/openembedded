LICENSE = "GPL"
DEPENDS = "libogg libvorbis libao curl"
DESCRIPTION = " vorbis-tools contains oggenc (an encoder), ogg123 (a playback tool), \
ogginfo (displays ogg information), vcut (ogg file splitter), and \
vorbiscomment (ogg comment editor)."

SECTION = "console/multimedia"

SRC_URI = "http://www.vorbis.com/files/${PV}/unix/vorbis-tools-${PV}.tar.gz \
	   file://m4.patch;patch=1"

inherit autotools 

EXTRA_OECONF = "--without-flac --without-speex \
		--with-ogg-libraries=${STAGING_LIBDIR}/ \
		--with-ogg-includes=${STAGING_INCDIR}/ \
		--with-vorbis-libraries=${STAGING_LIBDIR}/ \
		--with-vorbis-includes=${STAGING_INCDIR}/ \
		--with-ao-libraries=${STAGING_LIBDIR}/ \
		--with-ao-includes=${STAGING_INCDIR}/ \
		--with-curl-libraries=${STAGING_LIBDIR}/ \
		--with-curl-includes=${STAGING_INCDIR}/"
