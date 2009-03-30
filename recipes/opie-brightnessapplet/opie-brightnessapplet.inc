DESCRIPTION = "Brightness Applet"
SECTION = "opie/applets"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "brightnessapplet"

S = "${WORKDIR}/${APPNAME}"

inherit opie

do_install() {
	install -d ${D}${palmtopdir}/pics/${APPNAME}
	install -m 0655 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

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

