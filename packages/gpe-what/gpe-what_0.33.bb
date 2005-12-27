LICENSE = "GPL"
SECTION = "gpe"
inherit gpe

SRC_URI += "file://makefile-fix.patch;patch=1"

DESCRIPTION = "GPE modal help"
DEPENDS = "x11 xpm libmatchbox"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
