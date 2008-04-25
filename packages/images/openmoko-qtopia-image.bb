#------------------------------------------------------
# OpenMoko Qtopia Image Recipe
#------------------------------------------------------

require openmoko-minimal-image.bb

export IMAGE_BASENAME = "${PN}"

IMAGE_INSTALL += "\
  alsa-state \
  bluez-hcidump \
  bluez-utils \
  task-openmoko-qtopia \
"

DEPENDS += "\
  task-openmoko-qtopia \
"

RDEPENDS = "${PACKAGE_INSTALL}"

LICENSE = MIT
