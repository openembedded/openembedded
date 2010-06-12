DESCRIPTION = "Python Bindings to the Enlightenment Foundation Libraries"
LICENSE = "MIT"
SECTION = "devel/python"
PR = "ml5"

ALLOW_EMPTY = "1"

RDEPENDS_${PN} = "\
  python-evas \
  python-ecore \
  python-edje \
  python-elementary \
  python-emotion \
  python-edbus \
"

