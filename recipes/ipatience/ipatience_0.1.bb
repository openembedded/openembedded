DESCRIPTION = "Patience game"
LICENSE = "GPL"
SECTION = "x11"
PRIORITY = "optional"
DEPENDS = "virtual/libx11 xft libxtst libxpm fltk"
PR = "r0"

SRC_URI = "cvs://anoncvs@keithp.com/local/src/CVS;method=pserver;module=ipatience \
          file://fix-make.patch;patch=1"

S = "${WORKDIR}/${PN}"

inherit autotools

