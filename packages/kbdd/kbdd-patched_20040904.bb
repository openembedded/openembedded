DESCRIPTION = "Keyboard Device Daemon which provides support for snapntype and stowaway keyboards"
MAINTAINER = "Paul Eggleton <http://handhelds.org/moin/moin.cgi/PaulEggleton>"
SECTION = "utils"
LICENSE = "GPL"
PR = "r2"
DEPENDS = "virtual/kernel"
RDEPENDS = "kernel-module-keybdev kernel-module-uinput"
SRC_URI = "${HANDHELDS_CVS};module=apps/kbdd;date=${PV} \
           file://snapntype.patch;patch=1;pnum=0 \
           file://stowaway-fellowes-apm.patch;patch=1;pnum=0 \
           file://kbdd.init \ 
           file://kbdd.default"

inherit autotools update-rc.d

S = "${WORKDIR}/kbdd"
INITSCRIPT_NAME = "kbdd.init"
INITSCRIPT_PARAMS = "default"
do_compile() {
	oe_runmake
}

do_install() {
	install -d ${D}/${sbindir}
	install -d ${D}/${docdir}/kbdd/
	install -m 0755 kbdd ${D}/${sbindir}/
	install -m 0644 README ${D}/${docdir}/kbdd/
}

do_install_append () {
        mkdir -p ${D}/${sysconfdir}/defaults
        cat ${WORKDIR}/kbdd.default > ${D}/${sysconfdir}/defaults/kbdd
        chmod 755 ${D}/${sysconfdir}/defaults/kbdd
        mkdir -p ${D}/${sysconfdir}/modutils
        touch ${D}/${sysconfdir}/modutils/kbdd-modules
        echo "keybdev" > ${D}/${sysconfdir}/modutils/kbdd-modules
        echo "uinput" >> ${D}/${sysconfdir}/modutils/kbdd-modules
        chmod 755 ${D}/${sysconfdir}/modutils/kbdd-modules
}

pkg_postinst () {
        update-modules
}

pkg_prerm () {
        rm ${D}/${sysconfdir}/modutils/kbdd-modules
        update-modules
}

updatercd_postinst() {
if test "x$D" != "x"; then
        D="-r $D"
else
        D="-s"
fi
update-rc.d $D ${INITSCRIPT_NAME} ${INITSCRIPT_PARAMS}
}

updatercd_postrm() {
if test "x$D" != "x"; then
        D="-r $D"
else
        ${INIT_D_DIR}/${INITSCRIPT_NAME} stop
fi
update-rc.d $D ${INITSCRIPT_NAME} remove
}
