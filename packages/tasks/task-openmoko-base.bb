DESCRIPTION = "Openmoko: Base Task for the Openmoko Linux Distribution"
SECTION = "openmoko/base"
LICENSE = "MIT"
PR = "r73"

inherit task

#
# task-openmoko-base
#
DESCRIPTION_task-openmoko-base = "Openmoko: Top Panel, Application Launcher, Application Manager"
RDEPENDS_task-openmoko-base = "\
  matchbox-panel-2 \
  matchbox-panel-2-applets \
#  matchbox-keyboard-inputmethod \
#  matchbox-keyboard-im \
#  matchbox-keyboard-applet \
  matchbox-stroke \
  multitap-pad \
  openmoko-terminal2 \
#  openmoko-keyboard \
  openmoko-panel-battery \
  openmoko-panel-clock \
  openmoko-panel-usb \
  ${@base_contains('MACHINE_FEATURES', 'bluetooth', 'openmoko-panel-bt', '', d)} \
  ${@base_contains('MACHINE_FEATURES', 'gps', 'openmoko-panel-gps', '', d)} \
  ${@base_contains('MACHINE_FEATURES', 'wifi', 'openmoko-panel-wifi', '', d)} \
  \
  openmoko-today2 \
#  openmoko-appmanager \
"
