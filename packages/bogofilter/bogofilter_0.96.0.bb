SECTION = "console/network"
DEPENDS = "db3"
DESCRIPTION = "Bogofilter is a mail filter that classifies mail as spam or ham (non-spam) \
by a statistical analysis of the message's header and content (body). \
The program is able to learn from the user's classifications and corrections."
LICENSE = "GPL"
PR = "r1"
PRIORITY = "optional"

SRC_URI = "http://download.sourceforge.net/bogofilter/bogofilter-${PV}.tar.bz2 \
           file://${FILESDIR}/configure.ac.patch;patch=1 \
	   "

inherit autotools

EXTRA_OECONF = "--with-libdb-prefix=${libdir}"

