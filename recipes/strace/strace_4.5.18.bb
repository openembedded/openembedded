DESCRIPTION = "strace is a system call tracing tool."
SECTION = "console/utils"
LICENSE = "GPL"
PR = "r2"

# this recipe is missing patches for arm and sh
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_avr32 = "1"
DEFAULT_PREFERENCE_mips = "1"
DEFAULT_PREFERENCE_mipsel = "1"

SRC_URI = "${SOURCEFORGE_MIRROR}/strace/strace-${PV}.tar.bz2 \
          "

SRC_URI_avr32 = "${SOURCEFORGE_MIRROR}/strace/strace-${PV}.tar.bz2 \
           file://strace-4.5.15.atmel.1.patch;patch=1 \  
          "

inherit autotools

export INCLUDES = "-I. -I./linux"

SRC_URI[md5sum] = "e9449fcee97e6a8ed73934c883c870e0"
SRC_URI[sha256sum] = "95e7b7470e04f22c3ec8dc6d0b1fdd8944306cb5313c84c4545cd83abada26d0"
