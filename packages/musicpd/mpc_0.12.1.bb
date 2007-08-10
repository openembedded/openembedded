DESCRIPTION = "Command-line (scriptable) Music Player Daemon (mpd) Client"
HOMEPAGE = "http://www.musicpd.org/mpc.shtml"
SECTION = "console/multimedia"
LICENSE = "GPLv2"

SRC_URI = "http://www.musicpd.org/uploads/files/mpc-${PV}.tar.bz2"
EXTRA_OECONF = "--with-iconv-libraries=${STAGING_LIBDIR} \
		--with-iconv-includes=${STAGING_INCDIR}"

inherit autotools
