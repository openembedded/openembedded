PACKAGES = "task-xterminal"
DESCRIPTION = "Meta-package for diskless X terminal"
PR = "r1"

inherit task

RDEPENDS_${PN} = "xserver-kdrive-fbdev minicom lrzsz dropbear"

LICENSE = "MIT"
