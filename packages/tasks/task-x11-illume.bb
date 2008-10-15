DESCRIPTION = "The Illume Windowing Environment -- install this task to get the Enlightenment Window Manager + the Illume environment."
SECTION = "x11/wm"
LICENSE = "MIT"
PV = "1.0"
PR = "r0"

# WORK IN PROGRESS

inherit task

# Default illume theme
ILLUME_THEME ?= "illume-theme-illume"

RDEPENDS_${PN} = "\
  task-x11-server \
  task-x11-utils \
#  xserver-kdrive-splash-illume \
  \
  e-wm \
  illume \
  illume-config-illume \
  illume-dicts-english-us \
  illume-keyboards-default \
  illume-keyboards-numbers \
  illume-keyboards-terminal \
  ${ILLUME_THEME} \
"
