DESCRIPTION = "OpenMoko: Tasks for the OpenMoko Linux Distribution"
SECTION = "openmoko/base"
ALLOW_EMPTY = "1"
PACKAGE_ARCH = "${MACHINE_ARCH}"
LICENSE = "MIT"
PR = "r46"

inherit task

XSERVER ?= "xserver-kdrive-fbdev"

PACKAGES = "task-openmoko-qtopia-x11"

#
# task-openmoko-qtopia-x11
#
DESCRIPTION_task-openmoko-qtopia-x11 = "OpenMoko: The Qtopia/X11 based User Interface"
RDEPENDS_task-openmoko-qtopia-x11 = "\
  alsa-state \
  bluez-hcidump \
  readline \
  qtopia-phone-x11 \
  e-wm \
  illume \
  ${XSERVER} \
  xserver-kdrive-common \
  xserver-nodm-init \
  xauth \
  xhost \
  xset \
  xrandr \
  neod \
  libnotify \
"

