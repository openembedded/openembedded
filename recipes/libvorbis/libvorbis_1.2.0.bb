
require libvorbis.inc

PR = "${INC_PR}.1"

SRC_URI = "http://downloads.xiph.org/releases/vorbis/libvorbis-${PV}.tar.gz \
	   file://configure_powerpc-no-fixed-cpu.patch;patch=1 \
	   file://r14598-CVE-2008-1420.patch;patch=1 \
	   file://r14602-CVE-2008-1419.patch;patch=1 \
	   file://r14602-CVE-2008-1423.patch;patch=1 \
	  "

