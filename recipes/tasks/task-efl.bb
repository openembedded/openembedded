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
  ethumb \
  elementary \
"
PR = "r3"

ALLOW_EMPTY = "1"
