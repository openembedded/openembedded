require forte.inc

PR = "r0"

SRC_URI = "http://downloads.sourceforge.net/fordiac/FORTE-0.3.5.zip \
	file://forte-0.3.5_socket_reuse.patch;patch=1 \
	file://forte-0.3.5_timer.patch;patch=1 \
	file://forte-0.3.5_stdlib_inc_fix.patch;patch=1"

S="${WORKDIR}/FORTE-${PV}"

SRC_URI[md5sum] = "d207d3b389ee9f2702df095681459f99"
SRC_URI[sha256sum] = "2b87b331e931db2db07408c1b07bdb557227e0c16f8fe37f72e40b08fca0a09c"
