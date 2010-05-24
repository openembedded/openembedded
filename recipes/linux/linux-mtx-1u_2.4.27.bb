include linux-mtx-1_2.4.27.bb

COMPATIBLE_MACHINE = "mtx-1u"

PR = "r11"

SRC_URI += "\
	file://22-umts.diff;apply=yes \
	file://28-idsel-cardbus.diff;apply=yes \
	file://30-mtx-1-sysled.diff;apply=yes \
	file://31-mtx-1u-led-init.diff;apply=yes \
	file://32-usbserial-stalled-hack.diff;apply=yes \
	file://33-usbserial-bulk_in_size-4096.diff;apply=yes \
	file://39-mppe-mpc.patch;apply=yes \
	file://40-option-hsdpa.patch;apply=yes"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-mtx-1-${PV}"

KERNEL_IMAGE_NAME = "kernel-${KV}-${MACHINE}u_${BUILDNAME}"

MTX_KERNEL_NON_PCI_OHCI = "no"

PACKAGE_ARCH = "mtx-1u"
