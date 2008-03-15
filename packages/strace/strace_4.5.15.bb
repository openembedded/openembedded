DESCRIPTION = "strace is a system call tracing tool."
SECTION = "console/utils"
LICENSE = "GPL"

# this recipe is missing patches for arm and sh
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_avr32 = "1"

SRC_URI = "${SOURCEFORGE_MIRROR}/strace/strace-${PV}.tar.bz2 \
          "

SRC_URI_avr32 = "${SOURCEFORGE_MIRROR}/strace/strace-${PV}.tar.bz2 \
           file://strace-4.5.15.atmel.1.patch;patch=1 \  
          "

inherit autotools

export INCLUDES = "-I. -I./linux"
