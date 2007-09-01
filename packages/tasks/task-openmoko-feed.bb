DESCRIPTION = "OpenMoko: Misc. Feed Items"
SECTION = "openmoko/base"
LICENSE = "MIT"
PR = "r4"

inherit task

RDEPENDS_task-openmoko-feed = "\
  ntpclient \
  openssh openssh-scp openssh-ssh openssh-sshd openssh-sftp openssh-misc \
  python \
  python-pygtk \
  python-pyserial \
  timezones \
"
