DESCRIPTION = "ESP Ghostscript is an up-to-date GNU Ghostscript distribution \
including bug fixes, new drivers, and additional support for CUPS."
HOMEPAGE = "http://www.cups.org/espgs/"
SECTION = "libs"
DEPENDS = "jpeg zlib libpng tiff fontconfig"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://ftp.rz.tu-bs.de/pub/mirror/ftp.easysw.com/ftp/pub/ghostscript/${PV}/espgs-${PV}-source.tar.bz2"

PARALLEL_MAKE = ""

inherit autotools

EXTRA_OECONF = "--with-drivers=ALL \
 		--enable-cups \
		--without-ijs \
		--disable-gtk \
 		--without-gimp-print \
		--without-x \
		--without-omni"

do_compile() {
	oe_runmake CCAUX="${BUILD_CC}"
}


do_install () {
	oe_runmake 'prefix=${D}${prefix}' \
		   'bindir=${D}${bindir}' \
		   'datadir=${D}${datadir}' \
		   'cups_datadir=${D}${datadir}/cups' \
		   'cups_serverroot=${D}${sysconfdir}/cups' \
		   'cups_serverbin= ${D}${libdir}/cups' \
		   'CUPSSERVER=${cups_serverbin}' \
	           'CUPSCONFIG=${cups_serverroot}' \
	           'CUPSDATA=${cups_datadir}' \
                   'sysconfdir=${D}${sysconfdir}' \
		   'gsdir=${D}${datadir}/ghostscript' \
		   'gsdatadir=${D}${datadir}/ghostscript/8.15' \	
                   'mandir=${D}${mandir}' \
                   'docdir=${D}${datadir}/doc/espgs/' install  		   		   
}

PACKAGES += "espgs-examples espgs-resources"

# I added the lib dir to the central package, since espgs complained of a missing file when run.
# If I find exactly which files are needed for operation, I'll just add those, and split the package.

FILES_${PN} += "${datadir}/ghostscript/8.15/lib/* \
		${libdir}/cups/filter/* \
		${datadir}/cups/model/* \"
FILES_${PN}-doc += "${datadir}/ghostscript/8.15/doc/*"
FILES_${PN}-examples += "${datadir}/ghostscript/8.15/examples/*"
FILES_${PN}-resources += "${datadir}/ghostscript/8.15/Resource/*"
