DESCRIPTION = "A vi clone"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "Perl Clarified Artistic License"

SRC_URI = "ftp://ftp.cs.pdx.edu/pub/elvis/elvis-2.2_0.tar.gz \
	file://elvis.ini.diff;patch=1"
S = "${WORKDIR}/elvis-2.2_0"

require elvis.inc
