DESCRIPTION = "Fast, scriptable ping"
LICENSE = "Stanford"
PR = "r0"

SRC_URI = " \
	http://fping.sourceforge.net/download/fping.tar.gz \
	file://sourceforge-truckload.patch;patch=1 \
"

S = "${WORKDIR}/fping-2.4b2_to"

inherit autotools

SRC_URI[md5sum] = "d5e8be59e307cef76bc479e1684df705"
SRC_URI[sha256sum] = "9f3b3ed7c9fffccefefa9af432eee7244a65592118851f75b5897814cb79b86f"
