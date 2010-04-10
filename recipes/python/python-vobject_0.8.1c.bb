DESCRIPTION = "Python package for parsing and generating vCard and vCalendar files" 
SECTION = "devel/python" 
PRIORITY = "optional" 
LICENSE = "Apache License V2.0" 
HOMEPAGE = "http://vobject.skyhouseconsulting.com/" 
SRCNAME = "vobject" 
RDEPENDS = "python python-dateutil"
PR = "r1"

SRC_URI = "http://vobject.skyhouseconsulting.com/${SRCNAME}-${PV}.tar.gz" 
S = "${WORKDIR}/${SRCNAME}-${PV}" 

inherit setuptools  

SRC_URI[md5sum] = "c9686dd74d39fdae140890d9c694c076"
SRC_URI[sha256sum] = "594113117f2017ed837c8f3ce727616f9053baa5a5463a7420c8249b8fc556f5"
