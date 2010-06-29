DESCRIPTION = "XBMC Media Centre"
LICENSE = "xbmc"

DEPENDS = "libmodplug libmicrohttpd wavpack libmms cmake-native libsdl-image libsdl-mixer virtual/egl mysql5 sqlite3 libmms faad2 libcdio libpcre boost lzo2 enca avahi libsamplerate0 libxrandr bzip2 virtual/libsdl"

SRC_URI = "git://xbmc.git.sourceforge.net/gitroot/xbmc/xbmc;protocol=git;branch=gsoc-2010-beagleboard"

SRCREV = "c494f76d87ed98838e9890319554d02814bef10e"

PV = "0.0"
PR_append = "+gitr${SRCPV}"

inherit autotools

S = "${WORKDIR}/git"

do_configure() {
	./bootstrap.angstrom
	oe_runconf
}

do_compile_prepend() {
	for i in $(find . -name "Makefil*") ; do
		sed -i 's:I/usr/include:I${STAGING_INCDIR}:g' $i
	done
	for i in $(find . -name "*.mak*") ; do
		sed -i 's:I/usr/include:I${STAGING_INCDIR}:g' $i
	done
	sed -i 's:I/usr/include:I${STAGING_INCDIR}:g' ${S}/Makefile	
}

EXTRA_OECONF = " \
 --enable-gles \
 --disable-optical-drive \
 --enable-external-libraries \
"

FILES_${PN} += "${datadir}/xsessions"
FILES_${PN}-dbg += "${libdir}/xbmc/.debug ${libdir}/xbmc/*/.debug ${libdir}/xbmc/*/*/.debug ${libdir}/xbmc/*/*/*/.debug"

# GNU_HASH QA errors...
INSANE_SKIP_${PN} = "True"


