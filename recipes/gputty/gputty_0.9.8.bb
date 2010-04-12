#  OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "GPuTTY is a PuTTY clone using the Gnome environment"
HOMEPAGE = "http://www.defora.org/index.php?page=gputty"
LICENSE = "GPL"
SECTION = "network"
PR = "r0"

SRC_URI = "http://people.defora.org/~khorben/projects/gputty/gputty-${PV}.tar.gz \
           file://gputty"

do_compile() {
	oe_runmake -C src
}

do_install() {
	install -d ${D}${bindir}
	oe_runmake -C src BINDIR="${bindir}" DESTDIR="${D}" install
	install -d ${D}${sysconfdir}/
	install -m 0644 ${WORKDIR}/gputty ${D}${sysconfdir}/
}

# Save the configuration file in the package
FILES_${PN} += " /etc/gputty"


SRC_URI[md5sum] = "d227a37a8a7b036eed44e4278db45735"
SRC_URI[sha256sum] = "fcee22d7e31a936cde4672ac318ffabb9d39b7fc3b74de391bdade1419c59dfd"
