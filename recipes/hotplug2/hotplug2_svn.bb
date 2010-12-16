# Copyright (C) 2010, O.S. Systems Software Ltda. All Rights Reserved
# Released under the MIT license

DESCRIPTION = "Hotplug2 is a lightweight udev replacement"
HOMEPAGE = "http://code.google.com/p/hotplug2/"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPLv2"
RRECOMMENDS += "udev-utils"
RPROVIDES_${PN} = "hotplug"
RREPLACES_${PN} = "udev"
PV = "1.0+svnr${SRCPV}"
PR = "r1"

SRC_URI = "svn://hotplug2.googlecode.com/svn;module=trunk;proto=http"

SRCREV = "4"
S = "${WORKDIR}/trunk"

inherit autotools

PACKAGES_DYNAMIC = "hotplug2-worker-*"

FILES_${PN}-dbg += "${base_libdir}/hotplug2/.debug"

python populate_packages_prepend() {
        workers = bb.data.expand('${base_libdir}/hotplug2/', d)
        do_split_packages(d, workers, 'worker_(.*).so$',
                          'hotplug2-worker-%s', 'Hotplug2 %s worker support',
                          prepend=True)
}
