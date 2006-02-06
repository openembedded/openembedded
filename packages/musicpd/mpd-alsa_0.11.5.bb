DESCRIPTION = "Music Player Daemon (mpd). This version is configured for alsa support"
HOMEPAGE = "http://www.musicpd.org"
LICENSE = "GPLv2"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
SECTION = "console/multimedia"
DEPENDS = "libvorbis libogg libid3tag libao-alsa zlib libmikmod libmad flac audiofile virtual/libiconv"
RDEPENDS = "libao-alsa"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/musicpd/mpd-${PV}.tar.gz \
           file://mpd/save-volume-state.patch;patch=1 file://mpd/mpd.init"
S = "${WORKDIR}/mpd-${PV}"

inherit autotools update-rc.d
INITSCRIPT_NAME = "mpd"

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

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/mpd/mpd.init ${D}${sysconfdir}/init.d/mpd
}
