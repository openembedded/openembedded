DESCRIPTION = "Command-line (scriptable) Music Player Daemon (mpd) Client"
HOMEPAGE = "http://www.musicpd.org/mpc.shtml"
SECTION = "console/multimedia"
LICENSE = "GPLv2"

SRC_URI = "${SOURCEFORGE_MIRROR}/musicpd/mpc-${PV}.tar.bz2"
EXTRA_OECONF = "--with-iconv-libraries=${STAGING_LIBDIR} \
		--with-iconv-includes=${STAGING_INCDIR}"

inherit autotools

SRC_URI[md5sum] = "48897aeb3a7ee5c64f30e56789f105a8"
SRC_URI[sha256sum] = "7b549ca4af77fc5b0472df1ecd9e76d2f8415258ddcfb63dfa64a55a04e1e590"
