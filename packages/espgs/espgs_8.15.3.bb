DESCRIPTION = "ESP Ghostscript is an up-to-date GNU Ghostscript distribution \
including bug fixes, new drivers, and additional support for CUPS."
HOMEPAGE = "http://www.cups.org/espgs/"
SECTION = "libs"
DEPENDS = "jpeg zlib libpng fontconfig"
LICENSE = "GPL"

SRC_URI = "http://ftp.rz.tu-bs.de/pub/mirror/ftp.easysw.com/ftp/pub/ghostscript/${PV}/espgs-${PV}-source.tar.bz2"
S = "${WORKDIR}/espgs-${PV}"

PARALLEL_MAKE = ""

inherit autotools

PACKAGES += "espgs-examples espgs-resources"

# I added the lib dir to the central package, since espgs complained of a missing file when run.
# If I find exactly which files are needed for operation, I'll just add those, and split the package.

FILES_${PN} += "${datadir}/ghostscript/8.15/lib/*"
FILES_${PN}-doc += "${datadir}/ghostscript/8.15/doc/*"
FILES_${PN}-examples += "${datadir}/ghostscript/8.15/examples/*"
FILES_${PN}-resources += "${datadir}/ghostscript/8.15/Resource/*"

EXTRA_OECONF = "--with-drivers= \
		--disable-cups \
		--disable-gtk \
		--without-ijs \
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
		   'gsdir=${D}${datadir}/ghostscript' \
		   'gsdatadir=${D}${datadir}/ghostscript/8.15' \	
                   'mandir=${D}${mandir}' \
                   'docdir=${D}${datadir}/doc/espgs/' install		   		   
}
