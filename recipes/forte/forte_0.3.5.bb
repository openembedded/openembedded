require forte.inc

PR = "r0"

SRC_URI = "http://downloads.sourceforge.net/fordiac/FORTE-0.3.5.zip \
	file://forte-0.3.5_socket_reuse.patch;patch=1 \
	file://forte-0.3.5_timer.patch;patch=1 \
	file://forte-0.3.5_stdlib_inc_fix.patch;patch=1"

S="${WORKDIR}/FORTE-${PV}"
