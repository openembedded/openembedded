DESCRIPTION = "Linux Bluetooth Stack Userland Libaries."
SECTION = "libs"
PRIORITY = "optional"
HOMEPAGE = "http://www.bluez.org"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://bluez.sourceforge.net/download/bluez-libs-${PV}.tar.gz"

inherit autotools pkgconfig

HEADERS = "bluetooth.h bnep.h cmtp.h hci.h hci_lib.h hidp.h l2cap.h rfcomm.h sco.h sdp.h sdp_lib.h"
