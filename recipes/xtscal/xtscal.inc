DESCRIPTION = "Touchscreen calibration utility"
SECTION = "x11/base"
LICENSE = "GPL"
DEPENDS = "virtual/libx11 libxcalibrate libxft libxrandr"

# xtscal needs a font to display text
RRECOMMENDS_${PN} = "ttf-dejavu-sans"

SRC_URI = "${GPE_MIRROR}/xtscal-${PV}.tar.bz2"

inherit autotools
