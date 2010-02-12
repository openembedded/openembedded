DESCRIPTION = "SHR Fat Image Feed"
PR = "r5"
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
RDEPENDS_${PN}-apps += "\
   task-shr-minimal-cli \
        screen \
        rsync \
        mdbus2 \
        mterm2 \
	openssh-sftp-server \
"

RDEPENDS_${PN}-games += "\
	mokomaze \
	numptyphysics \
"
