DESCRIPTION = "OpenMoko: Networking for the OpenMoko Linux Distribution"
SECTION = "openmoko/base"
LICENSE = "MIT"
PR = "r71"

inherit task

#
# task-openmoko-net
#
DESCRIPTION_task-openmoko-net = "OpenMoko: Linux Advanced Networking"
RDEPENDS_task-openmoko-net = "\
  bluez-utils \
  bridge-utils \
"
