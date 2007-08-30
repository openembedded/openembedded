DESCRIPTION = "OpenMoko: Misc. Feed Items"
SECTION = "openmoko/base"
LICENSE = "MIT"
PR = "r2"

inherit task

RDEPENDS_task-openmoko-feed = "\
  openssh openssh-scp openssh-ssh openssh-sshd openssh-sftp openssh-misc \
  python \
  python-pygtk \
  python-pyserial \
"
