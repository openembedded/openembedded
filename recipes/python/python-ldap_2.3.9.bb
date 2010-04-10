DESCRIPTION = "LDAP client API for Python, C wrapper module around OpenLDAP 2.x with an object-oriented API" 
SECTION = "devel/python" 
PRIORITY = "optional" 
LICENSE = "Python-style" 
HOMEPAGE = "http://www.python-ldap.org/" 
DEPENDS = "python openldap" 
 
SRC_URI = "http://pypi.python.org/packages/source/p/${PN}/${PN}-${PV}.tar.gz \ 
           file://setup.cfg.patch;patch=1"  
 
inherit setuptools  

SRC_URI[md5sum] = "a9f9f16338288d118a1ae6266c993247"
SRC_URI[sha256sum] = "62f75b21c5ee744408c9d8b59878328b3bdf47899d30e8abf0c09b3ffb893ed4"
