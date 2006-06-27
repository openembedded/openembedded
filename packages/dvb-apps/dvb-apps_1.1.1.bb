#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: GPL (see http://www.gnu.org/licenses/gpl.txt for a copy of the license)
#
# Filename: dvb-apps_1.1.1.bb
# Date: 17-Jun-06

DESCRIPTION = "<description>"
MAINTAINER = "Matthias 'CoreDump' Hentges <oe@hentges.net>"
HOMEPAGE = "http://www.hentges.net/misc/openzaurus/index.shtml"
LICENSE = "GPL"
######################################################################################

PR = "r0"

######################################################################################

S = "${WORKDIR}/linuxtv-${PN}-${PV}"
PARALLEL_MAKE = ""

######################################################################################

PACKAGES = "${PN}-scan ${PN}-dvbdate ${PN}-dvbtraffic ${PN}-zap"

FILES_${PN}-scan = "/usr/bin/scan \
		    /usr/share/dvb-apps-scan/*"

FILES_${PN}-dvbdate = "/usr/bin/dvbdate"

FILES_${PN}-dvbtraffic = "/usr/bin/dvbtraffic"

FILES_${PN}-zap = "/usr/bin/*zap"

######################################################################################

SRC_URI = "http://linuxtv.org/downloads/linuxtv-${PN}-${PV}.tar.bz2 \
	   file://dvbdate-Makefile.patch;patch=1 \
	   file://dvbtraffic-Makefile.patch;patch=1 \
	   file://szap-Makefile.patch;patch=1 \
	   file://dvbnet-Makefile.patch;patch=1 \
	   file://scan-Makefile.patch;patch=1 \
	   file://szap-header.patch;patch=1 \
	   file://dvbnet-Makefile-2.patch;patch=1"

######################################################################################
	   
do_compile() {	
	for dir in lib dvbdate dvbtraffic szap scan
	do
		echo "[$dir]"
		cd ${WORKDIR}/linuxtv-dvb-apps-1.1.1/util/$dir
		oe_runmake
		echo "[done]"
	done
}	   

do_install() {
	install -d "${D}/usr/bin"
	install -d "${D}/usr/share/dvb-apps-scan"
	
	for exe in dvbdate dvbtraffic scan
	do
		install -m 0755 "${S}/util/$exe/$exe" "${D}/usr/bin"
	done
	
	for d in atsc dvb-c dvb-s dvb-t
	do
		cp -a "${S}/util/scan/$d" "${D}/usr/share/dvb-apps-scan"
	done
	
	for exe in azap czap szap tzap
	do
		install -m 0755 "${S}/util/szap/$exe" "${D}/usr/bin"
	done
}
