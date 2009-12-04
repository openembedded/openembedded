DESCRIPTION = "SHR Fat Image Feed"
PR = "r3"
PV = "2.0"
LICENSE = "GPL"

inherit task

PACKAGES = "\
  ${PN}-gtk \
  ${PN}-apps \
  ${PN}-games \
"

RDEPENDS_${PN}-gtk = "\
  gpe-scap \
  pidgin \
  libpurple-protocol-msn \
  libpurple-protocol-icq \
  vagalume \
  gpe-sketchbook \ 
"

RDEPENDS_${PN}-apps += "\
   task-shr-minimal-apps \
	opimd-utils-notes \
	mokonnect \
	midori \
	intone \
"

RDEPENDS_${PN}-games += "\
	mokomaze \
	numptyphysics \
"

