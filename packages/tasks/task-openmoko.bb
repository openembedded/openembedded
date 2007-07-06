DESCRIPTION = "OpenMoko: Tasks for the OpenMoko Linux Distribution"
SECTION = "openmoko/base"
LICENSE = "MIT"
PROVIDES = "task-openmoko-everything"
PR = "r46"

ALLOW_EMPTY = "1"
PACKAGE_ARCH = "all"

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
  task-openmoko-native-sdk \
"

RDEPENDS_task-openmoko-everything := "${PACKAGES}"

#
# task-openmoko-core
#
DESCRIPTION_task-openmoko-linux = "OpenMoko: Linux Core Services"
RDEPENDS_task-openmoko-linux = "\
  task-base \
  netbase \
  sysfsutils \
  modutils-initscripts \
  module-init-tools-depmod \
  rsync \
  screen \
#  update-alternatives \
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
  libgtkstylus \
  libgtkinput \
  matchbox-common \
  matchbox-wm \
  xserver-kdrive-fbdev \
  xserver-kdrive-common \
  xserver-nodm-init \
#  x11-c-locale \
  ttf-bitstream-vera \
  xauth \
  xhost \
  xset \
  xrandr \
  settings-daemon \
  openmoko-common \
  openmoko-session \
  openmoko-theme-standard \
  openmoko-icon-theme-standard \
  openmoko-sound-system \
  openmoko-sound-theme-standard \
#  psplash \
"

#
# task-openmoko-base
#
DESCRIPTION_task-openmoko-base = "OpenMoko: Main-Menu Launcher, Top Panel, and Footer"
RDEPENDS_task-openmoko-base = "\
  openmoko-terminal \
  openmoko-mainmenu \
  matchbox-panel-2 \
  matchbox-panel-2-applets \
  matchbox-applet-inputmanager \
  openmoko-appmanager \
  openmoko-keyboard \
  openmoko-footer \
  openmoko-taskmanager \
  openmoko-panel-mainmenu \
  openmoko-panel-battery \
  openmoko-panel-bt \
  openmoko-panel-clock \
  openmoko-panel-usb \
  openmoko-panel-gps \
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
#  ppp \
"

#
# task-openmoko-finger
#
DESCRIPTION_task-openmoko-finger = "OpenMoko: Finger UI Applications"
RDEPENDS_task-openmoko-finger = "\
  openmoko-calculator \
"

#
# task-openmoko-pim
#
DESCRIPTION_task-openmoko-pim = "OpenMoko: PIM Applications"
RDEPENDS_task-openmoko-pim = "\
  eds-dbus \
  openmoko-contacts \
  openmoko-dates \
  openmoko-tasks \
  openmoko-today \
  openmoko-messages \
  openmoko-rssreader \
"

#
# task-openmoko-net
#
DESCRIPTION_task-openmoko-net = "OpenMoko: Linux Advanced Networking"
RDEPENDS_task-openmoko-net = "\
  bluez-utils \
  bridge-utils \
"

#
# task-openmoko-demo
#
DESCRIPTION_task-openmoko-demo = "OpenMoko: Demo Applications"
RDEPENDS_task-openmoko-demo = "\
  matchbox-desktop-2 \
  matchbox-keyboard \
  matchbox-stroke \
  matchbox-config-gtk \
  xcursor-transparent-theme \
  web \
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
  alsa-state \
  alsa-utils-amixer \
  alsa-utils-aplay \
  alsa-utils-aconnect \
  alsa-utils-alsamixer \
  alsa-utils-speakertest \
  madplay \
  vorbis-tools \
  strace \
  ltrace \
  gdb \
  gdbserver \
  tcpdump \
  tslib-calibrate \
  tslib-tests \
  fbgrab \
  fstests \
  lsof \
  lrzsz \
  udev-utils \
  usbutils \
  uucp \
  cu \
#  sensors-i2cdetect sensors-i2cdump sensors-i2cset \
  xev \
  bonnie++ \
  memtester \
  dbench \
"

#
# task-openmoko-native-sdk
#
DESCRIPTION_task-openmoko-native-sdk = "OpenMoko: Native SDK"
RDEPENDS_task-openmoko-native-sdk = "\
  binutils \
  binutils-symlinks \
  gcc \
  gcc-symlinks \
  cpp \
  cpp-symlinks \
  cvs \
  libc6-dev \
  libgcc-dev \
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
