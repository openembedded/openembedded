inherit gpe

DEPENDS = "virtual/xserver xtst xau xpm libgpelaunch "
DEPENDS_append_openzaurus = " display-brightness"
RDEPENDS_append_openzaurus = " display-brightness"

SECTION = "gpe"
LICENSE = "GPL"
DESCRIPTION = "A small utility for binding commands to a hot key.\
 Keylaunch is a minimal utility for associating commands with hot keys. This\
 GPE version is intended for use with the special keys found on most handheld\
 computers. You can connect each key to a program of your choice; if the\
 program is already running, keylaunch can bring its window to the front\
 rather than just running another copy."
PACKAGE_ARCH = "${MACHINE_ARCH}"
PR = "r6"

SRC_URI += " file://keylaunchrc \
	     file://80chvt-SUID"

do_install_prepend () {
	install -d ${D}/etc/X11/Xinit.d
	install ${WORKDIR}/keylaunchrc ${S}/keylaunchrc
	install ${WORKDIR}/80chvt-SUID ${D}/etc/X11/Xinit.d
}

export CVSBUILD="no"
