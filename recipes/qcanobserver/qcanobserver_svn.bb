DESCRIPTION = "The Linux CAN Sniffer"
LICENSE = "GPLv3+"

inherit qt4x11

DEPENDS += "qwt"

PV = "0.5+svnr${SRCPV}"
SRCREV = "43"
SRC_URI = "svn://qcanobserver.svn.sourceforge.net/svnroot;module=qcanobserver;proto=https \
           file://0001-messagebufferinterface.cpp-add-sys-socket.h-as-inclu.patch \
           file://candemo.xml"

S = "${WORKDIR}/qcanobserver/"

CXXFLAGS += " -DPF_CAN=29  -DAF_CAN=PF_CAN"

do_configure_prepend() {
	sed -i s:/usr/include/qwt5/:${STAGING_INCDIR}:g *.pro
}

do_install() {
	install -d ${D}${datadir}/qcanobserver
	install -d ${D}${datadir}/qcanobserver/cfg
	install -d ${D}${datadir}/qcanobserver/lib
	install -d ${D}${datadir}/qcanobserver/db

	install -m 0755 ${S}/QCanObserver ${D}${datadir}/qcanobserver

	install -m 0644 ${WORKDIR}/candemo.xml ${D}${datadir}/qcanobserver/db
	install -m 0644 ${S}/db/*.xml ${D}${datadir}/qcanobserver/db
}

FILES_${PN}-dbg += "${datadir}/qcanobserver/.debug"
