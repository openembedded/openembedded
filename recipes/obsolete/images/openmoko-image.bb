#------------------------------------------------------
# Openmoko Image Recipe
#------------------------------------------------------

require openmoko-minimal-image.bb

IMAGE_INSTALL += "\
  task-openmoko-net \
  task-openmoko-ui \
  task-openmoko-base \
  task-openmoko-phone \
  task-openmoko-games \
  task-openmoko-pim \
  "

DEPENDS += "\
  task-openmoko \
  "

inherit image

