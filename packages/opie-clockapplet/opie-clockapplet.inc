DESCRIPTION = "Clock applet"
SECTION = "opie/applets"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "clockapplet"


S = "${WORKDIR}/${APPNAME}"

inherit opie

pkg_postinst() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
if pidof -s qpe >/dev/null; then
  ${bindir}/qcop QPE/TaskBar "reloadApplets()"
fi
}

pkg_postrm() {
#!/bin/sh
${bindir}/qcop QPE/TaskBar "reloadApplets()"
 if [ -n "$D" ]; then false; fi
}

# FILES plugins/applets/libclockapplet.so*
do_install() {
}

# FILES plugins/applets/libclockapplet.so* pics/clockapplet/*.png
do_install() {
        install -d ${D}${palmtopdir}/pics/clockapplet/
        install -m 0644 ${WORKDIR}/pics/clockapplet/*.png ${D}${palmtopdir}/pics/clockapplet/
}

