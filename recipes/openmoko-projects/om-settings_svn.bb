DESCRIPTION = "Exposure all devices on neo1973"
DEPENDS = "python-etk python-edbus"
RDEPENDS = "python-etk python-re python-codecs python-edbus python-pyxdg"
PV = "0.0.1+svnr${SRCPV}"
PR = "r3"
PE = "1"

S = "${WORKDIR}/trunk"

inherit setuptools
SRC_URI = "svn://svn.projects.openmoko.org/svnroot/exposure;module=trunk;proto=http \
           "


PACKAGES = "${PN}"
FILES_${PN} += "${prefix}/share/* ${sysconfdir}/X11/Xsession.d/*"

pkg_postinst_${PN} () {
#!/bin/sh
if test "x$D" = "x"; then
    killall exposure.py
    sleep 1
    exposure.py
fi
}
