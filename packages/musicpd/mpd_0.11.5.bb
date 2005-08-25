DESCRIPTION = "Music Player Daemon (mpd)"
HOMEPAGE = "http://www.musicpd.org"
LICENSE = "GPLv2"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
SECTION = "console/multimedia"
DEPENDS = "libvorbis libogg libid3tag libao zlib libmikmod libmad flac audiofile"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/musicpd/mpd-${PV}.tar.gz"

inherit autotools

# Setting --enable-mpd-{mad,id3tag} causes local caches of the libraries to
# be built, instead we use the OE built versions which should be installed
# in staging - remove the --with and replace with --enable to use the local
# versions.

EXTRA_OECONF = "--enable-ogg \
		--with-id3tag-libraries=${STAGING_LIBDIR} \
		--with-id3tag-includes=${STAGING_INCDIR} \
		--with-mad-libraries=${STAGING_LIBDIR} \
		--with-mad-includes=${STAGING_INCDIR} \
		--without-faad"
