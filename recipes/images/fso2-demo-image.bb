#------------------------------------------------------
# FSO-compliant Console Image Recipe
#------------------------------------------------------

require fso-image.inc

PV = "1.0"
PR = "r0"

IMAGE_INSTALL = "\
  task-base \
  task-fso2-compliance \
  task-cli-tools \
  task-cli-tools-python \
  \
  zhone2 \
"
