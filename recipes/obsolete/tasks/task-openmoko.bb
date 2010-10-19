DESCRIPTION = "Openmoko: Tasks for the Openmoko Linux Distribution"
SECTION = "openmoko/base"
LICENSE = "MIT"
PROVIDES = "task-openmoko-everything"
PR = "r71"

inherit task

PACKAGES += "\
        task-openmoko-everything \
"

RDEPENDS_task-openmoko-everything := "\
  task-openmoko-linux \
  task-openmoko-ui \
  task-openmoko-base \
  task-openmoko-phone \
  task-openmoko-pim \
  task-openmoko-net \
  task-openmoko-games \
  task-openmoko-examples \
  task-openmoko-debug \
  task-openmoko-native-sdk \
"







