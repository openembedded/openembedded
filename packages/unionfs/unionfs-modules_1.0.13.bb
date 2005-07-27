# When mickeyl decides to check in the correct make.patch, then the following line can be removed.
DEFAULT_PREFERENCE = "-1"

PARALLEL_MAKE = ""

include unionfs-modules.inc

KERNEL_MAJMIN = "${@base_read_file('${STAGING_KERNEL_DIR}/kernel-abiversion')[:3]}"

do_compile() {
	oe_runmake unionfs${KERNEL_MAJMIN}
}
