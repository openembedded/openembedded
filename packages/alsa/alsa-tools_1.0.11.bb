BROKEN = "1"

DESCRIPTION = "Alsa Tools"
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "alsa-lib"
PR = "r0"

SRC_URI = "ftp://ftp.alsa-project.org/pub/tools/alsa-tools-${PV}.tar.bz2"

inherit autotools

# this bb file requires quite some work.
# There is no top level makefile in tools
# that is why install fails, but actually nothing is compiled
# in order to fix this, the bb file needs heavy work 
# (but the tools are not very useful for oe, so I'll leave it for now)
