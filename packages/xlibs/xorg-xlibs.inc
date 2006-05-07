XORG_PV = "${@['X11R7.0-${PV}','${PV}'][bb.data.getVar('PV', d, 1)[0:8]=='X11R7.0-']}"
SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/${XORG_PN}-${XORG_PV}.tar.bz2"
S = "${WORKDIR}/${XORG_PN}-${XORG_PV}"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
