include linux-mtx-1_2.4.27.bb

COMPATIBLE_MACHINE = "mtx-1u"

PR = "r11"

SRC_URI += "\
	file://22-umts.diff \
	file://28-idsel-cardbus.diff \
	file://30-mtx-1-sysled.diff \
	file://31-mtx-1u-led-init.diff \
	file://32-usbserial-stalled-hack.diff \
	file://33-usbserial-bulk_in_size-4096.diff \
	file://39-mppe-mpc.patch \
	file://40-option-hsdpa.patch"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-mtx-1-${PV}"

KERNEL_IMAGE_NAME = "kernel-${KV}-${MACHINE}u_${BUILDNAME}"

MTX_KERNEL_NON_PCI_OHCI = "no"

PACKAGE_ARCH = "mtx-1u"
