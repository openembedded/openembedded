DESCRIPTION = "Openmoko: Core system for the Openmoko Linux Distribution"
SECTION = "openmoko/base"
LICENSE = "MIT"
PR = "r71"

inherit task

#
# task-openmoko-core
#
DESCRIPTION_task-openmoko-linux = "Openmoko: Linux Core Services"
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
