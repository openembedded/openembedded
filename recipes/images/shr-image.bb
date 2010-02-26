require shr-image.inc

IMAGE_BASENAME = "full"

DEPENDS += "task-shr"
RDEPENDS += "\
    task-shr-apps \
    task-shr-games \
    task-shr-gtk \
    task-shr-cli \
"

IMAGE_INSTALL += "\
  task-shr-apps \
  task-shr-games \
  task-shr-gtk \
  task-shr-cli \
"
