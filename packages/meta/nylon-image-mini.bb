export IMAGE_BASENAME = "nylon-mini"
 
NYLON_BASE = "base-files base-passwd busybox \
	dropbear \
	miniinit \
	modutils-collateral \
	modutils-initscripts \
	netbase \
	wireless-tools"

DEPENDS = "virtual/kernel modutils \
	${NYLON_BASE} ${BOOTSTRAP_EXTRA_DEPENDS}"
	
RDEPENDS = "kernel \
	${NYLON_BASE} ${BOOTSTRAP_EXTRA_RDEPENDS}"

export IPKG_INSTALL = "${RDEPENDS}" 

IMAGE_LINGUAS = ""

inherit image_ipk
LICENSE = "MIT"
