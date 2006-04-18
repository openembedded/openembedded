DESCRIPTION = "Etk is an advanced widget toolkit based on the Enlightenment Foundation Libraries"
DEPENDS = "evas-x11 ecore-x11 edje"
LICENSE = "MIT"
PR = "r0"

inherit efl

SRC_URI = "${E_CVS};module=e17/proto/etk;date=${PV}"
S = "${WORKDIR}/etk"
