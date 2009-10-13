#------------------------------------------------------
# FSO-compliant Console Image Recipe
#------------------------------------------------------

require fso-image.inc

PV = "1.1"
PR = "r1"

IMAGE_INSTALL = "\
  task-base \
  task-fso2-compliance \
  task-cli-tools \
  task-cli-tools-python \
"
