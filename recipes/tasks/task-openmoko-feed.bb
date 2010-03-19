DESCRIPTION = "Openmoko: Misc. Feed Items"
SECTION = "openmoko/base"
LICENSE = "MIT"
PR = "r62"

inherit task

RDEPENDS_task-openmoko-feed = "\
  aspell enchant \
  openmoko-agpsui \
  gypsy \
  fso-gsm0710muxd \
  ppp \
  bluez-hcidump \
  bootchart \
  eet evas ecore embryo edje efreet emotion epdf \
  exhibit edje-viewer \
  free42-vga \
  gpe-filemanager gpe-gallery gpe-timesheet gpe-todo gpe-contacts \
  leafpad abiword \
  claws-mail claws-plugin-mailmbox claws-plugin-gtkhtml2-viewer claws-plugin-rssyl \
  ipkg-link ipkg-utils \
  joe \
  kbdd \
  kexec-tools \
  midori \
  dillo \
  fennec \
  ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'mplayer', d)} \
  mtpaint \
  mysql \
  nano \
  ntpclient ntp \
  openssh openssh-scp openssh-ssh openssh-sshd openssh-sftp openssh-misc \
  python python-pygtk python-pyserial python-gst python-pygame \
#  python-lightblue \
  python-pybluez \
  obexpush \
  ruby \
  libsdl-x11 libsdl-mixer libsdl-net libsdl-ttf \
  settingsgui \
  synergy \
  tzdata \
  tor \
  vnc \
  wxwidgets \
  x11vnc \
  libswt3.4-gtk-java \
  cacao \
  jamvm \
  classpath \
  gpsdrive \
  gpsd \
  asterisk \
  gnash \
  mono \
  diversity-daemon \
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
  assassin-thumbnail \
  tangogps \
  pyefl-sudoku \
  minicom \
  iotop \
  evince \
  epdfview \
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
  openmoko-set-root-password \
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
  gzip \
  zip \
  firefox \
  paroli \
  pidgin \
  epdfview \
  midori \
  microcom \
  zhone \
  frameworkd \
  emacs \
  gpe-scap \
# for werner \
  net-tools \
  iproute2 \
  iputils \
  psmisc \
  debianutils \
  tcptraceroute \
  task-proper-tools \
  wmiconfig \
  netkit-telnet \
  bind-utils \
  font-adobe-100dpi \
  font-adobe-75dpi \
  font-adobe-utopia-100dpi \
  font-adobe-utopia-75dpi \
  font-adobe-utopia-type1 \
  font-arabic-misc \
  font-bh-100dpi \
  font-bh-75dpi \
  font-bh-lucidatypewriter-100dpi \
  font-bh-lucidatypewriter-75dpi \
  font-bh-ttf \
  font-bh-type1 \
  font-bitstream-100dpi \
  font-bitstream-75dpi \
  font-bitstream-speedo \
  font-bitstream-type1 \
  font-cronyx-cyrillic \
  font-cursor-misc \
  font-daewoo-misc \
  font-dec-misc \
  font-ibm-type1 \
  font-isas-misc \
  font-jis-misc \
  font-micro-misc \
  font-misc-cyrillic \
  font-misc-ethiopic \
  font-misc-meltho \
  font-misc-misc \
  font-mutt-misc \
  font-schumacher-misc \
  font-screen-cyrillic \
  font-sony-misc \
  font-sun-misc \
  font-winitzki-cyrillic \
  font-xfree86-type1 \
"
