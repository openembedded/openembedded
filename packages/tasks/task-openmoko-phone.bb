DESCRIPTION = "Openmoko: Tasks for the Openmoko Linux Distribution"
SECTION = "openmoko/base"
LICENSE = "MIT"
PR = "r73"

inherit task

#
# task-openmoko-phone
#
DESCRIPTION_task-openmoko-phone = "Openmoko: GSM and GPRS Phone Services"
RDEPENDS_task-openmoko-phone = "\
  gsmd \
  libgsmd-tools \
  openmoko-dialer2 \
  openmoko-panel-gsm \
  openmoko-panel-memory \
#  ppp \
"
