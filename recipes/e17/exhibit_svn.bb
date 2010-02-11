DESCRIPTION = "Exhibit is the ETK picture viewer"
LICENSE = "MIT BSD"
DEPENDS = "evas ecore epsilon edje eet etk efreet"
PV = "0.1.1+svnr${SRCPV}"
PR = "r2"

inherit e

SRC_URI = "svn://svn.enlightenment.org/svn/e/OLD;module=${SRCNAME};proto=http"
