DESCRIPTION = "Openmoko: Core system for the Openmoko Linux Distribution"
SECTION = "openmoko/base"
LICENSE = "MIT"
PR = "r72"

inherit task

#
# task-openmoko-core
#
DESCRIPTION_task-openmoko-linux = "Openmoko: Linux Core Services"
RDEPENDS_task-openmoko-linux = "\
  task-base \
  udev-static-devices \
  rsync \
  screen \
  fbset \
  fbset-modes \
"
