DESCRIPTION = "OpenMoko: Misc. Feed Items"
SECTION = "openmoko/base"
LICENSE = "MIT"
PR = "r20"

inherit task

RDEPENDS_task-openmoko-feed = "\
  aspell enchant \
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
  python python-pygtk python-pyserial \
#  python-efl \
  ruby \
  libsdl-x11 libsdl-mixer libsdl-net libsdl-ttf \
  settingsgui \
  synergy \
  tzdata \
  tor \
  vnc \
  wxwidgets \
  x11vnc \
"

