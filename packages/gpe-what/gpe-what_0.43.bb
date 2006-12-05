LICENSE = "GPL"
DESCRIPTION = "GPE modal help"
DEPENDS = "virtual/libx11 gtk+"
PR = "r1"

GPE_TARBALL_SUFFIX= "bz2"
inherit autotools gpe

SRC_URI += " file://set-wm-hint.patch;patch=1;pnum=0"
