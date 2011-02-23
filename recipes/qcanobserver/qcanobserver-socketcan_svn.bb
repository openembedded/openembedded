DESCRIPTION = "The Linux CAN Sniffer - SocketCAN driver"
LICENSE = "GPLv3+"

inherit qt4x11

DEPENDS += "qwt libsocketcan"

PV = "0.5+svnr${SRCPV}"
SRCREV = "41"
SRC_URI = "svn://qcanobserver.svn.sourceforge.net/svnroot;module=qcanobserver;proto=https"

S = "${WORKDIR}/qcanobserver/DeviceLib/linux/SocketCAN"

CXXFLAGS += " -DPF_CAN=29  -DAF_CAN=PF_CAN"

do_configure_prepend() {
	sed -i s:/usr/include/qwt5/:${STAGING_INCDIR}:g *.pro
}

do_install() {
	install -d ${D}${datadir}/qcanobserver/lib

	install -m 0755 ${S}/lib* ${D}${datadir}/qcanobserver/lib/
}

FILES_${PN} += "${datadir}/qcanobserver/lib"
FILES_${PN}-dbg += "${datadir}/qcanobserver/lib/.debug"

