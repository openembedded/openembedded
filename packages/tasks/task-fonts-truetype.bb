DESCRIPTION = "Install one of these tasks to get support for truetype fonts."
SECTION = "fonts"
LICENSE = "MIT"
PV = "1.0"
PR = "r0"

inherit task

PACKAGES += "\
  ${PN}-core \
  ${PN}-chinese \
  ${PN}-japanese \
"

RRECOMMENDS_task-fonts-truetype = "\
  ${PN}-core \
  ${PN}-chinese \
  ${PN}-japanese \
"

RDEPENDS_task-fonts-truetype-core = "\
  fontconfig-utils \
  \
  ttf-dejavu-common \
  ttf-dejavu-sans \
#  ttf-dejavu-serif \
  ttf-dejavu-sans-mono \
"

RDEPENDS_task-fonts-truetype-chinese = "\
  ${PN}-core \
  ttf-arphic-uming \
"

RDEPENDS_task-fonts-truetype-japanese = "\
  ${PN}-core \
  ttf-sazanami-gothic \
  ttf-sazanami-mincho \
"
