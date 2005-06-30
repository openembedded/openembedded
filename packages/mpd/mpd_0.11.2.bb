SECTION = "console/multimedia"
DESCRIPTION = "Music Player Daemon (mpd)"
HOMEPAGE = "http://www.musicpd.org"
LICENSE = "GPLv2"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
DEPENDS = "libvorbis libogg libid3tag libao zlib libmikmod libmad flac audiofile"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/musicpd/mpd-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--enable-ogg \
		--enable-mpd-mad \
		--enable-mpd-id3tag \
		--with-id3tag-libraries=${STAGING_LIBDIR} \
		--with-id3tag-includes=${STAGING_INCDIR} \
		--with-mad-libraries=${STAGING_LIBDIR} \
		--with-mad-includes=${STAGING_INCDIR} \
		--without-faad"
