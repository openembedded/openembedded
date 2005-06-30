SECTION = "base"
DESCRIPTION = "GNU tar saves many files together into a single tape \
or disk archive, and can restore individual files from the archive."
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"

SRC_URI = "ftp://alpha.gnu.org/gnu/tar/tar-${PV}.tar.gz \
	   file://configure.patch;patch=1 \
	   file://m4.patch;patch=1"

inherit autotools
