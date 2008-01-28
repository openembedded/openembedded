include dbus.inc

PR = "r0"

SRC_URI += "file://fix-install-daemon.patch;patch=1"

python populate_packages_prepend () {
	if (bb.data.getVar('DEBIAN_NAMES', d, 1)):
		bb.data.setVar('PKG_dbus', 'dbus-1', d)
}
