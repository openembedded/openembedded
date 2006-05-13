require libusb_${PV}.bb
inherit native

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libusb-0.1.10a"
