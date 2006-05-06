SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/${XORG_PN}-X11R7.0-${PV}.tar.bz2"
S = "${WORKDIR}/${XORG_PN}-X11R7.0-${PV}"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
