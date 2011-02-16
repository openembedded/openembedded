#! /bin/sh
#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2008
# License: MIT (see http://www.opensource.org/licenses/mit-license.php 
#               for a copy of the license)
#
# Filename: openmoko-gps_svn.bb
# Date: 20080101 (YMD)

DESCRIPTION = "A tiny GPS output parser for the Openmoko platform."
HOMEPAGE = "http://forge.bearstech.com/trac/wiki/OpenmokoGPS"
SECTION = "base"
LICENSE = "GPL"

RDEPENDS_${PN} = "python-pygtk"

SRCREV = "12"
PV = "0.0.1+svnr${SRCPV}"
PR = "r2" 

######################################################################################

SRC_URI = "svn://forge.bearstech.com/forge/openmoko;module=gps"

S = "${WORKDIR}/gps"

do_compile() {
        # fix hardcoded path
        sed -i "s#/usr/bin/python#env python#g" gps_reader.py
        # fix QA issues
        sed -i "/^Encoding/d; /^SingleInstance/d; s/Categories=GTK;Application;Utilities;/Categories=Utility;/g" openmoko-gps.desktop
}

do_install() {
	install -d ${D}${bindir}/
	install -d ${D}${datadir}/applications/
	install -d ${D}${datadir}/pixmaps/
	
	install -m 0755 ${S}/gps_reader.py ${D}${bindir}/
	install -m 0644 ${S}/openmoko-gps.desktop ${D}${datadir}/applications/
	install -m 0644 ${S}/*.png ${D}${datadir}/pixmaps/
}
