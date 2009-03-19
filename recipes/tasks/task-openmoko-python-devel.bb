DESCRIPTION = "Openmoko: Python Development Tools"
SECTION = "openmoko/devel"
LICENSE = "MIT"
PR = "r3"

inherit task

RDEPENDS_task-openmoko-python-devel = "\
  task-python-efl \
  python-pygtk \
  python-lightmediascanner \
"
