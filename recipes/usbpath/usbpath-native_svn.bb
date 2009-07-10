require usbpath_svn.bb
inherit native
DEPENDS = "virtual/libusb0-native"

do_stage () {
	autotools_stage_all
}

