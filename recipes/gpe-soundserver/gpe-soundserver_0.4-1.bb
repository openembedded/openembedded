LICENSE = "GPL"
SECTION = "gpe"
inherit gpe

DEPENDS = "virtual/libx11 esound"

SRC_URI += "file://makefile-breakage.patch;patch=1 \
	    file://makefile-fix.patch;patch=1"
