DESCRIPTION = "LZMA is a compression algorithm, based on the famous \
Lempel Ziff compression method. The windows only open source tool 7-zip \
is another tool which uses this algorithm."
SECTION = "libs"
PRIORITY = "optional"

SRC_URI = "http://students.fhs-hagenberg.ac.at/se/se00001/lzma-0.01.tar.bz2"
S = "${WORKDIR}/"

inherit qmake

do_configure_prepend() {
	${STAGING_BINDIR}/qmake -project -o lzma.pro
}

do_install_append () {
	# Make install doesn't properly install these
	oe_libinstall -so -C shlib libhistory ${D}/${libdir}
	oe_libinstall -so -C shlib libreadline ${D}/${libdir}
}

do_stage() {
	oe_libinstall -so -C shlib libhistory ${STAGING_LIBDIR}
	oe_libinstall -so -C shlib libreadline ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}/readline
	for f in readline.h chardefs.h keymaps.h history.h tilde.h rlstdc.h \
	  rlconf.h rltypedefs.h
	do
		install -m 0644 $f ${STAGING_INCDIR}/readline/
	done

}
