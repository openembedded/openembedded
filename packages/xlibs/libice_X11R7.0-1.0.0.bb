DESCRIPTION = "X11 ICE library"
SECTION = "libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE= "MIT"

DEPENDS = "libx11 util-macros"
PROVIDES = "ice"

XORG_PN = "libICE"

include xorg-xlibs.inc
