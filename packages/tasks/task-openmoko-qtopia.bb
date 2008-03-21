DESCRIPTION = "OpenMoko: Tasks for the OpenMoko Linux Distribution"
SECTION = "openmoko/base"
ALLOW_EMPTY = "1"
PACKAGE_ARCH = "all"
LICENSE = "MIT"
PR = "r45"

PACKAGES = "task-openmoko-qtopia"

#
# task-openmoko-qtopia
#
DESCRIPTION_task-openmoko-qtopia = "OpenMoko: The Qtopia based native User Interface"
RDEPENDS_task-openmoko-qtopia = "\
  alsa-state \
  bluez-hcidump \
  readline \
  gstreamer \
  bootchart \
  qtopia-phone \
"

