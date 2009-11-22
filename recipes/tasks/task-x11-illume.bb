DESCRIPTION = "The Illume Windowing Environment -- install this task to get the Enlightenment Window Manager + the Illume environment."
SECTION = "x11/wm"
LICENSE = "MIT"
PV = "1.0"
PR = "r0"

# WORK IN PROGRESS

inherit task

# Default illume theme
ILLUME_THEME ?= "e-wm-theme-illume"
ILLUME_CONFIG ?= "e-wm-config-illume"

RDEPENDS_${PN} = "\
  task-x11-server \
  task-x11-utils \
#  xserver-kdrive-splash-illume \
  \
  e-wm \
  ${ILLUME_CONFIG} \
  ${ILLUME_THEME} \
"
