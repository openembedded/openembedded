require wlan-ng-utils.inc

SRCREV = "1859"
PR = "r0"

PV = "0.2.8+svnr${SRCPV}"

SRC_URI += "svn://svn.shaftnet.org/linux-wlan-ng;module=trunk \
        file://scripts-makefile-hostcc.patch;apply=yes \
	file://pcmciasrc.patch;apply=yes \
	file://hostldflags.patch;apply=yes"

S = "${WORKDIR}/trunk"
