DESCRIPTION = "Meta-package for SDL"
LICENSE = MIT
PACKAGES = "task-sdl-libs task-sdl-base task-sdl-games task-sdl-emulators"
PR = "r1"

ALLOW_EMPTY = 1

# no need to add libsdl as all libsdl-* already (r)depend on it
task-sdl-libs = "libsdl-gfx libsdl-image libsdl-mixer libsdl-ttf libsdl-net"
task-sdl-base = ""

task-sdl-games = "abuse freedroid lbreakout2 openttd prboom quake1 rott supertux xmame"
task-sdl-emulators = "dgen-sdl e-uae frodo snes9x"


RDEPENDS_task-sdl-libs = "${task-sdl-libs}"
DEPENDS += "${task-sdl-libs}"

RDEPENDS_task-sdl-base = "${task-sdl-base}"
DEPENDS += "${task-sdl-base}"

RDEPENDS_task-sdl-games = "${task-sdl-games}"
DEPENDS += "${task-sdl-games}"

RDEPENDS_task-sdl-emulators = "${task-sdl-emulators}"
DEPENDS += "${task-sdl-emulators}"
