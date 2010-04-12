# Release 0.22 reveals bugs in g++ for thumb (g++ generates
# relocations which the linker cannot represent)
#FIXME: remove the following
ARM_INSTRUCTION_SET = "arm"

require monotone.inc

PR = "r0"

SRC_URI = "http://venge.net/monotone/downloads/monotone-${PV}.tar.gz \
           file://txt2c-cross-post-0.22.patch;patch=1 \
	   file://uclibc.database.hh.stdarg.patch;patch=1 \
	   file://configure.ac-no-sync-with-stdio-0.25.patch;patch=1 \
	   "

ALTERNATIVE_PRIORITY = "50"

SRC_URI[md5sum] = "108c18666ce6ff9c05643f923027de8e"
SRC_URI[sha256sum] = "ea95a2778e3dba087112dc6c42903f9629af17156c4da58c0ba3ac9761690159"
