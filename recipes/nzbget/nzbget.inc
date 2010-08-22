DESCRIPTION = "NZBGet is a command-line based binary newsgrabber for nzb files, written in C++"
SECTION = "net"
LICENSE = "GPL"
HOMEPAGE = "http://nzbget.sourceforge.net/Main_Page"
DEPENDS = "libsigc++-2.0 libpar2 ncurses libxml2"
INC_PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/nzbget/nzbget-stable/nzbget-${PV}.tar.gz"
S = "${WORKDIR}/nzbget-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = "\
	--disable-tls \
	--with-libcurses-libraries=${STAGING_LIBDIR} \
	--with-libcurses-includes=${STAGING_INCDIR} \
	--with-libpar2-includes={STAGING_INCDIR} \
	--with-libpar2-libraries={STAGING_INCDIR} \
"
