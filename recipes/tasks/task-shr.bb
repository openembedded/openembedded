DESCRIPTION = "SHR Fat Image Feed"
PR = "r6"
PV = "2.0"
LICENSE = "GPL"

inherit task

PACKAGES = "\
  ${PN}-gtk \
  ${PN}-apps \
  ${PN}-games \
  ${PN}-cli \
"

RDEPENDS_${PN}-gtk = "\
  gpe-scap \
  pidgin \
  libpurple-protocol-msn \
  libpurple-protocol-icq \
  vagalume \
  tangogps \
  gpe-sketchbook \ 
"

RDEPENDS_${PN}-apps += "\
   task-shr-minimal-apps \
	opimd-utils-notes \
	mokonnect \
	midori \
	intone \
"
RDEPENDS_${PN}-cli += "\
   task-cli-tools \
   task-cli-tools-debug \
   task-shr-minimal-cli \
        rsync \
	openssh-sftp-server \
"

RDEPENDS_${PN}-games += "\
	mokomaze \
	numptyphysics \
"
