PACKAGES = task-xterminal
DESCRIPTION = "Meta-package for diskless X terminal"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
ALLOW_EMPTY = 1
PR = "r0"

RDEPENDS = "xserver-kdrive-fbdev minicom lrzsz dropbear"
DEPENDS = "xserver-kdrive minicom lrzsz dropbear"

LICENSE = MIT
