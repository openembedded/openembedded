DESCRIPTION = "Authorization Protocol for X."
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE= "MIT"

DEPENDS = "xproto util-macros"
PROVIDES = "xau"

XORG_RELEASE = "X11R7.1"
XORG_PN = "libXau"

include xorg-xlibs.inc

