export IMAGE_BASENAME = "nylon-mini"

inherit image

NYLON_BASE = "base-files base-passwd busybox \
	dropbear \
	miniinit \
	modutils-collateral \
	modutils-initscripts \
	netbase \
	wireless-tools"

IMAGE_INSTALL += "kernel ${NYLON_BASE} ${BOOTSTRAP_EXTRA_RDEPENDS}"
IMAGE_LINGUAS = ""
