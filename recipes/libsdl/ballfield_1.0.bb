DESCRIPTION = "This is a cute little "3D" sprite demo using SDL and SDL_image."
DEPENDS = "virtual/libsdl libsdl-image"
LICENSE = "GPLv2"

SRC_URI = "http://olofson.net/download/ballfield-${PV}.tar.gz"

inherit autotools


SRC_URI[md5sum] = "cdb21380b0584db2a69ac10094bb97e1"
SRC_URI[sha256sum] = "926688080fd75a8d6eab6c6ea1168dc03c591625c21af492ec0c13d816573516"
