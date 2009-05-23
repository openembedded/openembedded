DESCRIPTION = "SHR Fat Image Feed"
PR = "r1"
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
  vagalume \
  gpe-sketchbook \ 
"

RDEPENDS_${PN}-apps += "\
   task-shr-minimal-apps \
	mofi \
	midori \
	intone \
"

RDEPENDS_${PN}-games += "\
  numptyphysics \
"

