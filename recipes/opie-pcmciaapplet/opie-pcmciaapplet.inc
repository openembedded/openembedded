DESCRIPTION = "PCMCIA/CF Manager Applet"
SECTION = "opie/applets"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "pcmciaapplet"

S = "${WORKDIR}/pcmcia"

inherit opie

pkg_postinst() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
if pidof -s qpe >/dev/null; then
  ${bindir}/qcop QPE/TaskBar "reloadApplets()"
else
  exit 0
fi
}

pkg_postrm() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
${bindir}/qcop QPE/TaskBar "reloadApplets()"
}

do_install() {
        install -d ${D}${palmtopdir}/pics/pcmcia/
#        install -m 0644 ${WORKDIR}/pics/pcmcia/*.png ${D}${palmtopdir}/pics/pcmcia/ 
}
