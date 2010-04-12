require gdb-cross.inc
LICENSE = "GPLv2"

inherit cross

PR = "r3"

SRC_URI += "file://sim-install-makefile.patch;patch=1 \
	file://sim-install-makefile-common.patch;patch=1"

SRC_URI[md5sum] = "812de9e756d53c749ea5516d9ffa5905"
SRC_URI[sha256sum] = "c06bf9715436b3a28c189163aa5ca42b46af8286659827f033eaaf7d8b1fc342"
