inherit gpe
LICENSE = "BSD-X"

DEPENDS = "x11 xpm"
SECTION = "gpe"
DESCRIPTION = "Mine-sweeper game for GPE."
PRIORITY = "optional"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2 \
	   file://Makefile"

do_configure_prepend() {
	mv ${WORKDIR}/Makefile ${S}/
}
