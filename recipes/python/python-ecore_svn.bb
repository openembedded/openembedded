require python-efl.inc
SRCREV = "${EFL_SRCREV}"
DEPENDS += "python-evas ecore"
RDEPENDS_${PN} += "python-evas"
