# - Currently this app needs ttf-dejavu-sans-mono[.ipk] installed!
# - think about using fbi -a option for autozoom on tiny screens
# - fbi displays in portrait-mode if your fb is in portrait (normal) mode too
#   (fbcon:rotate stands only for the fb console)

HOMEPAGE = "http://linux.bytesex.org/fbida/"
DESCRIPTION = "frame buffer image and doc viewer tools"
AUTHOR = "Gerd Knorr"
LICENSE = "GPL2"
SECTION = "utils"
PR = "r3"

DEPENDS = "virtual/libiconv jpeg fontconfig freetype libexif"
RDEPENDS = "ttf-dejavu-sans-mono"

SRC_URI = "http://dl.bytesex.org/releases/fbida/fbida-${PV}.tar.gz \
	   file://exiftran.c.patch;patch=1 \
	   file://fbi.c.patch;patch=1 \
	   file://GNUmakefile.patch;patch=1 \
	   file://sys_siglist.patch;patch=1 \
	  "

EXTRA_OEMAKE = ""

do_compile() {
	oe_runmake
}

do_install() {
	oe_runmake 'DESTDIR=${D}' install
}
