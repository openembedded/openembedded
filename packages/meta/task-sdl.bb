DESCRIPTION = "Tasks for SDL stuff"
LICENSE = MIT
PACKAGES = "task-sdl-libs task-sdl-games task-sdl-emulators"

# no need to add libsdl as all libsdl-* already rdepend on it
RDEPENDS_task-sdl-libs = "libsdl-gfx libsdl-image libsdl-mixer libsdl-ttf libsdl-net"

RDEPENDS_task-sdl-games = "abuse freedroid lbreakout2 openttd prboom quake1 rott supertux xmame"

RDEPENDS_task-sdl-emulators = "dgen-sdl e-uae frodo snes9x"

