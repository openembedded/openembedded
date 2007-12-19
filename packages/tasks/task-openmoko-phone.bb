DESCRIPTION = "OpenMoko: Tasks for the OpenMoko Linux Distribution"
SECTION = "openmoko/base"
LICENSE = "MIT"
PR = "r72"

inherit task

#
# task-openmoko-phone
#
DESCRIPTION_task-openmoko-phone = "OpenMoko: GSM and GPRS Phone Services"
RDEPENDS_task-openmoko-phone = "\
  gsmd \
  libgsmd-tools \
  openmoko-dialer2 \
  openmoko-panel-gsm \
#  ppp \
"
