DESCRIPTION = "OpenMoko: Core system for the OpenMoko Linux Distribution"
SECTION = "openmoko/base"
LICENSE = "MIT"
PR = "r71"

inherit task

#
# task-openmoko-core
#
DESCRIPTION_task-openmoko-linux = "OpenMoko: Linux Core Services"
RDEPENDS_task-openmoko-linux = "\
  task-base \
  netbase \
  sysfsutils \
  modutils-initscripts \
  module-init-tools-depmod \
  rsync \
  screen \
  psplash \
  fbset \
  fbset-modes \
#  update-alternatives \
"
