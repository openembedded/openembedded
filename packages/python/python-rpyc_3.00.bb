DESCRIPTION = "RPyC is a Remote Procedure Call Package for Python"
SECTION = "devel/python"
HOMEPAGE = "http://rpyc.wikizone.com"
LICENSE = "GPL"
SRCNAME = "rpyc"
PR = "ml0"

SRC_URI = "${SOURCEFORGE_MIRROR}/rpyc/${SRCNAME}-${PV}-dev.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}-dev/build"

inherit distutils

do_configure_prepend() {
	cd ..
	rm -rf build
	mkdir build
	mkdir build/rpyc
	
	cp README build
	cp setup.py build
	cp __init__.py build/rpyc
	cp license.py build/rpyc
	cp -r core build/rpyc/
	cp -r servers build/rpyc/
	cp -r utils build/rpyc/
	
	cd build
	find . -name "*.pyc" | xargs rm -f
}

