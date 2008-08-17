DESCRIPTION = "Openmoko: Misc. Feed Items"
SECTION = "openmoko/base"
LICENSE = "MIT"
PR = "r29"

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
  nano navit \
  ntpclient ntp \
  openssh openssh-scp openssh-ssh openssh-sshd openssh-sftp openssh-misc \
  python python-pygtk python-pyserial \
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
  asterisk \
  gnash \
  mono \
  diversity-daemon \
  diversity-nav \
  diversity-maps-taipei \
  assassin \
  tangogps \
"
