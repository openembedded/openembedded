inherit gpe
LICENSE = "BSD-X"
PR = "r1"

DEPENDS = "virtual/libx11 libxpm"
SECTION = "gpe/games"
DESCRIPTION = "Mine-sweeper game for GPE."
PRIORITY = "optional"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2 \
	   file://Makefile"

do_configure_prepend() {
	mv ${WORKDIR}/Makefile ${S}/
}

SRC_URI[md5sum] = "b3884eaec59a63691f66bc29ce57a56d"
SRC_URI[sha256sum] = "75378ad3eacbe32c625de3b4af3e1f6fc9772ab45c1cd1393483d95ac4da3b22"
