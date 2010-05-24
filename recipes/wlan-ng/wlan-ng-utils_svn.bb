require wlan-ng-utils.inc

SRCREV = "1859"
PR = "r0"

PV = "0.2.8+svnr${SRCPV}"

SRC_URI += "svn://svn.shaftnet.org/linux-wlan-ng;module=trunk \
        file://scripts-makefile-hostcc.patch \
	file://pcmciasrc.patch \
	file://hostldflags.patch"

S = "${WORKDIR}/trunk"
