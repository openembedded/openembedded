# Build of xserver-kdrive is not possible with xextproto >= 7.1.
# This package allows to install old 7.0 includes in parallel.
FILESPATH = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/xextproto-7.0:${@os.path.dirname(bb.data.getVar('FILE',d,1))}/xextproto:${@os.path.dirname(bb.data.getVar('FILE',d,1))}/files"
PR_append = ".0"

require xextproto_7.0.5.bb

XORG_PN = "xextproto"
EXTRA_OECONF += "--includedir=${includedir}/xextproto-70"

do_install_append() {
	rm -r ${D}${libdir}
}
# xorg-proto-common.inc would stage all. We need to overwrite it.
do_stage() {
	autotools_stage_includes
}
# No, we really do not want to install .pc file and overwrite newer one:
pkgconfig_sysroot_preprocess() {
}
