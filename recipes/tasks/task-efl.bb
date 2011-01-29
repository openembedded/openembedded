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
  edbus \
  efreet \
  epdf \
  ethumb \
  elementary \
"
PR = "r4"

ALLOW_EMPTY = "1"
