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

RDEPENDS = "python-pygtk"

PR = "r0" 

######################################################################################

SRC_URI = "svn://forge.bearstech.com/bearforge/openmoko;module=gps;rev=9"

S = "${WORKDIR}/gps"

do_install() {
	install -d ${D}/usr/bin
	install -d ${D}/usr/share/applications/
	install -d ${D}/usr/share/pixmaps/
	
	install -m 0755 ${S}/gps_reader.py ${D}/usr/bin
	install -m 0644 ${S}/openmoko-gps.desktop ${D}/usr/share/applications/
	install -m 0644 ${S}/*.png ${D}/usr/share/pixmaps/
}
