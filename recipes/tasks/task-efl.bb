DESCRIPTION = "Task package: Enlightenment Foundation Libraries"
LICENSE = "MIT"
SECTION = "devel/efl"
RDEPENDS_${PN} = "\
  eet \
  evas \
  ecore \
  embryo \
  edje \
  emotion \
  esmart \
  edbus \
  efreet \
  ewl \
  epdf \
"
PR = "r2"

ALLOW_EMPTY = "1"
