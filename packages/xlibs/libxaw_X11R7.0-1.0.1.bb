DESCRIPTION = "X Athena Widgets library"
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "MIT"

DEPENDS = "xproto libx11 libxt libxmu libxpm"
PROVIDES = "xaw"

XORG_PN = "libXaw"

include xorg-xlibs.inc

# FIXME: libXaw needs a full x11, not diet
BROKEN = "1"
