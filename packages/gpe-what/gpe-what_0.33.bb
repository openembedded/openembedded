LICENSE = "GPL"
SECTION = "gpe"
inherit gpe

SRC_URI += "file://makefile-fix.patch;patch=1"

DESCRIPTION = "GPE modal help"
DEPENDS = "virtual/x11 libxpm libmatchbox"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
