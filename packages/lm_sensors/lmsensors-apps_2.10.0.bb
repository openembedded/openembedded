# lmsensors-apps .bb build file
# Copyright (C) 2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see /COPYING)

DESCRIPTION = "Hardware health monitoring applications"
HOMEPAGE = "http://secure.netroedge.com/~lm78/"
MAINTAINER = "Raymond Danks <info-linux@geode.amd.com>"
DEPENDS = "libsysfs"
LICENSE = "GPL"

SRC_URI = "http://secure.netroedge.com/~lm78/archive/lm_sensors-${PV}.tar.gz \
           file://add-sysfs-ldflags.patch;patch=1"
S = "${WORKDIR}/lm_sensors-${PV}"

do_compile() {
	oe_runmake LINUX=${STAGING_KERNEL_DIR} EXLDFLAGS="${LDFLAGS}" user
}

APPS = "${S}/prog/dump/i2cdump ${S}/prog/dump/i2cset ${S}/prog/detect/i2cdetect"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${APPS} ${D}${bindir}
}

PACKAGES="sensors-i2cdump sensors-i2cset sensors-i2cdetect"

FILES_sensors-i2cdump="${bindir}/i2cdump"
FILES_sensors-i2cset="${bindir}/i2cset"
FILES_sensors-i2cdetect="${bindir}/i2cdetect"
