require python-efl.inc
SRCREV = "${EFL_SRCREV}"
DEPENDS += "elementary"
RDEPENDS_${PN} += "python-evas python-ecore python-edje" 
