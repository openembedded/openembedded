DESCRIPTION = "OpenMoko: Misc. Feed Items"
SECTION = "openmoko/base"
LICENSE = "MIT"
PR = "r1"

inherit task

RDEPENDS_task-openmoko-feed = "\
  python \
  python-pygtk \
  python-pyserial \
"
