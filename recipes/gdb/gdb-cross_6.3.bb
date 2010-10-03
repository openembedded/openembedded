require gdb-cross.inc
LICENSE = "GPLv2"

PR = "${INC_PR}.4"

SRC_URI += "file://sim-install-makefile.patch \
	file://sim-install-makefile-common.patch"

SRC_URI[md5sum] = "812de9e756d53c749ea5516d9ffa5905"
SRC_URI[sha256sum] = "c06bf9715436b3a28c189163aa5ca42b46af8286659827f033eaaf7d8b1fc342"
