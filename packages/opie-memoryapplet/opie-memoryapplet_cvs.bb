DESCRIPTION = "Memory Applet. \
This applet displays the amount of free memory and manages the swap partition"
SECTION = "opie/applets"
PRIORITY = "optional"
LICENSE = "GPL"
PV = "1.1.9+cvs-${CVSDATE}"
PR = "r1"
APPNAME = "memoryapplet"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/applets/memoryapplet \
           ${HANDHELDS_CVS};module=opie/noncore/settings/sysinfo \
           ${HANDHELDS_CVS};module=opie/pics"
S = "${WORKDIR}/memoryapplet"

inherit opie

pkg_postinst() {
#!/bin/sh
if pidof -s qpe >/dev/null; then
  /opt/QtPalmtop/bin/qcop QPE/TaskBar "reloadApplets()"
fi
 if [ -n "$D" ]; then false; fi
}

pkg_postrm() {
#!/bin/sh
/opt/QtPalmtop/bin/qcop QPE/TaskBar "reloadApplets()"
 if [ -n "$D" ]; then false; fi
}

do_install() {
    install -d ${D}${palmtopdir}/plugins/applets ${D}${palmtopdir}/pics/memory/
    install -m 0644 ${WORKDIR}/pics/memory/*.png ${D}${palmtopdir}/pics/memory/
    oe_libinstall -so libmemoryapplet ${D}${palmtopdir}/plugins/applets/
}

