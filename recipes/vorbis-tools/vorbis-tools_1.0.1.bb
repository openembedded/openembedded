DESCRIPTION = "vorbis-tools contains oggenc (an encoder), ogg123 (a playback tool), \
ogginfo (displays ogg information), vcut (ogg file splitter), and \
vorbiscomment (ogg comment editor)."
LICENSE = "GPL"
DEPENDS = "libogg libvorbis libao curl"
SECTION = "console/multimedia"
PR = "r1"

SRC_URI = "http://www.vorbis.com/files/${PV}/unix/vorbis-tools-${PV}.tar.gz \
           file://m4.patch;patch=1 \
           file://remove-deprecated-curl-option.patch;patch=1"

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

SRC_URI[md5sum] = "80d3ae3bbae2a488d433d86b8fd64777"
SRC_URI[sha256sum] = "4f1f6ba6410e5f2aeb473d0a09caaa528cc926866735ab66e05cdff9c5093a37"
