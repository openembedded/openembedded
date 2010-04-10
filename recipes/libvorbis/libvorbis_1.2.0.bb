
require libvorbis.inc

PR = "${INC_PR}.1"

SRC_URI = "http://downloads.xiph.org/releases/vorbis/libvorbis-${PV}.tar.gz \
	   file://configure_powerpc-no-fixed-cpu.patch;patch=1 \
	   file://r14598-CVE-2008-1420.patch;patch=1 \
	   file://r14602-CVE-2008-1419.patch;patch=1 \
	   file://r14602-CVE-2008-1423.patch;patch=1 \
	  "


SRC_URI[md5sum] = "478646358c49f34aedcce58948793619"
SRC_URI[sha256sum] = "6eb7040048e35448fe224fa3fd993eb4e49a905c57893886082f1674d43b0e73"
