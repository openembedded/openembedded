#------------------------------------------------------
# OpenMoko Image Recipe
#------------------------------------------------------

export IMAGE_BASENAME = "${PN}"
export IMAGE_LINGUAS = ""

export PACKAGE_INSTALL = "\
  ${MACHINE_TASK_PROVIDER} \
  task-openmoko-linux \
  task-openmoko-net \
  task-openmoko-ui \
  task-openmoko-base \
  task-openmoko-phone \
  task-openmoko-games \
  task-openmoko-pim \
  "

DEPENDS = "\
  ${MACHINE_TASK_PROVIDER} \
  task-openmoko \
"

RDEPENDS = "${PACKAGE_INSTALL}"

inherit image

LICENSE = MIT
