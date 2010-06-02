require python-efl.inc
SRCREV = "${EFL_SRCREV}"
DEPENDS += "emotion python-evas"
RDEPENDS_${PN} += "python-ecore"
