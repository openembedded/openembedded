DESCRIPTION = "Video 4 Linux 2 Tools for Bug 2.0"
LICENSE = "BSD"
HOMEPAGE = "http://bugcommunity.com/wiki"
MAINTAINER = "Bug Labs, Inc."
DEPENDS += "virtual/kernel python"
AUTHOR = "Lane Brooks <lane@brooksee.org>"
inherit distutils-base 

PV = "0.01"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "bug20"

SRCREV="8321b5766b464a4cf80ff5f1c03276ee7f136d81"
SRC_URI = git://gitorious.org/bl-camera2-test-app/bl-camera2-test-app.git;protocol=git"

EXTRA_OEMAKE += "KDIR=${STAGING_KERNEL_DIR} OE_PATH=${STAGING_INCDIR}"

S = "${WORKDIR}/git"
do_install () {
install -d ${D}${bindir}/
install -m 0755 ${S}/bug2v4l2 ${D}${bindir}/

install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/bug2v4l2
install -m 0755 -t ${D}${libdir}/${PYTHON_DIR}/site-packages/bug2v4l2
{S}/python/build/bug2v4l2/*

install -d ${D}${datadir}/bug2v4l2/examples
install -m 0755 -t ${D}${datadir}/bug2v4l2/examples ${S}/python/examples/*
install -m 0755 -t ${D}${datadir}/bug2v4l2/examples ${S}/examples/*
}

FILES_${PN} += "${bindir}/bug2v4l2"
FILES_${PN} += "${libdir}/${PYTHON_DIR}/site-packages/bug2v4l2"
FILES_${PN}-debug += "${bindir}/.debug/bug2v4l2"

PACKAGES =+ "${PN}-examples"
FILES_${PN}-examples = "${datadir}/bug2v4l2/examples"
