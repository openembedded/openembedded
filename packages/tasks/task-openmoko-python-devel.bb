DESCRIPTION = "OpenMoko: Python Development Tools"
SECTION = "openmoko/devel"
LICENSE = "MIT"
PR = "r1"

inherit task

RDEPENDS_task-openmoko-python-devel = "\
  python-efl \
  python-pygtk \
"
