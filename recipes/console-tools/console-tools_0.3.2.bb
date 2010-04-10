SECTION = "base"
LICENSE = "GPL"
DESCRIPTION = "Allows you to set-up and manipulate the Linux console."
PR = "r4"

SRC_URI = "${SOURCEFORGE_MIRROR}/lct/console-tools-${PV}.tar.gz \
           file://codepage.patch;patch=1 \
           file://configure.patch;patch=1 \
           file://compile.patch;patch=1 \
           file://kbdrate.patch;patch=1 \
           file://uclibc-fileno.patch;patch=1 \
           file://config"

export SUBDIRS = "fontfiletools vttools kbdtools screenfonttools contrib \
		  examples po intl compat"

do_compile () {
	oe_runmake -C lib
	oe_runmake 'SUBDIRS=${SUBDIRS}'
}

inherit autotools gettext

acpaths = "-I ${WORKDIR}/config"

do_install () {
	autotools_do_install
	mv ${D}${bindir}/chvt ${D}${bindir}/chvt.${PN}
	mv ${D}${bindir}/deallocvt ${D}${bindir}/deallocvt.${PN}
	mv ${D}${bindir}/openvt ${D}${bindir}/openvt.${PN}
	mv ${D}${bindir}/showkey ${D}${bindir}/showkey.${PN}
}

pkg_postinst_${PN} () {
	update-alternatives --install ${bindir}/chvt chvt chvt.${PN} 100
	update-alternatives --install ${bindir}/deallocvt deallocvt deallocvt.${PN} 100
	update-alternatives --install ${bindir}/openvt openvt openvt.${PN} 100
	update-alternatives --install ${bindir}/showkey showkey showkey.${PN} 100
}

pkg_prerm_${PN} () {
	update-alternatives --remove chvt chvt.${PN}
	update-alternatives --remove deallocvt deallocvt.${PN}
	update-alternatives --remove openvt openvt.${PN}
	update-alternatives --remove showkey showkey.${PN}
}


SRC_URI[md5sum] = "bf21564fc38b3af853ef724babddbacd"
SRC_URI[sha256sum] = "eea6b441672dacd251079fc85ed322e196282e0e66c16303ec64c3a2b1c126c2"
