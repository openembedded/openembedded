DESCRIPTION = "OpenMoko: PIM for the OpenMoko Linux Distribution"
SECTION = "openmoko/base"
LICENSE = "MIT"
PR = "r71"

inherit task

#
# task-openmoko-pim
#
DESCRIPTION_task-openmoko-pim = "OpenMoko: Personal Information Management Suite"
RDEPENDS_task-openmoko-pim = "\
  eds-dbus \
  openmoko-calculator2 \
  openmoko-contacts2 \
  openmoko-dates2 \
  openmoko-feedreader2 \
  openmoko-browser2 \
  openmoko-appmanager2 \
  openmoko-tasks2 \
  openmoko-mediaplayer2 \
  openmoko-messages2 \
"
