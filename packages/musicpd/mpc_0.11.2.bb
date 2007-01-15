DESCRIPTION = "Command-line (scriptable) Music Player Daemon (mpd) Client"
HOMEPAGE = "http://www.musicpd.org/mpc.shtml"
LICENSE = "GPLv2"
SECTION = "console/multimedia"
PR = "r1"

SRC_URI = "http://mercury.chem.pitt.edu/~shank/mpc-${PV}.tar.gz"
EXTRA_OECONF = "--with-iconv-libraries=${STAGING_LIBDIR} \
		--with-iconv-includes=${STAGING_INCDIR}"

inherit autotools
