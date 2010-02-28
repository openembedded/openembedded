DESCRIPTION = "vorbis-tools contains oggenc (an encoder), ogg123 (a playback tool), \
ogginfo (displays ogg information), vcut (ogg file splitter), and \
vorbiscomment (ogg comment editor)."
LICENSE = "GPL"
DEPENDS = "libogg libvorbis libao curl"
SECTION = "console/multimedia"

SRC_URI = "http://downloads.xiph.org/releases/vorbis/vorbis-tools-${PV}.tar.gz;name=src"

SRC_URI[src.md5sum] = "df976d24e51ef3d87cd462edf747bf9a"
SRC_URI[src.sha256sum] = "dbe753ce0ae0797f25117720bb2ba0d848388d3f47af8db31ebc35552c3de07b"

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
