DESCRIPTION = "Eina is the Enlightenment data library"
LICENSE = "LGPL"
PV = "0.0.1+svnr${SRCREV}"
PR = "r0"

inherit efl

FILES_${PN} += "${libdir}/eina"
