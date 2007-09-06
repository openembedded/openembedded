DESCRIPTION = "OpenMoko: Misc. Feed Items"
SECTION = "openmoko/base"
LICENSE = "MIT"
PR = "r9"

inherit task

RDEPENDS_task-openmoko-feed = "\
  aspell enchant \
  bluez-hcidump \
  eet evas ecore embryo epsilon edje efreet emotion epdf \
  exhibit edje-viewer \
  gpe-filemanager gpe-gallery gpe-timesheet gpe-todo \
  ipkg-link \
  kbdd \
  midori \
  mtpaint \
  mysql \
  nano \
  ntpclient ntp \
  openssh openssh-scp openssh-ssh openssh-sshd openssh-sftp openssh-misc \
  python python-pygtk python-pyserial \
  ruby \
  timezones \
  tor \
  vnc \
"

