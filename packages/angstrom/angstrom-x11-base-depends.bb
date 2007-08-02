DESCRIPTION = "Task packages for the Angstrom distribution"
PR = "r32"
ALLOW_EMPTY = "1"

XSERVER ?= "xserver-kdrive-fbdev"

DEPENDS = "virtual/xserver"

RDEPENDS = "\
    virtual/libx11 \
    ${XSERVER} \
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    "

