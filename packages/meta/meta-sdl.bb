DESCRIPTION = "Meta-package for SDL"
LICENSE = "MIT"
RDEPENDS = "task-sdl-libs task-sdl-games task-sdl-emulators"
PR = "r2"

ALLOW_EMPTY = "1"
BUILD_ALL_DEPS = "1"

# no need to add libsdl as all libsdl-* already rdepend on it
RDEPENDS_task-sdl-libs = "libsdl-gfx libsdl-image libsdl-mixer libsdl-ttf libsdl-net"

RDEPENDS_task-sdl-games = "abuse freedroid lbreakout2 openttd prboom quake1 rott supertux xmame"

RDEPENDS_task-sdl-emulators = "dgen-sdl e-uae frodo snes9x"

