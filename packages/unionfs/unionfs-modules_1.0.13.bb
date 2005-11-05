PARALLEL_MAKE = ""

include unionfs-modules.inc

KERNEL_MAJMIN = "${@base_read_file('${STAGING_KERNEL_DIR}/kernel-abiversion')[:3]}"

do_compile() {
	unset LDFLAGS
	oe_runmake unionfs${KERNEL_MAJMIN}
}
