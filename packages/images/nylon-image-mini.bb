export IMAGE_BASENAME = "nylon-mini"

inherit image
LICENSE = "MIT"

NYLON_BASE = "base-files base-passwd busybox \
	dropbear \
	miniinit \
	modutils-collateral \
	modutils-initscripts \
	netbase \
	wireless-tools"

RDEPENDS += "kernel \
	${NYLON_BASE} ${BOOTSTRAP_EXTRA_RDEPENDS}"

export PACKAGE_INSTALL = "${RDEPENDS}"

IMAGE_LINGUAS = ""
