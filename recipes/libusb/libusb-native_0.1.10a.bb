require libusb_${PV}.bb
inherit native
PROVIDES = "virtual/libusb0-native"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libusb-0.1.10a"
