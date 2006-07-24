DESCRIPTION = "Session management library"
SECTION = "libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "MIT-X"
#PV="1:1.0.1"

DEPENDS = "libx11 libice util-macros"

XORG_RELEASE = "X11R7.1"
XORG_PN = "libSM"

include xorg-xlibs.inc
