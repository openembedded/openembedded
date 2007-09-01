DESCRIPTION = "Scope for your soundcard of COMEDI device"
LICENSE = "GPLv2"

DEPENDS = "gtk+-1.2 esound"

SRC_URI = "http://prdownloads.sourceforge.net/xoscope/xoscope-${PV}.tgz"

inherit autotools

PARALLEL_MAKE = ""

FILES_${PN}-dbg += "${libexecdir}/xoscope/.debug"

