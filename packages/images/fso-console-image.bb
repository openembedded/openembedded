#------------------------------------------------------
# FSO compliant Console Image Recipe
#------------------------------------------------------

require fso-image.bb

IMAGE_INSTALL = "\
  task-base \
  task-fso-compliance \
  task-cli-tools \
  task-cli-tools-python \
"
