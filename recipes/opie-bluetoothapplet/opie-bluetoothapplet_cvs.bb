require ${PN}.inc

PV = "${OPIE_GIT_PV}"
PR = "r1"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=noncore/net/opietooth/applet \
           ${OPIE_GIT};protocol=git;subpath=pics/bluetoothapplet"
