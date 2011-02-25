PV = "0.0+cvs${SRCDATE}"
LICENSE = "BSD-X"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libxfont xtrans"

PR = "r1"

SRC_URI = "${FREEDESKTOP_CVS}/xlibs;module=FS \
           file://fontsproto.patch \
           file://xtrans.patch \
          "

S = "${WORKDIR}/FS"

inherit autotools pkgconfig

