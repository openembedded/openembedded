DESCRIPTION = "Tasks for an LXDE based image"

inherit task

# Most of these tasks are arch independant
PACKAGE_ARCH = "all"

XSERVER ?= "xserver-xorg \
           xf86-input-evdev \
           xf86-input-mouse \
           xf86-video-fbdev \
           xf86-input-keyboard \
"

PACKAGES += "task-lxde-apps task-lxde-xserver task-lxde-xserver-base"

RDEPENDS_task-lxde-apps = " \
  pcmanfm \
  lxpanel \
  lxsession-lite \
  lxde-common \
  openbox \
  leafpad \
  gpicview \
"

RDEPENDS_task-lxde-xserver-base = " \
  dbus-x11 \
  desktop-file-utils \
  iso-codes \
  mime-support \
  notification-daemon inotify-tools \
  xauth \
  xdg-utils \
  xhost \
  xinetd \
  xinit \
  xlsfonts \
  xrandr \
  xrdb \
  xrefresh \
  xset \
  xvinfo \
 "

RDEPENDS_task-lxde-xserver = " \
  ${XSERVER} \
"

PACKAGE_ARCH_task-lxde-xserver = "${MACHINE_ARCH}"

RDEPENDS_${PN} = " \
	task-lxde-xserver-base \
"

RRECOMMENDS_${PN} = " \
   task-lxde-xserver \
"

