LICENSE = "GPL"
DESCRIPTION = "Touchscreen calibration utility"
SECTION = "x11/base"

DEPENDS = "virtual/libx11 libxft libxcalibrate"

PR = "r7"

SRC_URI = "${GPE_MIRROR}/xtscal-${PV}.tar.bz2 \
           file://change-cross.patch;patch=1 \
	   file://cleanup.patch;patch=1"

inherit autotools

SRC_URI[md5sum] = "9bcab80b474d5454477d1ca166a68c34"
SRC_URI[sha256sum] = "27b9dc2203de9b1706ca39fa6ca80ecab8807909ec901c4a345b8e41178800a1"
