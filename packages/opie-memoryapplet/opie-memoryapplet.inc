DESCRIPTION = "Memory Applet. \
This applet displays the amount of free memory and manages the swap partition"
SECTION = "opie/applets"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "memoryapplet"

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

