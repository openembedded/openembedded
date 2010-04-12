DESCRIPTION = "Scope for your soundcard of COMEDI device"
LICENSE = "GPLv2"

DEPENDS = "gtk+-1.2 esound"

SRC_URI = "http://prdownloads.sourceforge.net/xoscope/xoscope-${PV}.tgz"

inherit autotools

PARALLEL_MAKE = ""

FILES_${PN}-dbg += "${libexecdir}/xoscope/.debug"


SRC_URI[md5sum] = "89f8019a772713a976b634305d29cfe5"
SRC_URI[sha256sum] = "d7dec98f0d85f7ce889d0b2fcb4ed683a6384057ccea2ab531a0710969ff7ca2"
