# Build of xserver-kdrive is not possible with xextproto >= 7.1.
# This package allows to install old 7.0 includes in parallel.
# akita and spitz needs them:
FILESPATH = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/xextproto-7.0:${@os.path.dirname(bb.data.getVar('FILE',d,1))}/xextproto:${@os.path.dirname(bb.data.getVar('FILE',d,1))}/files"
PR_append = ".0"

require xextproto_7.0.5.bb

XORG_PN = "xextproto"
EXTRA_OECONF += "--includedir=${includedir}/xextproto-70"

#export INHIBIT_AUTO_STAGE = "1"
#SYSROOT_PREPROCESS_FUNCS = "${@bb.data.getVar('SYSROOT_PREPROCESS_FUNCS',d,1).replace('pkgconfig_sysroot_preprocess', '')}"

do_install_append() {
	rm -r ${D}${libdir}
}
## xorg-proto-common.inc would stage all. We need to overwrite it.
do_stage() {
#	export INHIBIT_AUTO_STAGE=1
	autotools_stage_includes
#	rm -r ${STAGE_TEMP_PREFIX}${libdir}
}
# No, we really do not want to install .pc file and overwrite newer one:
pkgconfig_sysroot_preprocess() {
}
