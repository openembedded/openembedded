inherit gpe

DEPENDS = "virtual/xserver libxtst libxau libxpm libgpelaunch"
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

SRC_URI += " file://keylaunchrc"

do_install_prepend () {
	install ${WORKDIR}/keylaunchrc ${S}/keylaunchrc
}

do_install_append() {
	# yeah I know...this is less than ideal
	mv ${D}/etc/keylaunchrc ${D}/etc/keylaunchrc.matchbox
}

export CVSBUILD="no"

pkg_postinst_${PN}() { 
	update-alternatives --install /etc/keylaunchrc keylaunchrc /etc/keylaunchrc.matchbox 10
}

pkg_postrm_${PN}() {   
       update-alternatives --remove keylaunchrc /etc/keylaunchrc.matchbox
}
