DESCRIPTION = "Meta-package for SDL"
PACKAGES = "sdl-libs sdl-base"

ALLOW_EMPTY = 1

task-sdl-libs = "libsdl-qpe libsdl-gfx libsdl-image libsdl-mixer libsdl-ttf libsdl-net"
task-sdl-base = ""

RDEPENDS_sdl-libs = "${task-sdl-libs}"
DEPENDS += "${task-sdl-libs}"

RDEPENDS_sdl-base = "${task-sdl-base}"
DEPENDS += "${task-sdl-base}"
LICENSE = MIT
