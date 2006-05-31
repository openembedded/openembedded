# lmsensors-apps .bb build file
# Copyright (C) 2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see /COPYING)

HOMEPAGE="http://secure.netroedge.com/~lm78/"
DESCRIPTION="Hardware health monitoring applications"
MAINTAINER = "Raymond Danks <info-linux@geode.amd.com>"
LICENSE = "GPL"

SRC_URI="http://secure.netroedge.com/~lm78/archive/lm_sensors-${PV}.tar.gz"

S="${WORKDIR}/lm_sensors-${PV}"

PACKAGES="sensors-i2cdump sensors-i2cset sensors-i2cdetect"

FILES_sensors-i2cdump="${bindir}/i2cdump"
FILES_sensors-i2cset="${bindir}/i2cset"
FILES_sensors-i2cdetect="${bindir}/i2cdetect"

do_configure() {
}

do_compile() {
	oe_runmake LINUX=${STAGING_KERNEL_DIR} user
}

APPS="${S}/prog/dump/i2cdump ${S}/prog/dump/i2cset ${S}/prog/detect/i2cdetect"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${APPS} ${D}${bindir}
}
