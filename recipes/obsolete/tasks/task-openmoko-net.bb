DESCRIPTION = "Openmoko: Networking for the Openmoko Linux Distribution"
SECTION = "openmoko/base"
LICENSE = "MIT"
PR = "r71"

inherit task

#
# task-openmoko-net
#
DESCRIPTION_task-openmoko-net = "Openmoko: Linux Advanced Networking"
RDEPENDS_task-openmoko-net = "\
  bluez-utils \
  bridge-utils \
"
