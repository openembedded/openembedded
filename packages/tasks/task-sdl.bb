DESCRIPTION = "Tasks for SDL stuff"
LICENSE = "MIT"
PR = "r2"

inherit task

PACKAGES = "\
  task-sdl-libs \
  task-sdl-games \
  task-sdl-emulators \
#  task-sdl-misc \
"

# no need to add libsdl as all libsdl-* already rdepend on it
RDEPENDS_task-sdl-libs = "\
  libsdl-gfx \
  libsdl-image \
  libsdl-mixer \
  libsdl-ttf \
  libsdl-net \
"

RDEPENDS_task-sdl-games = "\
  abuse \
  crimsonfields \
  freedroid \
  frozen-bubble \
  lbreakout2 \
  nogravity \
  horizon \
  openttd \
  prboom \
  quake1 \
  quetoo \
  rocksndiamonds \
  rott \
  supertux \
  uqm \
  xmame \
  "

RDEPENDS_task-sdl-emulators = "\
  dgen-sdl \
  dosbox \
  e-uae \
  fceu \
  frodo \
  scummvm \
  snes9x \
"

RDEPENDS_task-sdl-others = "\
  synaestehsia \
  chibitracker \
  gnash \
  midpath \
"

# ./powermanga/powermanga_0.79.bb:DEPENDS = "libsdl-qpe libsdl-mixer"





