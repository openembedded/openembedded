DESCRIPTION = "Utilities to detect and configure printers automatically"
HOMEPAGE = "https://fedorahosted.org/hal-cups-utils/"
SECTION = "console/utils"
LICENSE = "GPLv2 CUPS"
DEPENDS = "hal dbus cups"
RDEPENDS_${PN} += "python-dbus python-pycups python-cupshelpers python-subprocess python-syslog usbutils"

SRC_URI = "https://fedorahosted.org/releases/h/a/hal-cups-utils/hal-cups-utils-${PV}.tar.gz"
S = "${WORKDIR}/${PN}-${PV}"

inherit autotools

PACKAGES += "cups-backend-hal"

FILES_${PN} += "${libdir}/hal/* ${datadir}/hal/*"
FILES_${PN}-dbg += "${libdir}/hal/.debug ${libdir}/cups/backend/.debug"
FILES_cups-backend-hal += "${libdir}/cups/backend/*"

EXTRA_OECONF = "--libexecdir=${libdir}/hal/scripts"

do_configure_prepend() {
	sed -i -e s:{includedir}/cups:{STAGING_INCDIR}/cups:g configure.in
}

do_configure_append() {
	sed -i 's,^#!/bin/env python,#!/usr/bin/python,' systemv/hal_lpadmin
}

SRC_URI[md5sum] = "58e1c8f5597dd39e57dcf3c4aabe60f8"
SRC_URI[sha256sum] = "f40a7ebd1453d471a8a6bfd8c635708dd739a6160bb661813f936d936ba85618"
