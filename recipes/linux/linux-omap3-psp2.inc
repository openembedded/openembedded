require linux-omap3.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-omap3-psp/${MACHINE}/${PSPREL}"

SRC_URI := "${@oe_filter_out('file://defconfig', bb.data.getVar('SRC_URI', d, 1), d)}"

COMPATIBLE_MACHINE = "omap3evm"

do_setup_defconfig() {
	:
}

do_configure() {
	make omap3_evm_defconfig
}
