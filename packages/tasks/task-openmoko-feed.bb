DESCRIPTION = "Openmoko: Misc. Feed Items"
SECTION = "openmoko/base"
LICENSE = "MIT"
PR = "r45"

inherit task

RDEPENDS_task-openmoko-feed = "\
  aspell enchant \
  openmoko-agpsui \
  gypsy \
  gsm0710muxd \
  ppp \
  bluez-hcidump \
  bootchart \
  eet evas ecore embryo epsilon edje efreet emotion epdf \
  exhibit edje-viewer \
  free42-vga \
  gpe-filemanager gpe-gallery gpe-timesheet gpe-todo \
  ipkg-link ipkg-utils \
  joe \
  kbdd \
  kexec-tools \
  midori \
  mplayer \
  mtpaint \
  mysql \
  nano \
  ntpclient ntp \
  openssh openssh-scp openssh-ssh openssh-sshd openssh-sftp openssh-misc \
  python python-pygtk python-pyserial python-gst \
  ruby \
  libsdl-x11 libsdl-mixer libsdl-net libsdl-ttf \
  settingsgui \
  synergy \
  tzdata \
  tor \
  vnc \
  wxwidgets \
  x11vnc \
#  libswt3.4-gtk-java \
#  cacao \
#  jamvm \
#  classpath \
#  gpsdrive \
  gpsd \
  asterisk \
#  gnash \
  mono \
#  diversity-daemon \
#  diversity-maps-taipei \
  om-maps-berlin \
  om-maps-buenos-aires \
  om-maps-hong-kong \
  om-maps-london \
  om-maps-low-levels \
  om-maps-new-york \
  om-maps-paris \
  om-maps-providence \
  om-maps-san-francisco \
  om-maps-sydney \
  om-maps-taipei \
  om-locations \
  om-settings \
  assassin \
#  assassin-thumbnail \
  tangogps \
#  pyefl-sudoku \
  minicom \
  vim \
#  iotop \
#  evince \
  epdf \
  xprop \
  xev \
  xwininfo \
  gpsd \
  mc \
  devmem2 \
  bluez-utils-alsa \
  tcpdump \
  gdb \
  lsof \
#  openmoko-set-root-password \
#  qtopia-phone-enable-debug \
  git \
  navit \
  libnotify \
  notification-daemon \
  libxine \
#  subversion \
  task-openmoko-games \
  xournal \
  openvpn \
  python-pygame \
  irssi \
  zsh \
  fbreader \
  zip \
  firefox \
  tichy \
  pidgin \
  epdfview \
  midori \
  microcom \
  emacs \
"
