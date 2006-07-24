XORG_PV = "${@['${XORG_RELEASE}-${PV}','${PV}'][bb.data.getVar('PV', d, 1)[0:4]=='X11R']}"
XORG_RELEASE ?= "X11R7.0"

SRC_URI = "${XORG_MIRROR}/${XORG_RELEASE}/src/lib/${XORG_PN}-${XORG_PV}.tar.bz2"
S = "${WORKDIR}/${XORG_PN}-${XORG_PV}"


inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
