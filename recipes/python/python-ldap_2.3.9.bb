DESCRIPTION = "LDAP client API for Python, C wrapper module around OpenLDAP 2.x with an object-oriented API" 
SECTION = "devel/python" 
PRIORITY = "optional" 
LICENSE = "Python-style" 
HOMEPAGE = "http://www.python-ldap.org/" 
DEPENDS = "python openldap" 
 
SRC_URI = "http://pypi.python.org/packages/source/p/${PN}/${PN}-${PV}.tar.gz \ 
           file://setup.cfg.patch;patch=1"  
 
inherit setuptools  
