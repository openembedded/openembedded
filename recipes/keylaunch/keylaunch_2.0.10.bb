inherit gpe

DEPENDS = "virtual/xserver libxtst libxau libxpm libgpelaunch keylaunch-conf"
RDEPENDS = "keylaunch-conf"

SECTION = "gpe"
LICENSE = "GPL"
DESCRIPTION = "A small utility for binding commands to a hot key.\
 Keylaunch is a minimal utility for associating commands with hot keys. This\
 GPE version is intended for use with the special keys found on most handheld\
 computers. You can connect each key to a program of your choice; if the\
 program is already running, keylaunch can bring its window to the front\
 rather than just running another copy."
PR = "r14"

SRC_URI += " file://makefile-fix.patch;patch=1 file://unbreak-keyevents.patch;patch=1"

export CVSBUILD="no"

do_install_append() {
	# Remove random crap
	rm ${D}/etc/keylaunchrc
	rm -rf ${D}/etc/X11/Xinit.d/
}

SRC_URI[md5sum] = "2d81de20b26eac5ad44b759eb412e8eb"
SRC_URI[sha256sum] = "38715fcc508740deb3f169a01092f03ea4ce92c9ec3c2589a9510534aa52a540"
