#------------------------------------------------------
# FSO2 Demo Image
#------------------------------------------------------

require fso-image.inc

PV = "1.0"
PR = "r1"

IMAGE_INSTALL = "\
  task-base \
  task-fso2-compliance \
  \
  task-cli-tools \
  task-cli-tools-python \
  \
  iptables \
  alsa-utils-aplay \
  alsa-utils-alsamixer \
  \
  zhone2 \
"
