# hibernate-script OE build file
# Copyright (C) 2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="Hibernate script supporting multiple suspend methods"
LICENSE="GPL"
MAINTAINER = "Raymond Danks <info-linux@geode.amd.com>"
HOMEPAGE="http://www.suspend2.net"

SRC_URI="http://www.suspend2.net/downloads/all/${PN}-${PV}.tar.gz \
	file://hibernate.conf \
	file://standby.conf \
	file://ram.conf"

inherit update-rc.d

INITSCRIPT_NAME = "hibernate-cleanup"
INITSCRIPT_PARAMS = "start 31 S ."

FILES_${PN}_append = " /usr/share/hibernate"

do_install () {
	BASE_DIR=${D} PREFIX=/usr MAN_DIR=${D}/usr/share/man \
		${S}/install.sh

	ln -s ./hibernate ${D}/usr/sbin/hibernate-standby
	ln -s ./hibernate ${D}/usr/sbin/hibernate-ram 

	#Override conf files from ${WORKDIR}
	install -m 0644 ${WORKDIR}/hibernate.conf ${D}/etc/hibernate/
	install -m 0644 ${WORKDIR}/ram.conf ${D}/etc/hibernate/
	install -m 0644 ${WORKDIR}/standby.conf ${D}/etc/hibernate/

	install -d ${D}/etc/init.d
	install -m 0755 ${S}/init.d/hibernate-cleanup.sh ${D}/etc/init.d/hibernate-cleanup

}


