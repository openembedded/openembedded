PV = "0.0+cvs${SRCDATE}"
LICENSE = "Xorg"
SECTION = "x11/libs"
DESCRIPTION = "Xxf86dga extension headers"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=XF86DGAExt"
S = "${WORKDIR}/XF86DGAExt"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
