DESCRIPTION = "Python package for parsing and generating vCard and vCalendar files" 
SECTION = "devel/python" 
PRIORITY = "optional" 
LICENSE = "Apache License V2.0" 
HOMEPAGE = "http://vobject.skyhouseconsulting.com/" 
SRCNAME = "vobject" 
DEPENDS = "python python-dateutil" 
 
SRC_URI = "http://vobject.skyhouseconsulting.com/${SRCNAME}-${PV}.tar.gz" 
S = "${WORKDIR}/${SRCNAME}-${PV}" 
 
inherit setuptools  
