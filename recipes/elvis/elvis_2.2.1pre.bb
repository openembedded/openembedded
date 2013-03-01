DESCRIPTION = "A vi clone"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "Perl Clarified Artistic License"

SRC_URI = "http://www.the-little-red-haired-girl.org/pub/elvis/almost_2.2.1-unofficial-1.tar.gz \
	file://elvis.ini.diff;patch=1"
S = "${WORKDIR}/elvis-2.2_1"

require elvis.inc
