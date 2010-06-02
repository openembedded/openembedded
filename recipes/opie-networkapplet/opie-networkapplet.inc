DESCRIPTION = "Network Applet"
SECTION = "opie/applets"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS_${PN} = "opie-networksettings"
APPNAME = "networkapplet"

S = "${WORKDIR}/${APPNAME}"

inherit opie

pkg_postinst() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
if pidof -s qpe >/dev/null; then
  /usr/bin/qcop QPE/TaskBar "reloadApplets()"
else
  exit 0
fi
}

pkg_postrm() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
/usr/bin/qcop QPE/TaskBar "reloadApplets()"
}

# FILES plugins/applets/libnetworkapplet.so* pics/networkapplet
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/ 
}
