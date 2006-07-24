DESCRIPTION = "X Display Manager Control Protocol library."
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE= "MIT"

DEPENDS = "xproto util-macros"
PROVIDES = "xdmcp"

XORG_PN = "libXdmcp"

include xorg-xlibs.inc
