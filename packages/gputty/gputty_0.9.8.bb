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

