require bash.inc
PR = "r8"

SRC_URI = "${GNU_MIRROR}/bash/bash-${PV}.tar.gz \
        file://bash-3.0-fixes.patch;patch=1 \
	file://signames-mipsel.diff;patch=1"
