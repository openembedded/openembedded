DESCRIPTION = "Brightness Applet"
SECTION = "opie/applets"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

CVSDATE = "20041001"

PV = "1.1.8+cvs-${CVSDATE}"
APPNAME = "brightnessapplet"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/applets/brightnessapplet \
           ${HANDHELDS_CVS};module=opie/pics"
S = "${WORKDIR}/${APPNAME}"

inherit opie

do_install() {
	install -d ${D}/${palmtopdir}/pics/${APPNAME}
	install -m 0655 ${WORKDIR}/pics/${APPNAME}/*.png ${D}/${palmtopdir}/pics/${APPNAME}/
}

pkg_postinst() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
if pidof -s qpe >/dev/null; then
  /opt/QtPalmtop/bin/qcop QPE/TaskBar "reloadApplets()"
else
  exit 0
fi
}

pkg_postrm() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
/opt/QtPalmtop/bin/qcop QPE/TaskBar "reloadApplets()"
}

