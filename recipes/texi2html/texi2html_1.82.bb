DESCRIPTION = "Perl script that converts Texinfo to HTML"
HOMEPAGE    = "http://www.nongnu.org/texi2html/"
SECTION     = "console/utils"
LICENSE     = "GPLv2"
SRC_URI     = "http://download.savannah.gnu.org/releases/texi2html/${P}.tar.bz2"

PR = "r0"

inherit autotools

EXTRA_OECONF = "PERL=/usr/bin/perl"

