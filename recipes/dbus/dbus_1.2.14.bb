include dbus.inc
SRC_URI += "file://0002-Fix-Pending-Connections-Bug.patch;patch=1 \
	file://permissive.patch;patch=1"

PR = "${INC_PR}.2"
