DESCRIPTION = "The SWORD Project is an open source, cross-platform \
(Linux, Windows, Solaris, MacOSX etc.) API and library for \
Bible software with a constantly growing list of front-ends \
(GUI, textmode, web-based, etc.) and a library of over 200 text modules"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r5"

SRC_URI = "http://www.crosswire.org/~dglassey/sword-1.5.7a.tar.gz"

inherit autotools 

EXTRA_OECONF = "--without-clucene --without-curl"

do_stage() {
	oe_libinstall -so -C lib libsword ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}/sword/
	for f in include/*.h
	do
		install -m 0644 $f ${STAGING_INCDIR}/sword/
	done

}
