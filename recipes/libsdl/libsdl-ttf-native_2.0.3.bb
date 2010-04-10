require libsdl-ttf_${PV}.bb
inherit native

DEPENDS = "libsdl-native"
FILESPATH = "${FILE_DIRNAME}/libsdl-ttf-${PV}:${FILE_DIRNAME}/libsdl-ttf:${FILE_DIRNAME}/files"

EXTRA_OECONF = "--disable-sdltest --with-sdl-prefix=${STAGING_LIBDIR}/.."

export SDL_CONFIG = "${STAGING_BINDIR}/sdl-config"


SRC_URI[md5sum] = "29d12d1b883bf834c291c93f52ba8dc5"
SRC_URI[sha256sum] = "7e2e7b46088a7b9594b255b58123598d49c5c3d11bcc3c9a8f80969cd9caa6c5"
