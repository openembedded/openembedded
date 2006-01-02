SECTION = "console/utils"
DESCRIPTION = "GNU enscript is a drop-in replacement for the enscript program. \
Enscript converts ASCII files to PostScript and stores generated \
output to a file or sends it directly to the printer."
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"

SRC_URI = "${DEBIAN_MIRROR}/main/e/enscript/enscript_${PV}.orig.tar.gz \
	   file://autotools.patch;patch=1"

inherit autotools
