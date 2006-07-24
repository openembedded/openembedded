include xorg-doc-common.inc

DESCRIPTION = "The documentation in this package is from xc/doc in the monolithic \
source tree."

DEPENDS += " intltool"

FILES_${PN} += " /usr/share/X11/doc"

