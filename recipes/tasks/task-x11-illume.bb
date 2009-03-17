DESCRIPTION = "The Illume Windowing Environment -- install this task to get the Enlightenment Window Manager + the Illume environment."
SECTION = "x11/wm"
LICENSE = "MIT"
PV = "1.0"
PR = "r0"

# WORK IN PROGRESS

inherit task

# Default illume theme
ILLUME_THEME ?= "e-wm-theme-illume"

RDEPENDS_${PN} = "\
  task-x11-server \
  task-x11-utils \
#  xserver-kdrive-splash-illume \
  \
  e-wm \
  e-wm-config-illume \
  ${ILLUME_THEME} \
"
