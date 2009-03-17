DESCRIPTION = "IrDA Applet"
SECTION = "opie/applets"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "irdaapplet"


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

# FILES plugins/applets/libirdaapplet.so* pics/irdaapplet/* sounds/irdaapplet/*.wav
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -d ${D}${palmtopdir}/sounds/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/sounds/${APPNAME}/*.wav ${D}${palmtopdir}/sounds/${APPNAME}/
}

