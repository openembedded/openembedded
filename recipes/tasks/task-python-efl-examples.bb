DESCRIPTION = "Python Examples for the Enlightenment Foundation Libraries"
LICENSE = "MIT"
SECTION = "devel/python"
RDEPENDS_${PN} = "\
  task-python-efl \
  python-ecore-examples \
  python-emotion-examples \
  python-edje-examples \
  python-math python-textutils \
"
PR = "ml5"

ALLOW_EMPTY = "1"
