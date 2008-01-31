#------------------------------------------------------
# OpenMoko Image Recipe
#------------------------------------------------------

export IMAGE_BASENAME = "${PN}"
export IMAGE_LINGUAS = ""

IMAGE_INSTALL = "\
  ${MACHINE_TASK_PROVIDER} \
  task-openmoko-linux \
  alsa-state \
  bluez-hcidump \
  bluez-utils \
  task-openmoko-qtopia \
"
DEPENDS = "\
  ${MACHINE_TASK_PROVIDER} \
  task-openmoko-qtopia \
"

RDEPENDS = "${PACKAGE_INSTALL}"

inherit image

LICENSE = MIT

