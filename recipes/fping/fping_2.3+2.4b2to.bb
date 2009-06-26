DESCRIPTION = "Fast, scriptable ping"
LICENSE = "Stanford"
PR = "r0"

SRC_URI = " \
	http://fping.sourceforge.net/download/fping.tar.gz \
	file://sourceforge-truckload.patch;patch=1 \
"

S = "${WORKDIR}/fping-2.4b2_to"

inherit autotools
