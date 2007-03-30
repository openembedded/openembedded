DESCRIPTION = "OpenMoko: Tasks for the OpenMoko Linux Distribution"
SECTION = "openmoko/base"
ALLOW_EMPTY = "1"
PACKAGE_ARCH = "all"
LICENSE = "MIT"
PROVIDES = "task-openmoko-everything"

PR = "r32"

PACKAGES = "\
  task-openmoko-linux \
  task-openmoko-ui \
  task-openmoko-base \
  task-openmoko-phone \
  task-openmoko-finger \
  task-openmoko-pim \
  task-openmoko-net \
  \
  task-openmoko-demo \
  task-openmoko-examples \
  task-openmoko-debug \
"

RDEPENDS_task-openmoko-everything := "${PACKAGES}"

#
# task-openmoko-core
#
DESCRIPTION_task-openmoko-linux = "OpenMoko: Linux Core Services"
RDEPENDS_task-openmoko-linux = "\
  task-base \
  sysfsutils \
  modutils-initscripts \
  module-init-tools-depmod \
  rsync \
#  update-alternatives \
"

#
# task-openmoko-base
#
DESCRIPTION_task-openmoko-base = "OpenMoko: Main-Menu Launcher, and Panel"
RDEPENDS_task-openmoko-base = "\
"

#
# task-openmoko-phone
#
DESCRIPTION_task-openmoko-phone = "OpenMoko: GSM Phone Services"
RDEPENDS_task-openmoko-phone = "\
  gsmd \
  libgsmd-tools \
  openmoko-dialer \
"

#
# task-openmoko-ui
#
DESCRIPTION_task-openmoko-ui = "OpenMoko: The X11/Gtk+2 based native User Interface"
RDEPENDS_task-openmoko-ui = "\
  gdk-pixbuf-loader-png \
  gdk-pixbuf-loader-gif \
  gdk-pixbuf-loader-xpm \
  gdk-pixbuf-loader-jpeg \
  pango-module-basic-x \
  pango-module-basic-fc \
  gtk+ \
  matchbox-common \
  matchbox-wm \
  matchbox-panel-2 \
  xserver-kdrive-fbdev \
  xserver-kdrive-common \
  xserver-nodm-init \
  ttf-bitstream-vera \
  xauth \
  xhost \
  xset \
  xrandr \
  openmoko-common \
  openmoko-session \
  openmoko-theme-standard \
  openmoko-icon-theme-standard \
  settings-daemon \
#  psplash \
"

#
# task-openmoko-base
#
DESCRIPTION_task-openmoko-base = "OpenMoko: Main-Menu Launcher, Top Panel, and Footer"
RDEPENDS_task-openmoko-base = "\
  openmoko-mainmenu \
  matchbox-panel-2 \
  openmoko-footer \
  openmoko-taskmanager \
  openmoko-panel-mainmenu \
"

#
# task-openmoko-phone
#
DESCRIPTION_task-openmoko-phone = "OpenMoko: GSM and GPRS Phone Services"
RDEPENDS_task-openmoko-phone = "\
  gsmd \
  libgsmd-tools \
  openmoko-dialer \
  openmoko-panel-gsm \
# ppp \
"

#
# task-openmoko-finger
#
DESCRIPTION_task-openmoko-finger = "OpenMoko: Finger UI Applications"
RDEPENDS_task-openmoko-finger = "\
"

#
# task-openmoko-pim
#
DESCRIPTION_task-openmoko-pim = "OpenMoko: PIM Applications"
RDEPENDS_task-openmoko-pim = "\
  eds-dbus \
  openmoko-contacts \
  openmoko-dates \
  openmoko-today \
"

#
# task-openmoko-net
#
DESCRIPTION_task-openmoko-net = "OpenMoko: Linux Advanced Networking"
RDEPENDS_task-openmoko-net = "\
  bluez-utils \
"

#
# task-openmoko-demo
#
DESCRIPTION_task-openmoko-demo = "OpenMoko: Demo Applications"
RDEPENDS_task-openmoko-demo = "\
  matchbox-desktop \
  matchbox-keyboard \
  openmoko-keyboard \
  matchbox-stroke \
  matchbox-config-gtk \
  matchbox-panel-2-applets \
  matchbox-panel-hacks \
  matchbox-themes-extra \
  matchbox-themes-gtk \
  matchbox-applet-inputmanager \
  matchbox-applet-startup-monitor \
  openmoko-panel-battery \
  openmoko-panel-clock \
  openmoko-panel-demo \
  openmoko-panel-demo-simple \
  openmoko-panel-gsm \
  openmoko-panel-mainmenu \
  openmoko-rssreader \
  openmoko-messages \
  openmoko-today \
  xcursor-transparent-theme \
  web \
  rxvt-unicode \
  gpe-terminal \
  mtpaint \
"

#
# task-openmoko-examples
#
DESCRIPTION_task-openmoko-examples = "OpenMoko: Example Applications"
RDEPENDS_task-openmoko-examples = "\
  openmoko-stylus-demo-simple \
  openmoko-stylus-demo \
  openmoko-finger-demo \
  openmoko-panel-demo-simple \
  openmoko-panel-demo \
  openmoko-chordmaster"

#
# task-openmoko-debug
#
DESCRIPTION_task-openmoko-debug = "OpenMoko: Debugging Tools"
RDEPENDS_task-openmoko-debug = "\
  alsa-utils-amixer \
  alsa-utils-aplay \
  alsa-utils-aconnect \
  alsa-utils-alsamixer \
  alsa-utils-speakertest \
  madplay \
  vorbis-tools \
  strace \
#  ltrace \
  gdb \
  gdbserver \
  tcpdump \
  tslib-calibrate \
  tslib-tests \
  fstests \
  lsof \
  lrzsz \
  udev-utils \
  usbutils \
  uucp \
  cu \
  sensors-i2cdetect sensors-i2cdump sensors-i2cset \
  xev \
"

#
# task-openmoko-sdk-native
#
DESCRIPTION_task-openmoko-native-sdk = "OpenMoko: Native SDK"
RDEPENDS_task-openmoko-native-sdk = "\
  binutils \
  binutils-symlinks \
  gcc \
  gcc-symlinks \
  cpp \
  cpp-symlinks \
  libc6-dev \
  libgcc-dev \
  libgcc-s-dev \
  glibc-utils \
  ldd \
  g++ \
  g++-symlinks \
  libstdc++-dev \
  \
  make \
  flex \
  flex-dev \
  bison \
  gawk \
  grep \
  sed \
  automake \
  autoconf \
  patch \
  patchutils \
  diffstat \
  diffutils \
  libtool \
  pkgconfig \
  \
  xoo \
"
