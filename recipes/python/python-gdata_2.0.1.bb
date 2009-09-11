DESCRIPTION = "The Google Data APIs (Google Data) provide a simple protocol for reading and writing data on the web." 
SECTION = "devel/python" 
PRIORITY = "optional" 
LICENSE = "Apache License V2.0" 
HOMEPAGE = "http://code.google.com/p/gdata-python-client/" 
SRCNAME = "gdata" 
DEPENDS = "python" 
 
SRC_URI = "http://gdata-python-client.googlecode.com/files/${SRCNAME}-${PV}.tar.gz" 
S = "${WORKDIR}/${SRCNAME}-${PV}" 
 
inherit distutils  
