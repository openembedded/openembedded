inherit gpe

DEPENDS = "virtual/xserver xtst xau xpm"
SECTION = "gpe"
LICENSE = "GPL"
DESCRIPTION = "A small utility for binding commands to a hot key.\
 Keylaunch is a minimal utility for associating commands with hot keys. This\
 GPE version is intended for use with the special keys found on most handheld\
 computers. You can connect each key to a program of your choice; if the\
 program is already running, keylaunch can bring its window to the front\
 rather than just running another copy."
PR = "r1"

SRC_URI += " file://keylaunchrc"

do_install_prepend () {
	install ${WORKDIR}/keylaunchrc ${S}/keylaunchrc
}

export CVSBUILD="no"
