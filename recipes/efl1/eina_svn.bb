DESCRIPTION = "Eina is the Enlightenment data library"
LICENSE = "LGPL"
PV = "0.0.1+svnr${SRCREV}"
PR = "r0"

inherit efl

DEBIAN_NOAUTONAME_${PN}-dbg = "1"
DEBIAN_NOAUTONAME_${PN} = "1"
DEBIAN_NOAUTONAME_${PN}-themes = "1"
DEBIAN_NOAUTONAME_${PN}-dev = "1"
DEBIAN_NOAUTONAME_${PN}-tests = "1"

FILES_${PN} += "${libdir}/eina"
