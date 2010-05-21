TAG = "v${PV}"
require libsocketcan.inc

PR = "${INC_PR}.0"

SRC_URI += "file://install-can_netlink.h.patch;apply=yes \
	"
