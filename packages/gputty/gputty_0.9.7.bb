#  OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="GPuTTY is a PuTTY clone using the Gnome environment"
HOMEPAGE="http://www.defora.org/index.php?page=gputty"
LICENSE="GPL"
SECTION="net-misc"

SRC_URI="http://www.defora.org/projects/GPuTTY/files/gputty-${PV}.tar.gz \
	file://conf.patch;patch=1 \
	file://gputty"

# Save the configuration file in the package
FILES_${PN} += " /etc/gputty"

do_compile() {
	oe_runmake -C src
}

do_install() {
	install -d ${D}/${bindir}
	oe_runmake -C src BINDIR="${bindir}" DESTDIR="${D}" install
	install -d ${D}/${sysconfdir}/
	install -m 0644 ${WORKDIR}/gputty ${D}/${sysconfdir}/
}
