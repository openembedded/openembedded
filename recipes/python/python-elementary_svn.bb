require python-efl.inc
SRCREV = "${EFL_SRCREV}"
DEPENDS += "elementary python-evas"
RDEPENDS_${PN} += "python-evas python-ecore python-edje" 
