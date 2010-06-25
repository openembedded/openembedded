DESCRIPTION = "Patience game"
LICENSE = "GPL"
SECTION = "x11"
PRIORITY = "optional"
DEPENDS = "virtual/libx11 libxft libxtst libxpm fltk"
SRCDATE = "20061112"
PR = "r0"

SRC_URI = "cvs://anoncvs@keithp.com/local/src/CVS;method=pserver;module=ipatience \
          file://fix-make.patch"

S = "${WORKDIR}/${PN}"

inherit autotools

